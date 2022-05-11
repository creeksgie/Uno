package Carte;

import Joueur.Joueur;

public class CartePlusDeux extends Carte{


    public CartePlusDeux(String couleur) {
        super(couleur);
    }

    public void faireEffet(Joueur j1) {
        j1.setPlusDeux(true);
    }

    @Override
    public String toString() {
        return "CartePlusDeux{" +
                "Couleur='" + Couleur + '\'' +
                '}';
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
