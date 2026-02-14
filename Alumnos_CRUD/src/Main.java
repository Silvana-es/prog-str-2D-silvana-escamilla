import java.util.Scanner;

public class Main {

    static Alumno[] alumnos = new Alumno[25];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n---- MENU ----");
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
                    altaAlumno();
                break;
                case 2:
                    buscarAlumno();
                break;
                case 3:
                    actualizarPromedio();
                break;
                case 4:
                    bajaLogica();
                break;
                case 5:
                    listarActivos();
                break;
                case 6:
                    reportes();
                break;
                case 0:
                    System.out.println("Saliendo del Programa");
                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 0);
    }

    // ALTA
    public static void altaAlumno() {

        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (id <= 0) {
            System.out.println("ID invalido");
            return;
        }

        if (buscarPorIdInterno(id) != -1) {
            System.out.println("ID repetido");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        if (nombre.isEmpty()) {
            System.out.println("Nombre vacio");
            return;
        }

        System.out.print("Promedio del 0-10: ");
        double promedio = sc.nextDouble();

        if (promedio < 0 || promedio > 10) {
            System.out.println("Promedio invalido");
            return;
        }

        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] == null) {
                alumnos[i] = new Alumno(id, nombre, promedio);
                System.out.println("Alumno agregado");
                return;
            }
        }

        System.out.println("Arreglo lleno el limite era de 25 alumnos");
    }

    // BUSCAR
    public static void buscarAlumno() {

        System.out.print("ID a buscar: ");
        int id = sc.nextInt();

        int posicion = buscarPorIdInterno(id);

        if (posicion != -1 && alumnos[posicion].activo) {
            System.out.println("ID: " + alumnos[posicion].id);
            System.out.println("Nombre: " + alumnos[posicion].nombre);
            System.out.println("Promedio: " + alumnos[posicion].promedio);
        } else {
            System.out.println("Alumno no encontrado o inactivo");
        }
    }

    // ACTUALIZAR
    public static void actualizarPromedio() {

        System.out.print("ID: ");
        int id = sc.nextInt();

        int posicion = buscarPorIdInterno(id);

        if (posicion != -1 && alumnos[posicion].activo) {

            System.out.print("Nuevo promedio del 0-10: ");
            double nuevo = sc.nextDouble();

            if (nuevo >= 0 && nuevo <= 10) {
                alumnos[posicion].promedio = nuevo;
                System.out.println("Promedio actualizado");
            } else {
                System.out.println("Promedio invalido");
            }

        } else {
            System.out.println("Alumno no encontrado o inactivo");
        }
    }

    // BAJA LOGICA
    public static void bajaLogica() {

        System.out.print("ID: ");
        int id = sc.nextInt();

        int posicion = buscarPorIdInterno(id);

        if (posicion != -1 && alumnos[posicion].activo) {
            alumnos[posicion].activo = false;
            System.out.println("Alumno dado de baja");
        } else {
            System.out.println("Alumno no encontrado");
        }
    }

    // LISTAR
    public static void listarActivos() {

        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].activo) {
                System.out.println("ID: " + alumnos[i].id + " Nombre: " + alumnos[i].nombre + " Promedio: " + alumnos[i].promedio);
            }
        }
    }

    // REPORTES
    public static void reportes() {

        double suma = 0;
        int contador = 0;
        Alumno mayor = null;
        Alumno menor = null;
        int mayores = 0;

        for (int i = 0; i < alumnos.length; i++) {

            if (alumnos[i] != null && alumnos[i].activo) {

                suma += alumnos[i].promedio;
                contador++;

                if (mayor == null || alumnos[i].promedio > mayor.promedio) {
                    mayor = alumnos[i];
                }

                if (menor == null || alumnos[i].promedio < menor.promedio) {
                    menor = alumnos[i];
                }

                if (alumnos[i].promedio >= 8.0) {
                    mayores++;
                }
            }
        }

        if (contador == 0) {
            System.out.println("No hay alumnos activos");
            return;
        }
        double promedioGeneral ;
             promedioGeneral = suma / contador;

        System.out.println("Promedio general: " + promedioGeneral);

        System.out.println("Mayor promedio:");
        System.out.println("ID: " + mayor.id + " Nombre: " + mayor.nombre + " Promedio: " + mayor.promedio);

        System.out.println("Menor promedio:");
        System.out.println("ID: " + menor.id + " Nombre: " + menor.nombre + " Promedio: " + menor.promedio);

        System.out.println("Alumnos con promedio >= 8: " + mayores);
    }

    // BUSQUEDA INTERNA
    public static int buscarPorIdInterno(int id) {

        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].id == id) {
                return i;
            }
        }

        return id;
    }
}