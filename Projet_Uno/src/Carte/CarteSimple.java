package Carte;

import Joueur.Joueur;

import java.util.Objects;

/**
 * Classe CarteSimple
 */
public class CarteSimple extends Carte {

    private int Numero;

    /**
     * Constructeur de la classe CarteSimple
     * @param numero numero de la carte
     * @param couleur couleur de la carte
     */
    public CarteSimple(int numero, String couleur) {
        super(couleur);
        setNumero(numero);
    }

    /**
     * Getter de l'attribut Numero
     * @return Numero
     */
    public int getNumero() {
        return Numero;
    }

    /**
     * Setter de l'attribut Numero
     * @param numero numero de la carte
     */
    public void setNumero(int numero) {
        if(numero < 0 || numero > 9)
            throw new IllegalArgumentException("Numero incorrect");

        Numero = numero;
    }

    /**
     * getter de l'attribut Couleur
     * @return Couleur
     */
    public String getCouleur() {
        return Couleur;
    }

    /**
     * Setter de l'attribut Couleur
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

    }

    /**
     * Méthode toString
     * @return
     */
    @Override
    public String toString() {
        return "CarteSimple{" +
                "Numero=" + Numero +
                ", Couleur='" + Couleur + '\'' +
                '}';
    }

    /**
     * Méthode equals
     * @param o objet à comparer
     * @return true si les objets sont égaux
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarteSimple that = (CarteSimple) o;
        return Numero == that.Numero && Objects.equals(Couleur, that.Couleur);
    }

    /**
     * Méthode hashCode
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(Numero, Couleur);
    }
}
