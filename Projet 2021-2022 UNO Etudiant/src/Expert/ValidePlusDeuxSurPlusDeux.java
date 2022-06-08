package Expert;

import Carte.Carte;
import Carte.CartePlusDeux;

public class ValidePlusDeuxSurPlusDeux extends Valide {
	
	/**
     * Constructeur de la classe ValidePlusDeuxSurPlusDeux
     * @param suivant
     */
    public ValidePlusDeuxSurPlusDeux(Valide suivant) {
        super(suivant);
    }

    @Override
    public boolean Test(Carte carte, Carte carteTas) {


	    if (saitTester(carte, carteTas)) {
	             return true;
	    }
	
	
	     return false;
    }

    @Override
    public boolean saitTester(Carte carte, Carte carteTas) {

        if (carte instanceof CartePlusDeux && carteTas instanceof CartePlusDeux) {
            return true;
        }
        return false;
    }
}
