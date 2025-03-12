package sound;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundClip {
    private String filePath;
    private File audioFile;
    private AudioInputStream audioIn;
    private Clip clip;
    private boolean loop = false;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public boolean getLoop() {
        return loop;
    }

    public SoundClip(String path) {
        // implement method here.
        filePath = path;
        clip = null;
    }

    public void open() {
        // implement method here.
        try {
            audioFile = new File(filePath);
            audioIn = AudioSystem.getAudioInputStream(audioFile.getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioIn);
        } catch (UnsupportedAudioFileException e) {
            System.err.println("Unable to initialize the Clip.  Unsupported audio file.");
            System.err.println(e.getMessage());
            clip = null;
            return;
        } catch (IOException e) {
            System.err.println("Unable to initialize the Clip.  IO Exception.");
            System.err.println(e.getMessage());
            return;
        } catch (LineUnavailableException e) {
            System.err.println("Unable to initialize the Clip.  Line unavailable.");
            System.err.println(e.getMessage());
            return;
        }
    }

    public void play() {
        boolean quit = false;

        // implement method here.
        if (clip != null) {
            // if the clip is running, stop it before playing it again.
            if (clip.isRunning()) {
                clip.stop();
                try {
                    // sleep for a moment to give line time to stop playback.
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }

            // start at the beginning of the clip
            clip.setFramePosition(0);
            clip.start();

        }
    }

    private void loop() {

    }

    public void play(boolean wait) {
        // implement method here.
        play();
        if (clip != null && wait) {
            long msec = clip.getMicrosecondLength() / 1000;
            try {
                Thread.sleep(msec);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void stop() {
        loop = false;
    }

    public void close() {
        // implement method here.
        if (clip != null) {
            clip.stop();
            clip.close();
        }

    }

}
