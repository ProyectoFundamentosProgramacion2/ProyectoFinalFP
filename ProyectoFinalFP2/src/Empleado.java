public class Empleado {
    private String codigoEmpleado;
    private String nombre;
    private String apellidos;
    private String puesto;
    private double sueldo;
    private String dni;
    private String areaDeTrabajo;

    public Empleado(String codigoEmpleado, String nombre, String apellidos, String puesto, double sueldo, String dni, String areaDeTrabajo) {
        this.codigoEmpleado = codigoEmpleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.puesto = puesto;
        this.sueldo = sueldo;
        this.dni = dni;
        this.areaDeTrabajo = areaDeTrabajo;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getAreaDeTrabajo() {
        return areaDeTrabajo;
    }

    public void setAreaDeTrabajo(String areaDeTrabajo) {
        this.areaDeTrabajo = areaDeTrabajo;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "codigoEmpleado='" + codigoEmpleado + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", puesto='" + puesto + '\'' +
                ", sueldo=" + sueldo +
                ", dni='" + dni + '\'' +
                ", areaDeTrabajo='" + areaDeTrabajo + '\'' +
                '}';
    }
}
