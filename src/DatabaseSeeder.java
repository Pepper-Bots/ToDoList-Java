package src;

import me.xdrop.jrand.JRand;
import java.util.ArrayList;
import java.util.List;


public class DatabaseSeeder {

    // Méthode qui va me permettre de créer plein de Tasks et d'Users
    public void seed() {

        // Ségrégation des responsabilités
        DatabaseAccess dba = DatabaseAccess.getInstance();

        // Je créé une liste d'Users retournée par la méthode
        List<User> users = generateUsers(100);
        // Je les sauvegarde avec la méthode addUser
        users.forEach(dba :: addUser);
        List<Task> tasks = generateTasks(100);
        tasks.forEach(task -> {
            task.setCreator(users.get(new Random().nextInt(users.size()))); // Random().nextInt renvoie une tache au hasard selon le nb d'utilisateurs
            dba.addTask(task);
        });
    }


    private List<User> generateUsers(int number){
        var firstNames = JRand.firstname().genMany(number);
        var lastNames = JRand.lastname().genMany(number);
        for (int i = 0; i < number ; i++) {
            var user = new User(firstNames.get(i), lastNames.get(i));
            users.add(user);
        }
        return users;
    }

    private List<Task> generateTasks(int number){
        var wordGenerator = JRand.word();
        var paragraphGenerator = JRand.paragraph();
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Task t = new Task();
            t.setTitle(wordGenerator.gen());
            t.setDescription(paragraphGenerator.gen());
        }
        return tasks;

    }


}
