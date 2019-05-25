package aiss.resource.Twitter;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.data.Header;
import org.restlet.resource.ClientResource;
import org.restlet.util.Series;


import aiss.model.twitter.Tweet;

public class TwitterResource {


	private static final Logger log = Logger.getLogger(TwitterResource.class.getName());
	private final String access_token;
    private final String uri = "https://api.twitter.com/1.1/search/tweets.json?q=";
	
	
    public TwitterResource(String access_token) {
        this.access_token = "1122553569545207808-Xq6ad1wNPZritYK4hF6DCeFEcZI6jf";
    }
	
    
    
	public Tweet getSearch(String query) throws UnsupportedEncodingException {

		String query2 = URLEncoder.encode(query,"UTF-8");
		log.log(Level.FINE, "busqueda: ", query);
		log.log(Level.FINE, "token: ", this.access_token); 
		log.log(Level.FINE, "Twitter: ", uri+query);
		 ClientResource cr = null;
	        Tweet file = null;
	            cr = new ClientResource(uri + query2);
	            
	    		Series<Header> header = (Series<Header>) cr.getRequestAttributes().get("org.restlet.http.headers");
	    		if (header == null) {
	    			header = new Series<Header>(Header.class);
	    		    cr.getRequestAttributes().put("org.restlet.http.headers", header);
	    		}
	    		
	    		header.set("Authorization" , "Bearer" + access_token);
	    		
	            file = cr.get(Tweet.class);
	           
	        return file;

	}
}
