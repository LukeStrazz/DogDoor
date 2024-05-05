package luke.strazzera.strazzeracsc211dogdoor;

public class Remote{
    boolean windows;
    int windowsKeypadCode;

    //The remote class holds 3 constructors:

    //The first is empty for GUI operations
    public Remote() {
        windows = true;
    }

    // The second constructor is one to be used if the owner wants to not setup windows
    public Remote(boolean windows) {
        this.windows = windows;
    }

    // The third constructor is used for owners who would like a key code made for the windows.
    public Remote(int windowsKeypadCode) {
        this.windows = true;
        this.windowsKeypadCode = windowsKeypadCode;
    }

    //For GUI remote
    public void closeDoor(){
        System.out.println("Door closed. ");
    }

    //For GUI remote
    public void openDoor(){
        System.out.println("Door closed. ");
    }
    //Close windows
    public void closeWindows(){
        if(windows){
            System.out.println("Windows are closed.");
        }else {
            System.out.println("Windows aren't enabled.");
        }
    }
    // Open windows is a method made 3 times, similar to the reasons why the constructors are made three times
    // Open windows from remote
    public void openWindows(){
        if(windows){
            System.out.println("Windows are open.");
        }else {
            System.out.println("Windows aren't enabled.");
        }
    }

    //Open windows by entering true
    public void openWindows(boolean openWindows){
        if(windows){
            if(openWindows){
                // Open windows
                System.out.println("Windows are open.");
            }else {
                // Close windows
                System.out.println("Windows are closed.");
            }
        }else {
            System.out.println("Windows aren't enabled.");
        }
    }

    //Open windows with keypad
    public void openWindows(int codeEntered){
        // If windows are enabled
        if(windows){
            // If code is entered correctly
            if(windowsKeypadCode == codeEntered){
                System.out.println("Correct code entered. Windows are open.");
            }else {
                // Wrong code entered
                System.out.println("Wrong code entered. Windows are closed.");
            }
        }else {
            System.out.println("Windows aren't enabled.");
        }
    }
}
