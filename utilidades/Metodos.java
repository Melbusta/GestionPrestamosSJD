package utilidades;
import java.util.Scanner;

import entidades.ComputadorPortatil;
import entidades.EstudianteDiseño;
import entidades.EstudianteIngenieria;
import entidades.TabletaGrafica;

public class Metodos {
    private Scanner sc;

    public Metodos(Scanner sc) {
        this.sc = sc;
    }

    public void registrarPrestamoIngeniero() {
        System.out.println("\n   REGISTRO DE PRESTAMO - INGENIERIA");
        System.out.print("Ingrese la cédula del estudiante: ");
        String cedula = sc.nextLine();

        for (EstudianteIngenieria e : BaseDatos.ingenieros) {
            if (e.getCedula().equals(cedula)) {
                System.out.print("Este estudiante ya tiene un computador prestado.");
                return;
            }
        }

        System.out.print("Nombre del estudiante: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido del estudiante: ");
        String apellido = sc.nextLine();
        System.out.print("Teléfono del estudiante: ");
        String telefono = sc.nextLine();
        System.out.print("Número de semestre: ");
        int numeroSemestre = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Promedio acumulado: ");
        float promedioAcumulado = sc.nextFloat();
        sc.nextLine();
        System.out.print("Serial del computador: ");
        String serial = sc.nextLine();
        System.out.print("Marca del computador: ");
        String marca = sc.nextLine();
        System.out.print("Tamaño del computador (pulgadas): ");
        float tamaño = sc.nextFloat();
        sc.nextLine();
        System.out.print("Precio del computador: ");
        float precio = sc.nextFloat();
        sc.nextLine();

        String sistemaOperativo = ComputadorPortatil.seleccionarSistemaOperativo(sc);
        String procesador = ComputadorPortatil.seleccionarProcesador(sc);

        try {
            ComputadorPortatil computador = new ComputadorPortatil(serial, marca, tamaño, precio, sistemaOperativo,
                    procesador);
            EstudianteIngenieria estudiante = new EstudianteIngenieria(cedula, nombre, apellido, telefono,
                    numeroSemestre, promedioAcumulado, serial);
            BaseDatos.portatiles.add(computador);
            BaseDatos.ingenieros.add(estudiante);

            System.out.println("Computador registrado exitosamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al registrar el computador: " + e.getMessage());
        }
    }

    public void modificarPrestamoIngeniero() {

        System.out.println("\n MODIFICAR PRESTAMO - INGENIERIA");
        System.out.print("Ingrese la cédula del estudiante o el serial del computador: ");
        String input = sc.nextLine();

        for (EstudianteIngenieria estudiante : BaseDatos.ingenieros) {
            if (estudiante.getCedula().equals(input) || estudiante.getSerial().equals(input)) {
                System.out.println("Registro encontrado, ingrese los nuevos datos: ");

                System.out.print("Nuevo nombre: ");
                estudiante.setNombre(sc.nextLine());
                System.out.print("Nuevo apellido: ");
                estudiante.setApellido(sc.nextLine());
                System.out.print("Nuevo teléfono: ");
                estudiante.setTelefono(sc.nextLine());
                System.out.print("Nuevo número de semestre: ");
                estudiante.setNumeroSemestre(sc.nextInt());
                sc.nextLine();
                System.out.print("Nuevo promedio acumulado: ");
                estudiante.setPromedioAcumulado(sc.nextFloat());
                sc.nextLine();

                System.out.println("Datos modificados exitosamente.");
                return;
            }
        }
        System.out.println("No se encontró el registro.");
    }

    public void devolverPrestamoIngeniero() {
        System.out.println("\n DEVOLVER PRESTAMO - INGENIERIA");
        System.out.print("Ingrese la cédula del estudiante o el serial del computador: ");
        String input = sc.nextLine();

        for (int i = 0; i < BaseDatos.ingenieros.size(); i++) {
            EstudianteIngenieria estudiante = BaseDatos.ingenieros.get(i);
            if (estudiante.getCedula().equals(input) || estudiante.getSerial().equals(input)) {
                String serial = estudiante.getSerial();
                BaseDatos.ingenieros.remove(i);
                BaseDatos.portatiles.removeIf(computador -> computador.getSerial().equals(serial));
                System.out.println("Computador devuelto exitosamente.");
                return;
            }
        }
        System.out.println("No se encontró el registro.");
    }

