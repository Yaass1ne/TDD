
public class TicTacToeGame {
    private final Board board;
    private char currentPlayer; 
    private boolean gameOver;
    private int turn;

    public TicTacToeGame() {
        this.board = new Board();
        this.currentPlayer = 'X';
        this.gameOver = false;
        this.turn = 1;
    }

    public boolean play(int x, int y) {
        if (gameOver) {
            return false;
        }
        try {
            board.placeMove(x, y, currentPlayer);

            char winner = board.checkWinner();
            if (winner != '-') {
                gameOver = true;
            } else if (board.isFull()) {
                gameOver = true;
            }
            turn++;
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public char getWinner() {
        return board.checkWinner();
    }

    public int getTurn() {
        return turn;
    }

    public Board getBoard() {
        return board;
    }
    public void resetGame() {
        board.reset();
        currentPlayer = 'X';
        gameOver = false;
        turn = 1;
    }
}
