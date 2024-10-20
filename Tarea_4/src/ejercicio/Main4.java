package ejercicio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


/**
 * La clase Main4 es una aplicación que permite almacenar los datos de 5 alumnos en un fichero.
 * Cada alumno tiene un conjunto de atributos como nombre, apellidos, género, fecha de nacimiento, etc.,
 * que se recogen mediante la entrada del usuario y se guardan en un fichero utilizando serialización de objetos.
 */
public class Main4 {

    /**
     * Método principal que solicita datos de 5 alumnos y los guarda en un fichero.
     * Los datos de cada alumno incluyen NIA, nombre, apellidos, género, fecha de nacimiento, ciclo, curso y grupo.
     * Estos datos se guardan en un archivo binario utilizando un flujo de salida de objetos.
     */
    public static void main(String[] args) {
        
        // Declaración de variables para almacenar los datos del alumno
        String fichero = null;
        String nombre, apellido1, apellido2, ciclo, grupo, curso, fecha;
        char genero;
        int nia;
        Date fecha_nac = null;
        Scanner sc = new Scanner(System.in);

        try {
            // Solicita el nombre del fichero donde se guardarán los datos
            System.out.println("Nombre del fichero donde quieres guardar los datos");
            fichero = sc.nextLine();

            // Crea el archivo y prepara los flujos de salida para guardar los objetos
            File f = new File(fichero);
            FileOutputStream fSalida = new FileOutputStream(f);
            ObjectOutputStream escrObjetos = new ObjectOutputStream(fSalida);

            // Bucle para capturar los datos de 5 alumnos
            for (int i = 0; i < 5; i++) {
                
                // Solicita el NIA del alumno
                System.out.println("Nia");
                nia = sc.nextInt();
                
                // Solicita el nombre del alumno
                System.out.println("Nombre");
                nombre = sc.next();

                // Solicita el primer apellido del alumno
                System.out.println("1 Apellido");
                apellido1 = sc.next();

                // Solicita el segundo apellido del alumno
                System.out.println("2 Apellido");
                apellido2 = sc.next();

                // Solicita el género del alumno (H o G)
                System.out.println("Genero (H o G)");
                genero = sc.next().charAt(0);

                // Solicita la fecha de nacimiento y la convierte a formato Date
                System.out.println("Fecha de nacimiento");
                fecha = sc.next();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    fecha_nac = sdf.parse(fecha);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                // Solicita el ciclo del alumno
                System.out.println("Ciclo");
                ciclo = sc.next();

                // Solicita el curso del alumno
                System.out.println("Curso");
                curso = sc.next();

                // Solicita el grupo del alumno
                System.out.println("Grupo");
                grupo = sc.next();
                
                // Crea un objeto Alumno con los datos capturados (debes implementar la clase Alumno)
                Alumno alumno = new Alumno(nia, nombre, apellido1, apellido2, genero, fecha_nac, ciclo, curso, grupo);

                // Escribe los datos del alumno en el archivo
                escrObjetos.writeInt(nia);
                escrObjetos.writeUTF(nombre);
                escrObjetos.writeUTF(apellido1);
                escrObjetos.writeUTF(apellido2);
                escrObjetos.writeChar(genero);
                escrObjetos.writeUTF(fecha);
                escrObjetos.writeUTF(ciclo);
                escrObjetos.writeUTF(curso);
                escrObjetos.writeUTF(grupo);
            }

            // Cierra los flujos de salida y el escáner
            escrObjetos.close();
            sc.close();

        } catch (IOException e) {
            // Maneja las excepciones de entrada/salida
            e.printStackTrace();
        }
    }
}

