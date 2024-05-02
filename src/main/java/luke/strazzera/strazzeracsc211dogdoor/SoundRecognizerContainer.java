package luke.strazzera.strazzeracsc211dogdoor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SoundRecognizerContainer implements Iterable<SoundRecognizer> {
    public List<SoundRecognizer> recognizers = new ArrayList<>();

    public void addRecognizer(SoundRecognizer recognizer) {
        recognizers.add(recognizer);
    }

    @Override
    public Iterator<SoundRecognizer> iterator() {
        return recognizers.iterator();
    }
}
