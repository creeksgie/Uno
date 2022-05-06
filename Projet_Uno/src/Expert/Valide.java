package Expert;

import Carte.Carte;
import Partie.Partie;

public abstract class Valide extends Partie {


    private Valide suivant = null;

    public Valide(Valide suivant) {
        this.suivant = suivant;
    }

    public boolean traiter(Carte carte, Carte carteTas) throws Exception {
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

    private boolean aUnSuivant()
    {
        return suivant != null;
    }

    public Valide getSuivant() {
        return suivant;
    }

    public abstract boolean Test(Carte carte, Carte carteTas) throws Exception;

    public abstract boolean saitTester(Carte carte, Carte CarteTas);
}
