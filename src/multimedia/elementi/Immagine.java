package multimedia.elementi;
import multimedia.Multimediale;

public class Immagine extends Multimediale {
    public int getLuminosita() {
        return luminosita;
    }

    private int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = Math.max(luminosita, 1);
    }

    public void aumentaLuminosita() {
        luminosita++;
    }

    public void diminuisciLuminosita() {
        if (luminosita > 1) {
            luminosita--;
        }
    }

    public void show() {
        System.out.println(titolo + "*".repeat(luminosita));
    }
}
