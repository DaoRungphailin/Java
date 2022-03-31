import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class App extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        ClockPane clock = new ClockPane(((int) (Math.random() * 12)),(int) (Math.random() * 30), 0);
        clock.setSecondHandVisible(false);
        String time = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
        Label currentTimeLabel = new Label(time);

        BorderPane pane = new BorderPane();
        pane.setCenter(clock);
        pane.setBottom(currentTimeLabel);
        BorderPane.setAlignment(currentTimeLabel, Pos.TOP_CENTER);
        
        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle("Lab9.2 Program 3");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}