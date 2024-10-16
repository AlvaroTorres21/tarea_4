package ejercicio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Main4 {

	public static void main(String[] args) {
		
		String fichero = null;
		String nombre, apellido1, apellido2, ciclo, grupo, curso, fecha;
		char genero;
		int nia;
		Date fecha_nac = null;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Nombre del fichero donde quieres guardar los datos");
			fichero = sc.nextLine();

			File f = new File(fichero);
			FileOutputStream fSalida = new FileOutputStream(f);
			ObjectOutputStream escrObjetos = new ObjectOutputStream(fSalida);

			// for para rellenar los alumnos
			for (int i = 0; i < 5; i++) {

				System.out.println("Nia");
				nia = sc.nextInt();
	

				System.out.println("Nombre");
				nombre = sc.next();

				System.out.println("1 Apellido");
				apellido1 = sc.next();

				System.out.println("2 Apellido");
				apellido2 = sc.next();

				System.out.println("Genero (H o G)");
				genero = sc.next().charAt(0);

				System.out.println("Fecha de nacimiento");
				fecha = sc.next();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				try {
					fecha_nac = sdf.parse(fecha);
				} catch (ParseException e) {
					e.printStackTrace();
				}

				System.out.println("Ciclo");
				ciclo = sc.next();

				System.out.println("Curso");
				curso = sc.next();

				System.out.println("Grupo");
				grupo = sc.next();
				
				Alumno alumno=new Alumno(nia, nombre, apellido1, apellido2, genero, fecha_nac, ciclo, curso, grupo);

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
			
			escrObjetos.close();
			sc.close();

	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
