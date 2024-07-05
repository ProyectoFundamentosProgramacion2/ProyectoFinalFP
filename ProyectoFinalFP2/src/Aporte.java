public class Aporte extends Empleado {
    private final double esSalud = 9.00;
    private final double sctr = 0.53;
    private final double senati = 0.75;

    private final boolean sacoPrestamo = false;

    public Aporte(String codigoEmpleado, String nombre, String apellidos, String puesto, double sueldo, String dni, String areaDeTrabajo) {
        super(codigoEmpleado, nombre, apellidos, puesto, sueldo, dni, areaDeTrabajo);
    }

    public double calcularAporteEsSalud() {
        return getSueldo() * esSalud / 100;
    }

    public double calcularAporteSctr() {
        return getSueldo() * sctr / 100;
    }

    public double calcularAporteSenati() {
        return getSueldo() * senati / 100;
    }


    @Override
    public double sueldoFinal(){
        double sueldo = super.sueldoFinal();
        if (sacoPrestamo) sueldo -= 100;
        return sueldo;
    }
}

