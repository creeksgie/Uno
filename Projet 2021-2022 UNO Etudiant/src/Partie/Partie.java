package Partie;

import Carte.Carte;
import Carte.CartePasse;
import Carte.CartePlusDeux;
import Carte.CarteSimple;
import Expert.*;
import Joueur.Joueur;
import Exception.JoueurException;
import Exception.TasException;
import Exception.UnoException;
import Exception.PiocheException;

import java.util.ArrayList;

/**
 * Classe Partie
 */
public class Partie {

    private int NombreJoueur;
    private int JoueurCourant;
    private ArrayList<Carte> LeTas = new ArrayList<Carte>();
    private ArrayList<Carte> LaPioche = new ArrayList<Carte>();
    private static Partie instance = null;

    /**
     * Constructeur de la classe Partie
     */
    public Partie() {
        NombreJoueur = 3;
        JoueurCourant = 1;
    }

    /**
     * Getter de l'attribut NombreJoueur
     * @return NombreJoueur
     */
    public int getNombreJoueur() {
        return NombreJoueur;
    }

    /**
     * Setter de l'attribut NombreJoueur
     * @param nombreJoueur
     */
    public void setNombreJoueur(int nombreJoueur) {
        NombreJoueur = nombreJoueur;
    }

    /**
     * Getter de l'attribut JoueurCourant
     * @return JoueurCourant
     */
    public int getJoueurCourant() {
        return JoueurCourant;
    }

    /**
     * Setteur de l'attribut JoueurCourant
     * @param joueurCourant
     */
    public void setJoueurCourant(int joueurCourant) {
        JoueurCourant = joueurCourant;
    }

    /**
     * Getter de l'attribut Instance
     * @return Instance
     */
    public static Partie getInstance(){
        if(instance == null)
        {
            instance = new Partie();
        }
        return instance;
    }

    /**
     * Vérifie si la carte est valide pour le joueur
     * @param c carte à tester
     * @return Boolean, 1 Si la carte est valide 0 sinon
     * @throws TasException Si le tas est vide
     */
    public boolean PoseValide(Carte c) throws TasException{
        if(Tassize() == 0)
            throw new TasException("Tas vide");

        Valide v = null;
        v = new ValideSimpleSurSimple(v);
        v = new ValideSimpleSurPasse(v);
        v = new ValidePasseSurPasse(v);
        v = new ValidePasseSurSimple(v);
        v = new ValidePlusDeuxSurSimple(v);
        v = new ValideSimpleSurPlusDeux(v);
        v = new ValidePasseSurPlusDeux(v);
        v = new ValidePlusDeuxSurPlusDeux(v);
        v = new ValidePlusDeuxSurPasse(v);

        Carte CarteTas = getTAS(Tassize() - 1);

        return v.traiter(c, CarteTas);


    }


    /**
     * Méthode qui permet d'initialiser une partie
     */
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
    
    public void initialiserInterface()
    {
    	Carte carte1 = new CarteSimple(8, "vert");

        addAuTas(carte1);

    	Carte carte2 = new CarteSimple(0, "jaune");
    	Carte carte3 = new CarteSimple(1, "rouge");
    	Carte carte4 = new CarteSimple(2, "vert");
    	Carte carte5 = new CarteSimple(6, "bleu");
    	Carte carte6 = new CarteSimple(4, "vert");
    	Carte carte7 = new CarteSimple(5, "jaune");
    	Carte carte8 = new CarteSimple(6, "rouge");
    	Carte carte9 = new CarteSimple(9, "vert");
    	Carte carte10 = new CarteSimple(5, "bleu");
    	Carte carte11 = new CarteSimple(0, "vert");
    	Carte carte12 = new CarteSimple(3, "bleu");
    	Carte carte13 = new CarteSimple(9, "bleu");
    	Carte carte14 = new CarteSimple(5, "jaune");
    	Carte carte15 = new CarteSimple(3, "jaune");
    	Carte carte16 = new CarteSimple(8, "jaune");
    	Carte PasseRouge = new CartePasse("rouge");
    	Carte PasseVert = new CartePasse("vert");
    	Carte PasseBleu = new CartePasse("bleu");
    	Carte Vert2P = new CartePlusDeux("vert");
    	Carte Rouge2P = new CartePlusDeux("rouge");
    	Carte Jaune2P = new CartePlusDeux("jaune");
    	addALaPioche(carte8);
    	addALaPioche(carte6);
    	addALaPioche(carte5);
    	addALaPioche(PasseRouge);
    	addALaPioche(carte3);
    	addALaPioche(Jaune2P);
    	addALaPioche(carte7);
    	addALaPioche(PasseVert);
    	addALaPioche(carte9);
    	addALaPioche(Rouge2P);
    	addALaPioche(carte11);
    	addALaPioche(carte16);
    	addALaPioche(carte4);
    	addALaPioche(carte10);
    	addALaPioche(carte8);
    	addALaPioche(carte12);
    	addALaPioche(carte14);
    	addALaPioche(carte16);
    	addALaPioche(carte13);
    	addALaPioche(Rouge2P);
    	addALaPioche(carte15);
    	addALaPioche(carte2);
    	addALaPioche(PasseBleu);
    	addALaPioche(Vert2P);
    }
    /**
     * Méthode qui permet d'initialiser une partie pour les tests Uno
     */
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

