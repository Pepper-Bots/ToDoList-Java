// Singleton

public final class DatabaseAccess{

    private static DatabaseAccess instance = new DatabaseAccess();

    // TODO mieux ici ou apres la methode getInstance ?
    private DatabaseAccess() {}

    public static DatabaseAccess getInstance() {
        if (instance == null) {
            instance = new DatabaseAccess();
        }
        return instance;
    }

    public String getDBAddress() {
        return "localhost";

    }


}
