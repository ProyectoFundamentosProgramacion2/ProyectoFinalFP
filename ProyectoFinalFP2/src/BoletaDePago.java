import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

    public class BoletaDePago {
        private static List<Empleado> empleados = new ArrayList<>();

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int opcion = 0;

            do {
                System.out.println("\nMenu de Opciones:");
                System.out.println("1. Registrar trabajador");
                System.out.println("2. Listar trabajadores");
                System.out.println("3. Generar boleta de pago");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opcion: ");
                try {
                    opcion = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea

                    switch (opcion) {
                        case 1:
                            registrarTrabajador(scanner);
                            break;
                        case 2:
                            listarTrabajadores();
                            break;
                        case 3:
                            generarBoletaDePago(scanner);
                            break;
                        case 4:
                            System.out.println("Saliendo del programa...");
                            break;
                        default:
                            System.out.println("Opcion no valida. Intente de nuevo.");
                    }
                }catch (InputMismatchException e){
                    System.out.println("Entrada no valida. Por favor, ingrese un número.");
                    scanner.nextLine(); // Consumir la entrada no válida
                }
            } while (opcion != 4);
        }

        private static void registrarTrabajador(Scanner scanner) {
                System.out.print("Codigo de empleado: ");
                String codigo = scanner.nextLine();
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Apellidos: ");
                String apellidos = scanner.nextLine();
                System.out.print("Puesto: ");
                String puesto = scanner.nextLine();
                System.out.print("Sueldo: ");
                double sueldo = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("DNI: ");
                String dni = scanner.nextLine();
                System.out.print("Area de trabajo: ");
                String area = scanner.nextLine();

                Empleado empleado = new Empleado(codigo, nombre, apellidos, puesto, sueldo, dni, area);
                empleados.add(empleado);

                System.out.println("Empleado registrado exitosamente.");
        }

        private static void listarTrabajadores() {
            if (empleados.isEmpty()) {
                System.out.println("No hay trabajadores registrados.");
                return;
            }

            System.out.println("\nLista de Trabajadores:");
            for (Empleado empleado : empleados) {
                System.out.println("Nombre: " + empleado.getNombre() + " " + empleado.getApellidos() + ", DNI: " + empleado.getDni());
            }
        }

        private static void generarBoletaDePago(Scanner scanner) {
            if (empleados.isEmpty()) {
                System.out.println("No hay trabajadores registrados.");
                return;
            }

            System.out.print("Ingrese el DNI del trabajador: ");
            String dni = scanner.nextLine();

            Empleado empleado = null;
            for (Empleado e : empleados) {
                if (e.getDni().equals(dni)) {
                    empleado = e;
                    break;
                }
            }

            if (empleado == null) {
                System.out.println("Trabajador no encontrado.");
                return;
            }

            Aporte aporte = new Aporte(empleado.getCodigoEmpleado(), empleado.getNombre(), empleado.getApellidos(), empleado.getPuesto(), empleado.getSueldo(), empleado.getDni(), empleado.getAreaDeTrabajo());
            Provisiones provisiones = new Provisiones(empleado.getCodigoEmpleado(), empleado.getNombre(), empleado.getApellidos(), empleado.getPuesto(), empleado.getSueldo(), empleado.getDni(), empleado.getAreaDeTrabajo());

            double esSalud = aporte.calcularAporteEsSalud();
            double sctr = aporte.calcularAporteSctr();
            double senati = aporte.calcularAporteSenati();

            double gratificacion = provisiones.calcularGratificacion();
            double cts = provisiones.calcularCts();
            double vacaciones = provisiones.calcularVacaciones();

            double totalCargas = esSalud + sctr + senati + gratificacion + cts + vacaciones;

            System.out.println("\nBoleta de Pago:");
            System.out.println("Empleado: " + empleado.getNombre() + " " + empleado.getApellidos());
            System.out.println("Puesto: " + empleado.getPuesto());
            System.out.println("Sueldo: " + empleado.getSueldo());
            System.out.println("Aporte EsSalud: " + esSalud);
            System.out.println("Aporte SCTR: " + sctr);
            System.out.println("Aporte SENATI: " + senati);
            System.out.println("Provisión Gratificaciones: " + gratificacion);
            System.out.println("Provisión CTS: " + cts);
            System.out.println("Provisión Vacaciones: " + vacaciones);
            System.out.println("Total Cargas Sociales: " + totalCargas);
        }
    }
