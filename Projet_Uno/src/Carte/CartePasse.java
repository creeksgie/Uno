package Carte;


import Joueur.Joueur;

/**
 * Classe CartePasse
 */
public class CartePasse extends Carte{
    /**
     * Constructeur de la classe CartePasse
     * @param couleur couleur de la carte
     */
    public CartePasse(String couleur) {
        super(couleur);
    }

    /**
     * Getter de l'attribut couleur
     * @return couleur de la carte
     */
    public String getCouleur() {
        return Couleur;
    }

    /**
     * Setter de l'attribut couleur
     * @param couleur Couleur de la carte
     */
    public void setCouleur(String couleur) {
        if(couleur == null || couleur.trim().equals(""))
            throw new IllegalArgumentException("couleur vide");
        Couleur = couleur;
    }

    /**
     * Méthode FaireEffet
     * @param j1 Joueur 1
     */
    @Override
    public void faireEffet(Joueur j1) {
        j1.setPasse(true);
    }

    @Override
    public String toString() {
        return "CartePasse{" + "Couleur=" + Couleur + '}';
    }
}
