import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    String fileName;

    //Text area
    Window primaryStage;
    TextArea textArea = new TextArea();
    FileChooser fileChooser = new FileChooser();
    String file_dummy = "";

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();

        //scene
        Scene scene = new Scene(pane, 440, 675);

        primaryStage.setTitle("OOP project - Text Editor");
        primaryStage.setScene(scene);
        primaryStage.show();

        //button
        Button new_button = new Button("New");
        Button open_button = new Button("Open");
        Button save_button = new Button("Save");
        Button saveAs_button = new Button("Save As");

        pane.getChildren().add(new_button);
        new_button.relocate(10, 10);
        pane.getChildren().add(open_button);
        open_button.relocate(80, 10);
        pane.getChildren().add(save_button);
        save_button.relocate(155, 10);
        pane.getChildren().add(saveAs_button);
        saveAs_button.relocate(225, 10);

        //button action
        new_button.setOnAction(e -> create());
        open_button.setOnAction(e -> {
            try {
                open();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        save_button.setOnAction(e -> save());
        saveAs_button.setOnAction(e -> saveAs());

        //text area
        pane.getChildren().add(textArea);
        textArea.relocate(10, 50);
        textArea.setPrefColumnCount(35);
        textArea.setPrefRowCount(37);
    }

    //action
    public Object create() {
        fileName = null;
        if(fileName==null) {
            saveAs();
        }
        return null;
    }

    public void open() throws IOException {

        File selectedFile = fileChooser.showOpenDialog(primaryStage);
        String check = selectedFile.getPath().split("\\.")[1];
        if (check.equals("txt")){
            file_dummy = selectedFile.getPath();

            textArea.clear();
            File file = new File(selectedFile.getPath());

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader((fileReader));
            if (!file.canWrite()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Alert");
                alert.setHeaderText("This file can not be edit !");
                alert.showAndWait();
            }

            String line;
            String[] colums;

            while ((line=bufferedReader.readLine()) != null){
                colums = line.split("\n");
                textArea.appendText(colums[0] + "\n");
            }
            bufferedReader.close();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alert");
            alert.setHeaderText("This file is not a text file !");
            alert.showAndWait();
        }

    }
    public void save () {

        if (file_dummy.equals("")){
            FileChooser fileChooser = new FileChooser();

            FileChooser.ExtensionFilter extFilter =
                    new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);

            File file = fileChooser.showSaveDialog(primaryStage);
            if(file != null){
                SaveFile(textArea.getText(), file);
            }
        }
        else{
            File file = new File(file_dummy);
            SaveFile(textArea.getText(), file);
            file_dummy = file.getPath();
        }
    }
    
    public void saveAs() {

        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showSaveDialog(primaryStage);

        if(file != null){
            SaveFile(textArea.getText(), file);
        }
    }

    private void SaveFile(String content, File file){
        try {
            FileWriter fileWriter;
            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        file_dummy = file.getPath();
        }
    }