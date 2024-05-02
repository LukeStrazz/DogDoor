package luke.strazzera.strazzeracsc211dogdoor;

public class Remote{
    boolean windows;
    int windowsKeypadCode;

    public Remote() {
    }

    public Remote(boolean windows) {
        this.windows = windows;
    }

    public Remote(int windowsKeypadCode) {
        this.windows = true;
        this.windowsKeypadCode = windowsKeypadCode;
    }

    //Close windows
    public void closeWindows(){
        if(windows){
            System.out.println("Windows are open.");
        }else {
            System.out.println("Windows aren't enabled.");
        }
    }

    //Open windows from remote
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
                System.out.println("Windows are open.");
            }else {
                System.out.println("Windows are closed.");
            }
        }else {
            System.out.println("Windows aren't enabled.");
        }
    }

    //Open windows with keypad
    public void openWindows(int codeEntered){
        if(windows){
            if(windowsKeypadCode == codeEntered){
                System.out.println("Correct code entered. Windows are open.");
            }else {
                System.out.println("Wrong code entered. Windows are closed.");
            }
        }else {
            System.out.println("Windows aren't enabled.");
        }
    }
}
