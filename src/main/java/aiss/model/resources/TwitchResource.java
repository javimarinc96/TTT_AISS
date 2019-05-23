package aiss.model.resources;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;
import java.text.Normalizer.Form;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.util.Series;

import aiss.model.twitch.Streams;
import aiss.model.youtube.Search;

public class TwitchResource {
	
	private static final Logger log = Logger.getLogger(TwitchResource.class.getName());
	private final String access_token;
    private final String uri = "https://api.twitch.tv/helix/streams";

    public TwitchResource(String access_token) {
    	 this.access_token = access_token;
    }
    
//	public Streams getfirst() throws UnsupportedEncodingException {
//		
//		log.log(Level.FINE, "token: ", this.access_token);
//		
//		// Escribir la url de busqueda
//		
//		String url = uri+"?first=10";
//		
//		//Añadimos un log
//		
//		log.log(Level.FINE, "Twitch search for most active streams URI: ", url);
//		
//		//Pedir al servicio restful el recurso que queremos (lo devuelve en json)
//		
//		ClientResource cr = new ClientResource(url);
//		
//		//Convertir ese recurso en formato java
//		
//		Streams TwitchStream = cr.get(Streams.class);
//		
//	    return TwitchStream;
//	}
	
	public Streams getUserStream(String user0) throws UnsupportedEncodingException {
		//Asegurarnos que la cadena esta en el formato correcto
		
		String user = URLEncoder.encode(user0,"UTF-8");
				
		log.log(Level.FINE, "user_login: ", user);
		log.log(Level.FINE, "token: ", this.access_token);
		System.out.println(this.access_token);
		
		// Escribir la url de busqueda
		
		String url = uri + "?access_token=" + access_token +"&user_login=" + user;
		
		//Añadimos un log
		
		log.log(Level.FINE, "Twitch search user stream URI: ", url);
		
		//Pedir al servicio restful el recurso que queremos (lo devuelve en json)
		
		ClientResource cr = new ClientResource(url);
//		Form headers = (Form) cr.getRequestAttributes().get("org.restlet.http.headers");
//		Series<Header> header = cr.getRequestAttributes().get("org.restlet.http.headers");
//		headers.set("Client-ID" , "ctj1gvwlo2uf6u9l4r3y2gpy6sddow");
		
		
		//Convertir ese recurso en formato java
		
		Streams twitchStream = cr.get(Streams.class);
		
	    return twitchStream;
	}
	
//	public Streams getGameStreams(String game_id) throws UnsupportedEncodingException {
//		//Asegurarnos que la cadena esta en el formato correcto
//		
//		String game_id2 = URLEncoder.encode(game_id,"UTF-8");
//				
//		log.log(Level.FINE, "game_id: ", game_id2);
//		log.log(Level.FINE, "token: ", this.access_token);
//		
//		// Escribir la url de busqueda
//		
//		String url = uri+"?game_id="+game_id2;
//		
//		//Añadimos un log
//		
//		log.log(Level.FINE, "Twitch search game streams URI: ", url);
//		
//		//Pedir al servicio restful el recurso que queremos (lo devuelve en json)
//		
//		ClientResource cr = new ClientResource(url);
//		
//		//Convertir ese recurso en formato java
//		
//		Streams TwitchStream = cr.get(Streams.class);
//		
//	    return TwitchStream;
//	}
}
