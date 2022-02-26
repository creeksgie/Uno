package Partie;

import carte.ensemble.*;
import jeu.Joueur;
import jeu.TasCarte;
import Exception.CarteException;


import java.util.*;

public class Main {

    public static void main(String[] args) throws CarteException {


        //***********************************************************************//
        //**********Tests pour Alice joue une carte de la bonne couleur**********//
        //***********************************************************************//

        Carte HuitVert = new CarteNuméro("Vert", 8);
        TasCarte Tas = new TasCarte();
        Tas.ajoutePremière(HuitVert);

        Carte DeuxVert = new CarteNuméro("Vert", 2);
        Carte SixJaune = new CarteNuméro("Jaune", 6);
        Carte UnRouge = new CarteNuméro("Rouge", 1);

        MainJoueur MainAlice = new MainJoueur();
        MainAlice.ajout(DeuxVert);
        MainAlice.ajout(SixJaune);
        MainAlice.ajout(UnRouge);

        Joueur Alice = new Joueur("Alice", MainAlice);

        if(Alice.JoueurActuel() != 1){
            System.out.print("\nAlice n'est pas le joueur courant'");
            System.exit(1);
        }
        if(Alice.NbCarte() != 3){
            System.out.print("\nAlice n'a pas 3 carte");
            System.exit(1);
        }

        try {
            Tas.ajout(Alice.JoueUneCarte(DeuxVert), MainAlice);
        } catch (CarteException e) {
            e.printStackTrace();
        }

        if(Alice.NbCarte() != 2){
            System.out.print("\nAlice n'a pas 2 carte");
            System.exit(1);
        }

        System.out.printf("\nLes Cartes de Alice sont :\n");
        System.out.printf(Alice.getMain());

        Tas.DernièreCarte();

        if(Tas.NbCarteTas() != 2){
            System.out.print("\nLe Tas ne contient pas 2 cartes");
            System.exit(1);
        }

        Alice.finTour();
        MainJoueur MainBob = new MainJoueur();
        Carte DeuxBleu = new CarteNuméro("Bleu", 2);
        Carte QuatreJaune = new CarteNuméro("Jaune", 4);
        Carte NeufRouge = new CarteNuméro("Rouge", 9);
        MainBob.ajout(DeuxBleu);
        MainBob.ajout(QuatreJaune);
        MainBob.ajout(NeufRouge);
        Joueur Bob = new Joueur("Bob", MainBob);

        if(Alice.JoueurActuel() != 2)
        {
            System.out.print("\nBob n'est pas le joueurs courant");
            System.exit(1);
        }

        //********************************************************************************//
        //**********Bob joue une carte de couleur différente mais de même valeur**********//
        //********************************************************************************//


        if(Bob.NbCarte() != 3){
            System.out.print("\nBob n'a pas 3 carte");
            System.exit(1);
        }

        Tas.ajout(Bob.JoueUneCarte(DeuxBleu), MainBob);

        if(Bob.NbCarte() != 2){
            System.out.print("\nBob n'a pas 3 carte");
            System.exit(1);
        }

        System.out.printf("\nLes Cartes de Bob sont :\n");
        System.out.printf(Bob.getMain());

        Tas.DernièreCarte();

        if(Tas.NbCarteTas() != 3){
            System.out.print("\nLe Tas ne contient pas 3 cartes");
            System.exit(1);
        }

        Alice.finTour();

        if(Alice.JoueurActuel() != 3)
        {
            System.out.print("\nCharles n'est pas le joueurs courant");
            System.exit(1);
        }

        //*********************************************//
        //**********Test d’une carte illégale**********//
        //*********************************************//

        Carte HuittVert = new CarteNuméro("Vert", 8);
        TasCarte Tass = new TasCarte();
        Tass.ajoutePremière(HuittVert);

        Carte DeuxxVert = new CarteNuméro("Vert", 2);
        Carte SixxJaune = new CarteNuméro("Jaune", 6);
        Carte UnnRouge = new CarteNuméro("Rouge", 1);

        MainJoueur MainnAlice = new MainJoueur();
        MainnAlice.ajout(DeuxxVert);
        MainnAlice.ajout(SixxJaune);
        MainnAlice.ajout(UnnRouge);

        Joueur AAlice = new Joueur("AAlice", MainnAlice);
        try {
            Tass.ajout(AAlice.JoueUneCarte(SixxJaune), MainnAlice);;
        } catch (CarteException e) {
            System.out.print(AAlice.NbCarte());
            System.out.println("\nUne exception s'est produite :"+e);
        }


        //**************************************************************************//
        //**********Test d’un joueur qui pose deux cartes légales de suite**********//
        //**************************************************************************//



















    }


}
