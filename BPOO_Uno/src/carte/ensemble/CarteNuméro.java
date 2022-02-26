package carte.ensemble;

import java.util.Objects;

public class CarteNuméro extends CarteSimple{

    public static final int MAXIMUM = 9;
    private int numero;



    public CarteNuméro(String couleur, int numero) {
        super(couleur);
        setNumero(numero);
    }

    public void setNumero(int numero) {
        if(numero < 0 || numero > 9)
        {
            throw new IllegalArgumentException("Numéro de la carte invalide");
        }
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }



    @Override
    public String toString() {
        return "CarteNuméro{" +
                "numero=" + numero +
                ", couleur='" + couleur + '\'' +
                '}';
    }

    public int getValeurPoints() {
        return numero;
    }


    public CarteNuméro dupliquer() {
        return new CarteNuméro(couleur, numero);
    }

    public String getCouleur() {
        return couleur;
    }



}


