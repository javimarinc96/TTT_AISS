package aiss.api.resources;

import java.net.URI;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.api.model.Company;
import aiss.api.model.VideoGame;
import aiss.api.model.repository.MapCompanyRepository;
import aiss.api.model.repository.CompanyRepository;


@Path("/lists")
public class CompanyResource {
	
	/* Singleton */
	private static CompanyResource _instance=null;
	CompanyRepository repository;
	
	private CompanyResource() {
		repository=MapCompanyRepository.getInstance();

	}
	
	public static CompanyResource getInstance()
	{
		if(_instance==null)
				_instance=new CompanyResource();
		return _instance;
	}
	

	@GET
	@Produces("application/json")
	public Collection<Company> getAll()
	{
		return repository.getAllCompanys();
	}
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Company get(@PathParam("id") String id)
	{
		Company list = repository.getCompany(id);
		
		if (list == null) {
			throw new NotFoundException("The Company wit id="+ id +" was not found");			
		}
		
		return list;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addCompany(@Context UriInfo uriInfo, Company Company) {
		if (Company.getNombre() == null || "".equals(Company.getNombre()))
			throw new BadRequestException("The name of the Company must not be null");
		
		if (Company.getVideojuegos()!=null)
			throw new BadRequestException("The VideoGames property is not editable.");

		repository.addCompany(Company);

		// Builds the response. Returns the Company the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(Company.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(Company);			
		return resp.build();
	}

	
	@PUT
	@Consumes("application/json")
	public Response updateCompany(Company Company) {
		Company oldCompany = repository.getCompany(Company.getId());
		if (oldCompany == null) {
			throw new NotFoundException("The Company with id="+ Company.getId() +" was not found");			
		}
		
		if (Company.getVideojuegos()!=null)
			throw new BadRequestException("The VideoGames property is not editable.");
		
		// Update name
		if (Company.getNombre()!=null)
			oldCompany.setNombre(Company.getNombre());
		
		// Update description
		if (Company.getFechaFormacion()!=null)
			oldCompany.setFechaFormacion(Company.getFechaFormacion());
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeCompany(@PathParam("id") String id) {
		Company toberemoved=repository.getCompany(id);
		if (toberemoved == null)
			throw new NotFoundException("The Company with id="+ id +" was not found");
		else
			repository.deleteCompany(id);
		
		return Response.noContent().build();
	}
	
	
	@POST	
	@Path("/{CompanyId}/{VideoGameId}")
	@Consumes("text/plain")
	@Produces("application/json")
	public Response addVideoGame(@Context UriInfo uriInfo,@PathParam("CompanyId") String CompanyId, @PathParam("VideoGameId") String VideoGameId)
	{				
		
		Company Company = repository.getCompany(CompanyId);
		VideoGame VideoGame = repository.getVideoGame(VideoGameId);
		
		if (Company==null)
			throw new NotFoundException("The Company with id=" + CompanyId + " was not found");
		
		if (VideoGame == null)
			throw new NotFoundException("The VideoGame with id=" + VideoGameId + " was not found");
		
		if (Company.getGame(VideoGameId) != null)
			throw new BadRequestException("The VideoGame is already included in the Company.");
			
		repository.addVideoGame(CompanyId, VideoGameId);		

		// Builds the response
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(CompanyId);
		ResponseBuilder resp = Response.created(uri);
		resp.entity(Company);			
		return resp.build();
	}
	
	
	@DELETE
	@Path("/{CompanyId}/{VideoGameId}")
	public Response removeVideoGame(@PathParam("CompanyId") String CompanyId, @PathParam("VideoGameId") String VideoGameId) {
		Company Company = repository.getCompany(CompanyId);
		VideoGame VideoGame = repository.getVideoGame(VideoGameId);
		
		if (Company==null)
			throw new NotFoundException("The Company with id=" + CompanyId + " was not found");
		
		if (VideoGame == null)
			throw new NotFoundException("The VideoGame with id=" + VideoGameId + " was not found");
		
		
		repository.removeVideoGame(CompanyId, VideoGameId);		
		
		return Response.noContent().build();
	}
	
}
