package datastructures.ui;

import java.io.File;
import java.util.Scanner;
import datastructures.model.*;

public class  Main{

    private Scanner reader;
	private Controller controller;
    public Main(){
        reader = new Scanner(System.in);
		controller = new Controller();
        
    }

    public Scanner getReader(){
		return reader;
    }

	public Controller getController(){
		return controller;
	}
    public static void main(String[] args) {

        Main main = new Main();
		main.readerTxt();
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
		System.out.println("<<<<< Welcome to Airline System >>>>>");
		System.out.println(
				"1. Arriving of passengers \n" +
						"2. Boarding list of passengers \n" +
						"3. Disembarking list of passengers \n" +
                "0. Exit");

		option = validateIntegerInput();

		return option; 
	}
    public void executeOption(int option){
        

        switch(option){
			case 1:

				File projectDir = new File(System.getProperty("user.dir")); // ruta absoluta al directorio del proyecto
				File dataDir = new File(projectDir+"/data");
				File file = new File(dataDir+"/ordenDeLlegada.csv");

				controller.passengerOrder(file.getAbsolutePath());
				System.out.println("Initialized passengers");

				break;
			case 2:
				controller.showBoardingOrder();
				break;

			case 3:
				controller.showDisOrder();
				break;
			case 0:
				System.out.println("Exit program.");
        
            break;
            default:
				System.out.println("Invalid option");
            break;


        }
    }

	public void readerTxt(){
		//C:\\Users\\Isabella\\Documents\\ICESI\\Tercer Semestre\\Computacion y Estructuras Discretas I\\Integradora I\\data\\pasajeros.csv
		System.out.println("Write the pathfile of the passenger file (pasajeros.csv)");
		String pathfile = reader.nextLine();
		System.out.println("Write amount of passengers: ");
		int num = reader.nextInt();
		controller.uploadPss(pathfile,num);

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
