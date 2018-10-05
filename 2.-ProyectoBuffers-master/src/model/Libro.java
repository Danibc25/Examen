package model;

import java.io.Serializable;

public class Libro implements Serializable {
	
	String ID;
	String titulo;
	String autor;
	String ano;
	String editorial;
	String paginas;
	
	public Libro () {};
	
	public Libro (String id, String titulo, String autor, String ano, String editorial, String paginas) {
		
		this.ID=id;
		this.titulo=titulo;
		this.autor = autor;
		this.ano = ano;
		this.editorial=editorial;
		this.paginas=paginas;
		
	}

	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getPaginas() {
		return paginas;
	}

	public void setPaginas(String paginas) {
		this.paginas = paginas;
	};
	

}
