package carte.ensemble;


import jeu.TasCarte;

import java.util.*;
import java.util.ArrayList;
import Exception.CarteException;


public class MainJoueur extends TasCarte  {

    private ArrayList<Carte> cartes = new ArrayList<Carte>();



    public void MainJoueur() {
        cartes = new ArrayList<Carte>();
    }


    public List<Carte> getCartes() {
        return cartes;
    }

    public void ajout(Carte carte) {
        cartes.add(carte);
    }

    public Carte poseCarte(Carte carte){

        cartes.remove(carte);
        return carte;
    }


    public boolean estVide() {
        return cartes.isEmpty();
    }

    @Override
    public String toString() {
        if (cartes.isEmpty())
            return "(vide)";
        String s = "";
        for (final Carte c : cartes)
            s += "\n " + c;
        return s.substring(2);
    }



    public int getNbCarte(){
        if (cartes.isEmpty())
            return 0;
        int s = 0;
        for (final Carte c : cartes)
            s = s + 1;
        return s;
    }
}
