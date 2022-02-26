package carte.ensemble;

import java.awt.*;

    public enum Couleur {
        ROUGE, VERT, BLEU, JAUNE;


        public Color getColor() {
            switch(this) {
                case BLEU: return Color.BLUE;
                case JAUNE: return Color.YELLOW;
                case ROUGE: return Color.RED;
                case VERT: return Color.GREEN;
            }
            return Color.BLACK;
        }

        public static Couleur get(int id) {
            if(id < 0 || id >= values().length)
                return null;
            return values()[id];
        }



    }
