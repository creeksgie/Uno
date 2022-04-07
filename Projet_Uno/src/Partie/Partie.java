package Partie;

import Carte.Carte;
import Carte.CarteSimple;
import Joueur.Joueur;

import java.util.ArrayList;

public class Partie {
    private int NombreJoueur;
    private int JoueurCourant;
    private ArrayList<Carte> LeTas = new ArrayList<Carte>();
    private ArrayList<Carte> LaPioche = new ArrayList<Carte>();
    private ArrayList<Joueur> TabJoueur = new ArrayList<Joueur>();
    private static Partie instance = null;

    public Partie() {
        NombreJoueur = 3;
        JoueurCourant = 1;
        TabJoueur = new ArrayList<Joueur>();
    }


    public int getNombreJoueur() {
        return NombreJoueur;
    }

    public void setNombreJoueur(int nombreJoueur) {
        NombreJoueur = nombreJoueur;
    }

    public int getJoueurCourant() {
        return JoueurCourant;
    }

    public void setJoueurCourant(int joueurCourant) {
        JoueurCourant = joueurCourant;
    }

    public static Partie getInstance(){
        if(instance == null)
        {
            instance = new Partie();
        }
        return instance;
    }

    public boolean PoseValide(Carte c){
       if(Tassize() == 0)
           throw new IllegalArgumentException("Tas vide");

       if(c instanceof CarteSimple)
       {

           if(((CarteSimple) c).getNumero() == ((CarteSimple)get(Tassize() - 1)).getNumero() || ((CarteSimple) c).getCouleur() == ((CarteSimple) get(Tassize() - 1)).getCouleur())
               return true;
       }
      return false;
    }

    public void initialiser(){
        Carte carte1 = new CarteSimple(8, "vert");

        addAuTas(carte1);

        Carte carte2 = new CarteSimple(6, "jaune");
        Carte carte3 = new CarteSimple(4, "rouge");
        Carte carte4 = new CarteSimple(2, "vert");
        Carte carte5 = new CarteSimple(5, "bleu");
        Carte carte6 = new CarteSimple(0, "vert");

        addALaPioche(carte6);
        addALaPioche(carte5);
        addALaPioche(carte4);
        addALaPioche(carte3);
        addALaPioche(carte2);

    }

    public void resetPartie()
    {
        LeTas.clear();
        LaPioche.clear();
    }

    public void addAuTas(Carte carte)
    {
        LeTas.add(carte);
    }

    public void addALaPioche(Carte carte)
    {
        LaPioche.add(carte);
    }


    public int Tassize() {
        return LeTas.size();
    }

    public Carte get(int index) {
        return LeTas.get(index);
    }

    @Override
    public String toString() {
        return "Partie{" +
                "LeTas=" + LeTas +
                '}';
    }
}
