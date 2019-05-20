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
import aiss.model.youtube.CommentThreads;
import aiss.model.youtube.TopLevelComment;

/**
 * Servlet implementation class SearchController
 */
public class YoutubeAddCommentController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(YoutubeAddCommentController.class.getName());
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YoutubeAddCommentController() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		RequestDispatcher rd = null;
		String videoId = request.getParameter("videoId");
		String texto = request.getParameter("texto");
		
		CommentThreads nuevo = new CommentThreads();
		nuevo.getSnippet().setVideoId(videoId);
		TopLevelComment comment = nuevo.getSnippet().getTopLevelComment();
		comment.getSnippet().setTextOriginal(texto);
		nuevo.getSnippet().setTopLevelComment(comment);
		
		
		String accessToken = (String) request.getSession().getAttribute("Youtube-token");
		
		if (accessToken != null && !"".equals(accessToken)) {
			
			// Search for videos on youtube
			log.log(Level.FINE, "Adding comment with text" + texto);
			log.log(Level.FINE, "token" + accessToken);
			YoutubeResource youtube = new YoutubeResource(accessToken);
			CommentThreads res = youtube.insertTopComment(nuevo);
			
			if (res!=null){
				log.info("ok");
				//request.setAttribute("items", youtubeSearch.getItems());
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
