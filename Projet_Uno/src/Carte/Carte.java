package Carte;

import Joueur.Joueur;

public abstract class Carte {


    String Couleur;

    public Carte(String couleur) {
        setCouleur(couleur);
    }

    public void faireEffet(Joueur j1) {

    }

    public String getCouleur() {
        return Couleur;
    }

    public void setCouleur(String couleur) {
        Couleur = couleur;
    }
}
