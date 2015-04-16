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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
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

public class newTimeLine implements Initializable {
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
    private Button ok;
	    @FXML
	    void cancel(ActionEvent event) throws IOException {
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
	    
	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
