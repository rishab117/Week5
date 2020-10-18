
package au.edu.unsw.business.infs2605.W4E1IndiefyLoginScreen;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginScreenController {

    //Initiate JavaFX nodes (visual elements), how do we connect these variables to the FXML view?
    private final String title = "Indiefy";
    final Label message = new Label("");
    
    @FXML
    TextField usernameField;
    
    @FXML
    PasswordField passwordField;
    
    @FXML
    Button loginButton;
    
    @FXML
    Button nextButton;
    
    
    
    
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
     
    /* What should happen when you click the login button?
       How do we connect this function to the FXML view? */
    private void handleLoginButtonAction(ActionEvent event) {
        
        // Get the user's input from the GUI
        String username = usernameField.getText().trim();
        String password = passwordField.getText();
        boolean success = database.loginusername;
        
        if (username.equals("Pretentious") && password.equals("Hipster")) {
          // What should the user see when the login is successful?
          message.setText("Login Succesful, Rishab N, z5164662");
          switchToSecondary();
          
        } else {
          // What should the user see when the login is unsuccessful?
          nextButton.setVisible(false);
          message.setText("Your password is incorrect!");
        }
        
    }


    private void handleNextButtonAction(ActionEvent event) throws IOException {
        // What method should we call?
        switchToSecondary();
    }

    
    public void initialize() {
        // What should the user see when the screen loads?
        
    }

}

/*What should we test?*/
