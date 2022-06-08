package Expert;

import Carte.Carte;
import Carte.CarteSimple;
import Carte.CartePlusDeux;

public class ValideSimpleSurPlusDeux extends Valide{

    /**
     * Constructeur de la classe ValideSimpleSurPlusDeux
     * @param suivant
     */
    public ValideSimpleSurPlusDeux(Valide suivant) {
        super(suivant);
    }

    @Override
    public boolean Test(Carte carte, Carte carteTas) {

        CartePlusDeux cp = (CartePlusDeux) carteTas;
        CarteSimple cs = (CarteSimple) carte;
        return cp.getCouleur() == cs.getCouleur();

    }

    @Override
    public boolean saitTester(Carte carte, Carte carteTas) {

        if (carte instanceof CarteSimple && carteTas instanceof CartePlusDeux) {
            return true;
        }
        return false;
    }
}
