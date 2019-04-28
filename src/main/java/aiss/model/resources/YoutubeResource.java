package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.youtube.Search;

public class YoutubeResource {

	//private static final String OMDB_API_KEY = "840f71e7";  
	// TODO: Change this API KEY for your personal Key
	private static final Logger log = Logger.getLogger(YoutubeResource.class.getName());
	
	public Search getVideos(String part,String query) throws UnsupportedEncodingException {

		//Asegurarnos que la cadena esta en el formato correcto
		
		String part2 = URLEncoder.encode(part, "UTF-8");
		String query2 = URLEncoder.encode(query, "UTF-8");
		
		
		// Escribir la url de busqueda
		
		String uri = "https://www.googleapis.com/youtube/v3/search?part="+part2+"&q="+query2;
		
		//Añadimos un log
		
		log.log(Level.FINE, "Youtube Search URI: ", uri);
		
		//Pedir al servicio restful el recurso que queremos (lo devuelve en json)
		
		ClientResource cr = new ClientResource(uri);
		
		//Convertir ese recurso en formato java
		
		Search youtubeSearch = cr.get(Search.class);
		
	    return youtubeSearch;
	}
}
