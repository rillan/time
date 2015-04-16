package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import com.sun.javafx.stage.StagePeerListener;

import javafx.animation.Timeline;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Test implements Initializable  {

	@FXML
	private Button cancel;

	@FXML
	private AnchorPane below;


	@FXML
	LocalDateTime timePoin;
	@FXML
	private DatePicker endDate;

	@FXML
	private MenuItem openTimebtn;

	@FXML
	private Button ok;

	@FXML
	private MenuItem newTimebtn;

	@FXML
	private DatePicker startDate;

	@FXML
	private DatePicker timelineDate;

	@FXML
	private LocalDate startTime ;



	@FXML
	private LocalDate endTime ;

	@FXML
	private Label start = new Label();

	@FXML
	private Label end = new Label();
	@FXML
	private TextField txtfield;

	@FXML
	private Label timeLabel;
	@FXML
	TemporalField t = null;
	
	@FXML
    private AnchorPane newTimeline;

    @FXML
    private Button addTimed;
    @FXML
	private Label title = new Label();
    
    @FXML
    private Pane menu;

    @FXML
    private Button addNoTime;
    @FXML
    private Button oke;
    
    @FXML
    private AnchorPane Window;
 

    @FXML
    private Button ok3;
    
    @FXML
    private Button cancel3;

    @FXML
    private TextArea Description;

    @FXML
    private DatePicker start2;

    @FXML
    private TextField Title;

    @FXML
    private DatePicker end3;

@FXML
void cancel3(ActionEvent event) throws IOException{
	AnchorPane backToTimeLine; //we need to load the layout that we want to swap
	backToTimeLine = (AnchorPane)FXMLLoader.load(getClass().getResource("newTimeLine.fxml"));

    Stage mainWindow; //Here is the magic. We get the reference to main Stage.
    
    
    
   Scene newScene = new Scene(backToTimeLine); //then we create a new scene with our new layout

    mainWindow = (Stage)  ((Node)event.getSource()).getScene().getWindow();
   
    mainWindow.setScene(newScene); //here we simply set the new scene
}
	    @FXML
	    void cancelevent(ActionEvent event) throws IOException {
	    		    }
	    
	    @FXML 
	    void showEvent()  {
	
	    	addTimed.setVisible(true);
	    	addNoTime.setVisible(true);
	
}
	    @FXML
	     void addEvent(ActionEvent event) throws IOException{
	    	
	    	AnchorPane addEvent; //we need to load the layout that we want to swap
	    	addEvent = (AnchorPane)FXMLLoader.load(getClass().getResource("addevent.fxml"));
	        Scene newScene = new Scene(addEvent);
	        
	        Stage mainWindow2; //Here is the magic. We get the reference to main Stage.
	        mainWindow2 = (Stage)  ((Node)event.getSource()).getScene().getWindow();
	        mainWindow2.setTitle("Add event");
	        mainWindow2.setScene(newScene);
	    }
	    
	@FXML
	private void handleButtonAction(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open File");
		File file = fileChooser.showOpenDialog(null);

	}
	@FXML
	final Callback<DatePicker, DateCell> dayCellFactory = 
	new Callback<DatePicker, DateCell>() {
		public DateCell call(final DatePicker datePicker) {
			return new DateCell() {
				@Override
				public void updateItem(LocalDate item, boolean empty) {
					super.updateItem(item, empty);

					if (item.isBefore(
							startDate.getValue().plusDays(1))
							) {
						setDisable(true);
						setStyle("-fx-background-color: #ffc0cb;");
					} 
					if (item.isAfter(
							startDate.getValue().plusYears(1))
							) {
						setDisable(true);
						setStyle("-fx-background-color: #ffc0cb;");
					}   
				}
			};
		}
	};




	@FXML
	public void setStartdate(ActionEvent event) throws IOException {
		startTime = startDate.getValue();
		endDate.setDayCellFactory(dayCellFactory);
		int year = startTime.getYear();
		int month= startTime.getMonthValue();
		int date = startTime.getDayOfMonth();

		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, date);
		start.setText(""+calendar.getTime());
	}

	@FXML
	public void setEnddate(ActionEvent event) {
		endTime =endDate.getValue();
		end.setText(""+endTime);


	}
	@FXML
	public void newTimeLine(ActionEvent event) {

		txtfield.setVisible(true);
		startDate.setVisible(true);
		endDate.setVisible(true);
		ok.setVisible(true);
		cancel.setVisible(true);
		timeLabel.setVisible(true);


	}
	@FXML
	void createTimeLine(ActionEvent event) throws IOException {
		String title = txtfield.getText().toString();
		AnchorPane window3; //we need to load the layout that we want to swap
		window3 = (AnchorPane)FXMLLoader.load(getClass().getResource("newTimeLine.fxml"));
		window3.getChildren().add(start);
		window3.getChildren().add(end);


		Scene newScene; //then we create a new scene with our new layout
		newScene = new Scene(window3);
		start.setPadding(new Insets(30, 30, 30, 30));
		end.setPadding(new Insets(30, 30, 30, 500));

		Stage mainWindow; //Here is the magic. We get the reference to main Stage.
		mainWindow = (Stage)  ((Node)event.getSource()).getScene().getWindow();
		mainWindow.setTitle(title);
		mainWindow.setScene(newScene); //here we simply set the new scene


	}
	@FXML
	void cancel(ActionEvent event) throws IOException {
		txtfield.setVisible(false);
		startDate.setVisible(false);
		endDate.setVisible(false);
		ok.setVisible(false);
		cancel.setVisible(false);
		timeLabel.setVisible(false);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
	


}
