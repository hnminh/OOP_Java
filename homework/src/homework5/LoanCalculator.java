package homework5;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoanCalculator extends Application {
	
	private final TextField loanAmountInput = new TextField();
	private final TextField interestRateInput = new TextField();
	private final TextField periodInput = new TextField();
	private final TextArea textArea = new TextArea();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		BorderPane mainpanel = new BorderPane();

		//Controls for creating new order
		GridPane grid1 = new GridPane();
		grid1.setAlignment(Pos.CENTER);
		grid1.setHgap(10); //Horizontal space between columns
		grid1.setVgap(10); //Vertical space between rows
		grid1.setPadding(new Insets(25, 25, 25, 25));
		// Text control for instructions
		Text instrText = new Text("Give information, then the result will be written in a file");
		// In column 0, row 0, column span 2 and row span 1
		grid1.add(instrText, 0, 0, 2, 1);

		// Label in column 0, row 1
		Label label1 = new Label("Loan Amount ($)");
		grid1.add(label1, 0, 1);
		// TextField in column 1, row 1
		grid1.add(loanAmountInput, 1, 1);

		Label label2 = new Label("Interest Rate (%)");
		grid1.add(label2, 0, 2);
		grid1.add(interestRateInput, 1, 2);

		Label label4 = new Label("Period (years)");
		grid1.add(label4, 0, 3);
		grid1.add(periodInput, 1, 3);

		Button calculateBtn = new Button("Calculate");
		grid1.add(calculateBtn, 1, 4);
		
		//Grid1 left on borderpane
		mainpanel.setLeft(grid1);
		
		//TextArea center of borderpane
		textArea.setEditable(false);
		textArea.setFont(Font.font("Courier New", FontWeight.NORMAL, 12));
		mainpanel.setCenter(textArea);
        	
		Scene scene = new Scene(mainpanel, 1000, 500);
		
		primaryStage.setTitle("Loan Calculator");		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//Event handlers
		calculateBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				displayInformation(e);
			}

		});

	}
	
	private void displayInformation(ActionEvent e) {

		// creating output using StringBuilder
		StringBuilder sb = new StringBuilder();

		// creating headers
		StringBuilder s = new StringBuilder();
		s.append("Year");
		for (int i = s.length(); i <= 10; i++) s.append(" ");
		s.append("Repayment");
		for (int i = s.length(); i <= 30; i++) s.append(" ");
		s.append("Interest");
		for (int i = s.length(); i <= 50; i++) s.append(" ");
		s.append("Installment");
		for (int i = s.length(); i <= 70; i++) s.append(" ");
		s.append("Remaining");
		for (int i = s.length(); i <= 90; i++) s.append(" ");
		s.append("\n");
		sb.append(s.toString());		
		
		// calculate the lines
		double remaining = Double.parseDouble(loanAmountInput.getText());	// set the initial remaining
		int numberOfLines = Integer.parseInt(periodInput.getText());		// number of output lines
		// transfer interest rate to decimal format
		double interestRate = Double.parseDouble(interestRateInput.getText())/100;	
		// calculate the amount of each repayment
		double repayment = remaining/numberOfLines;
		double interest, installment;

		for (int i = 0; i < numberOfLines; i++) {
			interest = remaining*interestRate;
			installment = repayment + interest;
			remaining -= repayment;
			// create a new information entry
			s = new StringBuilder();
			s.append(i + 1);
			for (int j = s.length(); j <= 10; j++) s.append(" ");
			s.append(repayment);
			for (int j = s.length(); j <= 30; j++) s.append(" ");
			s.append(interest);
			for (int j = s.length(); j <= 50; j++) s.append(" ");
			s.append(installment);
			for (int j = s.length(); j <= 70; j++) s.append(" ");
			s.append(remaining);
			for (int j = s.length(); j <= 90; j++) s.append(" ");
			s.append("\n");
			sb.append(s.toString());
		}
		
		// write out to textArea
		textArea.setText(sb.toString());
		
		// print to file
		try {
			PrintWriter output = new PrintWriter(new FileOutputStream("loanCalculator.txt"), true);
			output.println(sb.toString());
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
