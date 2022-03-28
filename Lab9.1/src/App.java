import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;

public class App extends Application{
    TextField loanAmount = new TextField();
    TextField numOfyear = new TextField();
    TextArea output = new TextArea();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn = new Button("Show Table");
        btn.setOnAction(e -> show());
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(new Label("Loan Amount"),loanAmount,new Label("Number of Years"),numOfyear,btn);
        loanAmount.setPrefColumnCount(7);
        numOfyear.setPrefColumnCount(2);
        output.setEditable(true);

        BorderPane pane = new BorderPane();
        pane.setTop(hBox);
        pane.setCenter(output);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("loan GUI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void show() {
        String out = "Interest Rate       Monthly Payment          Total Payment\n";
        double loan;
        int years;
        try {
            loan = Double.parseDouble(loanAmount.getText());
            years = Integer.parseInt(numOfyear.getText());
        } catch (Exception e) {
            return;
        }
        for (double i = 5; i <= 8; i+=0.25) {
            double monthlyPayment = payPerMonth(loan, years, i);
            out += String.format("%-24.2f%-32.2f%-8.2f\n", i, monthlyPayment, monthlyPayment * 12 * years);
        }
        output.setText(out);
    }

    public double payPerMonth(double loan, int years, double interestRate) {
        double r = interestRate / 1200;
        int n = years * 12;
        return (loan * r * Math.pow(1 + r, n)) / (Math.pow(1 + r, n) - 1);
    }
    public static void main(String[] args) {
        launch(args);
    }
}