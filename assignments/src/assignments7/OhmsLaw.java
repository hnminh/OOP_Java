package assignments7;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OhmsLaw extends Application {

	// start method is main entry point for application.
	// Stage is top-level container.
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Example 1");

		// GridPane for flexible layout of controls in rows and columns
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10); // Horizontal space between columns
		grid.setVgap(10); // Vertical space between rows
		grid.setPadding(new Insets(25, 25, 25, 25));

		// Text control for instructions
		Text instrText = new Text("Give 2/3 values");
		instrText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
		// In column 0, row 0, column span 2 and row span 1
		grid.add(instrText, 0, 0, 2, 1);

		// Label in column 0, row 1
		Label vLabel = new Label("V");
		grid.add(vLabel, 0, 1);

		// TextField in column 1, row 1
		TextField vInput = new TextField();
		grid.add(vInput, 1, 1);

		Label rLabel = new Label("R");
		grid.add(rLabel, 0, 2);

		TextField rInput = new TextField();
		grid.add(rInput, 1, 2);

		Label iLabel = new Label("I");
		grid.add(iLabel, 0, 3);

		TextField iInput = new TextField();
		grid.add(iInput, 1, 3);

		Button btn = new Button("Calculate");
		grid.add(btn, 1, 4);

		Text resultText = new Text();
		grid.add(resultText, 0, 6, 2, 1);
		resultText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));

		// Event handling for button
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				String v = vInput.getText();
				String r = rInput.getText();
				String i = iInput.getText();
				if (v.equals("") && !r.equals("") && !i.equals("")) {
					double rValue = Double.parseDouble(r);
					double iValue = Double.parseDouble(i);
					resultText.setText("V = R*I = " + (rValue * iValue));
				} else if (r.equals("") && !v.equals("") && !i.equals("")) {
					double vValue = Double.parseDouble(v);
					double iValue = Double.parseDouble(i);
					resultText.setText("R = V/I = " + (vValue / iValue));
				} else if (i.equals("") && !v.equals("") && !r.equals("")) {
					double vValue = Double.parseDouble(v);
					double rValue = Double.parseDouble(r);
					resultText.setText("I = V/R = " + (vValue / rValue));
				}
				else resultText.setText("");
			}
		});

		// Scene is container for all content
		Scene scene = new Scene(grid, 300, 300);
		primaryStage.setScene(scene);

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}