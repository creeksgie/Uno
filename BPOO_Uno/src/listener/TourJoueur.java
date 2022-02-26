package listener;

public interface TourJoueur {

    public void debutTour(TourJoueur tour);

    public void finTour(TourJoueur tour);

    public void peutRejouer(TourJoueur tour);
}
