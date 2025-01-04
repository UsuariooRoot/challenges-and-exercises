public class IntToRoman {
    public static String intToRoman(int num) {
        String[][] roman = { { "I", "V" }, { "X", "L" }, { "C", "D" }, { "M", "" } };

        String[] digist = new String[4];
        int lastIdx = 3;
        while (num > 0) {
            int unid = num % 10;
            int rep = unid % 5;
            if (unid == 5) {
                digist[lastIdx] = roman[3 - lastIdx][1];
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
}
