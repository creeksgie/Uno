package Carte;

import Joueur.Joueur;

public class CartePlusDeux extends Carte{

    public CartePlusDeux(String couleur) {
        super(couleur);
    }

    public void faireEffet(Joueur j1) {
        j1.setPlusDeux(true);
    }

}
