package aiss.api.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Company {

	private String id;
	private String nombre;
	private String procedencia;
	private LocalDate fechaFormacion;
	private List<VideoGame> videojuegos;
	
	public Company() {
		
	}
	
	public Company(String nombre,String procedencia, LocalDate fecha) {
		super();
		this.nombre = nombre;
		this.procedencia = procedencia;
		this.fechaFormacion = fecha;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public String getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}
	
	public LocalDate getFechaFormacion() {
		return fechaFormacion;
	}

	public void setFechaFormacion(LocalDate fechaFormacion) {
		this.fechaFormacion = fechaFormacion;
	}
	
	public List<VideoGame> getVideojuegos() {
		return videojuegos;
	}
	
	protected void setVideojuegos(List<VideoGame> videojuegos) {
		this.videojuegos = videojuegos;
	}
	
	
	public VideoGame getGame (String id) {
		if (videojuegos==null)
			return null;
		
		VideoGame game = null;
		for(VideoGame g : videojuegos)
			if (g.getId().equals(id))
			{
				game = g;
				break;
			}
		
		return game;
	}
	
	public void addGame (VideoGame game) {
		if (videojuegos==null)
			videojuegos = new ArrayList<VideoGame>();
		videojuegos.add(game);
	}
	
	public void deleteGame (VideoGame game) {
		videojuegos.remove(game);
	}
	
	public void deleteGame (String id) {
		VideoGame game = getGame(id);
		if (game!=null)
			videojuegos.remove(game);
	}


}
