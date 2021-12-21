package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connectiondb.dbhandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class votingProcedure {
	private Connection connection;
  	 private PreparedStatement pst;
  	 private dbhandler handler=new dbhandler();
    @FXML
    private Button castvote;

    @FXML
    private Button help;

    @FXML
    private Button logoutvoter;

    @FXML
    private Button viewresult;

    @FXML
    void castvote(ActionEvent event) throws IOException {
    	
    	Stage votingproc=new Stage();
    	Parent root=FXMLLoader.load(getClass().getResource("CastingVote.fxml"));

    	Scene scene=new Scene(root);
    	votingproc.setScene(scene);
    	votingproc.show();
    	votingproc.setResizable(false);

    	votingproc.setTitle("Casting Vote");
    	

    }

    @FXML
    void help(ActionEvent event) throws IOException {
    	Stage votingproc=new Stage();
    	Parent root=FXMLLoader.load(getClass().getResource("Help.fxml"));

    	Scene scene=new Scene(root);
    	votingproc.setScene(scene);
    	votingproc.show();
    	votingproc.setResizable(false);

    	votingproc.setTitle("Help");
    	
    }

    @FXML
    void logoutvoter(ActionEvent event) throws IOException {
    	Stage votingproc=new Stage();
       	Parent root=FXMLLoader.load(getClass().getResource("Choice.fxml"));

       	Scene scene=new Scene(root);
       	votingproc.setScene(scene);
       	votingproc.show();
       	votingproc.setResizable(false);

       	votingproc.setTitle("Electronic Voting");
    }

    @FXML
    void viewresult(ActionEvent event) throws IOException {
    	
   	 

   	
   	
   	try {
   		connection=handler.getConnection();
       	String results="SELECT candidatename,numofvotes FROM candidates";
       	pst = connection.prepareStatement(results);
       	
       	ResultSet rs=pst.executeQuery();
       	
       	while (rs.next())
		{
			System.out.println("\n"  + rs.getString(1) + " : " + rs.getString(2));
		}
		

		

   		//System.out.println("Is the Winner");
   		pst.close();	
   	}catch(Exception e)
   	{
   		System.out.println(e);
   	}
   	
   	try {
   		connection=handler.getConnection();
      	String winner="SELECT candidatename FROM candidates WHERE numofvotes=(SELECT MAX(numofvotes) FROM candidates)";	         
      	pst = connection.prepareStatement(winner);
       	
       	ResultSet rs=pst.executeQuery();
       	
       	while (rs.next())
		{
			System.out.println("\n"  + rs.getString(1)+" is the winner");
		}
		

		

   		//System.out.println("Is the Winner");
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
