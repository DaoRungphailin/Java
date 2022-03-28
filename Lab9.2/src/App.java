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
import javafx.geometry.Pos;

public class App extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane gridPane = new GridPane();
        //gridPane.setPadding(new Insets(5, 5, 5, 5));

        //Image
        Image uk = new Image("C:/Desktop/Java/Lab9.2/images/UK.png");
        Image us = new Image("C:/Desktop/Java/Lab9.2/images/US.png");
        Image canada = new Image("C:/Desktop/Java/Lab9.2/images/Canada.png");
        Image china = new Image("C:/Desktop/Java/Lab9.2/images/China.png");

        ImageView ukView = new ImageView(uk);
        ImageView usView = new ImageView(us);
        ImageView canadaView = new ImageView(canada);
        ImageView chinaView = new ImageView(china);

        usView.setFitHeight(150);
        usView.setFitWidth(200);
        ukView.setFitHeight(150);
        ukView.setFitWidth(200);
        canadaView.setFitHeight(150);
        canadaView.setFitWidth(200);
        chinaView.setFitHeight(150);
        chinaView.setFitWidth(200);

        //Place Node
        gridPane.add(new ImageView(uk), 0, 0);
        gridPane.add(new ImageView(canada), 1, 0);
        gridPane.add(new ImageView(china), 0, 1);
        gridPane.add(new ImageView(us), 1, 1);

        //Set Scene
        Scene scene = new Scene(gridPane, 400, 600);
        primaryStage.setTitle("Lab9.2 Pro1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}