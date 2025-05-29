package entidades;
import java.util.Scanner;

public class TabletaGrafica {
    
    private String serial;
    private String marca;
    private float tamaño;
    private float precio;
    private String almacenamiento;
    private float peso;
    public TabletaGrafica(String serial, String marca, float tamaño, float precio, String almacenamiento, float peso) {
        
        if (!validarSerial(serial)) throw new IllegalArgumentException("Serial inválido.");
        if (!validarTexto(marca)) throw new IllegalArgumentException("Marca inválida.");
        if (!validarAlmacenamiento(almacenamiento)) throw new IllegalArgumentException("Almacenamiento inválido.");
        
        this.serial = serial;
        this.marca = marca;
        this.tamaño = tamaño;
        this.precio = precio;
        this.almacenamiento = almacenamiento;
        this.peso = peso;
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
    public String getAlmacenamiento() {
        return almacenamiento;
    }
    public float getPeso() {
        return peso;
    }

    public void setMarca(String marca) {
        if (validarTexto(marca)) this.marca = marca;
    }

    public void setTamaño(float tamaño) {
        this.tamaño = tamaño;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setAlmacenamiento(String almacenamiento) {
        if (validarAlmacenamiento(almacenamiento)) this.almacenamiento = almacenamiento;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
    public static String seleccionarAlmacenamiento(Scanner sc) {
        int opcion;
        String resultado = "";
        do {
            System.out.println("Seleccione almacenamiento:");
            System.out.println("1. 256 GB");
            System.out.println("2. 512 GB");
            System.out.println("3. 1 TB");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    resultado = "256 GB";
                    break;
                case 2:
                    resultado = "512 GB";
                    break;
                case 3:
                    resultado = "1 TB";
                    break;
                default:
                    System.out.println("Opción inválida.");
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

    private boolean validarAlmacenamiento(String almacenamiento) {
        return almacenamiento.equals("256 GB") ||
                almacenamiento.equals("512 GB") ||
                almacenamiento.equals("1 TB");
    }

    @Override
    public String toString() {
        return "Tableta Gráfica [Serial=" + serial + ", Marca=" + marca + ", Tamaño=" + tamaño +
                " pulgadas, Precio=$" + precio + ", Almacenamiento=" + almacenamiento + ", Peso=" + peso + " kg]";
    }
}