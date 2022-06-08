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

/**
 * Classe Joueur
 */
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

    /**
     * Constructeur de la classe Joueur
     * @param nom Nom du joueur
     * @param ordre Ordre du joueur
     * @param mainJoueur Main du joueur
     */
    public Joueur(String nom, int ordre, ArrayList<Carte> mainJoueur) {
        Nom = nom;
        Uno = false;
        Ordre = ordre;
        MainJoueur = mainJoueur;
    }


    /**
     * Méthode qui permet de jouer une carte
     * @param carte Carte à ajouter
     * @throws CarteException si la carte est invalide ou si le joueur n'a pas la carte
     * @throws JoueurException si le joueur à déjà jouer
     * @throws TasException si la pose n'est pas valide
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
     * Méthode qui permet de finir le tour
     * @throws JoueurException si le joueur n'à pas jouer et passe son tour
     * @throws UnoException si le joueur à oublié de dire uno
     */
    public void finTour() throws JoueurException, UnoException {
            if(this.getPasse() == false) {
                if (this.Mainsize() == 1 && this.getUno() == true || this.getUno() == false && this.Mainsize() > 1) {
                    if (this.AJouer == false)
                        throw new JoueurException("Le joueur n'a pas jouer et passe son tour ");
                    else {
                        this.AJouer = false;
                        if (partie.getNombreJoueur() >= this.Ordre + 1)
                        {
                        	partie.setJoueurCourant(this.Ordre + 1);
                        	this.setUno(false);
                        }
                        else
                        {
                        	partie.setJoueurCourant(1);
                        	this.setUno(false);
                        }
                    }
                } else {
                    if(this.getUno() == false && this.Mainsize() == 1)
                    {
                        throw new UnoException("Oublie de dire Uno");
                    }
                    this.AJouer = false;
                    if (partie.getNombreJoueur() >= this.Ordre + 1)
                    {
                    	partie.setJoueurCourant(this.Ordre + 1);
                    	this.setUno(false);
                    }
                    else
                    {
                    	partie.setJoueurCourant(1);
                    	this.setUno(false);
                    }
                       

                    throw new UnoException("Le Joueur � dit Uno mais � plus de une carte dans la main"); }
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
                        {
                        	partie.setJoueurCourant(this.Ordre + 2);
                        	this.setUno(false);
                        }
                        else
                        {
                        	partie.setJoueurCourant((this.getOrdre() + 2) - partie.getNombreJoueur());
                        	this.setUno(false);
                        }
                    }
                } else {

                    this.AJouer = false;
                    if (partie.getNombreJoueur() >= this.Ordre + 2)
                    {
                    	partie.setJoueurCourant(this.Ordre + 2);
                    	this.setUno(false);
                    }


                    else
                    {
                    	partie.setJoueurCourant((this.getOrdre() + 2) - partie.getNombreJoueur());
                    	System.out.println((this.getOrdre() + 2) - partie.getNombreJoueur());
                    	this.setUno(false);
                    }
                        

                    throw new UnoException("Le Joueur � dit Uno mais � plus de une carte dans la main");

                }
            }
  

    }

    /**
     * Méthode qui permet de faire piocher un joueur qui a oublié de dire uno
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

    /**
     * Méthode qui permet de faire piocher un joueur
     * @throws PiocheException si le joueur à déjà jouer ou si ce n'est pas son tour
     */
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
                setAJouer(true);
        }


    }

    /**
     * Méthode qui permet de dire uno
     * @throws UnoException si ce n'est pas le tour du joueur
     */
    public void Uno() throws UnoException{
            this.setUno(true);
            System.out.println("UNOOOO !");
            if(partie.getJoueurCourant() != this.getOrdre())
            {
                throw new UnoException("Dit Uno pas son tour");
            }
    }
    /**
     * Getter de l'attribut Nom
     * @return un String Nom
     */
    public String getNom() {
        return Nom;
    }
    
    public void SetPartie(Partie P) {
    	this.partie = P;
    }
    
    /**
     * Getter de l'attribut MainJoueur
     * @return un ArrayList de carte MainJoueur
     */
    public ArrayList<Carte> getMainJoueur() {
        return MainJoueur;
    }
    
    /**
     * Getter de l'attribut uno
     * @return un boolean Uno
     */
    public Boolean getUno() {
        return Uno;
    }

    /**
     * Setter de l'attribut uno
     * @param uno le boolean Uno
     */
    public void setUno(Boolean uno) {
        Uno = uno;
    }

    /**
     * Setter de l'attribut AJouer
     * @param AJouer le boolean AJouer
     */
    public void setAJouer(Boolean AJouer) {
        this.AJouer = AJouer;
    }

    /**
     * Getter de l'attribut AJouer
     * @return le boolean AJouer
     */
    public Boolean getAJouer() {
        return AJouer;
    }

    /**
     * Méthode qui permet de recuperer la taille de la main d'un joueur
     * @return  la taille de la main
     */
    public int Mainsize() {
        return MainJoueur.size();
    }

    /**
     * Getter de l'attribut Ordre
     * @return le int Ordre
     */
    public int getOrdre() {
        return Ordre;
    }

    /**
     * à modifier
     * @param index l'index de la carte à récupérer
     * @return la carte à l'index donné
     */
    public Carte get(int index) {
        return MainJoueur.get(index);
    }

    /**
     * Méthode qui permet d'ajouter une carte à la main d'un joueur
     * @param carte la carte à ajouter
     * @return un boolean qui vérifie si la carte a été ajoutée
     */
    public boolean add(Carte carte) {
        return MainJoueur.add(carte);
    }

    /**
     * Méthode qui permet de supprimer la main d'un joueur, et qui reset l'attribut AJouer et Uno à false
     */
    public void clear() {
        MainJoueur.clear(); this.setUno(false); this.setAJouer(false);
    }

    /**
     * Getter de l'attribut Passe
     * @return le boolean Passe
     */
    public Boolean getPasse() {
        return Passe;
    }

    /**
     * Setter de l'attribut Passe
     * @param passe le boolean Passe
     */
    public void setPasse(Boolean passe) {
        Passe = passe;
    }

    /** 
     * Getter de l'attribut PlusDeux
     * @return le boolean PlusDeux
     */
    public boolean isPlusDeux() {
        return PlusDeux;
    }

    /**
     * Setter de l'attribut PlusDeux
     * @param plusDeux le boolean PlusDeux
     */
    public void setPlusDeux(boolean plusDeux) {
        PlusDeux = plusDeux;
    }

    /**
     * Méthode toString
     * @return une chaine de caractère contenant les informations du joueur
     */
    @Override
    public String toString() {
        return "Joueur{" +
                "Main"+Nom+"=" + MainJoueur +
                '}';
    }
}
