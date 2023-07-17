package bookmyshows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MusicShow extends Book {

	static String url = "jdbc:postgresql://localhost:5432/Student_jdbc";
	static String username = "postgres";
	static String password = "tiger";
	
	static String singer;
    void search(){
        System.out.println("Searching Music Shows in "+ super.lang+" language in "+super.loc +"........");
        
        
        try {
        	//connection
        	Connection con = DriverManager.getConnection(url,username, password);
        	
        	//query
        	String query = "select singer from music where lang = ? and loc = ?";
        	
        	
        	//prepare statement
        	PreparedStatement pst = con.prepareStatement(query);
        	pst.setString(1, super.lang);
        	pst.setString(2, super.loc);
        	
        	//execute query
        	ResultSet rs = pst.executeQuery();
        	
        	int i=1;
        	while(rs.next()) {
        		System.out.println(i+": "+rs.getString(1));
        		i++;
        	}
        	String qry = "select singer from music where singer = ?";
        	PreparedStatement pst1 = con.prepareStatement(qry);
        	System.out.println("Enter Singer name");
        	sc.nextLine();
        	String st = sc.nextLine();
        	pst1.setString(1, st);
        	
        	ResultSet rs2 = pst1.executeQuery();
        	
        	while(rs2.next()) {
        		singer = rs2.getString(1);
        	}
        	
        	//close all the statments
        	pst.close();
        	pst1.close();
        	con.close();
            
            
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
  
    }

    void book(){
        System.out.println("You have booked music show of "+singer + " in "+super.loc+ " and total tickets are "+super.noofticket);
    }
}
