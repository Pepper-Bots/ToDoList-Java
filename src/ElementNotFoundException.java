package src;

public class ElementNotFoundException extends Exception{

    public ElementNotFoundException(String message) {  // j'ai crée un constructeur pr pouvoir ecrire un msg
        super(message);
    }
}
