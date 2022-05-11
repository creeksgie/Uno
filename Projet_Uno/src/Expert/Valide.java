package Expert;

import Carte.Carte;
import Partie.Partie;

/**
 * Classe qui permet de valider une carte
 */
public abstract class Valide{


    private Valide suivant;

    /**
     * Permet de mettre un suivant à la classe
     * @param suivant
     */
    public Valide(Valide suivant) {
        this.suivant = suivant;
    }

    /**
     * permet de traiter la carte en fonction de la carte du tas si on sait la tester
     * @param carte la carte à traiter
     * @param carteTas la carte du tas
     * @return true si la carte est valide sinon false
     */
    public boolean traiter(Carte carte, Carte carteTas){
        if(saitTester(carte, carteTas))
        {
            return Test(carte, carteTas);
        }
        else if(aUnSuivant())
        {
            return getSuivant().traiter(carte, carteTas);
        }
            return false;
    }

    /**
     * permet de savoir si il y a un suivant
     * @return true si il y a un suivant sinon false
     */
    private boolean aUnSuivant()
    {
        return suivant != null;
    }

    /**
     * Getter du suivant
     * @return le suivant
     */
    public Valide getSuivant() {
        return suivant;
    }

    /**
     * Permet de tester la carte
     * @param carte la carte à tester
     * @param carteTas la carte du tas
     * @return true si la carte est valide sinon false
     */
    public abstract boolean Test(Carte carte, Carte carteTas);

    /**
     * Permet de savoir si la carte peut être testée
     * @param carte la carte à tester
     * @param CarteTas la carte du tas
     * @return true si la carte peut être testée sinon false
     */
    public abstract boolean saitTester(Carte carte, Carte CarteTas);
}
