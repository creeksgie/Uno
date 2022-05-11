package Exception;


public class CarteException extends Exception{

    /**
     * Exception liée à une carte
     * @param s le message d'erreur
     */
    public CarteException(String s){
        super(s);
    }
}
