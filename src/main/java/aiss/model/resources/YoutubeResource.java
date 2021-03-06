package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;


import aiss.model.youtube.CommentThreads;
import aiss.model.youtube.Search;

public class YoutubeResource {


	private static final Logger log = Logger.getLogger(YoutubeResource.class.getName());
	private final String access_token;
    private final String uri = "https://www.googleapis.com/youtube/v3/search";
    private final String uri2 = "https://www.googleapis.com/youtube/v3/commentThreads";
	
    
    public YoutubeResource(String access_token) {
        this.access_token = access_token;
    }
	
    
	public Search getSearch (String query) throws UnsupportedEncodingException {

		//Asegurarnos que la cadena esta en el formato correcto
		
		String query2 = URLEncoder.encode(query,"UTF-8");
		
		log.log(Level.FINE, "query: ", query2);
		log.log(Level.FINE, "token: ", this.access_token);
		System.out.println(this.access_token);
		
		// Escribir la url de busqueda
		
		String url = uri+"?part=snippet&q="+query2+"&access_token="+access_token;
		
		//Añadimos un log
		
		log.log(Level.FINE, "Youtube Search URI: ", url);
		
		//Pedir al servicio restful el recurso que queremos (lo devuelve en json)
		
		ClientResource cr = null;
		Search youtubeSearch = null;
		
		try {
			cr = new ClientResource(url);
			//Convertir ese recurso en formato java
			System.out.println("Client Resource:"+cr);
			youtubeSearch = cr.get(Search.class);
		} catch (ResourceException re) {
		youtubeSearch = null;
		System.err.println("Error when retrieving all videos: " + cr.getResponse().getStatus());
		return null;
		}
		
	    return youtubeSearch;
	}
	
	
	public CommentThreads insertTopComment (CommentThreads comment) {
		
		ClientResource cr = null;
		CommentThreads res = null;
		
		String url = uri2+"?part=snippet&access_token="+access_token;
		
		try {
			cr = new ClientResource(url);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			res = cr.post(comment,CommentThreads.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when adding the comment: " + cr.getResponse().getStatus());
		}
		
		return res;
	}
	
}
