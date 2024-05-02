package luke.strazzera.strazzeracsc211dogdoor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("door-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Strazzera - Dog Door");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Dog fido = new Dog("Fido", "Aroo", "ScrScr");
        Dog spot = new Dog("Spot", "Woof", "ErrErr");

        SoundRecognizerContainer soundRecognizerContainer = new SoundRecognizerContainer();
        soundRecognizerContainer.addRecognizer(new BarkRecognizer(fido.bark));
        soundRecognizerContainer.addRecognizer(new ScratchRecognizer(fido.scratch));

        DogDoor fidosDoor = new DogDoor(soundRecognizerContainer);

        //Fido barks at the door
        System.out.println("Fido barks at his door:");
        System.out.println(fidosDoor.openDoor(fido.bark));

        //Fido scratches at door
        System.out.println("\nFido scratches at his door:");
        System.out.println(fidosDoor.openDoor(fido.scratch));

        //Spot barks at the door
        System.out.println("Spot barks at Fido's door:");
        System.out.println(fidosDoor.openDoor(spot.bark));

        System.out.println("Use remote to open windows by opting for windows on remote");
        //Use remote to open windows by opting for windows on remote
        Remote fidosRemote = new Remote(true);
        fidosRemote.openWindows(true);
        fidosRemote.closeWindows(); //It would be rude to leave the windows open

        System.out.println("Use remote to attempt to open windows that haven't been enabled");
        //Use remote to attempt to open windows that haven't been enabled
        Remote spotsRemote = new Remote();
        spotsRemote.openWindows(true);

        System.out.println("Use remote to attempt to open windows with keypad with correct code");
        //Use remote to attempt to open windows that haven't been enabled
        spotsRemote = new Remote(12345);
        spotsRemote.openWindows(12345);

        System.out.println("Use remote to attempt to open windows with keypad with wrong code");
        //Use remote to attempt to open windows with wrong code
        spotsRemote.openWindows(123456);

        launch();
    }
}