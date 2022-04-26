import javafx.application.Application;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.FileChooser;

public class App extends Application {
    public static void main(String[] args){
        launch(args);
    }

    private Desktop desktop = Desktop.getDesktop();
    final FileChooser fileChooser = new FileChooser();

    //Text area
    TextArea textArea = new TextArea();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();

        //scene
        int width = 440;
        int height = 500;
        Scene scene = new Scene(pane, width, height);

        primaryStage.setTitle("OOP project - Text Editor");
        primaryStage.setScene(scene);
        primaryStage.show();

        //button
        Button new_button = new Button("New");
        Button open_button = new Button("Open");
        Button save_button = new Button("Save");
        Button edit_button = new Button("Edit");

        pane.getChildren().add(new_button);
        new_button.relocate(10,10);
        pane.getChildren().add(open_button);
        open_button.relocate(80,10);
        pane.getChildren().add(save_button);
        save_button.relocate(160,10);
        pane.getChildren().add(edit_button);
        edit_button.relocate(230,10);

        //button action
        new_button.setOnAction(e -> create());
        open_button.setOnAction(e -> open());
        save_button.setOnAction(e -> save());
        edit_button.setOnAction(e -> edit());

        //text area
        pane.getChildren().add(textArea);
        textArea.relocate(10,50);
        textArea.setPrefColumnCount(35);
        textArea.setPrefRowCount(26);
    }

    //action
    public void create(){
        System.out.println("new");

        
    }
    public void open(File file){
        System.out.println("open");
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
                App.class.getName()).log(
                    Level.SEVERE, null, ex
                );
        }
    }
    
    public void save(){
        System.out.println("save");
        MenuItem cmItem2 = new MenuItem("Save Image");
    cmItem2.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Image");
            System.out.println(pic.getId());
            File file = fileChooser.showSaveDialog(stage);
            if (file != null) {
                try {
                    ImageIO.write(SwingFXUtils.fromFXImage(pic.getImage(),
                        null), "png", file);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
);
    }
    public void edit(){
        System.out.println("edit");
    }
}