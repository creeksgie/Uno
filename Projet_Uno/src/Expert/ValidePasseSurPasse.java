package Expert;

import Carte.Carte;
import Carte.CartePasse;

public class ValidePasseSurPasse extends Valide {


    public ValidePasseSurPasse(Valide suivant) {
        super(suivant);
    }

    @Override
    public boolean Test(Carte carte, Carte carteTas) throws Exception {


        if (saitTester(carte, carteTas)) {
                return true;
        }


        return false;
    }

    @Override
    public boolean saitTester(Carte carte, Carte carteTas) {


        if (carte instanceof CartePasse && carteTas instanceof CartePasse) {
            return true;
        }
        return false;
    }
}
