/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.unsw.business.infs2605.W4E1IndiefyLoginScreen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author risha
 */
public class Database {
    
public static void intialise() throws ClassNotFoundException, SQLException{
Class.forName("org.sqlite.JDBC");
Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
Statement stat = conn.createStatement();	

String createLogin = "CREATE TABLE Login"
		+ "(Username TEXT NOT NULL"
		+ ", Password TEXT NOT NULL"
		+ ")";

String createTracks = "CREATE TABLE Tracks"
		+ "(Track TEXT NOT NULL"
		+ ", Artist TEXT NOT NULL"
                + ", Album TEXT NOT NULL"
                + ", Genre TEXT NOT NULL"
		+ ")";

stat.execute(createLogin);
stat.execute(createTracks);
stat.close();
conn.close();
    }

public static void insertValues() throws SQLException{
		Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");	
		Statement stat = conn.createStatement();	

        stat.executeUpdate("INSERT INTO Login " + 
                "VALUES ('Pretentious', 'Hipster')"); 
        stat.executeUpdate("INSERT INTO Tracks " + 
                "VALUES ('Glacier', 'DJ ABC', 'Frozen Chips', 'EDM')"); 
		stat.executeUpdate("INSERT INTO Tracks " + 
                "VALUES ('Foot Roll', 'Lil X', 'Gray', 'Rap')"); 
		stat.executeUpdate("INSERT INTO Tracks " + 
                "VALUES ('Breeze', 'DJ ABC', 'Frozen Chips', 'EDM')"); 
		stat.close();
		conn.close();      
            }
    
public boolean login (String username, String password) throws SQLExcpetion{
    Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
    String query = "SELECT * FROM Login";
    PreparedStatement stat = conn.prepareStatement(query);
    stat.setString(1,username);
    stat.setString(2,password);
    ResultSet rs = stat.executeQuery();
    
    if (rs.next()){
        stat.close();
        conn.close();
        return true;
    }
    else{
        stat.close();
        conn.close();
        return false;
    }
    
    
}

public ObservableList<Tracks> getTracks(){
ObservableList<Tracks> listOfTracks = FXCollections.observableArrayList[];

return listOfTracks;
}

}
