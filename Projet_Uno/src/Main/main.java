package Main;

import Partie.Partie;
import Partie.Test;

public class main {

    public static void main(String[] args) {

        Partie partie = Partie.getInstance();
        Test T1 = new Test();

        T1.AliceBonneCouleur(partie);

        T1.BobBonneCarteCouleurDiff(partie);

        T1.TestCarteIllegale(partie);

        T1.DeuxCarteLegale(partie);

        T1.FaitRien(partie);

        T1.JouePuisPioche(partie);

        T1.AlicePunition(partie);

        T1.TestBobPasSontTour(partie);

        T1.AliceUno(partie);

        T1.AliceOublieUno(partie);

        T1.BobUnoPasSontTour(partie);

        T1.AliceJouePasseTour(partie);

        T1.SimpleSurPasseIllegale(partie);

        T1.PasseSurSimpleIllegale(partie);

        T1.PlusDeux(partie);


    }


}
