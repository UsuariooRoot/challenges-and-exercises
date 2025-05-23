public class IntToRoman {

    private static String[][] roman = { { "I", "V" }, { "X", "L" }, { "C", "D" }, { "M", "" } };

    public static String intToRoman(int num) {
        String[][] roman = new String[][] { { "I", "V" }, { "X", "L" }, { "C", "D" }, { "M", "" } };

        String[] digist = new String[4];
        int lastIdx = 3;
        while (num > 0) {
            int unid = num % 10;
            int rep = unid % 5;
            if (unid == 5) {
                digist[lastIdx] = roman[3 - lastIdx][1];
                ;
            } else if (unid > 5) {
                digist[lastIdx] = (rep <= 3)
                        ? roman[3 - lastIdx][1] + roman[3 - lastIdx][0].repeat(rep)
                        : roman[3 - lastIdx][0] + roman[4 - lastIdx][0];
            } else {
                digist[lastIdx] = (rep <= 3)
                        ? roman[3 - lastIdx][0].repeat(rep)
                        : roman[3 - lastIdx][0] + roman[3 - lastIdx][1];
            }
            lastIdx--;
            num = (num - unid) / 10;
        }

        StringBuilder sb = new StringBuilder();
        for (String d : digist) {
            if (d != null) {
                sb.append(d);
            }
        }
        return sb.toString();
    }

    public static String intToRoman2(int num) {
        StringBuilder sb = new StringBuilder();
        int lastIdx = 0;
        int div = 1000;
        while (num > 0) {
            int unid = num / div;
            int rep = unid % 5;
            if (unid > 0) {
                int i = 3 - lastIdx;
                sb.append(
                        unid == 5
                                ? roman[i][1]
                                : unid > 5
                                        ? rep == 4
                                                ? roman[i][0] + roman[i + 1][0]
                                                : roman[i][1] + roman[i][0].repeat(rep)
                                        : rep == 4
                                                ? roman[i][0] + roman[i][1]
                                                : roman[i][0].repeat(rep)

                );
                num = num - (unid * div);
            }
            lastIdx++;
            div /= 10;
        }

        return sb.toString();
    }

    static class Symbol {
        int value;
        String symbol;
    
        Symbol(int value, String symbol) {
            this.value = value;
            this.symbol = symbol;
        }
    }

    public static String intToRoman3(int num) {
        Symbol[] symbols = {
            new Symbol(1000, "M"),
            new Symbol(900, "CM"),
            new Symbol(500, "D"),
            new Symbol(400, "CD"),
            new Symbol(100, "C"),
            new Symbol(90, "XC"),
            new Symbol(50, "L"),
            new Symbol(40, "XL"),
            new Symbol(10, "X"),
            new Symbol(9, "IX"),
            new Symbol(5, "V"),
            new Symbol(4, "IV"),
            new Symbol(1, "I")
        };
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < symbols.length && num > 0; i++) {
            while (num >= symbols[i].value) {
                sb.append(symbols[i].symbol);
                num -= symbols[i].value;
            }
        }

        return sb.toString();
    }
}
