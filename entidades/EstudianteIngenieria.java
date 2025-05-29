package entidades;
public class EstudianteIngenieria {
    private String cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private int numeroSemestre;
    private float promedioAcumulado;
    private String serial;

    public EstudianteIngenieria() {
    }

    public EstudianteIngenieria(String cedula, String nombre, String apellido, String telefono, int numeroSemestre,
            float promedioAcumulado, String serial) {

        if (!validarCedula(cedula)) throw new IllegalArgumentException("Cédula inválida.");
        if (!validarTexto(nombre)) throw new IllegalArgumentException("Nombre inválido.");
        if (!validarTexto(apellido)) throw new IllegalArgumentException("Apellido inválido.");
        if (!validarTelefono(telefono)) throw new IllegalArgumentException("Teléfono inválido.");
        if (!validarSerial(serial)) throw new IllegalArgumentException("Serial inválido.");

        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.numeroSemestre = numeroSemestre;
        this.promedioAcumulado = promedioAcumulado;
        this.serial = serial;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getNumeroSemestre() {
        return numeroSemestre;
    }

    public float getPromedioAcumulado() {
        return promedioAcumulado;
    }

    public String getSerial() {
        return serial;
    }

    public void setNombre(String nombre) {
        if (validarTexto(nombre)) this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        if (validarTexto(apellido)) this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        if (validarTelefono(telefono)) this.telefono = telefono;
    }

    public void setNumeroSemestre(int numeroSemestre) {
        this.numeroSemestre = numeroSemestre;
    }

    public void setPromedioAcumulado(float promedioAcumulado) {
        this.promedioAcumulado = promedioAcumulado;
    }
    
    private boolean validarCedula(String cedula) {
        return cedula.matches("\\d+"); 
    }

    private boolean validarTexto(String texto) {
        return texto.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+");
    }

    private boolean validarTelefono(String telefono) {
        return telefono.matches("\\d+"); 
    }

    private boolean validarSerial(String serial) {
        return serial.matches("[a-zA-Z0-9]+");
    }
}
