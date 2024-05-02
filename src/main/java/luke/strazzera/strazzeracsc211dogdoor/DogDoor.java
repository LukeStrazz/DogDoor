package luke.strazzera.strazzeracsc211dogdoor;

import java.util.Iterator;

public class DogDoor {
    private SoundRecognizerContainer recognizers;

    public DogDoor(SoundRecognizerContainer recognizers) {
        this.recognizers = recognizers;
    }

    public boolean openDoor(String sound) {
        Iterator<SoundRecognizer> iterator = recognizers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().recognize(sound)) {
                System.out.println("Door opens for " + sound);
                return true;
            }
        }
        System.out.println("Door closed for " + sound);
        return false;
    }
}