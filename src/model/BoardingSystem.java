package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BoardingSystem<T extends Passenger>{

    private List<T> pasajeros;
    private Map<Integer, List<T>> pasajerosPorFila;

    public BoardingSystem(){
        pasajeros = new ArrayList<>();
        pasajerosPorFila = new HashMap<>();
    }

    public void cargarPasajeros(String rutaArchivo) throws FileNotFoundException {
        File archivo = new File(rutaArchivo);
        Scanner scanner = new Scanner(archivo);

        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine();
            String[] datosPasajero = linea.split(",");
            T pasajero = (T) new Passenger(datosPasajero[0], datosPasajero[1], Integer.parseInt(datosPasajero[2]));
            int fila = Integer.parseInt(datosPasajero[3]);

            pasajeros.add(pasajero);
            if (pasajerosPorFila.containsKey(fila)) {
                pasajerosPorFila.get(fila).add(pasajero);
            } else {
                List<T> pasajerosFila = new ArrayList<>();
                pasajerosFila.add(pasajero);
                pasajerosPorFila.put(fila, pasajerosFila);
            }
        }
    }

    public List<T> buscarPasajeros(String nombre) {
        List<T> resultados = new ArrayList<>();
        for (T pasajero : pasajeros) {
            if (pasajero.getName().equalsIgnoreCase(nombre)) {
                resultados.add(pasajero);
            }
        }
        return resultados;
    }

    public <T extends Pasajero> void registrarLlegada(Pasajero pasajero, Sala sala) {
        // Buscar al pasajero en la lista correspondiente
        List<T> lista = (List<T>) this.pasajeros.get(sala);
        int index = lista.indexOf(pasajero);
    
        if (index != -1) {
            // Actualizar la información del pasajero y reordenar la lista
            lista.get(index).setLlegada(new Date());
            Collections.sort(lista);
        }
    }

    public List<T> obtenerOrdenEmbarque() {
        List<T> ordenEmbarque = new ArrayList<>();
        for (int fila = 1; fila <= pasajerosPorFila.size(); fila++) {
            List<T> pasajerosFila = pasajerosPorFila.get(fila);
            if (pasajerosFila != null) {
                Collections.sort(pasajerosFila);
                ordenEmbarque.addAll(pasajerosFila);
            }
        }
        return ordenEmbarque;
    }

} 
