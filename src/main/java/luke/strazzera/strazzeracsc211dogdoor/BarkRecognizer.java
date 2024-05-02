package luke.strazzera.strazzeracsc211dogdoor;

class BarkRecognizer implements SoundRecognizer {
    private String recognizedSound;

    public BarkRecognizer(String sound) {
        this.recognizedSound = sound;
    }

    public boolean recognize(String sound) {
        return sound.equals(recognizedSound);
    }
}
