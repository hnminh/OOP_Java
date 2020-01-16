package project_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;

public class ElectricityApp extends Application {
	
	private HashMap<String, Double> devices = new HashMap<>();
	private ArrayList<Consumption> consumptionList = new ArrayList<>();
	private HashMap<String, Double> devicesTotalUsage = new HashMap<>();
	
	private TextField dateInput = new TextField();
	private ComboBox<String> devicesComboBox = new ComboBox<>();
	private TextField timeUsedInput = new TextField();
	private ComboBox<String> datesComboBox = new ComboBox<>();
	private FileChooser fileChooser = new FileChooser();
	
	private TextArea textArea = new TextArea();
	
	private final String devicesFile = "project_1/devices.txt";
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// initialize for the devices combobox
		try {
			readDevices();
		} catch(IOException ex) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Problems with the file");
			alert.setContentText(ex.getMessage());
			alert.showAndWait();
			return;
		}
		
		BorderPane mainPanel = new BorderPane();

		// the input area is declared as a grid
		GridPane inputArea = new GridPane();
		inputArea.setAlignment(Pos.CENTER);
		inputArea.setHgap(10); // horizontal space between columns
		inputArea.setVgap(10); // vertical space between rows
		inputArea.setPadding(new Insets(25, 25, 25, 25));
		
		// the data insert part
		// text control for instructions
		Text instruction1 = new Text("Please give date, devices and time used ");
		// in column 0, row 0, column span 2 and row span 1
		inputArea.add(instruction1, 0, 0, 2, 1);

		// label in column 0, row 1
		Label label1 = new Label("Date (dd.mm.yyyy)");
		inputArea.add(label1, 0, 1);
		inputArea.add(dateInput, 1, 1);

		Label label2 = new Label("Device");
		inputArea.add(label2, 0, 2);
		inputArea.add(devicesComboBox, 1, 2);
		
		Label label3 = new Label("Time used (hours)");
		inputArea.add(label3, 0, 3);
		inputArea.add(timeUsedInput, 1, 3);

		Button addButton = new Button("Add data");
		inputArea.add(addButton, 1, 4);
		
		// the days usage check part
		Text instruction2 = new Text("Choose a day to check the usage");
		inputArea.add(instruction2, 0, 5, 2, 1);
		
		Label label4 = new Label("Date");
		inputArea.add(label4, 0, 6);
		
		inputArea.add(datesComboBox, 1, 6);
		
		Button checkDateButton = new Button("Check");
		inputArea.add(checkDateButton, 1, 7);
		
		// the devices usage check part 
		Button calculateUsageButton = new Button("Calculate total usage");
		inputArea.add(calculateUsageButton, 0, 9);

		Button barChartButton = new Button("Show usage barchart");
		inputArea.add(barChartButton, 1, 9);
		
		mainPanel.setLeft(inputArea);
		
		// create menu bar and File menu
		MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        menuBar.getMenus().add(menuFile);
        
        MenuItem startNew = new MenuItem("New");
        MenuItem openFile = new MenuItem("Open");
        MenuItem saveFile = new MenuItem("Save");
        menuFile.getItems().addAll(startNew, openFile, saveFile);
		mainPanel.setTop(menuBar);
		
		// text information displaying part
		textArea.setEditable(false);
		textArea.setFont(Font.font("Courier New", FontWeight.NORMAL, 12));
		
		// the barchart part
		NumberAxis xAxis = new NumberAxis();
		CategoryAxis yAxis = new CategoryAxis();
		BarChart<Number, String> barchart = new BarChart(xAxis, yAxis);
		barchart.setLegendVisible(false); // no need due to just one series
		xAxis.setLabel("Consumption (kWh)");
		//yAxis.setLabel("Device");
		
		// set the output categories
		XYChart.Series series = new XYChart.Series();
		for (String device : devices.keySet()) {
			series.getData().add(new XYChart.Data(devicesTotalUsage.get(device), device));
		}
		barchart.getData().add(series);
		
		// the output part contains the text area and the barchart
		// work as a grid
		GridPane resultsArea = new GridPane();
		resultsArea.setAlignment(Pos.CENTER);
		resultsArea.setHgap(10); // horizontal space between columns
		resultsArea.setVgap(10); // vertical space between rows
		resultsArea.setPadding(new Insets(25, 25, 25, 25));
		
		resultsArea.add(textArea, 0, 0);
		resultsArea.add(barchart, 0, 1);
		
		mainPanel.setCenter(resultsArea);
	        
			
		Scene scene = new Scene(mainPanel, 800, 700);
		
		primaryStage.setTitle("Electricity application");		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		// event handlers
		addButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				addData();
			}
		});
		
		checkDateButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				showConsumptionByDate();
			}
		});
		
		calculateUsageButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				showConsumptionByDevice();
			}
		});
		
		barChartButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				for (String device : devices.keySet()) {
					series.getData().add(new Data<>(devicesTotalUsage.get(device), device));
				}
			}
		});
		
		saveFile.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				 File file = fileChooser.showSaveDialog(primaryStage);
                 if (file != null) {
                    saveDataToFile(file);
                 }
			}
		});
		
		openFile.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				 File file = fileChooser.showOpenDialog(primaryStage);
                 if (file != null) {
                    readDataFromFile(file);
                 }
			}
		});
		
		startNew.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				textArea.setText("");
				dateInput.setText(null);
				devicesComboBox.getSelectionModel().clearSelection();
				timeUsedInput.setText(null);
				datesComboBox.getItems().clear();;
				while (consumptionList.size() > 0) {
					consumptionList.remove(0);
				}
				for (String device : devices.keySet()) {
					devicesTotalUsage.put(device, (double)0);
					series.getData().add(new Data<>(devicesTotalUsage.get(device), device));
				}
			}
		});

	}
	
	// reads devices and consumption values from the file
	public void readDevices() throws IOException{
		ClassLoader cl = this.getClass().getClassLoader();
		URL url = cl.getResource(devicesFile); 

		try(InputStream in = url.openStream(); BufferedReader input = new BufferedReader(new InputStreamReader(in))){
			String device;
			while((device = input.readLine()) != null) {
				double value = new Double(input.readLine());
				devices.put(device, value);
				devicesTotalUsage.put(device, (double)0);
			}
			List<String> names = devices.keySet().stream().sorted().collect(Collectors.toList());
			devicesComboBox.setItems(FXCollections.observableArrayList(names));
		}
	}
	
	public void addData() {
		String deviceName = devicesComboBox.getValue();
		double consumptionUnit = devices.get(deviceName);
		String date = dateInput.getText();
		
		// add the date to combo box only when it does not exist
		int flag = 1;
		for (int i = 0; i < consumptionList.size(); i++) {
			if (consumptionList.get(i).getDateUsed().equals(date)) {
				flag = 0;
				break;
			}
		}
		if (flag == 1) datesComboBox.getItems().add(date);
		
		consumptionList.add(new Consumption(deviceName, Double.parseDouble(timeUsedInput.getText()), date, consumptionUnit));
		devicesTotalUsage.put(deviceName, devicesTotalUsage.get(deviceName) + consumptionUnit*Double.parseDouble(timeUsedInput.getText()));
	}
	
	public void showConsumptionByDate() {
		if (datesComboBox != null) {
			String result = "Date: " + datesComboBox.getValue() + "\n";
			double totalConsumption = 0;
			for (int i = 0; i < consumptionList.size(); i++) {
				Consumption newEntry = consumptionList.get(i);
				if (newEntry.getDateUsed().equals(datesComboBox.getValue())) {
					result += newEntry.getDeviceName() + ", " + newEntry.getTimeUsed() + " hours\n";
					totalConsumption += newEntry.getConsumption();
				}
			}
			result += "Total consumption: " + totalConsumption + "kWh";
			textArea.setText(result);
		}
	}
	
	public void showConsumptionByDevice() {
		String result = "";
		for (String device : devices.keySet()) {
			result += device + ": " + devicesTotalUsage.get(device) + "kWh\n";
		}
		textArea.setText(result);
	}
	
	public void saveDataToFile(File file) {
		try {
			PrintWriter output = new PrintWriter(new FileOutputStream(file), true);
			for (int i = 0; i < consumptionList.size(); i++) {
				Consumption newEntry = consumptionList.get(i);
				output.println(newEntry.getDateUsed());
				output.println(newEntry.getDeviceName());
				output.println(newEntry.getTimeUsed());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void readDataFromFile(File file) {
		try {
			BufferedReader input = new BufferedReader(new FileReader(file));
			String dateUsed;
			while ((dateUsed = input.readLine()) != null) {
				String deviceName = input.readLine();
				Double timeUsed = Double.parseDouble(input.readLine());
				
				// add the date to combo box only when it does not exist
				int flag = 1;
				for (int i = 0; i < consumptionList.size(); i++) {
					if (consumptionList.get(i).getDateUsed().equals(dateUsed)) {
						flag = 0;
						break;
					}
				}
				if (flag == 1) datesComboBox.getItems().add(dateUsed);
				
				consumptionList.add(new Consumption(deviceName, timeUsed, dateUsed, devices.get(deviceName)));
				devicesTotalUsage.put(deviceName, timeUsed*devices.get(deviceName));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
