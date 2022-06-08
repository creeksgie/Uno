package Partie;

import Carte.Carte;
import Carte.CarteSimple;
import Carte.CartePasse;
import Carte.CartePlusDeux;
import Joueur.Joueur;
import Exception.CarteException;
import Exception.JoueurException;
import Exception.TasException;
import Exception.PiocheException;
import Exception.UnoException;

import java.util.ArrayList;

import static java.lang.System.exit;

/**
 * Classe de test
 */
public class Test {

    Carte Vert8 = new CarteSimple(8, "vert");
    ArrayList<Joueur> TabJoueur = new ArrayList<Joueur>();
    ArrayList<Carte> MainAlice = new ArrayList<Carte>();
    ArrayList<Carte> MainBob = new ArrayList<Carte>();
    ArrayList<Carte> MainCharle = new ArrayList<Carte>();

    Carte Rouge1 = new CarteSimple(1, "rouge");
    Carte Jaune6 = new CarteSimple(6, "jaune");
    Carte Vert2 = new CarteSimple(2, "vert");


    Carte Bleu2= new CarteSimple(2, "bleu");
    Carte Jaune4 = new CarteSimple(4, "jaune");
    Carte Rouge9 = new CarteSimple(9, "rouge");


    Carte Bleu0 = new CarteSimple(0, "bleu");
    Carte Bleu7 = new CarteSimple(7, "bleu");
    Carte Bleu9 = new CarteSimple(9, "bleu");


    Joueur Bob = new Joueur("Bob", 2, MainBob);
    Joueur Alice = new Joueur("Alice", 1, MainAlice);
    Joueur Charle = new Joueur("Charles", 3, MainCharle);

    Carte PasseRouge = new CartePasse("rouge");
    Carte PasseVert = new CartePasse("vert");

    Carte Vert6 = new CarteSimple(6, "vert");
    Carte Bleu1 = new CarteSimple(1, "bleu");

    Carte Vert2P = new CartePlusDeux("vert");
    Carte Vert1 = new CarteSimple(1, "vert");


    /**
     * Teste si la carte pausÃ© par Alice est bien de la bonne couleur
     * @param partie la partie
     */
    public  void AliceBonneCouleur(Partie partie)
    {
        partie.initialiser();
        MainAlice.add(Rouge1);
        MainAlice.add(Jaune6);
        MainAlice.add(Vert2);

        try{
            if(partie.getJoueurCourant() != Alice.getOrdre())
            {
                throw new IllegalArgumentException("Alice n'est pas le joueur courant");
            }
            if (Alice.Mainsize() != 3)
            {
                throw new IllegalArgumentException("Alice n'a pas 3 cartes en main" +Alice.Mainsize());

            }

            Alice.JoueUneCarte(Vert2);


            if(Alice.Mainsize() != 2)
            {
                throw new IllegalArgumentException("Alice n'a pas 2 cartes en main" +Alice.Mainsize());
            }

            if(!Alice.get(0).equals(Rouge1))
            {
                throw new IllegalArgumentException("Alice n'a pas la carte rouge 1");

            }

            if(!Alice.get(1).equals(Jaune6))
            {
                throw new IllegalArgumentException("Alice n'a pas la carte jaune 6");
            }

            if(!partie.getTAS(partie.Tassize() - 1).equals(Vert2))
            {
                throw new IllegalArgumentException("Pas la bonne carte au-dessus du tas");
            }

            if(partie.Tassize() != 2)
            {
                throw new IllegalArgumentException("Manque des cartes dans le tas");
            }

            Alice.finTour();

            if(partie.getJoueurCourant() != 2)
            {
                throw new IllegalArgumentException("Le joueur courant n'est pas Bob");
            }

            System.out.printf("Alice joue une carte de la bonne couleur : OK");
        } catch (Exception e) {
            e.printStackTrace();
            exit(1);
        }
    }

