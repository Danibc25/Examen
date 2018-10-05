package dir;

import java.io.File;
import java.io.FileNotFoundException;

public class Principal {

	public static void main(String[] args) throws FileNotFoundException {
		
		localizar();

	}
	
	
	public static void localizar(){
		
		
		File libr = new File("/Users/danielbc/Desktop/Examen/Directorios-master/dir1/");
		File libr2 = new File("/Users/danielbc/Desktop/Examen/Directorios-master/dir2/");
		
		String[] ficheros = libr.list();
		System.out.println(ficheros[0]);
	
	
	}
	
	public static void comparar(){
		
	}

}
