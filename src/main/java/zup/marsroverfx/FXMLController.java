package zup.marsroverfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable {
    
    MarsRover marsRover = new MarsRover();

    @FXML
    private TextArea txtInput;
    
    @FXML
    private TextArea txtOutput;
    
    @FXML
    private TextField txtGrid;            
    
    @FXML
    private Label labelStatus;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        txtOutput.setText("");
        
        try{
            String[] parts = txtInput.getText().split("\n");

            marsRover.setGridSize(txtGrid.getText());
            
            for (int i = 0 ; i < parts.length ; i += 2){
                try{
                    marsRover.setPosition(parts[i]);
                    marsRover.command(parts[i+1]);
                    txtOutput.setText(txtOutput.getText() + "\n" + marsRover.printPosition() + "\n");
                }catch(ArrayIndexOutOfBoundsException ex){
                    throw new IllegalArgumentException("Missing Parameters");
                }

            }
            labelStatus.setText("Status: Success");
        }catch(Exception ex){
            labelStatus.setText("Status: Error");
            txtOutput.setText(txtOutput.getText() + "\n" + ex.getMessage() + "\n");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
}