    /**
     * Teste si la carte pausÃ© par Bob est bien valide alors qu'elle n'a pas la bonne couleur
     * @param partie
     */
    public void BobBonneCarteCouleurDiff(Partie partie)
    {

        MainBob.add(Rouge9);
        MainBob.add(Jaune4);
        MainBob.add(Bleu2);
        try {

            if (Bob.Mainsize() != 3)
            {
                throw new IllegalArgumentException("Bob n'a pas 3 cartes en main" +Bob.Mainsize());
            }

            Bob.JoueUneCarte(Bleu2);

            if(Bob.Mainsize() != 2)
            {
                throw new IllegalArgumentException("Bob n'a pas 2 cartes dans la main" +Bob.Mainsize());
            }

            if(!Bob.get(0).equals(Rouge9))
            {
                throw new IllegalArgumentException("Bob n'a pas la carte rouge 9");
            }

            if(!Bob.get(1).equals(Jaune4))
            {
                throw new IllegalArgumentException("Bob n'a pas la carte jaune 4");
            }

            if(!partie.getTAS(partie.Tassize() - 1).equals(Bleu2))
            {
                throw new IllegalArgumentException("Pas la bonne carte");
            }

            if(partie.Tassize() != 3)
            {
                throw new IllegalArgumentException("Pas assez de cartes sur le Tas");
            }

            Bob.finTour();

            if(partie.getJoueurCourant() != 3)
            {
                throw  new IllegalArgumentException("Le joueur courant n'est pas Charle");
            }

            System.out.printf("\nBob joue une carte de couleur différente mais de même valeur : OK");


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Teste si la carte pauser est Illegale
     * @param partie
     */
    public void CarteIllegale(Partie partie)
    {
        partie.resetPartie();
        partie.initialiser();
        Alice.clear();
        MainAlice.add(Rouge1);
        MainAlice.add(Jaune6);
        MainAlice.add(Vert2);

        try
        {
            Alice.JoueUneCarte(Jaune6);

        } catch (CarteException e) {
            if (Alice.Mainsize() != 3) {
                throw  new IllegalArgumentException("Alice n'a pas 3 carte dans la main");
            }

            System.out.printf("\nTest d’une carte illégale : OK");

        } catch (JoueurException e)
        {
            e.printStackTrace();

        } catch (TasException e)
        {
            e.printStackTrace();
        }

    }

    /**
     * Teste sur l'exception ou un joueur joue 2 carte legal lors du mÃªme tour
     * @param partie la partie
     */
    public void DeuxCarteLegale(Partie partie)
    {
        partie.resetPartie();
        partie.initialiser();
        Alice.clear();
        MainAlice.add(Rouge1);
        MainAlice.add(Jaune6);
        MainAlice.add(Vert2);
        Bob.clear();
        MainBob.add(Rouge9);
        MainBob.add(Jaune4);
        MainBob.add(Bleu2);
        MainCharle.add(Bleu0);
        MainCharle.add(Bleu7);
        MainCharle.add(Bleu9);

        try {

            Alice.JoueUneCarte(Vert2);
            Alice.finTour();
            Bob.JoueUneCarte(Bleu2);
            Bob.finTour();
            Charle.JoueUneCarte(Bleu9);

            if(Charle.Mainsize() != 2)
            {
                throw  new IllegalArgumentException("Charle n'a pas deux carte dans la main");
            }

            Charle.JoueUneCarte(Bleu7);


        } catch (JoueurException e){

            if(Charle.Mainsize() != 2)
            {
                throw  new IllegalArgumentException("Charle n'a pas deux carte dans la main");
            }

            System.out.printf("\nTest d’un joueur qui pose deux cartes légales de suite : OK");

        } catch (CarteException e)
        {
            e.printStackTrace();
        } catch (TasException e)
        {
            e.printStackTrace();
        } catch (UnoException e)
        {
            e.printStackTrace();
        }


    }

    /**
     * Teste sur l'exception ou un joueur fini son tour sans jouer de carte
     * @param partie la partie
     */
    public void FaitRien(Partie partie)
    {
        Alice.clear();
        MainAlice.add(Rouge1);
        MainAlice.add(Jaune6);
        MainAlice.add(Vert2);

        try {

            Alice.finTour();

        }catch (JoueurException e)
        {
            if(Alice.Mainsize() != 3)
                throw  new IllegalArgumentException("Alice n'a pas 3 carte dans la main");

            System.out.printf("\nTest d’un joueur qui finit son tour sans rien faire : OK");
        } catch (UnoException e)
        {
            e.printStackTrace();
        }


    }

    /**
     * Teste sur l'exception ou un joueur joue une carte puis pioche une carte
     * @param partie la partie
     */
    public void JouePuisPioche(Partie partie)
    {
        partie.resetPartie();
        partie.initialiser();
        Alice.clear();
        MainAlice.add(Rouge1);
        MainAlice.add(Jaune6);
        MainAlice.add(Vert2);

        try{

            Alice.JoueUneCarte(Vert2);
            Alice.Pioche();

        }catch(PiocheException e)
        {
            if(Alice.Mainsize() != 2)
                throw  new IllegalArgumentException("Alice n'a pas 2 carte dans la main");

            if(!partie.getPioche(partie.Piochesize() - 1).equals(Jaune6))
            {
                throw  new IllegalArgumentException("Pas la bonne carte");
            }

            System.out.printf("\nTest d’un joueur qui joue puis pioche : OK");
        }catch (JoueurException e)
        {
           e.printStackTrace();
        } catch (CarteException e)
        {
            e.printStackTrace();
        } catch (TasException e)
        {
            e.printStackTrace();
        }


    }

    /**
     * Teste de la punition quand Alice joue une carte illegale
     * @param partie la partie
     */
    public void AlicePunition(Partie partie)
    {
        partie.resetPartie();
        partie.initialiser();
        partie.setJoueurCourant(1);
        Alice.clear();
        MainAlice.add(Rouge1);
        MainAlice.add(Jaune6);
        MainAlice.add(Vert2);

        try{
            if(partie.getJoueurCourant() != Alice.getOrdre())
            {
                System.out.printf("Alice n'est pas le bon joueur");
            }

            Alice.JoueUneCarte(Jaune6);

        }catch(CarteException e)
        {

            try
            {
                partie.punition(Alice);

                if(partie.getJoueurCourant() != Bob.getOrdre())
                {
                    throw new IllegalArgumentException("Bob n'est pas le bon joueur"+partie.getJoueurCourant());
                }

                if(Alice.Mainsize() != 5)
                {
                    throw new IllegalArgumentException("Alice n'a pas 5 carte");
                }

                if(!partie.getPioche(partie.Piochesize() - 1).equals(Vert2))
                {
                    throw new IllegalArgumentException("Le deux vert n'est pas au sommet de la pioche");
                }

                System.out.println("\nTest de la punition pour un coup illégal d’Alice (joueur courant) : OK");

            }catch(JoueurException a)
            {
                a.printStackTrace();
            }catch (PiocheException a){
                a.printStackTrace();
            } catch (UnoException a) {
                a.printStackTrace();
            }

        } catch (JoueurException e)
        {
            e.printStackTrace();
        } catch (TasException e) {
            e.printStackTrace();
        }
    }

    /**
     * Teste de la punition quand Bob dÃ©cide de jouer alors que ce n'est pas son tour
     * @param partie la partie
     */
    public void BobPasSontTour(Partie partie)
    {
        partie.resetPartie();
        partie.initialiser();
        partie.setJoueurCourant(1);
        Alice.clear();
        MainAlice.add(Rouge1);
        MainAlice.add(Jaune6);
        MainAlice.add(Vert2);
        Bob.clear();
        MainBob.add(Rouge9);
        MainBob.add(Jaune4);
        MainBob.add(Bleu2);


        try{

            if(partie.getJoueurCourant() != Alice.getOrdre())
            {
                System.out.println("Alice n'est pas le joueur courant");
            }

            Bob.Pioche();

        }catch(PiocheException e)
        {
            try{
                partie.punition(Bob);

                if(partie.getJoueurCourant() != Alice.getOrdre())
                {
                    throw new IllegalArgumentException("Alice n'est pas le joueur courant");
                }

                if(Bob.Mainsize() != 5)
                {
                    throw new IllegalArgumentException("Bob n'a pas 5 carte");
                }

                if(!partie.getPioche(partie.Piochesize() - 1).equals(Vert2))
                {
                    throw new IllegalArgumentException("Le deux vert n'est pas au sommet de la pioche");
                }

                System.out.println("Test d’une action de bob lorsque ce n’est pas son tour: OK");
            } catch (PiocheException a)
            {
                a.printStackTrace();
            } catch (JoueurException a)
            {
                a.printStackTrace();
            } catch (UnoException a) {
                a.printStackTrace();
            }


        }

    }

    /**
     * Teste quand Alice dit Uno
     * @param partie la partie
     */
    public void AliceUno(Partie partie)
    {
        partie.resetPartie();
        partie.initialiserUno();
        partie.setJoueurCourant(1);

        Alice.clear();
        Bob.clear();

        MainAlice.add(Jaune6);
        MainAlice.add(Vert2);

        MainBob.add(Bleu2);
        MainBob.add(Jaune4);

        try{

            if(Alice.Mainsize() != 2)
            {
                System.out.printf("Alice n'a pas deux carte dans les mains");
            }

            Alice.JoueUneCarte(Vert2);
            Alice.Uno();
            Alice.finTour();

            if(Alice.Mainsize() != 1)
            {
                throw new IllegalArgumentException("Alice n'a pas une carte dans les mains");
            }

            if(!partie.getTAS(partie.Tassize() - 1).equals(Vert2))
            {
                throw new IllegalArgumentException("Le deux vert n'est pas au sommet de la pioche");
            }

            if(partie.getJoueurCourant() != Bob.getOrdre())
            {
                throw new IllegalArgumentException("Bob n'est pas le joueurs courant");
            }

            System.out.printf("Test lorsqu’Alice dit « Uno ! » au bon moment : OK");

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Teste quand Alice oublie de dire uno
     * @param partie la partie
     */
    public void AliceOublieUno(Partie partie)
    {
        partie.resetPartie();
        partie.initialiserUno();
        partie.setJoueurCourant(1);


        Alice.clear();
        Bob.clear();

        MainAlice.add(Jaune6);
        MainAlice.add(Vert2);

        MainBob.add(Bleu2);
        MainBob.add(Jaune4);

        try{

            Alice.JoueUneCarte(Vert2);
            Alice.finTour();

        }catch(UnoException e)
        {
            try
            {
                partie.punitionUno(Alice);

                if(Alice.Mainsize() != 4)
                {
                    throw new IllegalArgumentException("\nAlice n'a pas quatre carte dans les mains");
                }

                if(!partie.getTAS(partie.Tassize() - 1).equals(Vert2))
                {
                    throw new IllegalArgumentException("\nLe huit vert n'est pas au sommet de la pioche");
                }

                if(partie.getJoueurCourant() != Bob.getOrdre())
                {
                    throw new IllegalArgumentException("\nBob n'est pas le joueurs courant");
                }

                System.out.printf("\nTest lorsqu’Alice oubli de dire « Uno ! » : OK\n");

            }catch(JoueurException a){
                a.printStackTrace();
            }catch (PiocheException a){
                a.printStackTrace();
            }


        } catch (JoueurException e)
        {
            e.printStackTrace();
        } catch (TasException e) {
            e.printStackTrace();
        }catch (CarteException e)
        {
            e.printStackTrace();
        }

    }

    /**
     * Teste de la punition quand Bob dit Uno alors que ce n'est pas son tour
     * @param partie la partie
     */
    public void BobUnoPasSontTour(Partie partie)
    {
        partie.resetPartie();
        partie.initialiserUno();
        partie.setJoueurCourant(1);

        Alice.clear();
        Bob.clear();

        MainBob.add(Bleu2);

        try{

            if(partie.getJoueurCourant() != Alice.getOrdre())
            {
                System.out.printf("\nAlice n'est pas le joueurs courant");
            }

            Bob.Uno();

        }catch(UnoException e)
        {

            try
            {
                partie.punitionUno(Bob);

                if(Bob.Mainsize() != 4)
                {
                    throw  new IllegalArgumentException("\nBob n'a pas quatre carte dans les mains");
                }

                if(!partie.getTAS(partie.Tassize() - 1).equals(Vert8))
                {
                    throw  new IllegalArgumentException("\nLe huit vert n'est pas au sommet de la pioche");
                }

                if(partie.getJoueurCourant() != Alice.getOrdre())
                {
                    throw  new IllegalArgumentException("\nAlice n'est pas le joueurs courant");
                }

                System.out.printf("Test lorsque Bob dit « Uno ! » quand ce n’est pas son tour : OK");

            }catch(JoueurException a)
            {
                a.printStackTrace();
            } catch (PiocheException a)
            {
                a.printStackTrace();
            }

        }

    }

    /**
     * Teste sur les cartes Passe tour
     * @param partie la partie
     */
    public void AliceJouePasseTour(Partie partie)
    {

        partie.resetPartie();
        partie.initialiserPasse();
        partie.setJoueurCourant(1);


        Alice.clear();
        Bob.clear();
        Charle.clear();

        MainAlice.add(PasseRouge);
        MainAlice.add(Bleu9);
        MainAlice.add(Jaune4);

        MainBob.add(Jaune6);
        MainBob.add(Vert6);
        MainBob.add(Bleu7);

        MainCharle.add(PasseVert);
        MainCharle.add(Bleu1);
        MainCharle.add(Rouge1);

        try{

            if(partie.getJoueurCourant() != Alice.getOrdre())
            {
                throw new IllegalArgumentException("\nAlice n'est pas le joueurs courant");
            }

            Alice.JoueUneCarte(PasseRouge);
            Alice.finTour();

            if(partie.getJoueurCourant() != Charle.getOrdre())
            {
                throw new IllegalArgumentException("\nCharle n'est pas le joueurs courant");
            }

            if(!partie.getTAS(partie.Tassize() - 1).equals(PasseRouge))
            {
                throw new IllegalArgumentException("\nLe passe rouge n'est pas au sommet de la pioche");
            }

            Charle.JoueUneCarte(PasseVert);
            Charle.finTour();

            if(partie.getJoueurCourant() != Bob.getOrdre())
            {
                throw new IllegalArgumentException("\nBob n'est pas le joueurs courant");
            }

            if(!partie.getTAS(partie.Tassize() - 1).equals(PasseVert))
            {
                throw new IllegalArgumentException("\nLe passe vert n'est pas au sommet de la pioche");
            }

            Bob.JoueUneCarte(Vert6);
            Bob.finTour();

            if(partie.getJoueurCourant() != Charle.getOrdre())
            {
                throw new IllegalArgumentException("\nCharle n'est pas le joueurs courant");
            }

            if(!partie.getTAS(partie.Tassize() - 1).equals(Vert6))
            {
                throw new IllegalArgumentException("\nLe 6 vert n'est pas au sommet de la pioche");
            }

            System.out.printf("\nTest de coups légaux avec des cartes « Passe ton tour » : OK");

        } catch (JoueurException e)
        {
            e.printStackTrace();
        }catch (TasException e) {
            e.printStackTrace();
        }catch (CarteException e)
        {
            e.printStackTrace();
        }catch (UnoException e)
        {
            e.printStackTrace();
        }

    }

    /**
     * Teste de la pause illegale d'une carte simple sur une carte passe tour d'une autre couleur
     * @param partie la partie
     */
    public void SimpleSurPasseIllegale(Partie partie)
    {
        partie.resetPartie();
        partie.initialiserPasse();
        partie.setJoueurCourant(1);


        Alice.clear();
        Bob.clear();
        Charle.clear();

        MainAlice.add(PasseRouge);
        MainAlice.add(Bleu9);
        MainAlice.add(Jaune4);

        MainBob.add(Jaune6);
        MainBob.add(Vert6);
        MainBob.add(Bleu7);

        MainCharle.add(PasseVert);
        MainCharle.add(Bleu1);
        MainCharle.add(Rouge1);

        try {
            if (partie.getJoueurCourant() != Alice.getOrdre()) {
                throw new IllegalArgumentException("\nAlice n'est pas le joueurs courant");
            }

            Alice.JoueUneCarte(PasseRouge);
            Alice.finTour();

            if (partie.getJoueurCourant() != Charle.getOrdre()) {
                throw new IllegalArgumentException("\nCharle n'est pas le joueurs courant");
            }

            if (!partie.getTAS(partie.Tassize() - 1).equals(PasseRouge)) {
                throw new IllegalArgumentException("\nLe passe rouge n'est pas au sommet de la pioche");
            }

            Charle.JoueUneCarte(Bleu1);
            Charle.finTour();

        }catch(CarteException e){

            if(Charle.Mainsize() != 3)
            {
                throw new IllegalArgumentException("Charle n'a pas 3 carte dans la main");
            }

            System.out.printf("\nTest d’une carte simple illégale sur un « Passe ton tour » : OK\n");

        } catch (JoueurException e)
        {
            e.printStackTrace();
        }catch (TasException e)
        {
            e.printStackTrace();
        } catch (UnoException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Teste de la pause illegale d'une carte passe tour sur une carte passe simple d'une autre couleur
     * @param partie la partie
     */
    public void PasseSurSimpleIllegale(Partie partie) {
        partie.resetPartie();
        partie.initialiserPasse();
        partie.setJoueurCourant(1);


        Alice.clear();
        Bob.clear();
        Charle.clear();

        MainAlice.add(PasseRouge);
        MainAlice.add(Bleu9);
        MainAlice.add(Jaune4);

        MainBob.add(Jaune6);
        MainBob.add(Vert6);
        MainBob.add(Bleu7);

        MainCharle.add(PasseVert);
        MainCharle.add(Bleu1);
        MainCharle.add(Rouge1);

        try {
            if (partie.getJoueurCourant() != Alice.getOrdre()) {
                throw new IllegalArgumentException("\nAlice n'est pas le joueurs courant");
            }

            Alice.JoueUneCarte(Bleu9);
            Alice.finTour();

            Bob.JoueUneCarte(Bleu7);
            Bob.finTour();

            if (partie.getJoueurCourant() != Charle.getOrdre()) {
                throw new IllegalArgumentException("\nCharle n'est pas le joueurs courant");
            }

            if(Charle.Mainsize() != 3)
            {
                throw new IllegalArgumentException("Charle n'a pas 3 carte dans la main");
            }

            Charle.JoueUneCarte(PasseVert);
            Charle.finTour();


        }catch (CarteException e){

            if(Charle.Mainsize() != 3)
            {
                throw new IllegalArgumentException("Charle n'a pas 3 carte dans la main");
            }

            System.out.printf("Test d’un « Passe ton tour » illégal sur une carte simple : OK\n");

        }catch (JoueurException e)
        {
            e.printStackTrace();
        }catch (TasException e)
        {
            e.printStackTrace();
        } catch (UnoException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Teste sur l'utilisation de la carte PlusDeux
     * @param partie la partie
     */
    public void PlusDeux(Partie partie)
    {
        partie.resetPartie();
        partie.initialiserPlusDeux();
        partie.setJoueurCourant(1);

        Alice.clear();
        Bob.clear();
        Charle.clear();

        MainAlice.add(Vert2P);
        MainAlice.add(Bleu9);
        MainAlice.add(Jaune4);

        MainBob.add(Jaune6);
        MainBob.add(Vert6);
        MainBob.add(Bleu7);

        MainCharle.add(Vert2P);
        MainCharle.add(Bleu1);
        MainCharle.add(Vert1);

        try {
            if (partie.getJoueurCourant() != Alice.getOrdre()) {
                throw new IllegalArgumentException("\nAlice n'est pas le joueur courant");
            }

            Alice.JoueUneCarte(Vert2P);
            Alice.finTour();

            if (partie.getJoueurCourant() != Bob.getOrdre()) {
                System.out.printf("\nBob n'est pas le joueurs courant");
            }

            if(Bob.Mainsize() != 3)
            {
                throw new IllegalArgumentException("Bob n'a pas 3 carte dans la main");
            }

            Bob.Encaisser();
            if(Bob.Mainsize() != 5)
            {
                throw new IllegalArgumentException("Bob n'a pas 5 carte dans la main");
            }

            if (partie.getJoueurCourant() != Charle.getOrdre()) {
                System.out.printf("\nCharle n'est pas le joueurs courant");
            }

            Charle.JoueUneCarte(Vert1);
            Charle.finTour();

            if(Charle.Mainsize() != 2)
            {
                throw new IllegalArgumentException("Charle n'a pas 2 carte dans la main");
            }

            System.out.printf("Test d’un coup légal avec une carte « +2 » : OK\n");

        }catch (Exception e){e.printStackTrace();

        }
    }
}
