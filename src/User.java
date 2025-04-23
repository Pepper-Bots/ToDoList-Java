package src;

import java.util.Objects;


public class User {

    private final Long id;
    private final String firstName;
//    private static int nextId = 1;   // nextId = variable qui va nous servir à donner un identifiant unique à chaque utilisateur  // static veut dire que cette variable appartient à la classe User et non à un objet User en particulier
    
    // Constructor
    public User(String creator, String firstname){  //Constructeur de la classe User / appelé quand on crée un nouvel objt User - prend en param prénom de l'user  + donne un id unique à l'user en utilisant nextId
        this.id = Math.round(Math.random()* 1000);
        this.firstName = firstname;
    }

    public User(String firstName){
        this.id = Math.round(Math.random()* 1000);
        this.firstName = "";
    }


    // Getter -> Récupérer
    public Long getId() {return id; }  // methode - action que l'objet peut faire / Ici permet de récupérerla valeur de l'id / getter
    public String getFirstName() {return firstName; } // autre getter qui permet de recuperer le prenom de l'user

    // Equals -> Comparer
    @Override  // ??
        public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return id == user.id; }
    // Permet de comparer 2 objt pour voir s'ils sont égaux
    // On dit qu'on la redéfinit car elle existe déjà dans la classe Object (la classe mère de toutes les classes en Java).
    // Ici, on dit que deux utilisateurs sont égaux s'ils ont le même identifiant (id).

    // hashCode TODO qu'est ce que ça fait exactement ?
    @Override
    public int hashCode() {return Objects.hash(id); }
    // Cette méthode est utilisée avec equals() pour stocker les objets User dans des collections (comme les listes).

    // toString TODO Comment ça fonctionne ?
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                '}'; }
    // Cette méthode permet de transformer un objet User en une chaîne de caractères pour l'afficher.
}
