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

    //Función para verificar que hay espacio disponible en la matriz.
    public static boolean espacioDisponible(Object[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0] == null){
                return true;
            }
        }
        return false;
    }

    //Función para obtener cuál es la fila donde hay espacio para agregar a la persona, solo se llama si la función anterior devuelve true, esto se usará en el mini-menú para agregar personas.
    public static int obtenerFilaVacia(Object[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0] == null){
                return i;
            }
        }
        return 0;
    }

    //Función para verificar que la persona no se encuentre ya registrada.
    public static boolean personaUnica(Object[][] registro, String nombre){
        String nombreIngresado = nombre.replace(" ","").toLowerCase();
        for (int i = 0; i < registro.length; i++) {
            if (registro[i][0] != null) {
                String nombreBuscado = (String)registro[i][0];
                if (nombreBuscado.replace(" ","").toLowerCase().equals(nombreIngresado)) {
                    return false;
                }
            }
        }
        return true;
    }

    //Funciones para ingresar el estado civil de forma predeterminada dependiendo de una elección limitada.
    public static String transformarEstadoCivil(int opcion){
        String status = "";
        if (opcion == 1){
            status = "Soltero/a";
        } else if (opcion == 2){
            status = "Casado/a";
        }
        return status;
    }

    //Función para escribir los datos de las personas.
    public static Object[][] escribirDatos(Object[][] registro, String nombre, String estadoCivil, int edad, int fila){
        registro[fila][0] = nombre;
        registro[fila][1] = estadoCivil;
        registro[fila][2] = edad;
        return registro;
    }

    //Función de mini-menú para agregar personas y validar las condiciones necesarias para que se puedan agregar.
    public static void agregarPersonas(Object[][] registro, String nombre){
        if(espacioDisponible(registro)){
            if(personaUnica(registro,nombre)) {
                int fila = obtenerFilaVacia(registro);
                escribirDatos(registro, nombre, transformarEstadoCivil(leerOpcionLimitada("Ingrese el estado civil (1 = Soltero/a ; 2 = Casado/a): ", 1, 2)), pedirIntPositivo("Ingrese la edad: "), fila);
                System.out.println("Se ha registrado a la persona correctamente.");
            } else {
                System.out.println("La persona ya se encuentra registrada.");
            }
        } else {
            System.out.println("No queda espacio disponible para el registro.");
        }
    }

    //Función cant. personas mayores de edad.
    public static int cantidadMayoresDeEdad(Object[][] registro){
        int contador = 0;
        for (int i = 0; i < registro.length; i++) {
            if((registro[i][0] != null) && ((Integer) registro[i][2] >= 18)){
            contador++;
            }
        }
        return contador;
    }

    public static void mostrarMayoresDeEdad(Object[][] registro) {
        System.out.println("La cantidad de personas mayores de edad es: "+cantidadMayoresDeEdad(registro));
    }

    //Función cant. personas menores de edad.
    public static int cantidadMenoresDeEdad(Object[][] registro){
        int contador = 0;
        for (int i = 0; i < registro.length; i++) {
            if((registro[i][0] != null) && ((Integer) registro[i][2] < 18)){
                contador++;
            }
        }
        return contador;
    }

    public static void mostrarMenoresDeEdad(Object[][] registro) {
        System.out.println("La cantidad de personas menores de edad es: "+cantidadMenoresDeEdad(registro));
    }

    // Funciones para cantidad de adulto mayores

    public static int cantidadAdultoMayor (Object[][] registro) {
        int cantidadDeAdultosMayores = 0;
        for (Object[] objects : registro) { // primero chequea que no sea null, y despues cuenta.
            if (objects[2] != null) {
                if ((int) objects[2] >= 65) { // en el codigo original considera 60 y 65, nosotros vamos a considerar 65
                    cantidadDeAdultosMayores++;
                }
            }
        }
        return cantidadDeAdultosMayores;
    }

    public static void mostrarCantidadDeAdultoMayor (Object[][] registro) {
        System.out.println("La cantidad de adultos mayor es " + cantidadAdultoMayor(registro)); // imprime solamente la cantidad
    }

    public static int cantidadDeSolteros (Object[][] registro) {
        int cantidadDeSolteros = 0;
        for (Object[] objects : registro) {
            if (objects[2] != null) { // chequea que no sea null y cuenta
                if (objects[1].equals("Soltero/a")) {
                    cantidadDeSolteros++;
                }
            }
        }
        return cantidadDeSolteros;
    }

    // Funciones para cantidad de casados y solteros.

    public static int cantidadDeCasados (Object[][] registro) {
        int cantidadDeCasados = 0;
        for (Object[] objects : registro) {
            if (objects[2] != null) { //chequea que no sea null y cuenta
                if (objects[1].equals("Casado/a")) {
                    cantidadDeCasados++;
                }
            }
        }
        return cantidadDeCasados;
    }

    public static void mostrarCantidadDePersonasPorEstadoCivil(Object[][] registro) {
        System.out.println("La cantidad de solteros es de " + cantidadDeSolteros(registro) + " solteros.");
        System.out.println("La cantidad de casados es de " + cantidadDeCasados(registro) + " casados."); // muestra en pantalla los valores de solteros y casados
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
        if (opcion == 1) { //agregar
            String nombre = pedirString("Ingrese el nombre: ");
            agregarPersonas(matriz,nombre);
        } else if (opcion == 2) { //mayores de edad
            mostrarMayoresDeEdad(matriz);
        } else if (opcion == 3) { //menores de edad.
            mostrarMenoresDeEdad(matriz);
        } else if (opcion == 4) {
            mostrarCantidadDeAdultoMayor(matriz);
        } else if (opcion == 5) {
            mostrarCantidadDePersonasPorEstadoCivil(matriz);
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