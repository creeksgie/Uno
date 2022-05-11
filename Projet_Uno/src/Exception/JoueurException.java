package Exception;

public class JoueurException extends Exception {
    /**
     * Exception liée au joueur
     * @param s le message à afficher
     */
    public JoueurException(String s){
        super(s);
    }
}
