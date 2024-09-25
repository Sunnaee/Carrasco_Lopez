# Taller Lab02 - Métodos, Pruebas Unitarias y Gestión de Excepciones
Integrantes: Martín Carrasco (github: martingci) - Sabrina López (github: Sunnaee)
***
## Caso a desarrollar.

Se le pide arreglar un programa que registra los datos de un máximo de 50 personas.
Los datos que se almacenan son el nombre de la persona, estado civil y la edad (en ese orden).
Recuerde que no debe sobreescribir a las personas.

El menú debe mostrar las siguientes opciones:
1) Agregar persona.
2) Mostrar la cantidad de personas mayores de edad.
3) Mostrar la cantidad de personas menores de edad.
4) Mostrar la cantidad de personas de tercera edad.
5) Mostrar la cantidad de personas según estado civil (Solter@ o casad@)
6) Salir.

Errores del código original:
- Variables, estructuras de control y métodos se encuentran en _public static void main_, todo esto debería estar en métodos fuera de _main_.
- Registro es una matriz que inicia como _String_ y luego se inicia de tipo _double_, lo cual provoca que no se puedan escribir los valores que se piden en todo el código. Debería ser _Object_ para admitir _String_ e _int_.
- Variables y métodos con nombres poco descriptivos (como _mmmm_ o _opa()_) y mal formato de escritura (sin camelCase).
- Condiciones que son siempre verdaderas como (a > 0 || a < 6).
- El método _obtenerUltimoEspacio(...)_ es redundante porque el método _opa(...)_ puede hacer la misma funcionalidad con cambiar la lógica del _return_.
- La funcionalidad de mostrar la cantidad de personas de tercera edad es redundante, ya que no es necesario comprobar el estado civil de la persona.

## Tareas:
- Martín: Operaciones 4, 5 y menú.
- Sabrina: Operaciones 1, 2 y 3.
