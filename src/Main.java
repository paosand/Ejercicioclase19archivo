import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String archivo = "D:/Ejercicioclase19archivo/test.txt";
        ArrayList<Integer> numeros = new ArrayList<>();
        String linea;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            while ((linea = br.readLine()) != null) {

                if (esNumero(linea)) {
                    int dato = Integer.parseInt(linea);
                    numeros.add(dato);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        if (numeros.isEmpty()) {
            System.out.println("No se encontraron los numeros");
            return;
        }

        float suma = 0;
        int mayor = numeros.get(0);
        int menor = numeros.get(0);

        for (int i = 0; i < numeros.size(); i++) {
            int dato = numeros.get(i);
            suma += dato;
            if (dato > mayor) {
                mayor = dato;
            }
            if (dato < menor) {
                menor = dato;
            }
        }

        float promedio = suma / numeros.size();

        System.out.println("Imprimir valor promedio: " + promedio);
        System.out.println("Imprimir numero mayor: " + mayor);
        System.out.println("Imprimir numero menor: " + menor);
    }

       private static boolean esNumero(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}