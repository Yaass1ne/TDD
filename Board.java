
public class Board {
    private final char[][] grid = new char[3][3];

    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = '-';
            }
        }
    }

    public void placeMove(int x, int y, char player) {
        if (x < 0 || x > 2) {
            throw new RuntimeException("Coordonnée x invalide : " + x);
        }
        if (y < 0 || y > 2) {
            throw new RuntimeException("Coordonnée y invalide : " + y);
        }
        if (grid[x][y] != '-') {
            throw new RuntimeException("Case déjà occupée : (" + x + ", " + y + ")");
        }
        grid[x][y] = player;
    }

    public char getCell(int x, int y) {
        return grid[x][y];
    }


    public char checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] != '-' &&
                grid[i][0] == grid[i][1] &&
                grid[i][1] == grid[i][2]) {
                return grid[i][0]; 
            }
        }
        for (int j = 0; j < 3; j++) {
            if (grid[0][j] != '-' &&
                grid[0][j] == grid[1][j] &&
                grid[1][j] == grid[2][j]) {
                return grid[0][j];
            }
        }
        if (grid[1][1] != '-') {
            if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
                return grid[1][1];
            }
            if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
                return grid[1][1];
            }
        }
        return '-'; 
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public void reset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = '-';
            }
        }
    }
}
