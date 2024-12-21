public class TicTacToeSave {
    
    private final GererDB gererDB;

    public TicTacToeSave(GererDB gererDB) {
        this.gererDB = gererDB;
    }

    public boolean initDb() {
        try {
            gererDB.verify();
            gererDB.connect();
            return true;
        } catch (Exception e) {
            try {
                gererDB.create();
                gererDB.connect();
                return true;
            } catch (Exception e2) {
                return false;
            }
        }
    }
    public boolean saveMove(int turn, int x, int y, char player) {
        try {
            Data d = new Data(turn, x, y, player);
            gererDB.save(d);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean resetDb() {
        try {
            gererDB.drop();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
