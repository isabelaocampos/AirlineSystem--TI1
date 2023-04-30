package ui;
import java.util.Scanner;

public class Main {

    private Scanner reader;
   
    
    
    public Main(){
        this.reader = new Scanner(System.in);
        
    }

    public Scanner getReader(){
        return reader;
    }
    public static void main(String[] args) {

        Main main = new Main();

        int option = 0; 

				do{
					option = main.getOptionShowMenu(); 
					main.executeOption(option);

				}while(option != 0);

				main.getReader().close();
	}
	//
	public int getOptionShowMenu(){
		int option = 0; 
		System.out.println("<<<<< Welcome to Snakes and Ladders >>>>>");
		System.out.println(
				"1. Play \n" +
                "0. Exit");

		option = reader.nextInt(); 

		return option; 
	}
    //
    public int getOptionShowMenu2(){
        int option2 = 0; 
		System.out.println("<<<<< Time to play >>>>>");
		System.out.println(
				"1. Throw dice \n" +
                "2. See snakes and ladders");
		option2 = reader.nextInt(); 

	    return option2;
    }
  

    public void executeOption(int option){
        

        switch(option){
            case 1: 
           
            case 0:
            System.out.println("Exit program.");
        
            break;
            default:

            break;


        }
    }
    



    public int validateIntegerInput(){
		int option = 0; 

		if(reader.hasNextInt()){
			option = reader.nextInt(); 
		}
		else{ 
			reader.nextLine(); 
			option = -1; 
		}

		return option; 
	}

    
}
