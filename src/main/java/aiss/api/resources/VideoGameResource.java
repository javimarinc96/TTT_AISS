package aiss.api.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.api.model.VideoGame;
import aiss.api.model.repository.MapCompanyRepository;
import aiss.api.model.repository.CompanyRepository;

import java.net.URI;
import java.util.Collection;


@Path("/videoGames")
public class VideoGameResource {
	

	public static VideoGameResource _instance=null;
	CompanyRepository repository;
	
	
	private VideoGameResource(){
		repository = MapCompanyRepository.getInstance();
	}
	
	public static VideoGameResource getInstance()
	{
		if(_instance==null)
			_instance=new VideoGameResource();
		return _instance; 
	}
	
	
	@GET
	@Produces("application/json")
	public Collection<VideoGame> getAll(){
		
		return repository.getAllVideoGames();
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public VideoGame get(@PathParam("id") String VideoGameId)
	{
		VideoGame VideoGame = repository.getVideoGame(VideoGameId);
		
		if (VideoGame == null) {
			throw new NotFoundException("The VideoGame with id="+ VideoGameId +" was not found");			
		}
		
		return VideoGame;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addVideoGame(@Context UriInfo uriInfo, VideoGame VideoGame) {
		
		if (VideoGame.getTitulo() == null || "".equals(VideoGame.getTitulo()) )
			throw new BadRequestException("The title of the VideoGame must not be null");
		

		repository.addVideoGame(VideoGame);

		// Builds the response. Returns the VideoGame the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(VideoGame.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(VideoGame);			
		return resp.build();
	}
	
	
	@PUT
	@Consumes("application/json")
	public Response updateVideoGame(VideoGame VideoGame) {
		VideoGame oldVideoGame = repository.getVideoGame(VideoGame.getId());
		if (oldVideoGame == null) {
			throw new NotFoundException("The VideoGame with id="+ VideoGame.getId() +" was not found");			
		}
		
		// Update name
		if (VideoGame.getTitulo()!=null)
			oldVideoGame.setTitulo(VideoGame.getTitulo());
		
		// Update Plataforma
		if (VideoGame.getPlataforma()!=null)
			oldVideoGame.setPlataforma(VideoGame.getPlataforma());
		
		// Update Genero
		if (VideoGame.getGenero()!=null)
			oldVideoGame.setGenero(VideoGame.getGenero());
		
		// Update FechaLanzamiento
		if (VideoGame.getFechaLanzamiento()!=null)
			oldVideoGame.setFechaLanzamiento(VideoGame.getFechaLanzamiento());
		
		// Update Caratula
		if (VideoGame.getCaratula()!=null)
			oldVideoGame.setCaratula(VideoGame.getCaratula());
		

		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeVideoGame(@PathParam("id") String VideoGameId) {
		VideoGame toberemoved = repository.getVideoGame(VideoGameId);
		if (toberemoved == null)
			throw new NotFoundException("The VideoGame with id="+ VideoGameId +" was not found");
		else
			repository.deleteVideoGame(VideoGameId);
		
		return Response.noContent().build();
	}
	
}
