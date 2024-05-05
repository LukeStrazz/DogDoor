package luke.strazzera.strazzeracsc211dogdoor;

import java.util.Iterator;

public interface SoundRecognizer {
    // Method to return true or false if the sound made is recognized.
    boolean recognize(String sound);
}