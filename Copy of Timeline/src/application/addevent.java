package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class addevent implements Initializable {
	 @FXML
	    private AnchorPane Window;
	 

	    @FXML
	    private Button ok;
	    
	    @FXML
	    private Button cancel;

	    @FXML
	    private TextArea Description;

	    @FXML
	    private DatePicker start;

	    @FXML
	    private TextField Title;

	    @FXML
	    private DatePicker end;
	
	@FXML
	void cancel(ActionEvent event) throws IOException{
		AnchorPane backToTimeLine; //we need to load the layout that we want to swap
		backToTimeLine = (AnchorPane)FXMLLoader.load(getClass().getResource("newTimeLine.fxml"));
	
        Stage mainWindow; //Here is the magic. We get the reference to main Stage.
        
        
        
       Scene newScene = new Scene(backToTimeLine); //then we create a new scene with our new layout
   
        mainWindow = (Stage)  ((Node)event.getSource()).getScene().getWindow();
       
        mainWindow.setScene(newScene); //here we simply set the new scene
	}
}
