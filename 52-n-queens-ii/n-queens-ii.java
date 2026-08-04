class Solution {

    public boolean isSafe(int row, int col, List<StringBuilder> chessboard, int n) {
        // Queen lies in
        // Same Column or Row ?
        for (int i = 0; i < n; i++) {
            if (chessboard.get(row).charAt(i) == 'Q' || chessboard.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        // Queen lies in Diagonals ?
        // UP LEFT

        int r = row;
        int c = col;

        while (r >= 0 && c >= 0) {
            if (chessboard.get(r).charAt(c) == 'Q') {
                return false;
            }

            r--;
            c--;
        }

        // UP RIGHT
        r = row;
        c = col;

        while (r >= 0 && c < n) {
            if (chessboard.get(r).charAt(c) == 'Q')
                return false;

            r--;
            c++;
        }

        //DOWN LEFT 
        r = row;
        c = col;

        while (r < n && c >= 0) {
            if (chessboard.get(r).charAt(c) == 'Q')
                return false;

            r++;
            c--;
        }

        // DOWN RIGHT
        r = row;
        c = col;
        while (r < n && c < n) {
            if (chessboard.get(r).charAt(c) == 'Q') {
                return false;
            }

            r++;
            c++;
        }

        // ALL false No Queens then
        return true;
    }

    public void recursion(int row, int n, List<StringBuilder> chessboard, int[] answer) {
        if (row == n) {

            answer[0] += 1;
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isSafe(row, j, chessboard, n)) {
                //Set the Queen
                chessboard.get(row).setCharAt(j, 'Q');
                recursion(row + 1, n, chessboard, answer);

                //Remove the Queen
                chessboard.get(row).setCharAt(j, '.');
            }

        }
    }

    public int totalNQueens(int n) {

        int[] answer = new int[1];

        List<StringBuilder> chessboard = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append(".");
            }
            chessboard.add(row);
        }

        recursion(0, n, chessboard, answer);

        return answer[0];
    }
}