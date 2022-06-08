package Expert;

import Carte.Carte;
import Carte.CartePasse;
import Carte.CartePlusDeux;

public class ValidePlusDeuxSurPasse extends Valide {
	/**
     * Constructeur de la classe ValidePlusDeuxSurPasse
     * @param suivant
     */
    public ValidePlusDeuxSurPasse(Valide suivant) {
        super(suivant);
    }

    @Override
    public boolean Test(Carte carte, Carte carteTas) {


        CartePlusDeux cp = (CartePlusDeux) carte;
        CartePasse cs = (CartePasse) carteTas;
        return cp.getCouleur() == cs.getCouleur();

    }

    @Override
    public boolean saitTester(Carte carte, Carte carteTas) {

        if (carte instanceof CartePlusDeux && carteTas instanceof CartePasse) {
            return true;
        }
        return false;
    }
}
