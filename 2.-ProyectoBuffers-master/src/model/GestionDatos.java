package model;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GestionDatos {

	public GestionDatos() {

	}

	//TODO: Implementa una funci�n para abrir ficheros
	public FileReader abrirFichero(String fichero1) {
		FileReader f1 = null;
		try {
			f1 = new FileReader("/Users/danielbc/Desktop/Examen/2.-ProyectoBuffers-master/"+fichero1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f1;
	}

	public void cerrarFichero(FileReader f1) {
		
		try {
			f1.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean compararContenido (String fichero1, String fichero2) throws IOException{
		//TODO: Implementa la funci�n
		
			boolean iguales= false;
		
			
			
			abrirFichero(fichero1);
			abrirFichero(fichero2);
			
			FileReader f1 = abrirFichero(fichero1);
			FileReader f2 = abrirFichero(fichero2);
			
			BufferedReader br1 = new BufferedReader(f1);
			BufferedReader br2 = new BufferedReader(f2);
			
			
			String str="";
			String str2="";
			
			while((str=br1.readLine()) != null && (str2=br2.readLine()) != null ){
				
				if(str.compareTo(str2) == 0){
					
					iguales=true;
					
					
				} else {
					
					iguales=false;

				}
				
				

			}
			
			
			
			
		
		
		return iguales;
	}
	
	public int buscarPalabra (String fichero1, String palabra, boolean primera_aparicion) throws IOException{
		//TODO: Implementa la funci�n
		
		File fl1 = new File("/Users/danielbc/Desktop/Examen/2.-ProyectoBuffers-master/" + fichero1);
		
		FileReader f1 = new FileReader(fl1);
		
		BufferedReader br3 = new BufferedReader(f1);
		
		
		int aparicionPrimera = 0;
		int aparicionFinal = 0;
		String srt="";
		int linea=0;
		
		while((srt=br3.readLine())!= null) {
			
			linea++;
			
			if((srt.compareTo(palabra)==0) && (aparicionPrimera==0)) {
				
				aparicionPrimera=linea;
				aparicionFinal=linea;
				
			}else if(srt.compareTo(palabra)==0){
					
					aparicionFinal=linea;
					
				}
			}
		
		if(primera_aparicion==true) {
			return aparicionPrimera;
			
		}else {
			return aparicionFinal;
		}
		
	}

	public void crear_libro(Libro L1) throws FileNotFoundException, IOException {
		
	System.out.println("recibo "+L1.ID);
		
		
			ObjectOutputStream out = null;
		
			out = new ObjectOutputStream(new FileOutputStream("/Users/danielbc/Desktop/Examen/2.-ProyectoBuffers-master/libreria/" + L1.ID + ".dat"));
			out.writeObject(L1);
			
			
	
			intentarCerrar(out);
		}
		
	public Libro recuperar_libro(String f) throws FileNotFoundException, IOException, ClassNotFoundException  {
		Libro Lib = null;
        
		ObjectInputStream in=null;
        
       
            in = new ObjectInputStream(new FileInputStream("/Users/danielbc/Desktop/Examen/2.-ProyectoBuffers-master/libreria/"+ f ));
            Lib = (Libro) in.readObject();  
            
            intentarCerrar(in);
        
        return Lib;
}
 	
	public ArrayList<Libro> recuperarTodo() throws FileNotFoundException, IOException, ClassNotFoundException{
		
		Libro L2 = null;
		
		ObjectInputStream in = null;
		
		ArrayList<Libro> libros = new ArrayList<Libro>();
		
		File libr = new File("/Users/danielbc/Desktop/Examen/2.-ProyectoBuffers-master/libreria/");
		
		String[] ficheros = libr.list();
		
		if(ficheros!=null) {
			
			for(int i=0; i<ficheros.length;i++) {
			
				
			if(!ficheros[i].equals(".DS_Store")) {
				in = new ObjectInputStream( new FileInputStream ( "/Users/danielbc/Desktop/Examen/2.-ProyectoBuffers-master/libreria/" + ficheros[i]));
				L2 = (Libro) in.readObject();
				
				libros.add(L2);
				
			}}
		}
		intentarCerrar(in);
		
		return libros;
		
	}
	
	
	//Examen
	public int buscar_anyo(String year) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		Libro L2 = null;
		
		ObjectInputStream in = null;
		
		//ArrayList<Libro> libros = new ArrayList<Libro>();
		
		File libr = new File("/Users/danielbc/Desktop/Examen/2.-ProyectoBuffers-master/libreria/");
		
		String[] ficheros = libr.list();
		
		int cont=0;
		
		if(ficheros!=null) {
			
			for(int i=0; i<ficheros.length; i++) {
			
				
				if(!ficheros[i].equals(".DS_Store")) {
					
					in = new ObjectInputStream( new FileInputStream ( "/Users/danielbc/Desktop/Examen/2.-ProyectoBuffers-master/libreria/" + ficheros[i]));
					
					L2 = (Libro) in.readObject();
					System.out.println("ano recu"+L2.ano);
					if(L2.ano.equals(year)){
						cont++;
					}
				}
			}
		}
		intentarCerrar(in);
		return cont;
	}
	
	public ArrayList<String> contar_Largo (String fichero1, int largo) throws IOException{
		
		
		File fl1 = new File("/Users/danielbc/Desktop/Examen/2.-ProyectoBuffers-master/" + fichero1);
		
		FileReader f1 = new FileReader(fl1);
		
		BufferedReader br3 = new BufferedReader(f1);
		
		ArrayList<String> als= new ArrayList<String>();
		

		String srt="";
		String linea="nulo";
		
		while((srt=br3.readLine())!= null) {

			if((srt.length()==largo)){
				
				als.add(srt);
				
			}
		}
		
		return als;
		
	}
	
	
	public void intentarCerrar(Closeable aCerrar) {
		try {
			if (aCerrar != null) {
				aCerrar.close();
			}
		}catch (IOException ex) {
			ex.printStackTrace(System.err);
		}
	}
}
	
