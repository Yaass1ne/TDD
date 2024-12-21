public class TicTacToeGameTest {

    private TicTacToeGame game;

    @BeforeEach
    void setUp() {
        game = new TicTacToeGame();
    }

    @Test
    void testPremierCoupEstX() {
        // Avant tout coup, le joueur courant est X
        assertEquals('X', game.getCurrentPlayer(),
                     "Le premier coup doit être joué par X");
    }

    @Test
    void testAlternanceXetO() {
        // Tour 1 (X)
        game.play(0, 0);
        assertEquals('O', game.getCurrentPlayer(),
                     "Après X, c’est à O de jouer");

        // Tour 2 (O)
        game.play(1, 0);
        assertEquals('X', game.getCurrentPlayer(),
                     "Après O, c’est à X de jouer");
    }

    @Test
    void testPlacementHorsBornesX() {
        boolean result = game.play(3, 0); // x = 3 (hors [0..2])
        assertFalse(result, "Le coup doit être refusé si x est hors bornes");
    }

    @Test
    void testPlacementHorsBornesY() {
        boolean result = game.play(0, -1); // y = -1 (hors [0..2])
        assertFalse(result, "Le coup doit être refusé si y est hors bornes");
    }

    @Test
    void testPlacementCaseOccupee() {
        // 1er coup : (0, 0)
        assertTrue(game.play(0, 0), "Le premier coup doit réussir");
        // 2e coup au même endroit
        assertFalse(game.play(0, 0), "La case est déjà occupée => refusé");
    }

    @Test
    void testVictoireParLigne() {
        game.play(0, 0); // X
        game.play(1, 0); // O
        game.play(0, 1); // X
        game.play(1, 1); // O
        boolean lastMove = game.play(0, 2); // X
        assertTrue(lastMove, "Le coup est valide");
        assertTrue(game.isGameOver(), "La partie doit être terminée (victoire X)");
        assertEquals('X', game.getWinner(), "Le gagnant est X");
    }

    @Test
    void testMatchNul() {
        game.play(0,0); // X
        game.play(0,1); // O
        game.play(0,2); // X
        game.play(1,0); // O
        game.play(1,1); // X
        game.play(1,2); // O
        game.play(2,0); // X
        game.play(2,2); // O
        game.play(2,1); // X => grille pleine

        assertTrue(game.isGameOver(), "La partie doit être terminée (grille pleine)");
        assertEquals('-', game.getWinner(), "Pas de gagnant => match nul");
    }
}