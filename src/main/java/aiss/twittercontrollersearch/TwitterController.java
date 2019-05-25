package aiss.twittercontrollersearch;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.twitter.SearchMetadata;
import aiss.model.twitter.Tweet;
import aiss.resource.Twitter.TwitterResource;

/**
 * Servlet implementation class SearchController
 */
public class TwitterController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
       
	private static final Logger log = Logger.getLogger(TwitterController.class.getName());
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TwitterController() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		RequestDispatcher rd = null;
		String query = request.getParameter("query");
		String accessToken = (String) request.getSession().getAttribute("Twitter-token");
		System.out.println(accessToken);
		
		if (accessToken != null && !"".equals(accessToken)) {
			
			// Search
			log.log(Level.FINE, "Searching for" + query);
			log.log(Level.FINE, "token" + accessToken);
			TwitterResource tw = new TwitterResource(accessToken);
			Tweet Searcht = tw.getSearch(query);	
			
			
		if (Searcht!=null){
				log.info("The files returned are null... probably your token has experied. Redirecting to OAuth servlet.");
				request.setAttribute("Contiene:", Searcht.getEntities());
				rd = request.getRequestDispatcher("/success.jsp");
		} else {
				log.info("The files returned are null... probably your token has experied. Redirecting to OAuth servlet.");
				rd = request.getRequestDispatcher("/AuthController/Twitter");}
		} else {
			log.info("The files returned are null... probably your token has experied. Redirecting to OAuth servlet.");
			rd = request.getRequestDispatcher("/AuthController/Twitter");
	}
		
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
