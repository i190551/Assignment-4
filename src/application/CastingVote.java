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
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CastingVote {
	
	 private Connection connection;
	 private PreparedStatement pst;
	 private dbhandler handler=new dbhandler();

    @FXML
    private Button bat;

    @FXML
    private Button lion;

    @FXML
    private Button kite;

    @FXML
    private Button arrow;

    @FXML
    void arrow(ActionEvent event) throws IOException {
    	
    	System.out.println("Voted");
    	String update="UPDATE candidates SET numofvotes=numofvotes+1 WHERE symbol='Arrow'";
		
		connection = handler.getConnection(); 
		try {
			pst=connection.prepareStatement(update);
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		try {
			
			
			pst.executeUpdate();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
    	
		Stage votingproc=new Stage();
		Parent root=FXMLLoader.load(getClass().getResource("Voted.fxml"));

		Scene scene=new Scene(root);
		votingproc.setScene(scene);
		votingproc.show();
		votingproc.setResizable(false);

		votingproc.setTitle("Vote Done");

    }

    @FXML
    void bat(ActionEvent event) throws IOException {
    	System.out.println("Voted");
    	String update="UPDATE candidates SET numofvotes=numofvotes+1 WHERE symbol='Bat'";
		
		connection = handler.getConnection(); 
		try {
			pst=connection.prepareStatement(update);
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		try {
			
			
			pst.executeUpdate();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		Stage votingproc=new Stage();
		Parent root=FXMLLoader.load(getClass().getResource("Voted.fxml"));

		Scene scene=new Scene(root);
		votingproc.setScene(scene);
		votingproc.show();
		votingproc.setResizable(false);

		votingproc.setTitle("Vote Done");

    }

    @FXML
    void kite(ActionEvent event) throws IOException {
    	System.out.println("Voted");
    	String update="UPDATE candidates SET numofvotes=numofvotes+1 WHERE symbol='Kite'";
		
		connection = handler.getConnection(); 
		try {
			pst=connection.prepareStatement(update);
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		try {
			
			
			pst.executeUpdate();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		Stage votingproc=new Stage();
		Parent root=FXMLLoader.load(getClass().getResource("Voted.fxml"));

		Scene scene=new Scene(root);
		votingproc.setScene(scene);
		votingproc.show();
		votingproc.setResizable(false);

		votingproc.setTitle("Vote Done");

    }

    @FXML
    void lion(ActionEvent event) throws IOException {
    	
    	System.out.println("Voted");
    	String update="UPDATE candidates SET numofvotes=numofvotes+1 WHERE symbol='Lion'";
		
		connection = handler.getConnection(); 
		try {
			pst=connection.prepareStatement(update);
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		try {
			
			
			pst.executeUpdate();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		Stage votingproc=new Stage();
		Parent root=FXMLLoader.load(getClass().getResource("Voted.fxml"));

		Scene scene=new Scene(root);
		votingproc.setScene(scene);
		votingproc.show();
		votingproc.setResizable(false);

		votingproc.setTitle("Vote Done");
		

    }

}
