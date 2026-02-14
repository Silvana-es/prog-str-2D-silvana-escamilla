import java.util.Scanner;

public class Main {

    static Alumno[] alumnos = new Alumno[25];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("MENU");
            System.out.println("1) Alta alumno");
            System.out.println("2) Buscar por ID");
            System.out.println("3) Actualizar promedio");
            System.out.println("4) Baja logica");
            System.out.println("5) Listar activos");
            System.out.println("6) Reportes");
            System.out.println("0) Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    alta();
                break;
                case 2:
                    buscar();
                break;
                case 3:
                    actualizar();
                break;
                case 4:
                    baja();
                break;
                case 5:
                    listar();
                break;
                case 6:
                    reporte();
                break;
                case 0:
                    System.out.println("Saliendo del Programa");
                break;
                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 0);
    }
    public static void alta() {

        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (id <= 0) {
            System.out.println("ID invalido");
            return;
        }

        if (buscarIDexis(id)) {
            System.out.println("ID repetido");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        if (nombre.trim().isEmpty()) {
            System.out.println("Nombre vacio");
            return;
        }

        System.out.print("Promedio ingresa un numero dentro de este rango del 0 al 10: ");
        double promedio = sc.nextDouble();
        sc.nextLine();

        if (promedio < 0 || promedio > 10) {
            System.out.println("Promedio invalido");
            return;
        }

        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] == null) {
                alumnos[i] = new Alumno(id, nombre, promedio);
                System.out.println("Alumno registrado");
                return;
            }
        }

        System.out.println("Arreglo lleno el limite de alumnos es de 25");


    }

    // VALIDAR ID
    public static boolean buscarIDexis(int id) {
        for (Alumno alumno : alumnos) {
            if (alumno != null && alumno.id == id) {
                return true;
            }
        }
        return false;
    }

    // BUSCAR
    public static void buscar() {
        System.out.print("ID a buscar: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Alumno alumno : alumnos) {
            if (alumno != null && alumno.id == id && alumno.activo) {
                System.out.println("ID: " + alumno.id);
                System.out.println("Nombre: " + alumno.nombre);
                System.out.println("Promedio: " + alumno.promedio);
                return;
            }
        }

        System.out.println("No encontrado o inactivo");
    }

    // ACTUALIZAR PROMEDIO
    public static void actualizar() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Alumno alumno : alumnos) {
            if (alumno != null && alumno.id == id && alumno.activo) {

                System.out.print("Nuevo promedio, ingresa un numero dentro de este rango del 0 al 10: ");
                double nuevo = sc.nextDouble();
                sc.nextLine();

                if (nuevo < 0 || nuevo > 10) {
                    System.out.println("Promedio invalido");
                    return;
                }

                alumno.promedio = nuevo;
                System.out.println("Promedio actualizado");
                return;
            }
        }

        System.out.println("No encontrado o inactivo");
    }

    // BAJA LOGICA
    public static void baja() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Alumno alumno : alumnos) {
            if (alumno != null && alumno.id == id && alumno.activo) {
                alumno.activo = false;
                System.out.println("Alumno dado de baja");
                return;
            }
        }

        System.out.println("No encontrado");
    }

    // LISTAR ACTIVOS
    public static void listar() {
        for (Alumno alumno : alumnos) {
            if (alumno != null && alumno.activo) {
                System.out.println(alumno.id + " - " + alumno.nombre + " - " + alumno.promedio);
            }
        }
    }

    // REPORTE
    public static void reporte() {
        double suma = 0;
        int contador = 0;
        int mayores = 0;
        Alumno mayor = null;
        Alumno menor = null;

        for (Alumno alumno : alumnos) {
            if (alumno != null && alumno.activo) {
                suma += alumno.promedio;
                contador++;
                if (mayor == null || alumno.promedio > mayor.promedio) {
                    mayor = alumno;
                }
                if (menor == null || alumno.promedio < menor.promedio) {
                    menor = alumno;
                }
                if (alumno.promedio >= 8.0) {
                    mayores++;
                }
            }
        }
        if (contador == 0) {
            System.out.println("No hay alumnos activos");
            return;
        }
        double promedioGeneral = suma / contador;
        System.out.println("Promedio general: " + promedioGeneral);
        System.out.println("Alumno con Mayor promedio:");
        System.out.println(mayor.id + " - " + mayor.nombre + " - " + mayor.promedio);
        System.out.println("Alumno con Menor promedio:");
        System.out.println(menor.id + " - " + menor.nombre + " - " + menor.promedio);
        System.out.println("Cantidad de alumnos con promedio a 8: " + mayores);
    }

}