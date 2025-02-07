package todo_list;

import java.util.Objects;


// Définition de la classe Task (dans Task.java ou ici)
public class Task {

    protected final long id; // Identifiant unique de la tâche
    protected String title; // Titre de la tâche
    protected String description; // Description de la tâche
    protected boolean done; // Indique si la tâche est terminée ou non
    protected User creator; // Utilisateur qui a créé la tâche

    // Constructeur de la classe Task
    public Task(String title, String description, User user) {
        this.id = Math.round(Math.random()* 1000); // Attribution de l'ID unique
        this.title = title;
        this.description = description;
        this.done = false; // Par défaut, une tâche n'est pas terminée
        this.creator = user;
    }

    public Task(){
        this.id = Math.round(Math.random()* 1000);
    }

    public Task(long id, String title, String description, User creator) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creator = creator;
    }

    // Getters pour accéder aux attributs (encapsulation)
    public final Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public boolean isDone() { return done; }
    public User getUser() { return creator; }

    // Setters pour modifier les attributs
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setDone(boolean done) { this.done = done; }


    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        todo_list.Task task = (todo_list.Task) obj;
        return id == task.id;
    }

    @Override
    public int hashCode(){ return Objects.hash(id); }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", done=" + done +
                ", user=" + creator +
                '}';
    }


}