    public void buscarEquipoIngeniero() {
        System.out.println("\n BUSCAR EQUIPO - INGENIERIA");
        System.out.print("Ingrese la cédula del estudiante o el serial del computador: ");
        String input = sc.nextLine();

        for (EstudianteIngenieria estudiante : BaseDatos.ingenieros) {
            if (estudiante.getCedula().equals(input) || estudiante.getSerial().equals(input)) {
                System.out.println("Registro encontrado:");
                System.out.println("Cédula: " + estudiante.getCedula());
                System.out.println("Nombre: " + estudiante.getNombre());
                System.out.println("Apellido: " + estudiante.getApellido());
                System.out.println("Teléfono: " + estudiante.getTelefono());
                System.out.println("Número de semestre: " + estudiante.getNumeroSemestre());
                System.out.println("Promedio acumulado: " + estudiante.getPromedioAcumulado());

                for (ComputadorPortatil computador : BaseDatos.portatiles) {
                    if (computador.getSerial().equals(estudiante.getSerial())) {
                        System.out.println("DATOS DEL COMPUTADOR:");
                        System.out.println(computador);
                        return;
                    }
                }
                System.out.println("No se encontró el registro.");
                return;
            }
        }
        System.out.println("No se encontró el registro.");
    }

    public void registrarPrestamoDiseño() {
        System.out.println("\n--- Registro de Préstamo - Diseño ---");

        System.out.print("Cédula: ");
        String cedula = sc.nextLine();

        for (EstudianteDiseño e : BaseDatos.diseñadores) {
            if (e.getCedula().equals(cedula)) {
                System.out.println("Este estudiante ya tiene un préstamo registrado.");
                return;
            }
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Apellido: ");
        String apellido = sc.nextLine();

        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();

        System.out.print("Modalidad de estudio (virtual/presencial): ");
        String modalidad = sc.nextLine();

        System.out.print("Cantidad de asignaturas: ");
        int cantidad = Integer.parseInt(sc.nextLine());

        System.out.print("Serial de la tableta: ");
        String serial = sc.nextLine();

        System.out.print("Marca de la tableta: ");
        String marca = sc.nextLine();

        System.out.print("Tamaño en pulgadas: ");
        float tamano = Float.parseFloat(sc.nextLine());

        System.out.print("Precio: ");
        float precio = Float.parseFloat(sc.nextLine());

        String almacenamiento = TabletaGrafica.seleccionarAlmacenamiento(sc);

        System.out.print("Peso (kg): ");
        float peso = Float.parseFloat(sc.nextLine());

        try {
            TabletaGrafica tableta = new TabletaGrafica(serial, marca, tamano, precio, almacenamiento, peso);
            EstudianteDiseño estudiante = new EstudianteDiseño(cedula, nombre, apellido, telefono, modalidad, cantidad,
                    Integer.parseInt(serial));

            BaseDatos.graficas.add(tableta);
            BaseDatos.diseñadores.add(estudiante);

            System.out.println("Préstamo registrado exitosamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al registrar: " + e.getMessage());
        }
    }

    public void modificarPrestamoDiseño() {
        System.out.println("\n--- Modificar Préstamo - Diseño ---");
        System.out.print("Ingrese cédula o serial del equipo: ");
        String input = sc.nextLine();

        for (EstudianteDiseño estudiante : BaseDatos.diseñadores) {
            if (estudiante.getCedula().equals(input) || String.valueOf(estudiante.getSerial()).equals(input)) {
                System.out.println("Registro encontrado. Ingrese los nuevos datos:");

                System.out.print("Nuevo nombre: ");
                estudiante.setNombre(sc.nextLine());

                System.out.print("Nuevo apellido: ");
                estudiante.setApellido(sc.nextLine());

                System.out.print("Nuevo teléfono: ");
                estudiante.setTelefono(sc.nextLine());

                System.out.print("Nueva modalidad (virtual/presencial): ");
                estudiante.setModalidadEstudio(sc.nextLine());

                System.out.print("Nueva cantidad de asignaturas: ");
                estudiante.setCantidadAsignaturas(Integer.parseInt(sc.nextLine()));

                System.out.println("Datos modificados con éxito.");
                return;
            }
        }

        System.out.println("No se encontró ningún registro con esa cédula o serial.");
    }

    public void devolverEquipoDiseño() {
        System.out.println("\n--- Devolución de Equipo - Diseño ---");
        System.out.print("Ingrese cédula o serial del equipo: ");
        String input = sc.nextLine();

        for (int i = 0; i < BaseDatos.diseñadores.size(); i++) {
            EstudianteDiseño estudiante = BaseDatos.diseñadores.get(i);
            if (estudiante.getCedula().equals(input) || String.valueOf(estudiante.getSerial()).equals(input)) {
                int serial = estudiante.getSerial();

                BaseDatos.diseñadores.remove(i);
                BaseDatos.graficas.removeIf(t -> t.getSerial().equals(String.valueOf(serial)));

                System.out.println("Registro eliminado exitosamente.");
                return;
            }
        }

        System.out.println("No se encontró ningún préstamo con esa cédula o serial.");
    }

    public void buscarEquipoDiseño() {
        System.out.println("\n--- Buscar Préstamo - Diseño ---");
        System.out.print("Ingrese cédula o serial del equipo: ");
        String input = sc.nextLine();

        for (EstudianteDiseño estudiante : BaseDatos.diseñadores) {
            if (estudiante.getCedula().equals(input) || String.valueOf(estudiante.getSerial()).equals(input)) {
                System.out.println("=== Datos del estudiante ===");
                System.out.println("Cédula: " + estudiante.getCedula());
                System.out.println("Nombre: " + estudiante.getNombre());
                System.out.println("Apellido: " + estudiante.getApellido());
                System.out.println("Teléfono: " + estudiante.getTelefono());
                System.out.println("Modalidad: " + estudiante.getModalidadEstudio());
                System.out.println("Asignaturas: " + estudiante.getCantidadAsignaturas());

                for (TabletaGrafica tableta : BaseDatos.graficas) {
                    if (tableta.getSerial().equals(String.valueOf(estudiante.getSerial()))) {
                        System.out.println("=== Datos del equipo ===");
                        System.out.println(tableta);
                        return;
                    }
                }

                System.out.println("Equipo asociado no encontrado.");
                return;
            }
        }

        System.out.println("No se encontró ningún préstamo con esa cédula o serial.");
    }

    public void imprimirInventarioTotal() {
        System.out.println("\n======= INVENTARIO TOTAL =======");

        System.out.println("\n--- Ingeniería ---");
        if (BaseDatos.ingenieros.isEmpty()) {
            System.out.println("No hay registros de préstamos para Ingeniería.");
        } else {
            for (EstudianteIngenieria estudiante : BaseDatos.ingenieros) {
                System.out.println("Estudiante:");
                System.out.println("Cédula: " + estudiante.getCedula());
                System.out.println("Nombre: " + estudiante.getNombre() + " " + estudiante.getApellido());

                for (ComputadorPortatil portatil : BaseDatos.portatiles) {
                    if (portatil.getSerial().equals(estudiante.getSerial())) {
                        System.out.println("Equipo: " + portatil);
                        break;
                    }
                }
                System.out.println("--------------------------------");
            }
        }

        System.out.println("\n--- Diseño ---");
        if (BaseDatos.diseñadores.isEmpty()) {
            System.out.println("No hay registros de préstamos para Diseño.");
        } else {
            for (EstudianteDiseño estudiante : BaseDatos.diseñadores) {
                System.out.println("Estudiante:");
                System.out.println("Cédula: " + estudiante.getCedula());
                System.out.println("Nombre: " + estudiante.getNombre() + " " + estudiante.getApellido());

                for (TabletaGrafica tableta : BaseDatos.graficas) {
                    if (tableta.getSerial().equals(String.valueOf(estudiante.getSerial()))) {
                        System.out.println("Equipo: " + tableta);
                        break;
                    }
                }
                System.out.println("--------------------------------");
            }
        }
    }
}