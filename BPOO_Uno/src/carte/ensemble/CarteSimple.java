package carte.ensemble;

    public abstract class CarteSimple extends Carte {


        /**
         * Cree une nouvelle carte dont la couleur ne peut pas varier
         * @param couleur la couleur de cette carte
         */
        public CarteSimple(String couleur) {
            super(couleur);
        }
}
