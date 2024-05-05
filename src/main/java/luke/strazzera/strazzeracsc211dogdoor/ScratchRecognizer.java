package luke.strazzera.strazzeracsc211dogdoor;

class ScratchRecognizer implements SoundRecognizer {
    private String recognizedSound;

    public ScratchRecognizer(String sound) {
        this.recognizedSound = sound;
    }

    // Using the SoundRecognizer interface
    public boolean recognize(String sound) {
        return sound.equals(recognizedSound);
    }
}