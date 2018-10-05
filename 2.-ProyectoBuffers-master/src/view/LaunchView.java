package view;

import java.awt.Dimension;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout.Alignment;

public class LaunchView extends JFrame {

	private JButton comparar,buscar;
	private JTextArea textArea;
	private JTextField fichero1,fichero2,palabra;
	private JLabel label_f1,label_f2,label_pal;
	private JCheckBox primera;
	
	private JPanel panel;
	
	private JButton leer_Libros;
	
	private JPanel panel_1;
	
	private JButton guardar;
	private JButton recu_todo;
	
	//EXAMEN
	private JButton buscar_anyo;;
	
	
	
	//private JButton recu_todo;
	
	


	private JLabel id;
	private JTextField text_ID;
	private JLabel titulo;
	private JTextField text_titulo;
	private JLabel autor;
	private JTextField text_autor;
	private JLabel ano;
	private JTextField text_ano;
	private JLabel editor;
	private JTextField text_editor;
	private JTextField text_paginas;
	private JTextField text_file;
	private JTextField text_banyo;
	private JLabel largo;
	private JTextField text_largo;
	private JButton btnContarLargo;
	
	public LaunchView() {
		
		setBounds(200,200,1008,570);
		setTitle("Proyecto Buffers");	
		panel = new JPanel();
		
		comparar = new JButton("Comparar contenido");
		comparar.setBounds(51, 5, 150, 26);
		comparar.setPreferredSize(new Dimension(150, 26));
		buscar = new JButton("Buscar palabra");
		buscar.setBounds(206, 5, 150, 26);
		buscar.setPreferredSize(new Dimension(150, 26));
					
		fichero1 = new JTextField("",10);
		fichero1.setBounds(428, 5, 130, 26);
		fichero2 = new JTextField("",10);
		fichero2.setBounds(630, 5, 130, 26);
		palabra = new JTextField("",10);
		palabra.setBounds(819, 5, 130, 26);
		
		label_f1 = new JLabel("Fichero 1:");
		label_f1.setBounds(361, 10, 62, 16);
		label_f2 = new JLabel("Fichero 2:");
		label_f2.setBounds(563, 10, 62, 16);
		label_pal = new JLabel("Palabra:");
		label_pal.setBounds(765, 10, 49, 16);
		
		primera = new JCheckBox("Primera aparici�n");
		primera.setBounds(381, 39, 146, 23);

		textArea = new JTextArea(20, 50);
		textArea.setBounds(47,63,688,435);
		textArea.setEditable(false);		
		panel.setLayout(null);
		
		panel.add(comparar);
		panel.add(buscar);
		panel.add(label_f1);
		panel.add(fichero1);
		panel.add(label_f2);
		panel.add(fichero2);
		panel.add(label_pal);
		panel.add(palabra);
		panel.add(primera);
		panel.add(textArea);
		
        // A�adimos el JPanel al JFrame
		
        this.getContentPane().add(panel);		
        
        panel_1 = new JPanel();
        panel_1.setBounds(747, 63, 247, 435);
        panel.add(panel_1);
        
        leer_Libros = new JButton("Leer");
        leer_Libros.setBounds(3, 0, 47, 43);
        
        guardar = new JButton("Guardar");
        guardar.setBounds(3, 274, 93, 23);
       
        
        recu_todo = new JButton("Recu Todo"); 
        recu_todo.setBounds(122, 271, 93, 29);
        panel_1.add(recu_todo);
       
        id = new JLabel("ID");
        id.setBounds(13, 50, 63, 23);
        
        text_ID = new JTextField();
        text_ID.setBounds(88, 49, 93, 23);
        text_ID.setText("");
        text_ID.setColumns(10);
        
        titulo = new JLabel("Titulo");
        titulo.setBounds(6, 91, 70, 23);
        
        text_titulo = new JTextField();
        text_titulo.setBounds(88, 90, 93, 23);
        text_titulo.setColumns(10);
        
        autor = new JLabel("Autor");
        autor.setBounds(3, 126, 73, 23);
        
        text_autor = new JTextField();
        text_autor.setBounds(88, 125, 93, 23);
        text_autor.setColumns(10);
        
        ano = new JLabel("Anyo");
        ano.setBounds(3, 161, 73, 23);
        
        text_ano = new JTextField();
        text_ano.setBounds(88, 198, 93, 23);
        text_ano.setColumns(10);
        
        editor = new JLabel("Editorial");
        editor.setBounds(3, 199, 73, 23);
        
        text_editor = new JTextField();
        text_editor.setBounds(88, 160, 93, 23);
        text_editor.setColumns(10);
        
        panel_1.setLayout(null);
        panel_1.add(leer_Libros);
        panel_1.add(guardar);
        panel_1.add(id);
        panel_1.add(text_ID);
        panel_1.add(titulo);
        panel_1.add(text_titulo);
        panel_1.add(autor);
        panel_1.add(text_autor);
        panel_1.add(ano);
        panel_1.add(text_ano);
        panel_1.add(editor);
        panel_1.add(text_editor);
        
        JLabel paginas = new JLabel("Paginas");
        paginas.setBounds(3, 239, 73, 23);
        panel_1.add(paginas);
        
        text_paginas = new JTextField();
        text_paginas.setColumns(10);
        text_paginas.setBounds(88, 230, 93, 23);
        panel_1.add(text_paginas);
        
        JLabel lblNewLabel = new JLabel("File");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(46, 12, 47, 16);
        panel_1.add(lblNewLabel);
        
        text_file = new JTextField();
        text_file.setBounds(88, 7, 93, 26);
        panel_1.add(text_file);
        text_file.setColumns(10);
        
        
      //EXAMEN
        JLabel b_anyo = new JLabel("Anyo");
        b_anyo.setHorizontalAlignment(SwingConstants.CENTER);
        b_anyo.setBounds(128, 300, 87, 16);
        panel_1.add(b_anyo);
        
        text_banyo = new JTextField();
        text_banyo.setBounds(128, 318, 87, 29);
        panel_1.add(text_banyo);
        text_banyo.setColumns(10);
        
        buscar_anyo = new JButton("Buscar anyo");
        buscar_anyo.setBounds(3, 319, 107, 29);
        panel_1.add(buscar_anyo);
        
        largo = new JLabel("Longitud");
        largo.setHorizontalAlignment(SwingConstants.CENTER);
        largo.setBounds(122, 347, 93, 16);
        panel_1.add(largo);
        
        text_largo = new JTextField();
        text_largo.setBounds(128, 375, 87, 26);
        panel_1.add(text_largo);
        text_largo.setColumns(10);
        
        btnContarLargo = new JButton("Contar Largo");
        btnContarLargo.setBounds(3, 375, 107, 29);
        panel_1.add(btnContarLargo);
        
     
        
       
       
		
	}	
	
	

	
	public JButton getComparar() {
		return comparar;
	}

