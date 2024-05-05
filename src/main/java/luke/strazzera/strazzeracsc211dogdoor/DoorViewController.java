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
    Dog fido = new Dog("Fido", "Aroo", "ScrScr");
    Dog spot = new Dog("Spot", "Woof", "ErrErr");

    DogDoor fidosDoor;
    SoundRecognizerContainer soundRecognizerContainer = new SoundRecognizerContainer();

    public void initialize(){
        statusLabel.setText("Welcome \nto the \nDog Door \nApplication");
        soundRecognizerContainer.addRecognizer(new BarkRecognizer(fido.bark));
        soundRecognizerContainer.addRecognizer(new ScratchRecognizer(fido.scratch));

        fidosDoor = new DogDoor(soundRecognizerContainer);
        fidosDoor.windowsKeypadCode = 12345;
    }

    public void openDoor(){
        door.setFill(Color.WHITE);
        fidosDoor.openDoor();
        statusLabel.setText("Opened door.");
    }

    public void closeDoor(){
        door.setFill(Color.BROWN);
        fidosDoor.closeDoor();
        statusLabel.setText("Closed door.");
    }

    public void openWindows(){
        window.setFill(Color.DODGERBLUE);
        fidosDoor.openWindows();
        statusLabel.setText("Opened Window.");
    }

    public void closeWindows(){
        window.setFill(Color.WHITE);
        fidosDoor.closeWindows();
        statusLabel.setText("Closed Window.");
    }

    public void windowCodeHandler(){
        if(!codeTextField.getText().isEmpty()){
            int parsedCode = Integer.parseInt(codeTextField.getText());
            if(parsedCode == fidosDoor.windowsKeypadCode){
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
        if(fidosDoor.openDoor("not a sound from fido")){
            door.setFill(Color.WHITE);
            statusLabel.setText("Door opened.");
        }else{
            door.setFill(Color.BROWN);
            statusLabel.setText("Not my dog!\nDoor closed.");
        }
    }
}
