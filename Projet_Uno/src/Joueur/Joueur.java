package Joueur;

import Carte.Carte;
import Partie.Partie;
import Carte.CarteSimple;
import Exception.CarteException;
import Exception.JoueurException;
import Exception.TasException;
import Exception.PiocheException;
import Exception.UnoException;

import java.util.ArrayList;

public class Joueur {

    private String Nom;
    private Boolean Uno;
    private int Ordre;
    private ArrayList<Carte> MainJoueur = new ArrayList<Carte>();
    Partie partie = Partie.getInstance();
    private Boolean AJouer = false;
    private Boolean Passe = false;
    private int Encaisse = 0;
    private boolean PlusDeux = false;

    public Joueur(String nom, int ordre, ArrayList<Carte> mainJoueur) {
        Nom = nom;
        Uno = false;
        Ordre = ordre;
        MainJoueur = mainJoueur;
    }


    /**
     *
     * @param carte
     * @throws CarteException
     * @throws JoueurException
     * @throws TasException
     */
    public void JoueUneCarte(Carte carte) throws CarteException, JoueurException, TasException {

        if (carte == null)
            throw new CarteException("Aucune carte a ajouter");
        if(this.AJouer == true)
            throw new JoueurException("Le joueur à déjà jouer");

        if (partie.PoseValide(carte)) {
            carte.faireEffet(this);
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

    /**
     *
     * @throws JoueurException
     * @throws UnoException
     */
    public void finTour() throws JoueurException, UnoException {
        if(this.getPasse() == false) {
            if (this.Mainsize() == 1 && this.getUno() == true || this.getUno() == false && this.Mainsize() > 1) {
                if (this.AJouer == false)
                    throw new JoueurException("Le joueur n'a pas jouer et passe son tour ");
                else {
                    this.AJouer = false;
                    if (partie.getNombreJoueur() >= this.Ordre + 1)
                        partie.setJoueurCourant(this.Ordre + 1);
                    else
                        partie.setJoueurCourant(1);
                }
            } else {
                if(this.getUno() == false && this.Mainsize() == 1)
                {
                    throw new UnoException("Oublie de dire Uno");
                }
                this.AJouer = false;
                if (partie.getNombreJoueur() >= this.Ordre + 1)
                    partie.setJoueurCourant(this.Ordre + 1);
                else
                    partie.setJoueurCourant(1);

                throw new JoueurException("Le joueur n'a pas jouer et passe son tour "); }
            }

         else
        {
            this.setPasse(false);
            if (this.Mainsize() == 1 && this.getUno() == true || this.getUno() == false && this.Mainsize() > 1) {
                if (this.AJouer == false)
                    throw new JoueurException("Le joueur n'a pas jouer et passe son tour ");
                else {
                    this.AJouer = false;
                    if (partie.getNombreJoueur() >= this.Ordre + 2)
                        partie.setJoueurCourant(this.Ordre + 2);
                    else

                        partie.setJoueurCourant((this.getOrdre() + 2) - partie.getNombreJoueur());
                }
            } else {

                this.AJouer = false;
                if (partie.getNombreJoueur() >= this.Ordre + 2)
                    partie.setJoueurCourant(this.Ordre + 2);


                else
                    partie.setJoueurCourant((this.getOrdre() + 2) - partie.getNombreJoueur());

                throw new JoueurException("Le joueur n'a pas jouer et passe son tour ");

            }
        }


    }

    /**
     * 
     * @throws JoueurException
     * @throws PiocheException
     * @throws UnoException
     */
    public void Encaisser() throws JoueurException, PiocheException, UnoException {

        this.setPlusDeux(true);
        if(this.isPlusDeux() == true)
        {

           partie.punition(this);
           this.setPlusDeux(false);
           this.setAJouer(true);
           this.finTour();

        }
    }

    public void Pioche() throws PiocheException
    {
        if(AJouer == true)
        {
            throw new PiocheException("Le joueur à déjà jouer, il ne peux pas piocher en plus");
        }
        else if(partie.getJoueurCourant() != this.getOrdre())
        {
            throw new PiocheException("Ce n'es pas sont tour de jouer");
        }

       if(partie.getJoueurCourant() == this.getOrdre())
        {
                MainJoueur.add(partie.getPioche(partie.Piochesize() - 1));
                partie.removePioche(partie.Piochesize() - 1);
        }


    }

    public void Uno() throws UnoException{
            this.setUno(true);
            System.out.println("UNOOOO !");
            if(partie.getJoueurCourant() != this.getOrdre())
            {
                throw new UnoException("Dit Uno pas son tour");
            }
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
        MainJoueur.clear(); this.setUno(false); this.setAJouer(false);
    }

    public Boolean getPasse() {
        return Passe;
    }

    public void setPasse(Boolean passe) {
        Passe = passe;
    }

    public boolean isPlusDeux() {
        return PlusDeux;
    }

    public void setPlusDeux(boolean plusDeux) {
        PlusDeux = plusDeux;
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "Main"+Nom+"=" + MainJoueur +
                '}';
    }
}
