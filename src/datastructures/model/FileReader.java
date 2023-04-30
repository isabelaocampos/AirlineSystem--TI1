package datastructures.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader<T> {
public List<Passenger<T>> readPassengersFromFile(String filePath) throws FileNotFoundException {
    List<Passenger<T>> passengers = new ArrayList<>();

    try {
        File archivo = new File("\\Users\\Isabella\\Documents\\ICESI\\Tercer Semestre\\Computacion y Estructuras Discretas I\\Integradora I\\doc\\pasajeros.txt");
        Scanner lector = new Scanner(archivo);

        while (lector.hasNextLine()) {
            String linea = lector.nextLine();
            String[] datos = linea.split(",");
            String nombre = datos[0];
            String numeroPasaporte = datos[1];
            int seatNumber = Integer.parseInt(datos[2]);
            String letraSilla = datos[3];
            int timeArrive = Integer.parseInt(datos[4]);
            Boolean specialCase = Boolean.parseBoolean(datos[5]);

            Passenger<T> passenger = new Passenger<T>(nombre, numeroPasaporte, seatNumber, letraSilla, timeArrive, specialCase);
            passengers.add(passenger);
        }

        lector.close();

    } catch (FileNotFoundException e) {
        // Archivo no encontrado
        e.printStackTrace();
    } catch (IOException e) {
        // Error de entrada o salida
        e.printStackTrace();
    } catch (NumberFormatException e) {
        // Error al convertir una cadena a un número
        e.printStackTrace();
    }

    return passengers;
   }
}

