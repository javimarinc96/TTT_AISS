package aiss.model.resources;

import java.io.UnsupportedEncodingException;

import org.restlet.data.Header;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.util.Series;

import aiss.model.twitch.Games;
import aiss.model.twitch.Stream;
import aiss.model.twitch.Videos;

public class TwitchResource {
	
	private static final String clientID = "ctj1gvwlo2uf6u9l4r3y2gpy6sddow";
	private static final Logger log = Logger.getLogger(TwitchResource.class.getName());
	private final String access_token;
    private final String uri = "https://api.twitch.tv/helix";

    public TwitchResource(String access_token) {
    	 this.access_token = access_token;
    }
	
	public Stream getStreams(String gameName0) throws UnsupportedEncodingException {
		
		//FORMATO CORRECTO
		if (getGameStreams(gameName0)==null) {}
		String id0 = getGameStreams(gameName0).getData().get(0).getId();
		
		String id = URLEncoder.encode(id0,"UTF-8");
		
		log.log(Level.FINE, "game_id: ", id);
		log.log(Level.FINE, "token: ", this.access_token);
		
		// URL
		
		String url = uri + "/streams" + "?access_token=" + access_token + "&first=2&game_id=" + id;
		
		//Añadimos un log
		
		log.log(Level.FINE, "Twitch search game stream URI: ", url);
		
		//Pedir al servicio restful el recurso que queremos (lo devuelve en json)
		
		ClientResource cr = new ClientResource(url);
		Series<Header> header = (Series<Header>) cr.getRequestAttributes().get("org.restlet.http.headers");
		if (header == null) {
			header = new Series<Header>(Header.class);
		    cr.getRequestAttributes().put("org.restlet.http.headers", header);
		}
		
		header.set("Client-ID" , clientID);
		
		//CREAR CLASE
		
		Stream twitchStream = cr.get(Stream.class);

	    return twitchStream;
	}
	
	public Games getGameStreams(String gN0) throws UnsupportedEncodingException {
		//Asegurarnos que la cadena esta en el formato correcto
		
		String gameName = URLEncoder.encode(gN0,"UTF-8");
				
		log.log(Level.FINE, "name: ", gameName);
		log.log(Level.FINE, "token: ", this.access_token);
		
		// Escribir la url de busqueda
		
		String url = uri + "/games" + "?access_token=" + access_token + "&name=" + gameName;
		
		//Añadimos un log
		
		log.log(Level.FINE, "Twitch search game streams URI: ", url);
		
		//Pedir al servicio restful el recurso que queremos (lo devuelve en json)
		
		ClientResource cr = new ClientResource(url);
		Series<Header> header = (Series<Header>) cr.getRequestAttributes().get("org.restlet.http.headers");
		if (header == null) {
			header = new Series<Header>(Header.class);
		    cr.getRequestAttributes().put("org.restlet.http.headers", header);
		}
		
		header.set("Client-ID" , clientID);
		
		
		//Convertir ese recurso en formato java
		
		Games TwitchGame = cr.get(Games.class);
		
	    return TwitchGame;
	}
	
	public Videos getVideos(String gameName0) throws UnsupportedEncodingException {
		
		//FORMATO CORRECTO
		
				String id0 = getGameStreams(gameName0).getData().get(0).getId();
				
				String id = URLEncoder.encode(id0,"UTF-8");
				
				log.log(Level.FINE, "game_id: ", id);
				log.log(Level.FINE, "token: ", this.access_token);
				
				// URL
				
				String url = uri + "/videos" + "?access_token=" + access_token + "&first=2&game_id=" + id;
				
				//Añadimos un log
				
				log.log(Level.FINE, "Twitch search game video URI: ", url);
				
				//Pedir al servicio restful el recurso que queremos (lo devuelve en json)
				
				ClientResource cr = new ClientResource(url);
				Series<Header> header = (Series<Header>) cr.getRequestAttributes().get("org.restlet.http.headers");
				if (header == null) {
					header = new Series<Header>(Header.class);
				    cr.getRequestAttributes().put("org.restlet.http.headers", header);
				}
				
				header.set("Client-ID" , clientID);
				
				//CREAR CLASE
				
				Videos twitchVideo = cr.get(Videos.class);

			    return twitchVideo;
		
	}
	
}
