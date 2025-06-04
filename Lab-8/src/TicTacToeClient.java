import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class TicTacToeClient extends JFrame {
    private JButton[][] buttons = new JButton[3][3];
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public TicTacToeClient() {
        setTitle("Tic Tac Toe (Client)");
        setSize(300, 300);
        setLayout(new GridLayout(3, 3));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        try {
            socket = new Socket("localhost", 4000);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            String board = in.readLine();
            drawBoard(board);
        } catch (IOException ex) {
            showMessage("Failed to connect to the server.");
            System.exit(1);
        }

        setVisible(true);
    }

    private void drawBoard(String boardStr) {
        char[] board = boardStr.toCharArray();
        getContentPane().removeAll();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton btn = new JButton(String.valueOf(board[i * 3 + j]));
                int row = i, col = j;

                btn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 36));
                btn.setFocusPainted(false);

                if (board[i * 3 + j] == ' ') {
                    btn.addActionListener(e -> handleMove(row, col));
                } else {
                    btn.setEnabled(false);
                }

                buttons[i][j] = btn;
                add(btn);
            }
        }

        revalidate();
        repaint();
    }

    private void handleMove(int row, int col) {
        out.println("" + row + col);

        try {
            String response = in.readLine();
            String updatedBoard = in.readLine();
            drawBoard(updatedBoard);

            switch (response) {
                case "WIN" -> endGame("🎉 You won!");
                case "LOSE" -> endGame("😢 You lost.");
                case "DRAW" -> endGame("🤝 It's a draw.");
                case "CONTINUE" -> {} // Do nothing, game continues
                case "INVALID" -> showMessage("Invalid move!");
            }
        } catch (IOException e) {
            showMessage("Connection to the server lost.");
        }
    }

    private void endGame(String message) {
        showMessage(message);
        for (JButton[] row : buttons)
            for (JButton btn : row)
                btn.setEnabled(false);
    }

    private void showMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TicTacToeClient::new);
    }
}
