import java.util.*;

public class tictactoe {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[][] board = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "9" } };

        String mark_p = "X";
        String mark_c = "O";

        boolean play = true;

        while (play) {

            printBoard(board);

            System.out.print("INPUT POSITION (1-9) : ");
            String p = sc.next();

            place_player(p, board, mark_p);

            boolean b = true;
            int c = 0;

            while (b) {

                c = random.nextInt(8) + 1;
                int p_int = Integer.parseInt(p);

                if (c != p_int) {
                    b = false;
                }

            }

            String k = "";
            k = Integer.toString(c);

            place_player(k, board, mark_c);

            play = win(board);
            
        }

    }

    public static void printBoard(String[][] board) {

        System.out.println(Arrays.toString(board[0]));
        System.out.println(Arrays.toString(board[1]));
        System.out.println(Arrays.toString(board[2]));
    }

    // method to check if three "X" or "O" marks are in line
    public static boolean win(String[][] board) {

        for (int i = 0; i < 3; i++) {

            // check verticl and horizontal
            if (board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2]) && board[i][0].equals("X")) {
                System.out.println("PLAYER WINS; GAME OVER");
                return false;
            }
            if (board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2]) && board[i][0].equals("O")) {
                System.out.print("CPU WINS; GAME OVER");
                return false;
            }
            if (board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]) && board[0][i].equals("X")) {
                System.out.println("PLAYER WINS; GAME OVER");
                return false;
            }
            if (board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]) && board[0][i].equals("O")) {
                System.out.print("CPU WINS; GAME OVER");
                return false;
            }

            // check diagonal
            if (board[i][0].equals(board[1][1]) && board[1][1].equals(board[2-i][2]) && board[i][0].equals("X")) {
                System.out.println("PLAYER WINS; GAME OVER");
                return false;
            }
            if (board[i][0].equals(board[1][1]) && board[1][1].equals(board[2-i][2]) && board[i][0].equals("O")) {
                System.out.print("CPU WINS; GAME OVER");
                return false;
            }
        }
        return true;

    }

    public static void place_player(String p, String[][] board, String m) {

        switch (p) {

        case "1":
            if (board[0][0].equals("1")) {
                board[0][0] = m;
                break;
            }

        case "2":
            if (board[0][1].equals("2")) {
                board[0][1] = m;
                break;
            }

        case "3":
            if (board[0][2].equals("3")) {
                board[0][2] = m;
                break;
            }

        case "4":
            if (board[1][0].equals("4")) {
                board[1][0] = m;
                break;
            }

        case "5":
            if (board[1][1].equals("5")) {
                board[1][1] = m;
                break;
            }

        case "6":
            if (board[1][2].equals("6")) {
                board[1][2] = m;
                break;
            }

        case "7":
            if (board[2][0].equals("7")) {
                board[2][0] = m;
                break;
            }

        case "8":
            if (board[2][1].equals("8")) {
                board[2][1] = m;
                break;
            }

        case "9":
            if (board[2][2].equals("9")) {
                board[2][2] = m;
                break;
            }

        default:
            break;
        }

    }

}