package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import connectiondb.dbhandler;
public class LoginPageVoter {
	
	  @FXML
	    private TextField username;

	    @FXML
	    private PasswordField password;
	 @FXML
	    private Button loginvoter;

	    @FXML
	    private Button signup;

	    
	    private dbhandler handler=new dbhandler();
	    private Connection connection;
	    private PreparedStatement pst;
	    
	    @FXML
	    void loginvoter(ActionEvent event) throws IOException 
	    {
	    	String nameUser=username.getText();
	    	int id=Integer.parseInt(nameUser); 
	    	connection=handler.getConnection();
	    	String auth="Select * from votes where cnic=? and pass=?";
	    
	    	try {
	    	pst = connection.prepareStatement(auth);
	    	pst.setInt(1,id);
	    	pst.setString(2, password.getText());
	    	
	    	ResultSet rs=pst.executeQuery();
	    	
	    	int count=0;
	    	while(rs.next())
	    	{
	    		count=count+1;
	    	}
	    	
	    	if(count==1)
	    	{
	    		System.out.print("Login Successful");

		    	Stage votingproc=new Stage();
				Parent root=FXMLLoader.load(getClass().getResource("votingProcedure.fxml"));

				Scene scene=new Scene(root);
				votingproc.setScene(scene);
				votingproc.show();
				votingproc.setResizable(false);

				votingproc.setTitle("Voting Procedure");
	    	}
	    	else
	    	{
	    		System.out.println("Invalid Username or Password");
	    	}
	    	}catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
	    		
	    	finally
	    	{
	    		try
	    		{
	    			connection.close();
	    		}catch(SQLException e)
	    		{
	    			e.printStackTrace();
	    		}
	    	}

	    }

	    @FXML
	    void signup(ActionEvent event) throws IOException 
	    {
	    	
	    	Stage votingproc=new Stage();
			Parent root=FXMLLoader.load(getClass().getResource("SignUp.fxml"));

			Scene scene=new Scene(root);
			votingproc.setScene(scene);
			votingproc.show();
			votingproc.setResizable(false);

			votingproc.setTitle("SignUp");
			

	    }

}
