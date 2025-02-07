package todo_list;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws ParseException {

        DatabaseAccess dba = DatabaseAccess.getInstance();

        var scanner = new Scanner(System.in);

    dba.addUser(new User());

        TaskBuilder tb = new TaskBuilder().setCreator(new User()).setDone(false).setTitle("Le titre de ma tâche").setDescription("La description de ma tâche");



public Task getTaskByISD(long id);

    List<Task> tasks = new ArrayList<>();     // On crée une liste pour stocker les tâches / ArrayList est un type de liste qui permet d'ajouter et suppr facilement des elemts
        for (Task t: tasks) {
            System.out.println(t);
        }
    }



    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Lister les tâches");
            System.out.println("2. Créer une tâche");
            System.out.println("3. Supprimer une tâche");
            System.out.println("4. Modifier une tâche");
            System.out.println("5. Quitter");
            System.out.print("Votre choix: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    listTasks();
                    break;
                case 2:
                    createTask();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    updateTask();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }
    }

    private void listTasks() {
        if (DatedTask.isEmpty()) {
            System.out.println("Aucune tâche enregistrée.");
        } else {
            Task[] DatedTask = new Task[0];
            for (Task task : DatedTask) {
                System.out.println(task);
            }
        }
    }

    private void createTask() {
        System.out.print("Titre de la tâche: ");
        String title = scanner.nextLine();
        System.out.print("Description de la tâche: ");
        String description = scanner.nextLine();

        // Création d'un utilisateur (à remplacer par votre logique de récupération de l'utilisateur)
        User user = new User("John Doe");

        System.out.print("Est-ce une tâche datée ? (oui/non): ");
        String isDated = scanner.nextLine();

        if (isDated.equalsIgnoreCase("oui")) {
            System.out.print("Date d'échéance (jj/mm/aaaa): ");
            String dueDateStr = scanner.nextLine();
            // Ajoutez ici la logique pour convertir dueDateStr en un objet Date
            Date dueDate = new Date(); // Ceci est un exemple, à remplacer par la conversion
            Task task = new DatedTask(title, description, user, dueDate);
            DatedTask.add(task);
        } else {
            Task task = new Task(title, description, user);
            DatedTask.add(task);
        }

        System.out.println("Tâche créée avec succès.");
    }

    private void deleteTask(Task task) {
        System.out.print("ID de la tâche à supprimer: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline
        Task.removeIf(DatedTask -> {
            boolean b;
            if (DatedTask.getId() == null) {
                b = false;
            } else {
                b = true;
            }
            return b;
        });
        System.out.println("Tâche supprimée.");
    }

    private void updateTask() {
        System.out.print("ID de la tâche à modifier: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Task[] DatedTask = new Task[0];
        for (Task task : DatedTask) {
            if (task.getId() == id) {
                System.out.print("Nouveau titre (laisser vide pour ne pas modifier): ");
                String title = scanner.nextLine();
                System.out.print("Nouvelle description (laisser vide pour ne pas modifier): ");
                String description = scanner.nextLine();

                if (!title.isEmpty()) {
                    task.setTitle(title);
                }
                if (!description.isEmpty()) {
                    task.setDescription(description);
                }

                System.out.println("Tâche modifiée.");
                return;
            }
        }

        System.out.println("Tâche non trouvée.");
    }
}
