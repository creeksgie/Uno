package Main;

import Carte.Carte;
import Carte.CarteSimple;
import Joueur.Joueur;
import Partie.Partie;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        ArrayList<Joueur> TabJoueur = new ArrayList<Joueur>();
        ArrayList<Carte> MainAlice = new ArrayList<Carte>();
        ArrayList<Carte> MainBob = new ArrayList<Carte>();
        ArrayList<Carte> MainCharle = new ArrayList<Carte>();

        Carte Rouge1 = new CarteSimple(1, "rouge");
        Carte Jaune6 = new CarteSimple(6, "jaune");
        Carte Vert2 = new CarteSimple(2, "vert");
        MainAlice.add(Rouge1);
        MainAlice.add(Jaune6);
        MainAlice.add(Vert2);

        Carte Bleu2= new CarteSimple(2, "bleu");
        Carte Jaune4 = new CarteSimple(4, "jaune");
        Carte Rouge9 = new CarteSimple(9, "rouge");
        MainBob.add(Rouge9);
        MainBob.add(Jaune4);
        MainBob.add(Bleu2);

        Carte Bleu0 = new CarteSimple(0, "bleu");
        Carte Bleu7 = new CarteSimple(7, "bleu");
        Carte Bleu9 = new CarteSimple(9, "bleu");
        MainCharle.add(Bleu0);
        MainCharle.add(Bleu7);
        MainCharle.add(Bleu9);

        Joueur Bob = new Joueur("Bob", 2, MainBob);
        Joueur Alice = new Joueur("Alice", 1, MainAlice);
        Joueur Charle = new Joueur("Charles", 3, MainCharle);
        TabJoueur.add(Alice);

        Partie partie = Partie.getInstance();
        partie.initialiser();

        //*******************************************************************//
        //**********Tests Alice joue uen carte de la bonne couleur***********//
        //*******************************************************************//

        try{
            if(partie.getJoueurCourant() != Alice.getOrdre())
            {
                System.out.println("Alice n'est pas le joueur courant");
            }
            if (Alice.Mainsize() != 3)
            {
                System.out.println("Alice n'a pas 3 carte en main" +Alice.Mainsize());
            }

            Alice.JoueUneCarte(Vert2);


            if(Alice.Mainsize() != 2)
            {
                System.out.println("Alice n'a pas deux carte dans la main" +Alice.Mainsize());
            }

            if(!Alice.get(0).equals(Rouge1))
            {
                System.out.println("Alice n'a pas la carte rouge 1");
            }

            if(!Alice.get(1).equals(Jaune6))
            {
                System.out.println("Alice n'a pas la carte jaune 6");
            }

            if(!partie.getTAS(partie.Tassize() - 1).equals(Vert2))
            {
                System.out.println("Pas la bonne carte");
            }

            if(partie.Tassize() != 2)
            {
                System.out.println("Pas assez de carte sur le Tas");
            }

            Alice.finTour();

            if(partie.getJoueurCourant() != 2)
            {
                System.out.println("Le joueur courant n'est pas bob");
            }

            System.out.printf("Tout les test ALICE JOUE UNE CARTE DE LA BONNE COULEUR PASSE");



        } catch (Exception e) {
            e.printStackTrace();
        }


        //***************************************************************************************//
        //**********Tests Bob joue une carte de couleur différente mais de même valeur***********//
        //***************************************************************************************//

        try {

            if (Bob.Mainsize() != 3)
            {
                System.out.println("Boby n'a pas 3 carte en main" +Bob.Mainsize());
            }

            Bob.JoueUneCarte(Bleu2);

            if(Bob.Mainsize() != 2)
            {
                System.out.println("Boby n'a pas deux carte dans la main" +Bob.Mainsize());
            }

            if(!Bob.get(0).equals(Rouge9))
            {
                System.out.println("Boby n'a pas la carte rouge 9");
            }

            if(!Bob.get(1).equals(Jaune4))
            {
                System.out.println("Boby n'a pas la carte jaune 4");
            }

            if(!partie.getTAS(partie.Tassize() - 1).equals(Bleu2))
            {
                System.out.println("Pas la bonne carte");
            }

            if(partie.Tassize() != 3)
            {
                System.out.println("Pas assez de carte sur le Tas");
            }

            Bob.finTour();

            if(partie.getJoueurCourant() != 3)
            {
                System.out.println("Le joueur courant n'est pas Charle");
            }

            System.out.printf("\nTout les test BOB JOUE UNE CARTE PASSE");


        }catch (Exception e){
            e.printStackTrace();
        }

        //*****************************************************************//
        //**********Tests coups illégaux avec des cartes simples***********//
        //*****************************************************************//

        partie.resetPartie();
        partie.initialiser();
        MainAlice.add(Vert2);

        try
        {
            Alice.JoueUneCarte(Jaune6);

        } catch (Exception e)
        {
            if(Alice.Mainsize() == 3)
            {
                System.out.println("\n");
                e.printStackTrace();
            }

        }

        System.out.printf("\nLes test coup illégaux avec carte simple passe");


        //***************************************************************//
        //**********Tests joueur pose 2 carte légales de suite***********//
        //***************************************************************//

        partie.resetPartie();
        partie.initialiser();
        MainBob.add(Bleu2);

        try {

            Alice.JoueUneCarte(Vert2);
            Alice.finTour();
            Bob.JoueUneCarte(Bleu2);
            Bob.finTour();
            Charle.JoueUneCarte(Bleu9);

            if(Charle.Mainsize() != 2)
            {
                System.out.printf("Charle n'a pas deux carte dans la main");
            }

            Charle.JoueUneCarte(Bleu7);


        } catch (Exception e){

            if(Charle.Mainsize() == 2)
            {
                e.printStackTrace();
            }

        }

        System.out.printf("\nLes test 2 carte légale de suite passe");



        //*******************************************************//
        //**********Tests Alice fin de tour sans jouer***********//
        //*******************************************************//

        MainAlice.add(Vert2);
        try {

            Alice.finTour();

        }catch (Exception e)
        {
            if(Alice.Mainsize() == 3)
                e.printStackTrace();
        }

        System.out.printf("\nLes test Alice fin de tour sans jouer");

        //***********************************************************//
        //**********Tests d'un joueur qui joue puis pioche***********//
        //***********************************************************//

        partie.resetPartie();
        partie.initialiser();

        try{

            Alice.JoueUneCarte(Vert2);
            Alice.Pioche();

        }catch(Exception e)
        {
            if(Alice.Mainsize() == 2)
                 e.printStackTrace();
            if(!partie.getPioche(partie.Piochesize() - 1).equals(Jaune6))
            {
                System.out.println("Pas la bonne carte");
            }
        }

        System.out.printf("\nLes test joueur joue puis pioche passe");


        //**********************************************************************//
        //**********Tests de la punition pour un coup illégal d'Alice***********//
        //**********************************************************************//

        partie.resetPartie();
        partie.initialiser();
        partie.setJoueurCourant(1);

        try{
            if(partie.getJoueurCourant() != Alice.getOrdre())
            {
                System.out.printf("Alice n'est pas le bon joueur");
            }

            Alice.JoueUneCarte(Jaune6);



        }catch(Exception e)
        {
            try
            {
                partie.punition(Alice);


            }catch(Exception a){ a.printStackTrace();}

            if(partie.getJoueurCourant() != Bob.getOrdre())
            {
                System.out.printf("Bob n'est pas le bon joueur"+partie.getJoueurCourant());
            }

            if(Alice.Mainsize() != 5)
            {
                System.out.println("Alice n'a pas 5 carte");
            }

            if(!partie.getPioche(partie.Piochesize() - 1).equals(Vert2))
            {
                System.out.println("Le deux vert n'est pas au sommet de la pioche");
            }
        }

        System.out.println("\nTest punition Alice passe");

        //***************************************************//
        //**********Tests action bob pas sont tour***********//
        //***************************************************//

        partie.resetPartie();
        partie.initialiser();
        partie.setJoueurCourant(1);


        try{

            if(partie.getJoueurCourant() != Alice.getOrdre())
            {
                System.out.println("Alice n'est pas le joueur courant");
            }

            Bob.Pioche();
            partie.punition(Bob);

        }catch(Exception e)
        {

            if(partie.getJoueurCourant() != Alice.getOrdre())
            {
                System.out.println("Alice n'est pas le joueur courant");
            }

            if(Bob.Mainsize() != 5)
            {
                System.out.println("Bob n'a pas 5 carte");
            }

            if(!partie.getPioche(partie.Piochesize() - 1).equals(Vert2))
            {
                System.out.println("Le deux vert n'est pas au sommet de la pioche");
            }

        }
        System.out.println("Test action bob pas sont tour");


        //***********************************************//
        //**********Tests Alice Uno bon moment***********//
        //***********************************************//

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
                System.out.printf("Alice n'a pas une carte dans les mains");
            }

            if(!partie.getTAS(partie.Tassize() - 1).equals(Vert2))
            {
                System.out.println("Le deux vert n'est pas au sommet de la pioche");
            }

            if(partie.getJoueurCourant() != Bob.getOrdre())
            {
                System.out.printf("Bob n'est pas le joueurs courant");
            }


        }catch(Exception e)
        {
            e.printStackTrace();
        }

        System.out.printf("Test Alice Uno bon timing passe");



    }


}
