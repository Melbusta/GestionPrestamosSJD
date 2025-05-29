import java.util.Scanner;
import utilidades.Metodos;
import utilidades.Validaciones;

public class Menu {
    private Scanner sc;
    private Metodos metodos;

    public Menu(Scanner sc) {
        this.sc = sc;
        this.metodos = new Metodos(sc);
    }

    public void menuPrincipal() {
        int opcion;
        do {
            System.out.println("\n GESTIÓN DE PRÉSTAMOS EQUIPOS SAN JUAN DE DIOS  ");
            System.out.println("1. Estudiantes de Ingeniería");
            System.out.println("2. Estudiantes de Diseño");
            System.out.println("3. Inventario Total");
            System.out.println("4. Salir");

            opcion = Validaciones.leerEntero(sc, "Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    menuIngenieria();
                    break;
                case 2:
                    menuDiseño();
                    break;
                case 3:
                    metodos.imprimirInventarioTotal();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 4);
    }

    private void menuIngenieria() {
        int opcion;
        do {
            System.out.println("\n MENÚ ESTUDIANTES DE INGENIERÍA ");
            System.out.println("1. Registrar préstamo");
            System.out.println("2. Modificar préstamo");
            System.out.println("3. Devolución de equipo");
            System.out.println("4. Buscar equipo");
            System.out.println("5. Volver al menú principal");

            opcion = Validaciones.leerEntero(sc, "Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    metodos.registrarPrestamoIngeniero();
                    break;
                case 2:
                    metodos.modificarPrestamoIngeniero();
                    break;
                case 3:
                    metodos.devolverPrestamoIngeniero();
                    break;
                case 4:
                    metodos.buscarEquipoIngeniero();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    private void menuDiseño() {
        int opcion;
        do {
            System.out.println("\n MENÚ ESTUDIANTES DE DISEÑO ");
            System.out.println("1. Registrar préstamo");
            System.out.println("2. Modificar préstamo");
            System.out.println("3. Devolución de equipo");
            System.out.println("4. Buscar equipo");
            System.out.println("5. Volver al menú principal");

            opcion = Validaciones.leerEntero(sc, "Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    metodos.registrarPrestamoDiseño();
                    break;
                case 2:
                    metodos.modificarPrestamoDiseño();
                    break;
                case 3:
                    metodos.devolverEquipoDiseño();
                    break;
                case 4:
                    metodos.buscarEquipoDiseño();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }
}