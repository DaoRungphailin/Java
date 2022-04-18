import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class App extends Application {
  //TextField
  private TextField tfAnnualInterestRate = new TextField();
  private TextField tfNumberOfYears = new TextField();
  private TextField tfLoanAmount = new TextField();
  private TextField tfMonthlyPayment = new TextField();
  private TextField tfTotalPayment = new TextField();
  //Button
  private Button btCalculate = new Button("Calculate");
  private Button btSave = new Button("Save");
  private Button btLoad = new Button("Load");
  private Button btClear = new Button("Clear");
  
  @Override 
  public void start(Stage primaryStage) {

    GridPane gridPane = new GridPane();
    gridPane.setHgap(5);
    gridPane.setVgap(5);
    gridPane.add(new Label("Annual Interest Rate:"), 0, 0);
    gridPane.add(tfAnnualInterestRate, 1, 0);
    gridPane.add(new Label("Number of Years:"), 0, 1);
    gridPane.add(tfNumberOfYears, 1, 1);
    gridPane.add(new Label("Loan Amount:"), 0, 2);
    gridPane.add(tfLoanAmount, 1, 2);
    gridPane.add(new Label("Monthly Payment:"), 0, 3);
    gridPane.add(tfMonthlyPayment, 1, 3);
    gridPane.add(new Label("Total Payment:"), 0, 4);
    gridPane.add(tfTotalPayment, 1, 4);

    //Button
    gridPane.add(btCalculate, 3, 5);
    gridPane.add(btSave, 0, 5);
    gridPane.add(btLoad, 1, 5);
    gridPane.add(btClear, 2, 5);


    //Set UI
    gridPane.setAlignment(Pos.CENTER);
    tfAnnualInterestRate.setAlignment(Pos.BOTTOM_RIGHT);
    tfNumberOfYears.setAlignment(Pos.BOTTOM_RIGHT);
    tfLoanAmount.setAlignment(Pos.BOTTOM_RIGHT);
    tfMonthlyPayment.setAlignment(Pos.BOTTOM_RIGHT);
    tfTotalPayment.setAlignment(Pos.BOTTOM_RIGHT);
    tfMonthlyPayment.setEditable(false);
    tfTotalPayment.setEditable(false);
    GridPane.setHalignment(btCalculate, HPos.RIGHT);
    GridPane.setHalignment(btSave, HPos.RIGHT);  
    GridPane.setHalignment(btLoad, HPos.LEFT);
    GridPane.setHalignment(btClear, HPos.LEFT);
    
    //Event
    btCalculate.setOnAction(e -> calculateLoanPayment());

    btClear.setOnAction(e -> clearTextField());
        btSave.setOnAction(e -> {
            try {
                saveData();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        btLoad.setOnAction(e -> {
            try {
                loadData();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

    Scene scene = new Scene(gridPane, 400, 250);
    primaryStage.setTitle("LoanCalculator");
    primaryStage.setScene(scene); 
    primaryStage.show();
  }
  
  private void calculateLoanPayment() {
   
    // Get values from text fields
    double interest = Double.parseDouble(tfAnnualInterestRate.getText());
    int year = Integer.parseInt(tfNumberOfYears.getText());
    double loanAmount = Double.parseDouble(tfLoanAmount.getText());

    Loan loan = new Loan(interest, year, loanAmount);

    // Monthly payment & Total payment
    tfMonthlyPayment.setText(String.format("$%.2f",
      loan.getMonthlyPayment()));
    tfTotalPayment.setText(String.format("$%.2f",
      loan.getTotalPayment()));
  }

  private void clearTextField() {
    tfAnnualInterestRate.setText("");
    tfNumberOfYears.setText("");
    tfLoanAmount.setText("");
    tfMonthlyPayment.setText("");
    tfTotalPayment.setText("");
}

private void saveData() throws IOException{
    try(DataOutputStream output = new DataOutputStream(new FileOutputStream("src\\loan.dat"));){
        output.writeUTF(tfAnnualInterestRate.getText());
        output.writeUTF(tfNumberOfYears.getText());
        output.writeUTF(tfLoanAmount.getText());
        output.writeUTF(tfMonthlyPayment.getText());
        output.writeUTF(tfTotalPayment.getText());
    }
}

private void loadData() throws IOException{
    try(DataInputStream input = new DataInputStream(new FileInputStream("src\\loan.dat"));){
        tfAnnualInterestRate.setText(input.readUTF());
        tfNumberOfYears.setText(input.readUTF());
        tfLoanAmount.setText(input.readUTF());
        tfMonthlyPayment.setText(input.readUTF());
        tfTotalPayment.setText(input.readUTF());
    }
}
  
  public static void main(String[] args) {
    launch(args);
  }
}