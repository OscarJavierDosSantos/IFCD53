package gestion.modelo;
/**
 * Clase que representa a un alumno.
 * Almacena sus datos personales y académicos.
 *
 * @author Estudiante
 * @version 1.0
 */
public class Alumno {
	// Atributos de diferentes tipos de datos
    private int id;
    private String nombre;
    private double nota1;
    private double nota2;
    private boolean matriculado;

    // Constructor vacío
    public Alumno() {}

    // Constructor con parámetros
    public Alumno(int id,String nombre,double nota1,double nota2,boolean matriculado) 
    {
        this.id = id;
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.matriculado = matriculado;
    }

    // GETTERS Y SETTERS

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    
    public double getNota1() {return nota1;}
    public void setNota1(double nota1) {this.nota1 = nota1;}

    public double getNota2() {return nota2;}
    public void setNota2(double nota2) {this.nota2 = nota2;}

    public boolean isMatriculado() {return matriculado;}
    public void setMatriculado(boolean matriculado) {this.matriculado = matriculado;}

    /**
     * Calcula la media de las dos notas.
     *
     * @return Nota media del alumno.
     */
    public double calcularMedia() {
        return (nota1 + nota2) / 2;
    }

    /**
     * Comprueba si el alumno ha aprobado.
     *
     * @return true si la nota media es igual o superior a 5.
     */
    public boolean estaAprobado() {
        return calcularMedia() >= 5;
    }

    // Muestra los datos del alumno
    public void mostrarDatos() {

        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Nota 1: " + nota1);
        System.out.println("Nota 2: " + nota2);
        System.out.println("Matriculado: " + matriculado);
        System.out.println("Media: " + calcularMedia());

        // Estructura condicional
        if (estaAprobado()) {
            System.out.println("Resultado: APROBADO");
        } else {
            System.out.println("Resultado: SUSPENDIDO");
        }

        System.out.println("-----------------------");
    }
}
