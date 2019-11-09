package assignments7;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class GradeDistributionChart extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Grade Distribution");
		Distribution values = new Distribution(0, 5);
		final String[] names = {"0", "1", "2", "3", "4", "5"};

		VBox all = new VBox();
        
		// the input area
		HBox input = new HBox();
		Label inputLabel = new Label("Enter grade: ");
		TextField gradeInput = new TextField();
		Button insertGrade = new Button("Insert");
		input.getChildren().add(inputLabel);
		input.getChildren().add(gradeInput);
		input.getChildren().add(insertGrade);
		input.setAlignment(Pos.CENTER);


        all.getChildren().add(input);

		// the barchart
		final CategoryAxis xAxis = new CategoryAxis(); //String category
		final NumberAxis yAxis = new NumberAxis();  
		final BarChart<String, Number> barchart = new BarChart<>(xAxis,yAxis);

		barchart.setLegendVisible(false); //Just one series, legend is not needed
		xAxis.setLabel("Grade");       
		yAxis.setLabel("Frequency");

        XYChart.Series<String, Number> distrib = new Series<>();
		for(int i = 0; i < names.length; i++) {
			distrib.getData().add(new Data<>(names[i], values.frequency(i)));
		}

		insertGrade.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e){
				if (!gradeInput.getText().equals("")) {
					int a = Integer.parseInt(gradeInput.getText());
					if (a >= 0 && a <= 5) {
						values.insertValue(a);
						distrib.getData().get(a).setYValue(values.frequency(a));
					}
				}
			}
		});
		barchart.getData().add(distrib);
		all.getChildren().add(barchart);
		
		Scene scene = new Scene(all,500,500);
		stage.setScene(scene);
		stage.show();
			
	}
	    
	public static void main(String[] args) {
		launch(args);
	}
}