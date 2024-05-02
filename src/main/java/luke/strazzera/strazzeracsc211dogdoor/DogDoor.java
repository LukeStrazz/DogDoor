package luke.strazzera.strazzeracsc211dogdoor;

public class DogDoor{
    int doorNumber;
    private SoundRecognizer soundRecognizer; // Composition

    public DogDoor(SoundRecognizer soundRecognizer) {
        this.soundRecognizer = soundRecognizer;
    }
    public int getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(int doorNumber) {
        this.doorNumber = doorNumber;
    }

    public boolean openDoor(String soundMade) {
        if (soundRecognizer.matchSound(soundMade)) {
            System.out.println("Door opens.");
            return true;
        }
        System.out.println("Door stays closed.");
        return false;
    }
}
