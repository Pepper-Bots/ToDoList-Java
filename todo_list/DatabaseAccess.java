package todo_list;// Singleton

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess{

    protected ArrayList<Task> tasks;
    protected ArrayList<User> users;

    // nouvelle instance  = nouvelle connexion à la db
    private static DatabaseAccess instance; // protégé contre l’accès externe et statique

    // TODO mieux ici ou apres la methode getInstance ?
    private DatabaseAccess() {} // constructeur privé avec protection d’accès externe  //  toujours vide pour le singleton

    public static DatabaseAccess getInstance() {  // méthode publique, appel par code
        if (instance == null) {  // seulement si aucune instance n’existe, en créer une nouvelle
            instance = new DatabaseAccess();
        }
        return instance;
    }

    private List<User> taskusers = new ArrayList<>();
    private List<Task> taskList = new ArrayList<>();


    // Initialisation liste de Taches
    private void fillTasks() {
        tasks.add(new Task("Titre 1", "Description 1", users.get(0)));
        tasks.add(new Task("Titre 2", "Description 2", users.get(1)));
        tasks.add(new Task("Titre 3", "Description 3", users.get(2)));
        tasks.add(new Task("Titre 4", "Description 4", users.get(2)));
        tasks.add(new Task("Titre 5", "Description 5", users.get(2)));
        tasks.add(new Task("Titre 6", "Description 6", users.get(1)));
    }


//    ----------------
//    ---------------- creation task
//    ----------------


    // Initialisation liste de Users
    private void fillUser() {
        users.add(new User("User1"));
        users.add(new User("User2"));
        users.add(new User("User3"));
        users.add(new User("User4"));
    }

    // Trouver 1 user
    public Boolean findUser(User user) {
        return users.contains(user);
    }

    // Ajouter 1 user
    public void addUser(User user) {
        users.add(user);
    }

    // Supprimer un User
    public void removeUser(User user) {
        users.remove(user);
    }



    public User getUser(Long id) {
        for(User user : users) {
            if(user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public User getUser(String name) {
        for(User user : users) {
            if(user.getFirstName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public Task getTask(Long id) {
        for(Task task : tasks) {
            if(task.getId().equals(id)) {
                return task;
            }
        }
        return null;
    }

    public Task getTask(String title) {
        for(Task task : tasks) {
            if(task.getTitle().equals(title)) {
                return task;
            }
        }
        return null;
    }

    private void fillUsers() {
        users.add(new User("Bob"));
        users.add(new User("Jacob"));
        users.add(new User("Paul"));
    }

    public Task getTAskByID(Long id) throws ElementNotFoundException {

        for(Task task : tasks) {
            if(task.getId().equals(id)) {
                return task;
            }
        }
        throw new ElementNotFoundException("Task not found");
    }

}







