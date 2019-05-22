package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.twitch.Streams;
import aiss.model.youtube.Search;

public class TwitchResource {
	private static final Logger log = Logger.getLogger(TwitchResource.class.getName());
	private final String access_token;
    private final String uri = "https://api.twitch.tv/kraken/streams";

    public TwitchResource(String access_token) {
    	 this.access_token = access_token;
    }
    
	public Streams getfirst() throws UnsupportedEncodingException {
		
		log.log(Level.FINE, "token: ", this.access_token);
		
		// Escribir la url de busqueda
		
		String url = uri+"?first=10";
		
		//Añadimos un log
		
		log.log(Level.FINE, "Twitch search for most active streams URI: ", url);
		
		//Pedir al servicio restful el recurso que queremos (lo devuelve en json)
		
		ClientResource cr = new ClientResource(url);
		
		//Convertir ese recurso en formato java
		
		Streams TwitchStream = cr.get(Streams.class);
		
	    return TwitchStream;
	}
	
	public Streams getUserStream(String user_login) throws UnsupportedEncodingException {
		//Asegurarnos que la cadena esta en el formato correcto
		
		String user_login2 = URLEncoder.encode(user_login,"UTF-8");
				
		log.log(Level.FINE, "user_login: ", user_login2);
		log.log(Level.FINE, "token: ", this.access_token);
		
		// Escribir la url de busqueda
		
		String url = uri+"?user_login="+user_login2+"&access_token="+access_token;
		
		//Añadimos un log
		
		log.log(Level.FINE, "Twitch search user stream URI: ", url);
		
		//Pedir al servicio restful el recurso que queremos (lo devuelve en json)
		
		ClientResource cr = new ClientResource(url);
		
		//Convertir ese recurso en formato java
		
		Streams TwitchStream = cr.get(Streams.class);
		
	    return TwitchStream;
	}
	
	public Streams getGameStreams(String game_id) throws UnsupportedEncodingException {
		//Asegurarnos que la cadena esta en el formato correcto
		
		String game_id2 = URLEncoder.encode(game_id,"UTF-8");
				
		log.log(Level.FINE, "game_id: ", game_id2);
		log.log(Level.FINE, "token: ", this.access_token);
		
		// Escribir la url de busqueda
		
		String url = uri+"?game_id="+game_id2;
		
		//Añadimos un log
		
		log.log(Level.FINE, "Twitch search game streams URI: ", url);
		
		//Pedir al servicio restful el recurso que queremos (lo devuelve en json)
		
		ClientResource cr = new ClientResource(url);
		
		//Convertir ese recurso en formato java
		
		Streams TwitchStream = cr.get(Streams.class);
		
	    return TwitchStream;
	}
}
