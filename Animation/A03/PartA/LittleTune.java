import javax.sound.sampled.LineUnavailableException;
import sound.ToneGenerator;
import sound.ToneGenerator.Note;

public class LittleTune {
    public static void main(String[] args) throws LineUnavailableException {
        // Create and ititialize my tone generator.
        ToneGenerator tg = new ToneGenerator();
        tg.init();
        try {
            tg.init();
        } catch (LineUnavailableException e) {
            System.err.println("Unable to initialize tone generator.");
            return;
        }

        // Play a little tune
        tg.play(Note.E5, 800); // Sweeet
        tg.play(Note.REST, 50);
        tg.play(Note.G4, 400); // Car-
        tg.play(Note.REST, 50);
        tg.play(Note.A4, 200); // Oh-
        tg.play(Note.REST, 50);
        tg.play(Note.A4, 600); // Line
        tg.play(Note.REST, 1000);

        tg.play(Note.A4, 600); // Good
        tg.play(Note.REST, 50);
        tg.play(Note.F5, 400); // Times
        tg.play(Note.REST, 50);
        tg.play(Note.F5, 200); // Ne
        tg.play(Note.REST, 50);
        tg.play(Note.E5, 200); // Ver
        tg.play(Note.REST, 50);

        tg.play(Note.D5, 400); // Seemed
        tg.play(Note.REST, 50);
        tg.play(Note.C5, 300); // so
        tg.play(Note.REST, 75);
        tg.play(Note.G4, 800); // gooddd

        tg.close();
    }
}
