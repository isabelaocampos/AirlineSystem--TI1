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

		option = reader.nextInt(); 

		return option; 
	}
    public void executeOption(int option){
        

        switch(option){
			case 1:
				//C:\\Users\\Isabella\\Documents\\ICESI\\Tercer Semestre\\Computacion y Estructuras Discretas I\\Integradora I\\data\\ordenDeLlegada.csv
				//File projectDir = new File(System.getProperty("user.dir"));
				//File dataDirectory = new File(projectDir+"/data");
				//File result = new File(projectDir+ "\ordenDeLlegada.csv”);
				//System.out.println(dataDirectory);
				//System.out.println("Please write the pathfile of the file (ordenDeLlegada.csv) that has the passengers by order of arrival");
				//String file = reader.next();
				//System.out.println(file);
				//controller.passengerOrder(file);
				System.out.println("orden de los pasajeros, ingrese la direccion del txt donde estan los pasajeros por orden de llegada.");
				String file= reader.next();
				controller.passengerOrder(file);
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
