import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;

public class App extends Application {
	@Override 
	public void start(Stage primaryStage) {
		
		// Create three buttons
		Button btPause = new Button("Pause");
		Button btResume = new Button("Resume");
		Button btReverse = new Button("Reverse");

		// Hbox
		HBox paneForButtons = new HBox(5);
		paneForButtons.setAlignment(Pos.CENTER);
		paneForButtons.getChildren().addAll(
			btPause, btResume, btReverse);

		FanPane fan = new FanPane();

		// Slider
		Slider slider = new Slider();
		slider.setMax(5);
		fan.rateProperty().bind(slider.valueProperty());

		// Pane
		BorderPane pane = new BorderPane();
		pane.setTop(paneForButtons);
		pane.setCenter(fan);
		pane.setBottom(slider);

		// Animation
		btPause.setOnAction(e -> {
			fan.pause();
		});

		btResume.setOnAction(e -> {
			fan.play();
		});

		btReverse.setOnAction(e -> {
			fan.reverse();
		});

		Scene scene = new Scene(pane, 200, 200);
		primaryStage.setTitle("Lab9.2 Program 6"); 
		primaryStage.setScene(scene); 
		primaryStage.show(); 
	}
    public static void main(String[] args) {
        launch(args);
    }
}