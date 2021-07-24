import java.util.Scanner;

public class RotatingChessboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // user input: board size
        int board_size = sc.nextInt();
        sc.nextLine();

        // create required board
        String[][] board = new String[board_size][board_size];
        for (int i = 0; i < board_size; i++) {
            char char_label = 'A';
            for (int j = 0; j < board_size; j++) {
                board[i][j] = char_label + "" + (board_size - i);
                char_label++;
            }
        }
        for (String[] x : board) {
            for (String y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }

        // user input: operation
        String operation[] = sc.nextLine().split(" ");
        char rotation = operation[0].charAt(0);
        int turns = Integer.parseInt(operation[1]);
        int actual_turns = perform_modulo(turns, 4);

        System.out.println(rotation + " " + actual_turns);

        String[][] final_board = perform_rotation(board, board_size, rotation, actual_turns);
        for (String[] x : final_board) {
            for (String y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }

        sc.close();

    }

    public static String[][] perform_rotation(String[][] board, int N, char rotation, int actual_turns) {
        for (int turns = 0; turns < actual_turns; turns++) {
            if (rotation == 'A') {
                // Consider all squares one by one
                for (int x = 0; x < N / 2; x++) {
                    // Consider elements in group
                    // of 4 in current square
                    for (int y = x; y < N - x - 1; y++) {
                        // Store current cell in
                        // temp variable
                        String temp = board[x][y];

                        // Move values from right to top
                        board[x][y] = board[y][N - 1 - x];

                        // Move values from bottom to right
                        board[y][N - 1 - x] = board[N - 1 - x][N - 1 - y];

                        // Move values from left to bottom
                        board[N - 1 - x][N - 1 - y] = board[N - 1 - y][x];

                        // Assign temp to left
                        board[N - 1 - y][x] = temp;
                    }
                }
            } else if (rotation == 'C') {
                // Traverse each cycle
                for (int i = 0; i < N / 2; i++) {
                    for (int j = i; j < N - i - 1; j++) {
                        // Swap elements of each cycle in clockwise direction
                        String temp = board[i][j];
                        board[i][j] = board[N - 1 - j][i];
                        board[N - 1 - j][i] = board[N - 1 - i][N - 1 - j];
                        board[N - 1 - i][N - 1 - j] = board[j][N - 1 - i];
                        board[j][N - 1 - i] = temp;
                    }
                }
            } else {
                System.out.println("Invalid input! No rotation performed!");
            }
        }
        return board;
    }

    public static int perform_modulo(int dividend, int divisor) {
        return (((dividend % divisor) + divisor) % divisor);
    }
}