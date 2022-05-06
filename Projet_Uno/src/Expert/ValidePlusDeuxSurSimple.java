package Expert;

import Carte.Carte;
import Carte.CarteSimple;
import Carte.CartePasse;
import Carte.CartePlusDeux;


public class ValidePlusDeuxSurSimple extends Valide {



    public ValidePlusDeuxSurSimple(Valide suivant) {
        super(suivant);
    }

    @Override
    public boolean Test(Carte carte, Carte carteTas) throws Exception {


        if (saitTester(carte, carteTas)) {

            CartePlusDeux cp = (CartePlusDeux) carte;
            CarteSimple cs = (CarteSimple) carteTas;
            return cp.getCouleur() == cs.getCouleur() ;

        }


        return false;
    }

    @Override
    public boolean saitTester(Carte carte, Carte carteTas) {

        if (carte instanceof CartePlusDeux && carteTas instanceof CarteSimple) {
            return true;
        }
        return false;
    }
}
