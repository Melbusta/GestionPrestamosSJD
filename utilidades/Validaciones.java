
package utilidades;

import java.util.Scanner;

public class Validaciones {

    private Scanner sc;

    public Validaciones(Scanner sc) {
        this.sc = sc;
    }

    public static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número válido.");
            }
        }
    }

    public String leerNombre(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();
            if (entrada.matches("[a-zA-ZÁÉÍÓÚáéíóúñÑ ]+")) {
                return entrada;
            } else {
                System.out.println("Ingrese solo letras.");
            }
        }
    }

    public int leerEntero(String mensaje, int min, int max) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();
            try {
                int valor = Integer.parseInt(entrada);
                if (valor >= min && valor <= max) {
                    return valor;
                } else {
                    System.out.println("Ingrese un número entre " + min + " y " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }
    }

    public String leerTextoNoVacio(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();
            if (!entrada.isEmpty()) {
                return entrada;
            } else {
                System.out.println("Este campo no puede estar vacío.");
            }
        }
    }
}
