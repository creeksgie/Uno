package listener;

import carte.ensemble.Carte;

import java.util.EventListener;

public interface MainListener extends EventListener {

    public void ajoutCarte(Carte carte, int rang);

    public void retireCarte(Carte carte, int rang);


}