	public void setComparar(JButton comparar) {
		this.comparar = comparar;
	}

	public JButton getBuscar() {
		return buscar;
	}

	public void setBuscar(JButton buscar) {
		this.buscar = buscar;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
			
	public JTextField getFichero1() {
		return fichero1;
	}

	public void setFichero1(JTextField fichero1) {
		this.fichero1 = fichero1;
	}

	public JTextField getFichero2() {
		return fichero2;
	}

	public void setFichero2(JTextField fichero2) {
		this.fichero2 = fichero2;
	}

	//
	public JTextField getPalabra() {
		return palabra;
	}

	public void setPalabra(JTextField palabra) {
		this.palabra = palabra;
	}

	public JCheckBox getPrimera() {
		return primera;
	}

	public void setPrimera(JCheckBox primera) {
		this.primera = primera;
	}
	//
	public void showError(String m){
		JOptionPane.showMessageDialog(this.panel,
			    m,
			    "Error",
			    JOptionPane.ERROR_MESSAGE);
	}

	// DAtos libro
	public JTextField getText_ID() {
		return text_ID;
	}

	public void setText_ID(JTextField text_ID) {
		this.text_ID = text_ID;
	}

	public JTextField getText_titulo() {
		return text_titulo;
	}

	public void setText_titulo(JTextField text_titulo) {
		this.text_titulo = text_titulo;
	}

	public JTextField getText_autor() {
		return text_autor;
	}

	public void setText_autor(JTextField text_autor) {
		this.text_autor = text_autor;
	}

	public JTextField getText_ano() {
		return text_ano;
	}

	public void setText_ano(JTextField text_ano) {
		this.text_ano = text_ano;
	}

	public JTextField getText_editor() {
		return text_editor;
	}

	public void setText_editor(JTextField text_editor) {
		this.text_editor = text_editor;
	}





	public JTextField getText_paginas() {
		return text_paginas;
	}





	public void setText_paginas(JTextField text_paginas) {
		this.text_paginas = text_paginas;
	}





	public JButton getLeer_Libros() {
		return leer_Libros;
	}





	public void setLeer_Libros(JButton leer_Libros) {
		this.leer_Libros = leer_Libros;
	}





	public JButton getGuardar() {
		return guardar;
	}





	public void setGuardar(JButton guardar) {
		this.guardar = guardar;
	}





	public JTextField getText_file() {
		return text_file;
	}





	public void setText_file(JTextField text_file) {
		this.text_file = text_file;
	}
	
	
	public JButton getRecu_todo() {
		return recu_todo;
	}


	public void setRecu_todo(JButton recu_todo) {
		this.recu_todo = recu_todo;
	}


	
	
	
	//EXAMEN
	public JButton getBuscar_anyo() {
		return buscar_anyo;
	}


	public void setBuscar_anyo(JButton buscar_anyo) {
		this.buscar_anyo = buscar_anyo;
	}


	public JTextField getText_banyo() {
		return text_banyo;
	}


	public void setText_banyo(JTextField text_banyo) {
		this.text_banyo = text_banyo;
	}
	public JTextField getText_largo() {
		return text_largo;
	}
	public void setText_largo(JTextField text_largo) {
		this.text_largo = text_largo;
	}
	public JButton getBtnContarLargo() {
		return btnContarLargo;
	}
	public void setBtnContarLargo(JButton btnContarLargo) {
		this.btnContarLargo = btnContarLargo;
	}


}



	

	


