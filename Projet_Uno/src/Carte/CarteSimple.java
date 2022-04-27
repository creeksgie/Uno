package Carte;

import Joueur.Joueur;

import java.util.Objects;

public class CarteSimple implements Carte {

    private int Numero;
    private String Couleur;

    public CarteSimple(int numero, String couleur) {
        setCouleur(couleur);
        setNumero(numero);
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int numero) {
        if(numero < 0 || numero > 9)
            throw new IllegalArgumentException("Numero incorrect");

        Numero = numero;
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

    }

    @Override
    public String toString() {
        return "CarteSimple{" +
                "Numero=" + Numero +
                ", Couleur='" + Couleur + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarteSimple that = (CarteSimple) o;
        return Numero == that.Numero && Objects.equals(Couleur, that.Couleur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Numero, Couleur);
    }
}
