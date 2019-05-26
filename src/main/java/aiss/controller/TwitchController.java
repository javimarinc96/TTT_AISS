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
import aiss.model.twitch.Games;
import aiss.model.twitch.Stream;
import aiss.model.twitch.Videos;

/**
 * Servlet implementation class StreamsController
 */
public class TwitchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(TwitchController.class.getName());

	/**
     * @see HttpServlet#HttpServlet()
     */
    public TwitchController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {

    	RequestDispatcher rd = null;
    	String query = request.getParameter("query");
    	System.out.println(query);
    	
    	String accessToken = (String) request.getSession().getAttribute("Twitch-token");
    	
    	if (accessToken != null && !"".equals(accessToken)) {
    	// Search for videos and streams on Twitch
    	log.log(Level.FINE, "Searching for videos and streams" + query);
    	log.log(Level.FINE, "token" + accessToken);
    	TwitchResource twitch = new TwitchResource(accessToken);
    	Games twitchGame = twitch.getGameStreams(query);
    	if(twitchGame.getData().size()==0) {rd = request.getRequestDispatcher("FalseName.jsp");}
		else {
    	Stream twitchGameSearch = twitch.getStreams(query);
    	Videos twitchVideo = twitch.getVideos(query);
    	

    	if (twitchGameSearch != null) {
    			log.info("");
				request.setAttribute("data", twitchGameSearch.getData());
				request.setAttribute("gdata", twitchGame.getData());
				request.setAttribute("vdata", twitchVideo.getData());
				rd = request.getRequestDispatcher("Success.jsp");
			} else {
				log.info("The files returned are null... probably your token has experied. Redirecting to OAuth servlet.");
				rd = request.getRequestDispatcher("/AuthController/Twitch");
			}
		}}else{
			 log.info("Trying to access Twitch without an access token, redirecting to OAuth servlet");
			 rd = request.getRequestDispatcher("/AuthController/Twitch");
		}

			rd.forward(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}	
}


