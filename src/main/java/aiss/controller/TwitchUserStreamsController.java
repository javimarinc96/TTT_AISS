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
import aiss.model.twitch.Streams;

/**
 * Servlet implementation class StreamsController
 */
public class TwitchUserStreamsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(TwitchGameStreamsController.class.getName());

	/**
     * @see HttpServlet#HttpServlet()
     */
    public TwitchUserStreamsController() {
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
    	
    	String accessToken = (String) request.getSession().getAttribute("twitch-token");
    	
    	if (accessToken != null && !"".equals(accessToken)) {
    	// Search for user streams on Twitch
    	log.log(Level.FINE, "Searching for user streams" + query);
    	log.log(Level.FINE, "token" + accessToken);
    	TwitchResource Twitch=new TwitchResource(accessToken);
    	Streams TwitchUserSearch = Twitch.getUserStream(query);

    	if (TwitchUserSearch != null) {
    			log.info("");
				request.setAttribute("data", TwitchUserSearch.getData());
				rd = request.getRequestDispatcher("/Usersuccess.jsp");
			} else {
				log.info("The files returned are null... probably your token has experied. Redirecting to OAuth servlet.");
				rd = request.getRequestDispatcher("/AuthController/Twitch");
			}
    	}else{
			 log.info("Trying to access Twitch without an access token, redirecting to OAuth servlet");
			 rd = request.getRequestDispatcher("/AuthController/Twitch");
		}

			rd.forward(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}	
}


