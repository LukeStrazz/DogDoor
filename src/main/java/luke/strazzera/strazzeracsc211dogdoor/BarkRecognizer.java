package luke.strazzera.strazzeracsc211dogdoor;

public class BarkRecognizer extends SoundRecognizer {
    public String sound;
    public BarkRecognizer(String sound) {
        super();
        this.sound = sound;
    }

    public boolean matchSound(String soundMade){
        if(sound == soundMade){
            System.out.println("Bark sound matches. Door opened.");
            return true;
        }
        System.out.println("Sound does not match! Door remains closed.");
        return false;
    }

}
