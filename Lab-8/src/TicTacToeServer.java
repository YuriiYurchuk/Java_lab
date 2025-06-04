import java.io.*;
import java.net.*;

public class TicTacToeServer {
    private static final char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    private static boolean makeMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') return false;
        board[row][col] = 'X';
        return true;
    }

    private static String boardToString() {
        StringBuilder sb = new StringBuilder();
        for (char[] row : board) {
            for (char c : row) sb.append(c);
        }
        return sb.toString();
    }

    private static boolean isWin(char player) {
        for (int i = 0; i < 3; i++)
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player))
                return true;
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    private static boolean isDraw() {
        for (char[] row : board)
            for (char c : row)
                if (c == ' ') return false;
        return true;
    }

    private static void makeMachineMove() {

        if (tryPlaceWinningMove('O')) return;

        if (tryPlaceWinningMove('X')) return;

        if (board[1][1] == ' ') {
            board[1][1] = 'O';
            return;
        }

        int[][] corners = {{0,0},{0,2},{2,0},{2,2}};
        for (int[] c : corners) {
            if (board[c[0]][c[1]] == ' ') {
                board[c[0]][c[1]] = 'O';
                return;
            }
        }

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ') {
                    board[i][j] = 'O';
                    return;
                }
    }

    private static boolean tryPlaceWinningMove(char player) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = player;
                    if (isWin(player)) {
                        if (player == 'O') return true; // make move
                        else {
                            board[i][j] = 'O'; // block player
                            return true;
                        }
                    }
                    board[i][j] = ' ';
                }
            }
        }
        return false;
    }


    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4000);
        System.out.println("Server started. Waiting for player...");

        Socket socket = serverSocket.accept();
        System.out.println("Player connected!");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        out.println(boardToString());

        while (true) {
            String input = in.readLine();
            int row = Character.getNumericValue(input.charAt(0));
            int col = Character.getNumericValue(input.charAt(1));

            if (!makeMove(row, col)) {
                out.println("INVALID");
                continue;
            }

            if (isWin('X')) {
                out.println("WIN\n" + boardToString());
                break;
            }

            if (isDraw()) {
                out.println("DRAW\n" + boardToString());
                break;
            }

            makeMachineMove();

            if (isWin('O')) {
                out.println("LOSE\n" + boardToString());
                break;
            }

            if (isDraw()) {
                out.println("DRAW\n" + boardToString());
                break;
            }

            out.println("CONTINUE\n" + boardToString());
        }

        socket.close();
        serverSocket.close();
    }
}
