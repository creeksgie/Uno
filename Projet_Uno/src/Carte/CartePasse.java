package Carte;


import Joueur.Joueur;

public class CartePasse implements Carte{

    private String Couleur;
    private String Passe;


    public CartePasse(String couleur, String passe) {
        setCouleur(couleur);
        setPasse(passe);
    }

    public String getCouleur() {
        return Couleur;
    }

    public void setCouleur(String couleur) {
        if(couleur == null || couleur.trim().equals(""))
            throw new IllegalArgumentException("couleur vide");
        Couleur = couleur;
    }

    public String getPasse() {
        return Passe;
    }

    public void setPasse(String passe) {
        if(passe == null || passe.trim().equals(""))
            throw new IllegalArgumentException("passe vide");
        Passe = passe;
    }



    @Override
    public void faireEffet(Joueur j1) {
        j1.setPasse(true);
    }
}
