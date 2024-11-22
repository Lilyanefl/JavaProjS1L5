package multimedia.elementi;

import multimedia.Multimediale;
import multimedia.Riproducibile;

public class Video extends Multimediale implements Riproducibile {
    private int durata;

    public int getVolume() {
        return volume;
    }

    public int getLuminosita() {
        return luminosita;
    }

    private int volume;
    private int luminosita;

    public Video(String titolo, int durata, int volume, int luminosita) {
        super(titolo);
        this.durata = Math.max(durata, 1);
        this.volume = Math.max(volume, 1);
        this.luminosita = Math.max(luminosita, 1);
    }

    public void abbassaVolume() {
        if (volume > 1) {
            volume--;
        }
    }

    public void alzaVolume() {
        volume++;
    }

    public void aumentaLuminosita() {
        luminosita++;
    }

    public void diminuisciLuminosita() {
        if (luminosita > 1) {
            luminosita--;
        }
    }

    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            System.out.println(titolo + "!".repeat(volume) + "*".repeat(luminosita));
        }
    }
}
