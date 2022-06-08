package Carte;

import Joueur.Joueur;

/**
 * Classe CartePlusDeux
 */
public class CartePlusDeux extends Carte{

    /**
     * Constructeur de la classe CartePlusDeux
     * @param couleur la couleur de la carte
     */
    public CartePlusDeux(String couleur) {
        super(couleur);
    }
    /**
     * Méthode FaireEffet
     * @param j1 Joueur 1
     */
    public void faireEffet(Joueur j1) {
        j1.setPlusDeux(true);
    }

    /**
     * Méthode toString
     * @return une chaîne de caractères
     */
    @Override
    public String toString() {
        return "CartePlusDeux{" +
                "Couleur='" + Couleur + '\'' +
                '}';
    }

    /**
     * Méthode hashCode
     * @return un entier
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Méthode equals
     * @param obj l'objet à comparer
     * @return un booléen
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
