package luke.strazzera.strazzeracsc211dogdoor;

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

    BarkRecognizer fidosBarkRecognizer = new BarkRecognizer(fido.bark);
    ScratchRecognizer fidosScratchRecognizer = new ScratchRecognizer(fido.scratch);
    SoundRecognizer fidosSoundRecognizer = new SoundRecognizer(fidosBarkRecognizer, fidosScratchRecognizer);

    DogDoor fidosDoor = new DogDoor(fidosSoundRecognizer);

    public void initialize(){
        statusLabel.setText("Welcome \nto the \nDog Door \nApplication");
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
