package aiss.model.resources;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.twitch.Streams;

public class TwitchResource {
	
	private static final Logger log = Logger.getLogger(TwitchResource.class.getName());
	private final String access_token;
    private final String uri = "https://api.twitch.tv/helix/streams";
	
	
    public TwitchResource(String access_token) {
        this.access_token = access_token;
    }
	
	public Streams getStreams(String user_id) throws UnsupportedEncodingException {
		//Asegurarnos que la cadena esta en el formato correcto
		
		String user_id2 = URLEncoder.encode(user_id, "UTF-8");
		
		log.log(Level.FINE, "user_id: ", user_id2);
		log.log(Level.FINE, "token: ", this.access_token);
				
		// Escribir la url de busqueda
		
		String url = uri + "user_id=" + user_id2;
		
		//Añadimos un log
		
		log.log(Level.FINE, "Search for streams: ", url);
		
		//Pedir al servicio restful el recurso que queremos (lo devuelve en json)
		
		ClientResource cr = new ClientResource(url);
		
		//Convertir ese recurso en formato java
		
		Streams twitchSearch= cr.get(Streams.class);
		
	    return twitchSearch;
	}
}
