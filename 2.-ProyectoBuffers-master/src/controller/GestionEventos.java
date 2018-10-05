package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTextField;

import model.*;
import view.*;

public class GestionEventos {

	private GestionDatos model;
	private LaunchView view;
	private ActionListener actionListener_comparar, actionListener_buscar, actionListener_guardar, actionListener_recuperar, actionListener_recuperarTodo, actionListener_buscarAnyo, actionListener_contarLargo ;

	public GestionEventos(GestionDatos model, LaunchView view) {
		this.model = model;
		this.view = view;
	}

	
	public void contol() {
		
		actionListener_comparar = new ActionListener() {
			
			public void actionPerformed(ActionEvent actionEvent) {
				
				if(call_compararContenido() == false) {
					
					view.getTextArea().setText("Distintos");
					
				}else {
					view.getTextArea().setText("Iguales");
					}
				}
			};	
		view.getComparar().addActionListener(actionListener_comparar);

		actionListener_buscar = new ActionListener() {
			
			public void actionPerformed(ActionEvent actionEvent) {
			if(call_buscarPalabra()==0) {
				view.getTextArea().setText("La palabra no está");
				
			}else {
				view.getTextArea().setText("En la inea " + call_buscarPalabra() + " aparece la palabra");
				}
			}
		};
		view.getBuscar().addActionListener(actionListener_buscar);

		actionListener_guardar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				call_crearLibro();
				
			}
			
			
		};
		view.getGuardar().addActionListener(actionListener_guardar);
		
		actionListener_recuperar = new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				 call_recuperarLibro();
			}
			
			
		};
		view.getLeer_Libros().addActionListener(actionListener_recuperar);
		
		
		actionListener_recuperarTodo = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Estoy aqui22");
				 call_recuperarTodo();
			}
			
			
		};
		view.getRecu_todo().addActionListener(actionListener_recuperarTodo);
	
		//EXAMEN
		actionListener_buscarAnyo = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			
				 call_buscarAnyo();
			}
			
			
		};
		view.getBuscar_anyo().addActionListener(actionListener_buscarAnyo);
	
		actionListener_contarLargo = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("holala");
				 call_contarLargo();
			}
			
			
		};
		view.getBtnContarLargo().addActionListener(actionListener_contarLargo);
	}

	
	
	private boolean call_compararContenido() {
		
		// TODO: Llamar a la funci�n compararContenido de GestionDatos
		String fich1 = view.getFichero1().getText();
		String fich2 = view.getFichero2().getText();
		
		try {
			
			return model.compararContenido(fich1, fich2);
			
		
		} catch (IOException e) {
			
			//LLAMAR AL SHOWERROR DE LA VISTA
			
			view.showError("Error al comparar ficheros.");
			e.printStackTrace();
		}
		return true;
	}

	private int call_buscarPalabra() {

	
		String fich1 = view.getFichero1().getText();
		String palabra = view.getPalabra().getText();
		boolean primera = view.getPrimera().isSelected();
		
		try {
			return model.buscarPalabra(fich1, palabra, primera);
			
		} catch (IOException e) {
			
			//LLAMAR AL SHOWERROR DE LA VISTA
			
			view.showError("Error al comparar ficheros.");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	private void call_crearLibro() {
		
		String ID = view.getText_ID().getText();
		String titulo = view.getText_titulo().getText();
		String autor =view.getText_autor().getText();
		String ano = view.getText_ano().getText();
		String editorial = view.getText_editor().getText();
		String pagina= view.getText_paginas().getText();
		
		Libro L1 = new Libro(ID, titulo, autor, editorial, ano, pagina);
		
		try {
			model.crear_libro(L1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	private void call_recuperarLibro() {
		
		String nom = view.getText_file().getText();
		
		
		try {	
			Libro l = model.recuperar_libro(nom);
			view.getTextArea().setText("ID:" + l.getID() + "\n" + "Titulo:"+ l.getTitulo() + "\n" + "Autor:"+ l.getAutor()+ "\n" + "Año:"+ l.getAno()+ "\n" + "Editorial:"+ l.getEditorial() + "\n" + "Paginas:"+ l.getPaginas());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

	private void call_recuperarTodo() {
		
		view.getTextArea().setText(null);
		
		try {
			ArrayList<Libro> libros = model.recuperarTodo();
			
			Iterator it = libros.iterator();
			while(it.hasNext()) {
				
				Libro L1 = (Libro) it.next();
				view.getTextArea().setText(view.getTextArea().getText() + "ID:" + L1.getID() + "\n" + "Titulo:"+ L1.getTitulo() + "\n" + "Autor:"+ L1.getAutor()+ "\n" + "Año:"+ L1.getAno()+ "\n" + "Editorial:"+ L1.getEditorial() + "\n" + "Paginas:"+ L1.getPaginas());
				view.getTextArea().setText(view.getTextArea().getText()+ "\n ---------------------------------------------");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	//EXAMEN
	private void call_buscarAnyo() {
		view.getTextArea().setText(null);
		
		String year = view.getText_banyo().getText();
		System.out.println("año buscado"+ year);
		try {
			
			System.out.println(model.buscar_anyo(year));
			int total =model.buscar_anyo(year);
			if(total==0) {
				view.getTextArea().setText("No se han encotrado libros de el año " + year);
				
			}else {
				view.getTextArea().setText("Se han encontrado " + total +"libro/s del año " + year);
			}
			
			
		} catch (FileNotFoundException e) {
			view.showError("Archivo no encontrado :,(");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void call_contarLargo(){
		 
		
		
		String fichero = view.getFichero1().getText();
		int largo = Integer.parseInt(view.getText_largo().getText());
		
		
		try {
			ArrayList<String> largos = model.contar_Largo(fichero, largo);
			Iterator it = largos.iterator();
			
			if(largos.size() != 0) {
				
				view.getTextArea().setText("Las palabras encontradas son: \n" + largos);
			
			}else{
				view.getTextArea().setText("No se han encontrado palabras de "+ largo + " de largo");
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
