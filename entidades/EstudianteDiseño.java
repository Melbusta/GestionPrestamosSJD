package entidades;
public class EstudianteDiseño {
 
    private String cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private String modalidadEstudio;
    private int cantidadAsignaturas;
    private int serial;
    public EstudianteDiseño(String cedula, String nombre, String apellido, String telefono, String modalidadEstudio,
            int cantidadAsignaturas, int serial) {

                if (!validarCedula(cedula)) throw new IllegalArgumentException("Cédula inválida.");
                if (!validarTexto(nombre)) throw new IllegalArgumentException("Nombre inválido.");
                if (!validarTexto(apellido)) throw new IllegalArgumentException("Apellido inválido.");
                if (!validarTelefono(telefono)) throw new IllegalArgumentException("Teléfono inválido.");
                if (!validarModalidad(modalidadEstudio)) throw new IllegalArgumentException("Modalidad inválida. Debe ser 'virtual' o 'presencial'.");
        
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.modalidadEstudio = modalidadEstudio.toLowerCase();
        this.cantidadAsignaturas = cantidadAsignaturas;
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
    public String getModalidadEstudio() {
        return modalidadEstudio;
    }
    public int getCantidadAsignaturas() {
        return cantidadAsignaturas;
    }
    public int getSerial() {
        return serial;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setModalidadEstudio(String modalidadEstudio) {
        this.modalidadEstudio = modalidadEstudio;
    }
    public void setCantidadAsignaturas(int cantidadAsignaturas) {
        this.cantidadAsignaturas = cantidadAsignaturas;
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

    private boolean validarModalidad(String modalidad) {
        String mod = modalidad.toLowerCase();
        return mod.equals("virtual") || mod.equals("presencial");
    }
}