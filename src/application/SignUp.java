package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connectiondb.dbhandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUp {
	
	@FXML
    private TextField username;

    @FXML
    private TextField cnic;

    @FXML
    private TextField place;

    @FXML
    private PasswordField password;
    
    private Connection connection;
    private PreparedStatement pst;
    private dbhandler handler=new dbhandler();

    @FXML
    void backtologin(ActionEvent event) throws IOException {
    	Stage votingproc=new Stage();
		Parent root=FXMLLoader.load(getClass().getResource("LoginPageVoter.fxml"));

		Scene scene=new Scene(root);
		votingproc.setScene(scene);
		votingproc.show();
		votingproc.setResizable(false);

		votingproc.setTitle("Login");

    }

    @FXML
    void signupdone(ActionEvent event) throws IOException {
        
    
    	String nic=cnic.getText();
    	int cni=Integer.parseInt(nic);  
    	String insert="INSERT INTO votes(cnic,name,place,pass)"+"VALUES(?,?,?,?)";
		
		connection = handler.getConnection(); 
		try {
			pst=connection.prepareStatement(insert);
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		try {
			
			pst.setInt(1, cni);
			pst.setString(2,username.getText());

			pst.setString(3,place.getText());
			pst.setString(4,password.getText());
			pst.executeUpdate();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		
		
		Stage votingproc=new Stage();
		Parent root=FXMLLoader.load(getClass().getResource("LoginPageVoter.fxml"));

		Scene scene=new Scene(root);
		votingproc.setScene(scene);
		votingproc.show();
		votingproc.setResizable(false);

		votingproc.setTitle("Login");

    }

}
