package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connectiondb.dbhandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class newcandidate {
	
	 private Connection connection;
	    private PreparedStatement pst;
	    private dbhandler handler=new dbhandler();


    @FXML
    private TextField candname;

    @FXML
    private TextField candsymbol;

    @FXML
    private TextField candparty;
    
    @FXML
    private TextField candcnic;

    @FXML
    private Button submit;

    @FXML
    void submit(ActionEvent event) {
    	
    	String cn=candcnic.getText();
    	int cid=Integer.parseInt(cn); 

    	String insert="INSERT INTO candidates(cnic,candidatename,candidateparty,symbol,numofvotes)"+"VALUES(?,?,?,?,?)";
		
		connection = handler.getConnection(); 
		try {
			pst=connection.prepareStatement(insert);
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		try {
			
			pst.setInt(1,cid);
			pst.setString(2,candname.getText());

			pst.setString(3,candparty.getText());
			pst.setString(4,candsymbol.getText());
			pst.setString(4,candsymbol.getText());
			pst.setInt(5,0);
			pst.executeUpdate();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
    	
    	
    	
    }

}
