
package Gestion;

import java.util.ArrayList;

public class Calificaciones {

    private static double[] notasIniciales = {8.5, 7.0, 9.2, 6.5, 10.0, 5.5, 8.0};

    private static ArrayList<Double> notas =
            new ArrayList<>();

    // Transferir datos del array al ArrayList
    public static void cargarNotas() 
    {
        for (double nota : notasIniciales) {
            notas.add(nota);
        }
    }

    // Mostrar todas las calificaciones
    public static void mostrarNotas() 
    {
        System.out.println("Calificaciones:\n");

        for (int i = 0; i < notas.size(); i++) {
            System.out.println("Alumno "+(i+1)+" :"+notas.get(i));
        }
    }

    // Calcular la suma mediante recursividad
    public static double sumarRecursivo(int posicion) {

        // Caso base
        if (posicion == notas.size()) 
        {
            return 0;
        }

        // Caso recursivo
        return notas.get(posicion)+ sumarRecursivo(posicion + 1);
    }

    // Calcular la nota mas alta
    public static double notaMaxima() {
        double max = notas.get(0);

        for (double nota : notas) {
            if (nota > max) 
            {
                max = nota;
            }
        }

        return max;
    }

    // Calcular la nota mas baja
    public static double notaMinima() {
        double min = notas.get(0);

        for (double nota : notas) {
            if (nota < min) 
            {
                min = nota;
            }
        }

        return min;
    }
    

    public static void main(String[] args) {

        cargarNotas();

        mostrarNotas();

        double suma = sumarRecursivo(0);
        double promedio = suma / notas.size();

        System.out.println("\nSuma total: " + suma);
        System.out.println("Promedio: " + Math.round(promedio * 100.0) / 100.0);
        System.out.println("Nota maxima: " + notaMaxima());
        System.out.println("Nota minima: " + notaMinima());
    }
}
