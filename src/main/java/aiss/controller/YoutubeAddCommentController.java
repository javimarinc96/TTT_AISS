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
import aiss.model.youtube.SnippetThread;
import aiss.model.youtube.SnippetTopLevelComment;
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
		
		System.out.println("ID DEL VIDEO:" +videoId);
		System.out.println("TEXTO:" + texto);
		
		CommentThreads nuevo = new CommentThreads();
		SnippetThread snippetTh = new SnippetThread();
		TopLevelComment topcom = new TopLevelComment();
		SnippetTopLevelComment snip2 = new SnippetTopLevelComment();
		
		//setear videoID
		snippetTh.setVideoId(videoId);
		//setear texto original
		snip2.setTextOriginal(texto);
		topcom.setSnippet(snip2);
		snippetTh.setTopLevelComment(topcom);
		//Setear todo al nuevo comment thread
		nuevo.setSnippet(snippetTh);
		
		String accessToken = (String) request.getSession().getAttribute("YouTube-token");
		
		if (accessToken != null && !"".equals(accessToken)) {
			
			// Search for videos on youtube
			log.log(Level.FINE, "Adding comment with text" + texto);
			log.log(Level.FINE, "token" + accessToken);
			YoutubeResource youtube = new YoutubeResource(accessToken);
			CommentThreads res = youtube.insertTopComment(nuevo);
			
			if (res!=null){
				log.info("Comentario creado correctamente");
				request.setAttribute("message", "Comentario añadido correctamente");
				rd = request.getRequestDispatcher("/index.jsp");
			} else {
				log.info("The files returned are null... probably your token has experied. Redirecting to OAuth servlet.");
				rd = request.getRequestDispatcher("/AuthController/YouTube");
			}
			
		}else{
			 log.info("Trying to access Youtube without an access token, redirecting to OAuth servlet");
			 rd = request.getRequestDispatcher("/AuthController/YouTube");
		}
		
		rd.forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
