import multimedia.Multimediale;
import multimedia.elementi.Immagine;
import multimedia.elementi.RegistrazioneAudio;
import multimedia.elementi.Video;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int scelta;
        Scanner scanner = new Scanner(System.in);
        List<Multimediale> elementi = new ArrayList<>();
        String titolo;
        final int MAX_ELEMENTI = 5;

        for (int i = 0; i < MAX_ELEMENTI; i++) {
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Crea un elemento multimediale (" + (i + 1) + "/" + MAX_ELEMENTI + "):");
            System.out.println("1. Immagine");
            System.out.println("2. Registrazione Audio");
            System.out.println("3. Video");
            System.out.print("Scelta: ");
            int tipo = scanner.nextInt();

            scanner.nextLine();



            switch (tipo) {
                case 1:
                    System.out.print("Inserisci il titolo: ");
                    titolo=scanner.nextLine();
                    System.out.print("Inserisci luminosità: ");
                    int luminositaImg = scanner.nextInt();
                    elementi.add(new Immagine(titolo, luminositaImg));
                    break;

                case 2:
                    System.out.print("Inserisci il titolo: ");
                    titolo=scanner.nextLine();
                    System.out.print("Inserisci durata: ");
                    int durataAudio = scanner.nextInt();
                    System.out.print("Inserisci volume: ");
                    int volumeAudio = scanner.nextInt();
                    elementi.add(new RegistrazioneAudio(titolo, durataAudio, volumeAudio));
                    break;

                case 3:
                    System.out.print("Inserisci il titolo: ");
                    titolo=scanner.nextLine();
                    System.out.print("Inserisci durata: ");
                    int durataVideo = scanner.nextInt();
                    System.out.print("Inserisci volume: ");
                    int volumeVideo = scanner.nextInt();
                    System.out.print("Inserisci luminosità: ");
                    int luminositaVideo = scanner.nextInt();
                    elementi.add(new Video(titolo, durataVideo, volumeVideo, luminositaVideo));
                    break;

                default:
                    System.out.println("Tipo non valido! Riprova.");
                    i--;
                    break;
            }
        }

        System.out.println("Creazione completata! Esegui gli elementi dal menu.");

        while (true) {
            System.out.println("Quale elemento vuoi gestire? (1-" + elementi.size() + ", 0 per uscire): ");
            scelta = scanner.nextInt();

            if (scelta == 0) {
                System.out.println("Uscita dal lettore multimediale.");
                break;
            }

            if (scelta < 1 || scelta > elementi.size()) {
                System.out.println("Scelta non valida. Riprova!");
                continue;
            }

            Multimediale elemento = elementi.get(scelta - 1);

            if (elemento instanceof Immagine) {
                System.out.println("Sei entrato nel menu' di gestione immagine, scelta effettuata: " + scelta + ", titolo: " + elemento.getTitolo());
                gestisciImmagine(scanner, (Immagine) elemento);
            } else if (elemento instanceof Video) {
                System.out.println("Sei entrato nel menu' di gestione video, scelta effettuata: " + scelta + ", titolo: " + elemento.getTitolo());
                gestisciVideo(scanner, (Video) elemento);
            } else if (elemento instanceof RegistrazioneAudio) {
                System.out.println("Sei entrato nel menu' di gestione registrazione, scelta effettuata: " + scelta + ", titolo: " + elemento.getTitolo());
                gestisciRegistrazione(scanner, (RegistrazioneAudio) elemento);
            }
        }

        scanner.close();
    }

    private static void gestisciImmagine(Scanner scanner, Immagine immagine) {
        while (true) {
            System.out.println("1. Mostra immagine");
            System.out.println("2. Aumenta luminosità");
            System.out.println("3. Diminuisci luminosità");
            System.out.println("0. Torna al menu principale");
            System.out.print("Scelta: ");
            int sceltaImm = scanner.nextInt();

            switch (sceltaImm) {
                case 1:
                    immagine.show();
                    break;
                case 2:
                    immagine.aumentaLuminosita();
                    System.out.println("-------------------------");
                    System.out.println("Luminosità aumentata, attuale luminosità: "+ immagine.getLuminosita());
                    System.out.println("-------------------------");
                    break;
                case 3:
                    immagine.diminuisciLuminosita();
                    System.out.println("-------------------------");
                    System.out.println("Luminosità diminuita, attuale luminosità: "+ immagine.getLuminosita());
                    System.out.println("-------------------------");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Scelta non valida.");
            }
        }
    }

    private static void gestisciVideo(Scanner scanner, Video video) {
        while (true) {
            System.out.println("1. Riproduci video");
            System.out.println("2. Aumenta volume");
            System.out.println("3. Diminuisci volume");
            System.out.println("4. Aumenta luminosità");
            System.out.println("5. Diminuisci luminosità");
            System.out.println("0. Torna al menu principale");
            System.out.print("Scelta: ");
            int sceltaVideo = scanner.nextInt();

            switch (sceltaVideo) {
                case 1:
                    video.play();
                    break;
                case 2:
                    video.alzaVolume();
                    System.out.println("-------------------------");
                    System.out.println("Volume aumentato, attuale volume: " + video.getVolume());
                    System.out.println("-------------------------");
                    break;
                case 3:
                    video.abbassaVolume();
                    System.out.println("-------------------------");
                    System.out.println("Volume diminuito, attuale volume: " + video.getVolume());
                    System.out.println("-------------------------");
                    break;
                case 4:
                    video.aumentaLuminosita();
                    System.out.println("-------------------------");
                    System.out.println("Luminosità aumentata, attuale luminosità: "+ video.getLuminosita());
                    System.out.println("-------------------------");
                    break;
                case 5:
                    video.diminuisciLuminosita();
                    System.out.println("-------------------------");
                    System.out.println("Luminosità diminuita, attuale luminosità: "+ video.getLuminosita());
                    System.out.println("-------------------------");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Scelta non valida.");
            }
        }
    }

    private static void gestisciRegistrazione(Scanner scanner, RegistrazioneAudio audio) {
        while (true) {
            System.out.println("1. Riproduci audio");
            System.out.println("2. Aumenta volume");
            System.out.println("3. Diminuisci volume");
            System.out.println("0. Torna al menu principale");
            System.out.print("Scelta: ");
            int sceltaRegistrazione = scanner.nextInt();

            switch (sceltaRegistrazione) {
                case 1:
                    audio.play();
                    break;
                case 2:
                    audio.alzaVolume();
                    System.out.println("-------------------------");
                    System.out.println("Volume aumentato, attuale volume: " + audio.getVolume());
                    System.out.println("-------------------------");
                    break;
                case 3:
                    audio.abbassaVolume();
                    System.out.println("-------------------------");
                    System.out.println("Volume diminuito, attuale volume: " + audio.getVolume());
                    System.out.println("-------------------------");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Scelta non valida.");
            }
        }
    }
}
