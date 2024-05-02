package luke.strazzera.strazzeracsc211dogdoor;

import java.util.Iterator;

public class SoundRecognizer {
    BarkRecognizer barkRecognizer;
    ScratchRecognizer scratchRecognizer;

    SoundRecognizer(BarkRecognizer barkRecognizer, ScratchRecognizer scratchRecognizer){
        this.barkRecognizer = barkRecognizer;
        this.scratchRecognizer = scratchRecognizer;
    }

    public SoundRecognizer() {

    }

    boolean matchSound(String madeSound){
        if(madeSound == barkRecognizer.sound || madeSound == scratchRecognizer.sound){
            return true;
        }
        return false;
    }
}