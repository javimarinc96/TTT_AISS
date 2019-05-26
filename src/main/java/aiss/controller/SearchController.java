package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.aliexpress.AliExpress;

import aiss.model.resources.AliExpressResource;
import aiss.model.resources.TwitchResource;
import aiss.model.resources.YoutubeResource;
import aiss.model.twitch.Games;
import aiss.model.twitch.Stream;
import aiss.model.twitch.Videos;
import aiss.model.youtube.Search;

/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
       
	private static final Logger log = Logger.getLogger(SearchController.class.getName());
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		RequestDispatcher rd = null;
		String query = request.getParameter("query");
		System.out.println(query);
		
		String youtubeToken = (String) request.getSession().getAttribute("YouTube-token");
		String twitchToken = (String) request.getSession().getAttribute("Twitch-token");
		
		//Comprobamos que esta logueado en las 3 apis mediantes sus tokens
		if (youtubeToken != null && !"".equals(youtubeToken) && twitchToken != null && !"".equals(twitchToken)) {
			
			// Search for videos on youtube
			log.log(Level.FINE, "Searching with keyword" + query);
			log.log(Level.FINE, "yttoken" + youtubeToken);
			log.log(Level.FINE, "twtoken" + twitchToken);
			System.out.println(youtubeToken);
			System.out.println(twitchToken);
			
			//inicializamos recursos
			YoutubeResource youtube = new YoutubeResource(youtubeToken);
			TwitchResource twitch = new TwitchResource(twitchToken);
			AliExpressResource aliexpress = new AliExpressResource();
		
			//obtenemos los objetos de busqueda
			Search youtubeSearch = youtube.getSearch(query);
	    	Stream twitchGameSearch = twitch.getStreams(query);
	    	Games twitchGame = twitch.getGameStreams(query);
	    	Videos twitchVideo = twitch.getVideos(query);
			AliExpress aliResults = aliexpress.getProducts(query);
			
//en el controlador se comprueba si estas logueado en las 3 APIS , si estas se lanza, si no, se manda al usuario a pagina 
//aviso de login vista con 3 enlaces a las vistas de  login de las 3 apis
		
	    	if (youtubeSearch!= null && twitchGameSearch != null){
	    		//cargamos los objetos en la vista de exito
				request.setAttribute("items", youtubeSearch.getItems());
				request.setAttribute("data", twitchGameSearch.getData());
				request.setAttribute("gdata", twitchGame.getData());
				request.setAttribute("vdata", twitchVideo.getData());
				request.setAttribute("productos", aliResults.getResult().getProducts());
				rd = request.getRequestDispatcher("/success.jsp");
			} else {
				log.info("The files returned are null... probably your token has experied. Redirecting to OAuth servlet.");
				rd = request.getRequestDispatcher("/error.jsp");
			}
			
	    	//si no esta logueado en las 3 apis, mandamos al controlador a la vista de error para que se loguee en todas
		}else{
			 log.info("Trying to access without an access token, redirecting to OAuth servlet");
			 rd = request.getRequestDispatcher("/error.jsp");
		}
		
		rd.forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
