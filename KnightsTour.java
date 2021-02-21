import java.text.DecimalFormat;
public class KnightsTour {
        private int path = 0;
        private int[][] position;

        public KnightsTour(int N) {
            position = new int[N][N];
        }

        public void solve() {
            if (nextMove(0, 0, 0, position.length)) {
                results();
            } else {
                System.out.println("ERROR:: Could not find solution");
            }
        }

        public boolean checkEdges(int row, int col, int N) {
            if(row >= 0 && col >= 0 && row < N && col < N) {
                return true;
            }else return false;
        }

        public boolean nextMove(int row, int col, int index, int N) {
            if (position[row][col] != 0) {
                return false;
            }
            position[row][col] = path++;
            if (index == N * N - 1) {
                return true;
            }else if (checkEdges(row + 2, col + 1, N) && nextMove(row + 2, col + 1, index + 1, N)) {
                return true;
            }else if (checkEdges(row + 1, col + 2, N) && nextMove(row + 1, col + 2, index + 1, N)) {
                return true;
            }else if (checkEdges(row - 1, col + 2, N) && nextMove(row - 1, col + 2, index + 1, N)) {
                return true;
            }else if (checkEdges(row - 2, col + 1, N) && nextMove(row - 2, col + 1, index + 1, N)) {
                return true;
            }else if (checkEdges(row - 2, col - 1, N) && nextMove(row - 2, col - 1, index + 1, N)) {
                return true;
            }else if (checkEdges(row - 1, col - 2, N) && nextMove(row - 1, col - 2, index + 1, N)) {
                return true;
            }else if (checkEdges(row + 1, col - 2, N) && nextMove(row + 1, col - 2, index + 1, N)) {
                return true;
            }else if (checkEdges(row + 2, col - 1, N) && nextMove(row + 2, col - 1, index + 1, N)) {
                return true;
            }else {
                path--;
                position[row][col] = 0;
                return false;
            }

        }

        public void results() {
            DecimalFormat numDigits = new DecimalFormat("00");
            for (int i = 0; i < position.length; i++) {
                for (int j = 0; j < position.length; j++) {
                    System.out.print("   " + numDigits.format(position[i][j]));
                }
                System.out.println();
            }
        }

        public static void main(String[] args) {
            KnightsTour x = new KnightsTour(8);
            x.solve();
        }

}

