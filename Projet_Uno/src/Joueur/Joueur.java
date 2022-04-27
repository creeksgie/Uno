package Joueur;

import Carte.Carte;
import Partie.Partie;
import Carte.CarteSimple;
import Exception.CarteException;
import Exception.JoueurException;

import java.util.ArrayList;

public class Joueur {

    private String Nom;
    private Boolean Uno;
    private int Ordre;
    private ArrayList<Carte> MainJoueur = new ArrayList<Carte>();
    Partie partie = Partie.getInstance();
    private Boolean AJouer = false;

    public Joueur(String nom, int ordre, ArrayList<Carte> mainJoueur) {
        Nom = nom;
        Uno = false;
        Ordre = ordre;
        MainJoueur = mainJoueur;
    }

    public void JoueUneCarte(Carte carte)throws CarteException , JoueurException {

        if (carte == null)
            throw new CarteException("Aucune carte a ajouter");
        if(this.AJouer == true)
            throw new JoueurException("Le joueur à déjà jouer");

                    if (partie.PoseValide(carte)) {
                        carte.faireEffet();
                        partie.addAuTas(carte);
                        MainJoueur.remove(carte);
                        this.AJouer = true;
                    }
                    else
                    {
                        this.AJouer = true;
                        throw new CarteException("Carte illégale");
                    }

            }


    public void finTour() throws JoueurException {
        if(this.Mainsize() == 1 && this.getUno() == true || this.getUno() == false || this.Mainsize() > 1 ) {
            if (this.AJouer == false)
                throw new JoueurException("Le joueur n'a pas jouer et passe son tour ");
            else {
                this.AJouer = false;
                if (partie.getNombreJoueur() >= this.Ordre + 1)
                    partie.setJoueurCourant(this.Ordre + 1);
                else
                    partie.setJoueurCourant(1);
            }
        }


    }

    public void Pioche() throws JoueurException
    {
        if(partie.getJoueurCourant() == this.getOrdre())
        {
            if(AJouer == true)
            {
                throw new JoueurException("Le joueur à déjà jouer, il ne peux pas piocher en plus");
            }
            else{
                MainJoueur.add(partie.getPioche(partie.Piochesize() - 1));
                partie.removePioche(partie.Piochesize() - 1);
            }
        }


    }

    public void Uno(){
            this.setUno(true);
            System.out.println(this+"\nUNOOO mon reuf");
    }

    public Boolean getUno() {
        return Uno;
    }

    public void setUno(Boolean uno) {
        Uno = uno;
    }

    public void setAJouer(Boolean AJouer) {
        this.AJouer = AJouer;
    }

    public Boolean getAJouer() {
        return AJouer;
    }

    public int Mainsize() {
        return MainJoueur.size();
    }

    public int getOrdre() {
        return Ordre;
    }

    public Carte get(int index) {
        return MainJoueur.get(index);
    }

    public boolean add(Carte carte) {
        return MainJoueur.add(carte);
    }

    public void clear() {
        MainJoueur.clear();
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "Main"+Nom+"=" + MainJoueur +
                '}';
    }
}
