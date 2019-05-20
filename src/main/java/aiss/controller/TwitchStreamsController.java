package aiss.controller;
	
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.TwitchResource;
import aiss.model.resources.YoutubeResource;
import aiss.model.twitch.Streams;
import aiss.model.youtube.Search;

/**
 * Servlet implementation class TwitchStreamsController
 */
public class TwitchStreamsController extends HttpServlet {
		
		
	private static final long serialVersionUID = 1L;
       
	private static final Logger log = Logger.getLogger(TwitchStreamsController.class.getName());
		 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TwitchStreamsController() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(Htt pServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String user_id  =  request.getParameter("user_id");
		RequestDispatcher rd = null;
		
		// Search for twitch streams
		log.log(Level.FINE, "Searching for first streams:");
		TwitchResource twitch = new TwitchResource();
		Streams twitchResults = twitch.getStreams(user_id);

		if (twitchResults!=null){
			rd = request.getRequestDispatcher("/success2.jsp");
			request.setAttribute("items", twitchResults.getData());		
		} else {
			log.log(Level.SEVERE, "Twitch object: " + twitchResults);
			rd = request.getRequestDispatcher("/error2.jsp");
		}
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
		
}
