class RichestCustomerWealth {

    private static int maximumWealth(int[][] accounts) {

        int whealth = 0;

        for (int i = 0; i < accounts.length; i++) {
            int amount = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                amount += accounts[i][j];
            }
            if (amount > whealth) {
                whealth = amount;
            }
        }

        return whealth;
    }

    public static void main(String[] args) {
        System.out.println(maximumWealth(new int[][]{{1,2,3}, {3,2,1}}));
        System.out.println(maximumWealth(new int[][]{{1,5},{7,3},{3,5}}));
    }
}
