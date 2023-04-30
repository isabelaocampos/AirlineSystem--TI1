package test;

import model.*;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.Assert.*;

public class FileReaderTest{

@Test
public void testReadPassengersFromFile() throws FileNotFoundException {
    FileReader<String> fileReader = new FileReader<>();
    List<Passenger<String>> passengers = fileReader.readPassengersFromFile("ruta/del/archivo/pasajeros.txt");

    assertEquals(3, passengers.size());
    assertEquals("Juan", passengers.get(0).getNombre());
    assertEquals("12345", passengers.get(0).getNumeroPasaporte());
    assertEquals(1, passengers.get(0).getNumSilla());
    assertEquals("A", passengers.get(0).getletraSilla());
    assertEquals(10, passengers.get(0).getArrivalTime());
    assertEquals(false, passengers.get(0).getSpecialCase());
}

@Test(expected = FileNotFoundException.class)
public void testReadPassengersFromFileWithInvalidFilePath() throws FileNotFoundException {
    FileReader<String> fileReader = new FileReader<>();
    List<Passenger<String>> passengers = fileReader.readPassengersFromFile("ruta/invalida/pasajeros.txt");
}


@Test
public void testReadPassengersFromFileWithInvalidDataFormat() throws FileNotFoundException {
    FileReader<String> fileReader = new FileReader<>();
    List<Passenger<String>> passengers = fileReader.readPassengersFromFile("ruta/del/archivo/pasajeros_invalidos.txt");

    assertEquals(2, passengers.size());
    assertEquals("Juan", passengers.get(0).getNombre());
    assertEquals("12345", passengers.get(0).getNumeroPasaporte());
    assertEquals(1, passengers.get(0).getNumSilla());
    assertEquals("A", passengers.get(0).getletraSilla());
    assertEquals(10, passengers.get(0).getArrivalTime());
    assertEquals(false, passengers.get(0).getSpecialCase());
    assertEquals("Pepe", passengers.get(1).getNombre());
    assertEquals("67890", passengers.get(1).getNumeroPasaporte());
    assertEquals(2, passengers.get(1).getNumSilla());
    assertEquals("B", passengers.get(1).getletraSilla());
    assertEquals(12, passengers.get(1).getArrivalTime());
    assertEquals(true, passengers.get(1).getSpecialCase());
}

}
