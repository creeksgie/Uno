package Expert;

import Carte.Carte;
import Carte.CarteSimple;
import Carte.CartePasse;
import Partie.Partie;

public class ValidePasseSurSimple extends Valide {



    public ValidePasseSurSimple(Valide suivant) {
        super(suivant);
    }

    @Override
    public boolean Test(Carte carte, Carte carteTas) throws Exception {


        if (saitTester(carte, carteTas)) {

            CartePasse cp = (CartePasse) carte;
            CarteSimple cs = (CarteSimple) carteTas;
                return cp.getCouleur() == cs.getCouleur() ;

        }


        return false;
    }

    @Override
    public boolean saitTester(Carte carte, Carte carteTas) {

        if (carte instanceof CartePasse && carteTas instanceof CarteSimple) {
            return true;
        }
        return false;
    }
}

