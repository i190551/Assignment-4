package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectiondb.dbhandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ManageSystem {
	 private Connection connection;
	 private PreparedStatement pst;
	 private dbhandler handler=new dbhandler();
	
	  @FXML
	    private Button records;

	    @FXML
	    private Button addnewparty;

	    @FXML
	    private Button addnewcand;
	    
	    @FXML
	    private Button logout;


	    @FXML
	    void logoutAdmin(ActionEvent event) throws IOException {
	    	
	    	Stage votingproc=new Stage();
			Parent root=FXMLLoader.load(getClass().getResource("Choice.fxml"));

			Scene scene=new Scene(root);
			votingproc.setScene(scene);
			votingproc.show();
			votingproc.setResizable(false);

			votingproc.setTitle("Electronic Voting");
			

	    }
    @FXML
    void addnewcandidate(ActionEvent event) throws IOException {
    	Stage votingproc=new Stage();
		Parent root=FXMLLoader.load(getClass().getResource("newcandidate.fxml"));

		Scene scene=new Scene(root);
		votingproc.setScene(scene);
		votingproc.show();
		votingproc.setResizable(false);

		votingproc.setTitle("Add new Candidate");
		

    }

    @FXML
    void addnewparty(ActionEvent event) {

    }

    @FXML
    void recordsvotes(ActionEvent event) throws IOException {
    	try {
			connection=handler.getConnection();
	    	String record="Select * from votes";
	    
	    
	    	pst = connection.prepareStatement(record);
	    	
	    	ResultSet rs=pst.executeQuery();
	    	
		System.out.println("Records of Voters:");
		while (rs.next())
		{
			System.out.println("\n" + rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
		}
		
		pst.close();	
	}catch(Exception e)
	{
		System.out.println(e);
	}
    	Stage votingproc=new Stage();
		Parent root=FXMLLoader.load(getClass().getResource("Choice.fxml"));

		Scene scene=new Scene(root);
		votingproc.setScene(scene);
		votingproc.show();
		votingproc.setResizable(false);

		votingproc.setTitle("Electronic Voting");
		
		
		

    }
    


}
