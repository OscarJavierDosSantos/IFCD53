package gestion.principal;
import gestion.crud.AlumnoCrud;
import gestion.modelo.Alumno;

import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        AlumnoCrud crud = new AlumnoCrud();

        int opcion = 0;

        // Estructura repetitiva while
        while (opcion != 4) {

            System.out.println("\n===== GESTION DE ALUMNOS =====");
            System.out.println("1. Registrar alumno");
            System.out.println("2. Listar alumnos");
            System.out.println("3. Eliminar alumno");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opcion: ");

            try {
                opcion = Integer.parseInt(teclado.nextLine());

                switch (opcion) {

                    case 1:

                        System.out.print("Nombre: ");
                        String nombre = teclado.nextLine();

                        System.out.print("Primera nota: ");
                        double nota1 = Double.parseDouble(teclado.nextLine());

                        System.out.print("Segunda nota: ");
                        double nota2 = Double.parseDouble(teclado.nextLine());

                        System.out.print("Esta matriculado (true/false): ");
                        boolean matriculado = Boolean.parseBoolean(teclado.nextLine());

                        // Validar las notas
                        if (nota1 < 0 || nota1 > 10 || nota2 < 0 || nota2 > 10) 
                        {
                            System.out.println( "Las notas deben estar entre 0 y 10." );
                        } 
                        else
                        {
                            Alumno alumno = new Alumno(0, nombre, nota1, nota2, matriculado);
                            crud.insertar(alumno);
                        }
                        break;

                    case 2:

                        List<Alumno> alumnos = crud.listar();

                        System.out.println("\nLISTADO DE ALUMNOS");

                        // Estructura repetitiva for
                        for (Alumno alumno : alumnos) 
                        {
                            alumno.mostrarDatos();
                        }

                        if (alumnos.isEmpty()) 
                        {
                        	System.out.println("No hay alumnos registrados.");
                        }

                        break;

                    case 3:

                        System.out.print("Introduce el ID: ");

                        int id = Integer.parseInt(teclado.nextLine());
                        crud.eliminar(id);

                        break;

                    case 4:

                        System.out.println("Saliendo de la aplicacion...");

                        break;

                    default:

                        System.out.println("Opcion incorrecta.");
                }

            } 
            catch (NumberFormatException e) 
            {
                System.out.println("Error: debes introducir un numero valido.");

            } 
            catch (Exception e) 
            {
            	System.out.println("Error en la aplicacion: " + e.getMessage());
            }
        }
        teclado.close();
    }
}
