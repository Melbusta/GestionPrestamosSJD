package entidades;
import java.util.Scanner;

public class ComputadorPortatil {

    private String serial;
    private String marca;
    private float tamaño;
    private float precio;
    private String sistemaOperativo;
    private String procesador;

    public ComputadorPortatil(String serial, String marca, float tamaño, float precio, String sistemaOperativo,
            String procesador) {

        if (!validarSerial(serial))
            throw new IllegalArgumentException("Serial inválido.");
        if (!validarTexto(marca))
            throw new IllegalArgumentException("Marca inválida.");
        if (!validarSO(sistemaOperativo))
            throw new IllegalArgumentException("Sistema operativo inválido.");
        if (!validarProcesador(procesador))
            throw new IllegalArgumentException("Procesador inválido.");

        this.serial = serial;
        this.marca = marca;
        this.tamaño = tamaño;
        this.precio = precio;
        this.sistemaOperativo = sistemaOperativo;
        this.procesador = procesador;
    }

    public String getSerial() {
        return serial;
    }

    public String getMarca() {
        return marca;
    }

    public float getTamaño() {
        return tamaño;
    }

    public float getPrecio() {
        return precio;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setMarca(String marca) {
        if (validarTexto(marca))
            this.marca = marca;
    }

    public void setTamano(float tamano) {
        this.tamaño = tamano;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        if (validarSO(sistemaOperativo))
            this.sistemaOperativo = sistemaOperativo;
    }

    public void setProcesador(String procesador) {
        if (validarProcesador(procesador))
            this.procesador = procesador;
    }

    public static String seleccionarSistemaOperativo(Scanner sc) {
        int opcion;
        String resultado = "";

        do {
        System.out.println("Seleccione el sistema operativo:");
        System.out.println("1. Windows 7");
        System.out.println("2. Windows 10");
        System.out.println("3. Windows 11");
        System.out.print("Opción: ");
        opcion = sc.nextInt();
        sc.nextLine(); 

        switch (opcion) {
            case 1:
                resultado = "Windows 7";
                break;
            case 2:
                resultado = "Windows 10";
                break;
            case 3:
                resultado = "Windows 11";
                break;
            default:
                System.out.println("Opción inválida. Intente de nuevo.");
        }
    } while (resultado.equals(""));

    return resultado;
}
public static String seleccionarProcesador(Scanner sc) {
        int opcion;
        String resultado = "";
        do {
            System.out.println("Seleccione el procesador:");
            System.out.println("1. AMD Ryzen");
            System.out.println("2. Intel Core i5");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            switch (opcion) { 
                case 1:
                    resultado = "AMD Ryzen";
                    break;
                case 2:
                    resultado = "Intel Core i5";
                    break;
                default:
                    System.out.println("Opción inválida."); 
                    resultado = ""; 
            }
        } while (resultado.equals(""));

        return resultado;
    }

    private boolean validarSerial(String serial) {
        return serial.matches("[a-zA-Z0-9]+");
    }

    private boolean validarTexto(String texto) {
        return texto.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+");
    }

    private boolean validarSO(String so) {
        return so.equals("Windows 7") || so.equals("Windows 10") || so.equals("Windows 11");
    }

    private boolean validarProcesador(String proc) {
        return proc.equals("AMD Ryzen") || proc.equals("Intel Core i5");
    }

    @Override
    public String toString() {
        return "Computador Portátil [Serial=" + serial + ", Marca=" + marca + ", Tamaño=" + tamaño +
                " pulgadas, Precio=$" + precio + ", SO=" + sistemaOperativo + ", Procesador=" + procesador + "]";
    }
}
