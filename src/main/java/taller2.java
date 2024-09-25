import java.util.Scanner;

public class taller2 {
    public static void main(String[] args) {
        iniciar();
    }
    public static Scanner scanner() {
        return new Scanner(System.in);
    }

    public static Object [][] crearMatriz () {
        return new Object[50][3];
    }

    public static int pedirInt(String mensaje){
        int valor;
        while (true) {
            try {
                System.out.print(mensaje);
                valor = scanner().nextInt();
                break;
            } catch(Exception InputMismatchException) {
                System.out.print("Entrada no válida. Ingrese un número: ");
            }
        }
        return valor;
    }

    public static int pedirIntPositivo(String mensaje) {
        while (true) {
            int numero = pedirInt(mensaje);
            if (numero < 0) {
                System.out.println("Ingrese un número positivo.");
            } else {
                return numero;
            }
        }
    }

    public static String pedirString(String mensaje){
        System.out.print(mensaje);
        String string;
        while (true){
            string = scanner().nextLine();
            if (string.isEmpty()){
                System.out.print("Por favor ingrese una entrada no vacía: ");
            }else{
                break;
            }
        }
        return string;
    }

    //Función imprimir opciones del menú.
    public static void mostrarOpciones(){
        System.out.println("\nMenú:");
        System.out.println("1) Agregar persona.");
        System.out.println("2) Mostrar la cantidad de personas mayores de edad.");
        System.out.println("3) Mostrar la cantidad de personas menores de edad.");
        System.out.println("4) Mostrar la cantidad de personas de tercera edad");
        System.out.println("5) Mostrar la cantidad de personas según estado civil (soltero/a - casado/a).");
        System.out.println("6) Salir.");
    }

    //Función de ejecutar las opciones del menú.
    public static void ejecutarOpciones(Object[][] matriz, int opcion){
        if (opcion == 1) {
        } else if (opcion == 2) {
        } else if (opcion == 3) {
        } else if (opcion == 4) {
        } else if (opcion == 5) {
        } else if (opcion == 6) {
            System.out.println("Saliendo del menú...");
        }
    }

    //Función menú.
    public static void menu(Object[][] matriz){

        while(true){
            mostrarOpciones();
            int opcion = leerOpcionLimitada("Ingrese el número de la opción que desea seleccionar: ",1,6);
            ejecutarOpciones(matriz, opcion);
            if (opcion == 6) {
                break;
            }
        }
        scanner().close();
    }

    public static int leerOpcionLimitada(String mensaje, int min, int max){
        System.out.print(mensaje);
        int opcion;
        while (true) {
            try {
                opcion = scanner().nextInt();
                if ((opcion >= min) && (opcion <= max)) {
                    break;
                } else {
                    System.out.print("Opción sale del rango. Inténtelo nuevamente: ");
                }
            } catch(Exception InputMismatchException){
                System.out.print("Entrada no válida. Ingrese un número: ");
            }
        }
        return opcion;
    }

    public static void iniciar () {
        menu(crearMatriz());
    }



}
