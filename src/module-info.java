module Assignmen4 {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires java.sql;
	requires mysql.connector.java;
	
	opens application to javafx.graphics, javafx.fxml;
}
