package Expert;

import Carte.Carte;
import Carte.CarteSimple;



public class ValideSimpleSurSimple extends Valide{

    /**
     * Constructeur de la classe ValideSimpleSurSimple
     * @param suivant
     */
    public ValideSimpleSurSimple(Valide suivant) {
        super(suivant);
    }

    @Override
    public boolean Test(Carte carte, Carte carteTas){


        if(saitTester(carte, carteTas))
        {
            CarteSimple cp = (CarteSimple) carte;
            CarteSimple cs = (CarteSimple) carteTas;

                return cp.getCouleur() == cs.getCouleur() || cp.getNumero() == cs.getNumero();

        }


        return false;
    }

    @Override
    public boolean saitTester(Carte carte, Carte carteTas) {



        if(carte instanceof CarteSimple && carteTas instanceof CarteSimple)
        {
            return true;
        }
        return false;
    }
}
