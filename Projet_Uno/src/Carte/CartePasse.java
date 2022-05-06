package Carte;


import Joueur.Joueur;

public class CartePasse extends Carte{

    public CartePasse(String couleur, String passe) {
        super(couleur);

    }

    public String getCouleur() {
        return Couleur;
    }

    public void setCouleur(String couleur) {
        if(couleur == null || couleur.trim().equals(""))
            throw new IllegalArgumentException("couleur vide");
        Couleur = couleur;
    }

    @Override
    public void faireEffet(Joueur j1) {
        j1.setPasse(true);
    }
}
