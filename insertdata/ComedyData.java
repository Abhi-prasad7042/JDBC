package insertdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ComedyData {
	
	static String url= "jdbc:postgresql://localhost:5432/Student_jdbc";
	static String username = "postgres";
	static String password = "tiger";
	static Scanner sc = new Scanner(System.in);
	static boolean flag = true;
	
	public static void insertComData() {
		try {
			
			Connection con = DriverManager.getConnection(url, username, password);
			
			String query = "insert into comedy values (?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			
			while(flag) {
				System.out.println("Enter id: ");
				int id = sc.nextInt();
				pst.setInt(1,id);
				sc.nextLine();
				
				System.out.println("Enter Comedian name: ");
				String mov = sc.nextLine();
				pst.setString(2,mov);
				
				System.out.println("Enter Language: ");
				String lan = sc.nextLine();
				pst.setString(3,lan);
				
				System.out.println("Enter location: ");
				String loc = sc.nextLine();
				pst.setString(4,loc);
				
				pst.execute();
				
				System.out.println("Do you want to continue:\n 1. Yes\n 2. No");
				int cs = sc.nextInt();
				switch (cs) {
				case 1:{
					continue;
					
				}
				
				case 2:{
					flag=false;
					break;
				}

				default:
					break;
				}
			}
			
			pst.close();
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
	
		insertComData();
		
	}

}
