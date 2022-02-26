package carte.ensemble;

import java.util.Objects;

public abstract class Carte {

    protected String couleur;

    public Carte() {}

    public Carte(String couleur) {
        this.couleur = couleur;
    }

    public String getCouleur() {
        return couleur;
    }

    public abstract int getValeurPoints();

    public abstract int getNumero();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Carte)) return false;
        Carte carte = (Carte) o;
        return Objects.equals(getCouleur(), carte.getCouleur());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCouleur());
    }


    //public int getValeurTri() {
     //   return couleur.ordinal() * 13;
    //}


}
