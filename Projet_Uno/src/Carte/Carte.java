package Carte;

import Joueur.Joueur;

/**
 * Classe Carte
 */
public abstract class Carte {

    String Couleur;

    /**
     * Constructeur de la classe Carte
     * @param couleur Couleur de la carte
     */
    public Carte(String couleur) {
        setCouleur(couleur);
    }

    /**
     * Méthode FaireEffet
     * @param j1 Joueur 1
     */
    public void faireEffet(Joueur j1) {

    }

    /**
     * Getter de l'attribut couleur
     * @return Couleur de la carte
     */
    public String getCouleur() {
        return Couleur;
    }

    /**
     * Setter de l'attribut couleur
     * @param couleur Couleur de la carte
     */
    public void setCouleur(String couleur) {
        Couleur = couleur;
    }
}
