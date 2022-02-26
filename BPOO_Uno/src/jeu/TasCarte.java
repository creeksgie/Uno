package jeu;

import carte.ensemble.Carte;
import carte.ensemble.CarteNuméro;
import carte.ensemble.MainJoueur;
import Exception.CarteException;

import java.util.ArrayList;

public class TasCarte {
    private ArrayList<Carte> Tas = new ArrayList<Carte>();

    public TasCarte(){
        new ArrayList<Carte>();
    }

    public int NbCarteTas(){
        if (Tas.isEmpty())
            return 0;
        int s = 0;
        for (final Carte c : Tas)
            s = s + 1;
        return s;
    }

    public void ajout(Carte carte, MainJoueur J1) throws CarteException {

        if(carte.equals(Tas.get(Tas.size()- 1)) || Tas.get(Tas.size() - 1).getNumero() == carte.getNumero())
        {
            Tas.add(carte);
        }
        else {
            J1.ajout(carte);
            throw new CarteException("Impossible d'ajouter la carte");
        }


    }

    public void DernièreCarte(){
        int lastIdx = Tas.size() - 1;
        System.out.println("\nLa dernière carte est :");
        System.out.println(Tas.get(lastIdx));
    }

    public void ajoutePremière(Carte carte)
    {
        Tas.add(carte);
    }


}
