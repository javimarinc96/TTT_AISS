package aiss.api.model;

import java.time.LocalDate;


public class VideoGame {

	private String id;
	private String titulo;
	private String genero;
	private String plataforma;
	private String caratula;
	private LocalDate fechaLanzamiento;

	public VideoGame() {
	}

	public VideoGame(String titulo, String genero, String plataforma, LocalDate fechaLanzamiento) {
		this.titulo = titulo;
		this.plataforma = plataforma;
		this.fechaLanzamiento = fechaLanzamiento;
	}
	
	public VideoGame(String id, String titulo, String genero, String plataforma, LocalDate fechaLanzamiento) {
		this.id=id;
		this.titulo = titulo;
		this.genero = genero;
		this.plataforma = plataforma;
		this.fechaLanzamiento = fechaLanzamiento;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public LocalDate getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}

	public String getCaratula() {
		return caratula;
	}

	public void setCaratula(String caratula) {
		this.caratula = caratula;
	}

}
