package multimedia.elementi;
import multimedia.Multimediale;
import multimedia.Riproducibile;

public class RegistrazioneAudio extends Multimediale implements Riproducibile {
    private int durata;

    public int getVolume() {
        return volume;
    }

    private int volume;

    public RegistrazioneAudio(String titolo, int durata, int volume) {
        super(titolo);
        this.durata = Math.max(durata, 1);
        this.volume = Math.max(volume, 1);
    }

    public void abbassaVolume() {
        if (volume > 1) {
            volume--;
        }
    }

    public void alzaVolume() {
        volume++;
    }

    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            System.out.println(titolo + "!".repeat(volume));
        }
    }
}
