package bookmyshows;

import java.util.Scanner;

public class Book {

	static Scanner sc = new Scanner(System.in);

    String lang,loc;
    int noofticket;
    
    void selectlang(){
        System.out.println("Enter the language");
        this.lang = sc.next();
    }

    void selectloc(){
        System.out.println("Enter the location");
        this.loc = sc.next();
    }

    void search(){
        System.out.println("seaching movie");
    }

    void book(){
        System.out.println("Booking");
    }

    void selectNoOfTicket(){
        System.out.println("Enter no tickets");
        this.noofticket = sc.nextInt();
    }
    
    
    public static void main(String[] args) {
        Book b;
        System.out.println("What do you want to watch\n 1. Movies\n 2. MusicShow\n 3. ComedyShows ");
        int cs = sc.nextInt();
        
        switch (cs){
            case 1: {
                b = new MovieShow();
                b.selectlang();
                b.selectloc();
                b.search();
                b.selectNoOfTicket();
                b.book();
                break;
            }
            case 2: {
                b = new MusicShow();
                b.selectlang();
                b.selectloc();
                b.search();
                b.selectNoOfTicket();
                b.book();
                break;
            }
            case 3: {
                b = new ComedyShow();
                b.selectlang();
                b.selectloc();
                b.search();
                b.selectNoOfTicket();
                b.book();
                break;
            }

            default:{
                System.out.println("There is no other shows");
            }

        }
    }
}
	

