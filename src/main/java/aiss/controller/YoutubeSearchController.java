package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import aiss.model.resources.YoutubeResource;
import aiss.model.youtube.Search;

/**
 * Servlet implementation class SearchController
 */
public class YoutubeSearchController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
       
	private static final Logger log = Logger.getLogger(YoutubeSearchController.class.getName());
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YoutubeSearchController() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		RequestDispatcher rd = null;
		String query = request.getParameter("query");
		System.out.println(query);
		
		String accessToken = (String) request.getSession().getAttribute("Youtube-token");
		
		if (accessToken != null && !"".equals(accessToken)) {
			
			// Search for videos on youtube
			log.log(Level.FINE, "Searching for videos with keyword" + query);
			log.log(Level.FINE, "token" + accessToken);
			YoutubeResource youtube = new YoutubeResource(accessToken);
			Search youtubeSearch = youtube.getSearch(query);
			
			if (youtubeSearch!=null){
				log.info("The files returned are null... probably your token has experied. Redirecting to OAuth servlet.");
				request.setAttribute("items", youtubeSearch.getItems());
				rd = request.getRequestDispatcher("/success.jsp");
			} else {
				log.info("The files returned are null... probably your token has experied. Redirecting to OAuth servlet.");
				rd = request.getRequestDispatcher("/AuthController/Youtube");
			}
			
		}else{
			 log.info("Trying to access Google Drive without an access token, redirecting to OAuth servlet");
			 rd = request.getRequestDispatcher("/AuthController/Youtube");
		}
		
		rd.forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
