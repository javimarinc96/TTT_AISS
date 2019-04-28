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
		

		String part  =  request.getParameter("part");
		String query = request.getParameter("query");
		RequestDispatcher rd = null;
		
		// Search for videos in youtube
		log.log(Level.FINE, "Searching for videos with  part" + part + "with keyword" + query);
		YoutubeResource youtube = new YoutubeResource();
		Search youtubeResults = youtube.getVideos(part, query);

		if (youtubeResults!=null){
			rd = request.getRequestDispatcher("/success.jsp");
			request.setAttribute("items", youtubeResults.getItems());		
		} else {
			log.log(Level.SEVERE, "Youtube object: " + youtubeResults);
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
