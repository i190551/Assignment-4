package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginPageAdmin {

    @FXML
    private TextField adminusername;

    @FXML
    private PasswordField adminpassword;

    @FXML
    void LoginAdmin(ActionEvent event) throws IOException {
    	
    	if((adminusername.getText()).equals("usama")&&(adminpassword.getText()).equals("uk1234"))
    	{
    	Stage votingproc=new Stage();
	Parent root=FXMLLoader.load(getClass().getResource("ManageSystem.fxml"));

	Scene scene=new Scene(root);
	votingproc.setScene(scene);
	votingproc.show();
	votingproc.setResizable(false);

	votingproc.setTitle("Manage");
	

    }
    	else
    	{
    		throw new IOException("Invalid Username or password");
    	}
    }
}
