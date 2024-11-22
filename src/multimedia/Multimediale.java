package multimedia;

public abstract class Multimediale {
    protected String titolo;

    public Multimediale(String titolo) {
        this.titolo = titolo;
    }

    public String getTitolo() {
        return titolo;
    }
}