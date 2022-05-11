package Partie;

import Carte.Carte;
import Carte.CarteSimple;
import Carte.CartePasse;
import Carte.CartePlusDeux;
import Joueur.Joueur;
import Partie.Partie;
import Exception.CarteException;
import Exception.JoueurException;
import Exception.TasException;
import Exception.PiocheException;
import Exception.UnoException;

import java.util.ArrayList;

import static java.lang.System.exit;

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

    Carte PasseRouge = new CartePasse("rouge", "passe");
    Carte PasseVert = new CartePasse("vert", "passe");

    Carte Vert6 = new CarteSimple(6, "vert");
    Carte Bleu1 = new CarteSimple(1, "bleu");

    Carte Vert2P = new CartePlusDeux("vert");
    Carte Vert1 = new CarteSimple(1, "vert");




    public  void AliceBonneCouleur(Partie partie)
    {
        partie.initialiser();
        MainAlice.add(Rouge1);
        MainAlice.add(Jaune6);
        MainAlice.add(Vert2);

        try{
            if(partie.getJoueurCourant() != Alice.getOrdre())
            {
                throw new IllegalArgumentException("Alice n'est pas le joueurs courant");
            }
            if (Alice.Mainsize() != 3)
            {
                throw new IllegalArgumentException("Alice n'a pas 3 carte en main" +Alice.Mainsize());

            }

            Alice.JoueUneCarte(Vert2);


            if(Alice.Mainsize() != 2)
            {
                throw new IllegalArgumentException("Alice n'a pas 2 carte en main" +Alice.Mainsize());
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
                throw new IllegalArgumentException("Pas la bonne carte au dessus du tas");
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

            System.out.printf("Tout les test ALICE JOUE UNE CARTE DE LA BONNE COULEUR PASSE");



        } catch (Exception e) {
            e.printStackTrace();
            exit(1);
        }
    }


    public void BobBonneCarteCouleurDiff(Partie partie)
    {

        MainBob.add(Rouge9);
        MainBob.add(Jaune4);
        MainBob.add(Bleu2);
        try {

            if (Bob.Mainsize() != 3)
            {
                throw new IllegalArgumentException("Boby n'a pas 3 carte en main" +Bob.Mainsize());
            }

            Bob.JoueUneCarte(Bleu2);

            if(Bob.Mainsize() != 2)
            {
                throw new IllegalArgumentException("Boby n'a pas deux carte dans la main" +Bob.Mainsize());
            }

            if(!Bob.get(0).equals(Rouge9))
            {
                throw new IllegalArgumentException("Boby n'a pas la carte rouge 9");
            }

            if(!Bob.get(1).equals(Jaune4))
            {
                throw new IllegalArgumentException("Boby n'a pas la carte jaune 4");
            }

            if(!partie.getTAS(partie.Tassize() - 1).equals(Bleu2))
            {
                throw new IllegalArgumentException("Pas la bonne carte");
            }

            if(partie.Tassize() != 3)
            {
                throw new IllegalArgumentException("Pas assez de carte sur le Tas");
            }

            Bob.finTour();

            if(partie.getJoueurCourant() != 3)
            {
                throw  new IllegalArgumentException("Le joueur courant n'est pas Charle");
            }

            System.out.printf("\nTout les test BOB JOUE UNE CARTE PASSE");


        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void TestCarteIllegale(Partie partie)
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

            System.out.printf("\nLes test coup illégaux avec carte simple passe");

        } catch (JoueurException e)
        {
            e.printStackTrace();

        } catch (TasException e)
        {
            e.printStackTrace();
        }

    }

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

            System.out.printf("\nLes test 2 carte légale de suite passe");

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

            System.out.printf("\nLes test Alice fin de tour sans jouer");
        } catch (UnoException e)
        {
            e.printStackTrace();
        }


    }

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

            System.out.printf("\nLes test joueur joue puis pioche passe");
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

                System.out.println("\nTest Alice punition passe");

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

    public void TestBobPasSontTour(Partie partie)
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

                System.out.println("Test action bob pas sont tour : OK");
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

            System.out.printf("Test Alice Uno");

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

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

                System.out.printf("\nTest Alice oubli Uno\n");

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

                System.out.printf("Test Bob Uno pas son tour");

            }catch(JoueurException a)
            {
                a.printStackTrace();
            } catch (PiocheException a)
            {
                a.printStackTrace();
            }

        }

    }

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

            System.out.printf("\nTest Passe ton tour : OK");

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

            System.out.printf("\nTest carte simple illégale sur Passe : OK\n");

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

            System.out.printf("Test carte passe Illegale sur Simple : OK\n");

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

            System.out.printf("Test carte Simple sur PlusDeux : OK\n");

        }catch (Exception e){e.printStackTrace();

        }
    }
}
