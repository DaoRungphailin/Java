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
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;

public class App extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(5,5,5,5));
        pane.setVgap(5);
        pane.setHgap(5);

        //Create Matrix
        for(int i = 0 ; i < 10 ; i++)
        {
            for(int j = 0 ; j < 10 ; j++)
            {
                TextField text = new TextField();
                text.setText(String.valueOf((int)(Math.random()*2)));
                pane.add(text, j, i);

                //set width & height
                text.setPrefHeight(30);
                text.setPrefWidth(30);
            }
        }

        //Set Scene
        Scene scene = new Scene(pane);
		primaryStage.setTitle("Lab9.2 Program 2");
		primaryStage.setScene(scene); 
		primaryStage.show(); 
    }


    public static void main(String[] args) {
        launch(args);
    }
}