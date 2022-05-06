package Partie;

import Carte.Carte;
import Carte.CarteSimple;
import Expert.*;
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

    public boolean PoseValide(Carte c) throws Exception {
        if(Tassize() == 0)
            throw new IllegalArgumentException("Tas vide");

        Valide v = null;
        v = new ValideSimpleSurSimple(v);
        v = new ValideSimpleSurPasse(v);
        v = new ValidePasseSurPasse(v);
        v = new ValidePasseSurSimple(v);
        v = new ValidePlusDeuxSurSimple(v);

        Carte CarteTas = getTAS(Tassize() - 1);
        try{
            if(v.traiter(c, CarteTas))
            {
                return true;
            }
        }catch (Exception e){e.printStackTrace();}

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

    public void initialiserPasse(){
        Carte carte1 = new CarteSimple(9, "rouge");

        addAuTas(carte1);

        Carte carte2 = new CarteSimple(0, "bleu");
        Carte carte3 = new CarteSimple(8, "vert");
        Carte carte4 = new CarteSimple(2, "vert");
        Carte carte5 = new CarteSimple(4, "rouge");
        Carte carte6 = new CarteSimple(2, "vert");

        addALaPioche(carte6);
        addALaPioche(carte5);
        addALaPioche(carte4);
        addALaPioche(carte3);
        addALaPioche(carte2);
    }

    public void initialiserPlusDeux(){

        Carte carte1 = new CarteSimple(9, "vert");

        addAuTas(carte1);

        Carte carte2 = new CarteSimple(0, "bleu");
        Carte carte3 = new CarteSimple(8, "vert");
        Carte carte4 = new CarteSimple(2, "vert");
        Carte carte5 = new CarteSimple(4, "rouge");
        Carte carte6 = new CarteSimple(2, "vert");

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
            punition2Carte(j1);
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
        int i = this.JoueurCourant;
        if(j1.getOrdre() != this.JoueurCourant && j1.getUno() == true)
        {
            punition3Carte(j1);
            this.setJoueurCourant(i);
        }
        if(j1.getUno() == false)
        {
            punition3Carte(j1);
            this.setJoueurCourant(j1.getOrdre() + 1);
        }


    }

    public void punition2Carte(Joueur j1) throws JoueurException
    {
        j1.setAJouer(false);
        j1.Pioche();
        j1.Pioche();
        j1.setAJouer(true);
        j1.finTour();
    }

    public void punition3Carte(Joueur j1) throws JoueurException
    {
        this.setJoueurCourant(j1.getOrdre());
        j1.setAJouer(false);
        j1.Pioche();
        j1.Pioche();
        j1.Pioche();
        j1.setAJouer(true);
    }

    @Override
    public String toString() {
        return "Partie{" +
                "LeTas=" + LeTas +
                '}';
    }


}
