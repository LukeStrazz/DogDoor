package luke.strazzera.strazzeracsc211dogdoor;

import java.util.Iterator;

public class DogDoor extends Remote {
    private SoundRecognizerContainer recognizers;

    // Add the SoundRecognizerContainer module to the Door.
    public DogDoor(SoundRecognizerContainer recognizers) {
        this.recognizers = recognizers;
    }
    // Using the SoundRecognizer interface, iterate through the sound made to see if the sound matches.
    public boolean openDoor(String sound) {
        Iterator<SoundRecognizer> iterator = recognizers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().recognize(sound)) {
                // If the sound is found in the list of recognized sounds, open the door.
                System.out.println("The Dog Door is open for " + sound);
                return true;
            }
        }
        // If the sound is NOT found in the list of recognized sounds, close the door.
        System.out.println("The Dog Door is closed for " + sound);
        return false;
    }

}