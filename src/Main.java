import com.mns.todo.database.DatabaseAccess;
import com.mns.todo.database.DatabaseSeeder;
import me.xdrop.jrand.JRand;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Main {
    static DatabaseAccess dba = DatabaseAccess.getInstance();

    public static void main(String[] args) {
        DatabaseSeeder dbSeeder = new DatabaseSeeder();
        dbSeeder.seed();

        DatabaseAccess dba = DatabaseAccess.getInstance();
        var users = dba.getUsers();

        users.forEach(System.out::println);

    }
}


//package src;
//
//import src.database.DatabaseAccess;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.*;
//import me.xdrop.jrand.JRand;
//
//public class Main {
//    static DatabaseAccess dba = DatabaseAccess.getInstance();
//
//
//    public static void main(String[] args) {
//
//        DatabaseSeeder dbSeeder = new DatabaseSeeder();
//        dbSeeder.seed();
//
//        // Utilisation dépendance JRand pour générer des firstName + lastName en auto
//        // Je peux créer auto User que je veux avec cette méthode
//        // var firstNameGenerator = JRand.firstname();
//        // var lastnameGenerator = JRand.lastname();
//
//        Task builtTask = new TaskBuilder()
//                .setCreator(new User(firstName))
//                .setDescription("Ceci est un test")
//                //.setTitle("Le titre de ma tâche")
//                .setDone(false)
//                .createTask();
//
//
//        var scanner = new Scanner(System.in);
//        System.out.print("Quel est votre nom? ");
//        String firstName = scanner.nextLine();
//        User u = new User(firstName);
//        dba.addUser(u);
//
//        Task task = new Task();
//        task.setCreatot(u);
//        task.setDone(false);
//        task.setTitle("Ma tâche");
//        task.setDescription("Ma description");
//        dba.addTask(task);
//
//        Task task2 = new Task();
//        task2.setCreator(u);
//        task2.setDone(false);
//        task2.setTitle("My Task2");
//        task2.setDescription("My Description2");
//        dba.addTask(task2);
//
//        DatedTask task3 = new DatedTask();
//        task3.setCreator;
//        task3.setDone(false);
//        task3.setTitle("My Task3");
//        task3.setDescription("My Description3");
//        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        try{
//            task3.setDueDate()(formatter.parse("01/01/2026"));
//        } catch (ParseException e){
//            System.out.println(e.getMessage());
//        }
//        dba.addTask(task3);
//
//
//public Task getTaskByISD(long id);
//
//    List<Task> tasks = new ArrayList<>();     // On crée une liste pour stocker les tâches / ArrayList est un type de liste qui permet d'ajouter et suppr facilement des elemts
//        for (Task t: tasks) {
//            System.out.println(t);
//        }
//    }
//
//
//
//    public void run() {
//        boolean running = true;
//        while (running) {
//            System.out.println("\nMenu:");
//            System.out.println("1. Lister les tâches");
//            System.out.println("2. Créer une tâche");
//            System.out.println("3. Supprimer une tâche");
//            System.out.println("4. Modifier une tâche");
//            System.out.println("5. Quitter");
//            System.out.print("Votre choix: ");
//
//            int choice = Scanner.nextInt();
//            Scanner.nextLine(); // Consume newline
//
//            switch (choice) {
//                case 1:
//                    listTasks();
//                    break;
//                case 2:
//                    createTask();
//                    break;
//                case 3:
//                    deleteTask();
//                    break;
//                case 4:
//                    updateTask();
//                    break;
//                case 5:
//                    running = false;
//                    break;
//                default:
//                    System.out.println("Choix invalide.");
//            }
//        }
//    }
//
//    private void listTasks() {
//        if (Task.isEmpty()) {
//            System.out.println("Aucune tâche enregistrée.");
//        } else {
//            Task[] DatedTask = new Task[0];
//            for (Task task : DatedTask) {
//                System.out.println(task);
//            }
//        }
//    }
//
//    private void createTask() {
//        System.out.print("Titre de la tâche: ");
//        String title = scanner.nextLine();
//        System.out.print("Description de la tâche: ");
//        String description = scanner.nextLine();
//
//        // Création d'un utilisateur (à remplacer par votre logique de récupération de l'utilisateur)
//        User user = new User(firstName);
//
//        System.out.print("Est-ce une tâche datée ? (oui/non): ");
//        String isDated = scanner.nextLine();
//
//        if (isDated.equalsIgnoreCase("oui")) {
//            System.out.print("Date d'échéance (jj/mm/aaaa): ");
//            String dueDateStr = scanner.nextLine();
//            // Ajoutez ici la logique pour convertir dueDateStr en un objet Date
//            Date dueDate = new Date(); // Ceci est un exemple, à remplacer par la conversion
//            Task task = new DatedTask(title, description, user, dueDate);
//            DatedTask.add(task);
//        } else {
//            Task task = new Task(title, description, user);
//            DatedTask.add(task);
//        }
//
//        System.out.println("Tâche créée avec succès.");
//    }
//
//    private void deleteTask(Task task) {
//        System.out.print("ID de la tâche à supprimer: ");
//        Long id = scanner.nextLong();
//        scanner.nextLine(); // Consume newline
//        Task.removeIf(DatedTask -> {
//            boolean b;
//            if (DatedTask.getId() == null) {
//                b = false;
//            } else {
//                b = true;
//            }
//            return b;
//        });
//        System.out.println("Tâche supprimée.");
//    }
//
//    private void updateTask() {
//        System.out.print("ID de la tâche à modifier: ");
//        Long id = scanner.nextLong();
//        scanner.nextLine(); // Consume newline
//
//        Task[] DatedTask = new Task[0];
//        for (Task task : DatedTask) {
//            if (task.getId() == id) {
//                System.out.print("Nouveau titre (laisser vide pour ne pas modifier): ");
//                String title = scanner.nextLine();
//                System.out.print("Nouvelle description (laisser vide pour ne pas modifier): ");
//                String description = scanner.nextLine();
//
//                if (!title.isEmpty()) {
//                    task.setTitle(title);
//                }
//                if (!description.isEmpty()) {
//                    task.setDescription(description);
//                }
//
//                System.out.println("Tâche modifiée.");
//                return;
//            }
//        }
//
//        System.out.println("Tâche non trouvée.");
//    }
//}