    /**
     * Méthode qui permet d'initialiser une partie pour les tests avec les cartes Passe
     */
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

    /**
     * Méthode qui permet d'initialiser une partie pour les tests avec les cartes PlusDeux
     */
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

    /**
     * Méthode qui permet de reset la partie
     */
    public void resetPartie()
    {
        LeTas.clear();
        LaPioche.clear();
    }

    /**
     * Méthode qui permet d'ajouter une carte au tas
     * @param carte Carte à ajouter
     */
    public void addAuTas(Carte carte)
    {
        LeTas.add(carte);
    }

    /**
     * Méthode qui permet d'ajouter une carte à la pioche
     * @param carte Carte à ajouter
     */
    public void addALaPioche(Carte carte)
    {
        LaPioche.add(carte);
    }

    /**
     * Méthode qui permet de récupérer le nombre de cartes présente dans le tas
     * @return Nombre de cartes présente dans le tas
     */
    public int Tassize() {
        return LeTas.size();
    }

    /**
     * Méthode qui permet de récupérer une certaine carte du tas
     * @param index Index de la carte à récupérer dans le tas
     * @return Carte à l'index donné
     */
    public Carte getTAS(int index) {
        return LeTas.get(index);
    }

    /**
     * Méthode qui permet de récupérer le nombre de cartes présente dans la pioche
     * @return Nombre de cartes présente dans la pioche
     */
    public int Piochesize() {
        return LaPioche.size();
    }

    /**
     * Méthode qui permet de récupérer une certaine carte de la pioche
     * @param index Index de la carte à récupérer dans la pioche
     * @return Carte à l'index donné
     */
    public Carte getPioche(int index) {
        return LaPioche.get(index);
    }

    /**
     * Méthode qui permet d'enlever une carte de la pioche
     * @param index Index de la carte à enlever dans la pioche
     * @return Carte à l'index donné
     */
    public Carte removePioche(int index) {
        return LaPioche.remove(index);
    }

    /**
     * Méthode qui permet de punir un joueur après avoir réalisé un coup illegal
     * @param j1 Joueur à punir
     * @throws JoueurException
     * @throws PiocheException
     * @throws UnoException
     */
    public void punition(Joueur j1) throws JoueurException, PiocheException, UnoException {

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

    /**
     * Méthode qui permet de punir un joueur si il réalise une action illegal en rapport avec Uno
     * @param j1 Joueur à punir
     * @throws JoueurException
     * @throws PiocheException
     */
    public void punitionUno(Joueur j1) throws JoueurException, PiocheException
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
            if(!j1.getPasse())
            {
            	this.setJoueurCourant(j1.getOrdre() + 1);
            }
            else
            {
            	if (this.getNombreJoueur() >= j1.getOrdre() + 2)
                {
                	this.setJoueurCourant(j1.getOrdre() + 2);
                }
                else
                {
                	this.setJoueurCourant((j1.getOrdre() + 2) - this.getNombreJoueur());
                }
            }
            	
        }


    }

    /**
     * Méthode qui permet de punir un joueur en lui faisant piocher exactement 2 cartes
     * @param j1 Joueur à punir
     * @throws JoueurException
     * @throws PiocheException
     * @throws UnoException
     */
    public void punition2Carte(Joueur j1) throws JoueurException, PiocheException, UnoException {
        j1.setAJouer(false);
        j1.Pioche();
        j1.setAJouer(false);
        j1.Pioche();
        j1.setAJouer(true);
        j1.finTour();
    }

    /**
     * Méthode qui permet de punir un joueur en lui faisant piocher exactement 3 cartes
     * @param j1 Joueur à punir
     * @throws PiocheException
     */
    public void punition3Carte(Joueur j1) throws PiocheException
    {
        this.setJoueurCourant(j1.getOrdre());
        j1.setAJouer(false);
        j1.Pioche();
        j1.setAJouer(false);
        j1.Pioche();
        j1.setAJouer(false);
        j1.Pioche();
        j1.setAJouer(true);
    }

    /**
     * Méthode toString
     * @return une chaine de caractère contenant les informations de la partie
     */
    @Override
    public String toString() {
        return "Partie{" +
                "LeTas=" + LeTas +
                '}';
    }


}
