package luke.strazzera.strazzeracsc211dogdoor;
import  luke.strazzera.strazzeracsc211dogdoor.SoundRecognizerContainer;
import  luke.strazzera.strazzeracsc211dogdoor.BarkRecognizer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DoorViewController {

    @FXML
    Rectangle door;
    @FXML
    Rectangle window;

    @FXML
    Button openDoor;
    @FXML
    Button closeDoor;
    @FXML
    Button windowButton;

    @FXML
    Label statusLabel;

    @FXML
    TextField codeTextField;
    Remote remote = new Remote(12345);
    Dog fido = new Dog("Fido", "Aroo", "ScrScr");
    Dog spot = new Dog("Spot", "Woof", "ErrErr");

    DogDoor fidosDoor;
    SoundRecognizerContainer soundRecognizerContainer = new SoundRecognizerContainer();

    public void initialize(){
        statusLabel.setText("Welcome \nto the \nDog Door \nApplication");
        soundRecognizerContainer.addRecognizer(new BarkRecognizer(fido.bark));
        soundRecognizerContainer.addRecognizer(new ScratchRecognizer(fido.scratch));

        fidosDoor = new DogDoor(soundRecognizerContainer);

    }

    public void openDoor(){
        door.setFill(Color.WHITE);
        statusLabel.setText("Opened door.");
    }

    public void closeDoor(){
        door.setFill(Color.BROWN);
        statusLabel.setText("Closed door.");
    }

    public void openWindows(){
        window.setFill(Color.DODGERBLUE);
        remote.openWindows();
        statusLabel.setText("Opened Window.");
    }

    public void closeWindows(){
        window.setFill(Color.WHITE);
        remote.closeWindows();
        statusLabel.setText("Closed Window.");
    }

    public void windowCodeHandler(){
        if(!codeTextField.getText().isEmpty()){
            int parsedCode = Integer.parseInt(codeTextField.getText());
            if(parsedCode == remote.windowsKeypadCode){
                openWindows();
                statusLabel.setText("Code correct\nWindows opened.");
            }
            else{
                closeWindows();
                statusLabel.setText("Code incorrect.\nWindows Closed.");
            }
        }
    }

    public void handleFidoBark(){
        if(fidosDoor.openDoor(fido.bark)){
            door.setFill(Color.WHITE);
            statusLabel.setText("Door opened.");
        }else{
            door.setFill(Color.BROWN);
            statusLabel.setText("Not my dog!\nDoor closed.");
        }
    }

    public void handleOtherSound(){
        if(fidosDoor.openDoor(spot.bark)){
            door.setFill(Color.WHITE);
            statusLabel.setText("Door opened.");
        }else{
            door.setFill(Color.BROWN);
            statusLabel.setText("Not my dog!\nDoor closed.");
        }
    }
}
