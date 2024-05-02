package luke.strazzera.strazzeracsc211dogdoor;

public class ScratchRecognizer extends SoundRecognizer {
    String sound;
    public ScratchRecognizer(String sound) {
        this.sound = sound;
    }

    public boolean matchSound(String soundMade){
        if(sound == soundMade){
            System.out.println("Scratch sound matches. Door opened.");
            return true;
        }
        System.out.println("Sound does not match! Door remains closed.");
        return false;
    }
}
