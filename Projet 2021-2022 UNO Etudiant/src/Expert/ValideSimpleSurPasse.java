package Expert;

import Carte.Carte;
import Carte.CarteSimple;
import Carte.CartePasse;

public class ValideSimpleSurPasse extends Valide{
    /**
     * Constructeur de la classe ValideSimpleSurPasse
     * @param suivant
     */
    public ValideSimpleSurPasse(Valide suivant) {
        super(suivant);
    }

    @Override
    public boolean Test(Carte carte, Carte carteTas){


        if(saitTester(carte,carteTas))
        {
            CarteSimple cp = (CarteSimple) carte;
            CartePasse cs = (CartePasse) carteTas;
                return cp.getCouleur() == cs.getCouleur();

        }


        return false;
    }

    @Override
    public boolean saitTester(Carte carte, Carte carteTas) {

        if(carte instanceof CarteSimple && carteTas instanceof CartePasse)
        {
            return true;
        }
        return false;
    }
}

