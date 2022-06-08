package Expert;

import Carte.Carte;
import Carte.CartePasse;
import Carte.CartePlusDeux;

public class ValidePasseSurPlusDeux extends Valide {
	
	   /**
     * Constructeur de la classe ValidePasseSurPlusDeux
     * @param suivant
     */
    public ValidePasseSurPlusDeux(Valide suivant) {
        super(suivant);
    }

    @Override
    public boolean Test(Carte carte, Carte carteTas) {

        CartePlusDeux cp = (CartePlusDeux) carteTas;
        CartePasse cs = (CartePasse) carte;
        return cp.getCouleur() == cs.getCouleur();

    }

    @Override
    public boolean saitTester(Carte carte, Carte carteTas) {

        if (carte instanceof CartePasse && carteTas instanceof CartePlusDeux) {
            return true;
        }
        return false;
    }
}
