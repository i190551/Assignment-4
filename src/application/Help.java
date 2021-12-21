package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Help {

    @FXML
    private Button back;

    @FXML
    void back(ActionEvent event) throws IOException {
    	Stage votingproc=new Stage();
    	Parent root=FXMLLoader.load(getClass().getResource("votingProcedure.fxml"));

    	Scene scene=new Scene(root);
    	votingproc.setScene(scene);
    	votingproc.show();
    	votingproc.setResizable(false);

    	votingproc.setTitle("Voting Procedure");
    	

    }

}
