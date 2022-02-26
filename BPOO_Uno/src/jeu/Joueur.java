package jeu;
import carte.ensemble.MainJoueur;
import listener.TourJoueur;
import carte.ensemble.Carte;

public class Joueur {

    private String nom;
    private boolean Uno;
    private final MainJoueur main;
    private TourJoueur tour;
    private int JoueurCourant = 1;


    public Joueur(String nom, MainJoueur main) {
        this.nom = nom;
        this.main = main;
    }

    public Joueur(String nom) {
        this(nom, new MainJoueur());
    }



    public TourJoueur getTour() {
        return tour;
    }

    public String getMain() {
        return main.toString();
    }

    public String getNom() {
        return nom;
    }

    public int NbCarte(){ return main.getNbCarte();}

    public Carte JoueUneCarte (Carte carte)
    {
        return this.main.poseCarte(carte);
    }

    public int TourSuivant()
    {
        if(JoueurCourant == 3)
        {
            return JoueurCourant = 1;
        }
        JoueurCourant = JoueurCourant + 1;
        return JoueurCourant;
    }

    public int JoueurActuel(){
    return JoueurCourant;
    }

    public void finTour() {
        if(this.NbCarte() == 1)
        {
            System.out.printf("UNO !!!");
        }
        TourSuivant();
        JoueurActuel();
    }





}
