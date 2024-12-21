public interface GererDB {
    public GererDB(String bd);

    public void connect();

    public void verify();

    public void create();

    public void drop();

    public void save(Data d);
}
