public class Provisiones extends Empleado {
    private final double gratificacion = 16.66;
    private final double cts = 9.72;
    private final double vacaciones = 8.33;

    public Provisiones(String codigoEmpleado, String nombre, String apellidos, String puesto, double sueldo, String dni, String areaDeTrabajo) {
        super(codigoEmpleado, nombre, apellidos, puesto, sueldo, dni, areaDeTrabajo);
    }

    public double calcularGratificacion() {
        return getSueldo() * gratificacion / 100;
    }

    public double calcularCts() {
        return getSueldo() * cts / 100;
    }

    public double calcularVacaciones() {
        return getSueldo() * vacaciones / 100;
    }
}
