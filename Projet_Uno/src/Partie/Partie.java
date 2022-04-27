package Partie;

import Carte.Carte;
import Carte.CarteSimple;
import Joueur.Joueur;
import Exception.JoueurException;

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

           if(((CarteSimple) c).getNumero() == ((CarteSimple) getTAS(Tassize() - 1)).getNumero() || ((CarteSimple) c).getCouleur() == ((CarteSimple) getTAS(Tassize() - 1)).getCouleur())
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

    public void initialiserUno(){
        Carte carte1 = new CarteSimple(8, "vert");

        addAuTas(carte1);

        Carte carte2 = new CarteSimple(6, "jaune");
        Carte carte3 = new CarteSimple(2, "vert");
        Carte carte4 = new CarteSimple(5, "bleu");
        Carte carte5 = new CarteSimple(0, "vert");
        Carte carte6 = new CarteSimple(3, "bleu");

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

    public Carte getTAS(int index) {
        return LeTas.get(index);
    }

    public int Piochesize() {
        return LaPioche.size();
    }

    public Carte getPioche(int index) {
        return LaPioche.get(index);
    }

    public Carte removePioche(int index) {
        return LaPioche.remove(index);
    }

    public void punition(Joueur j1) throws JoueurException {

        if(this.getJoueurCourant() == j1.getOrdre())
        {
            j1.setAJouer(false);
            j1.Pioche();
            j1.Pioche();
            j1.setAJouer(true);
            j1.finTour();
        }
        else
        {
            j1.add(this.getPioche(this.Piochesize() - 1));
            this.removePioche(this.Piochesize() - 1);
            j1.add(this.getPioche(this.Piochesize() - 1));
            this.removePioche(this.Piochesize() - 1);
        }
    }


    public void punitionUno(Joueur j1) throws JoueurException
    {
        if(j1.Mainsize() == 1)
        {
            j1.setAJouer(false);
            j1.Pioche();
            j1.Pioche();
            j1.Pioche();
            j1.setAJouer(true);
        }
    }

    @Override
    public String toString() {
        return "Partie{" +
                "LeTas=" + LeTas +
                '}';
    }
}
