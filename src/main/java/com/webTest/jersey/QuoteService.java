package main.java.com.webTest.jersey;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

/**
 * Quote service
 * 
 * @author workbook
 *
 */
@Path("/quote")
public class QuoteService {

	// TODO : implement a logger
	// private static final Logger LOGGER = LoggerFactory.getLogger(QuoteService.class);
	private static Map<String, String> quoteByAuthor = null;

	/**
	 * Return a quote from the author past in parameter
	 * 
	 * @param author
	 * @return
	 */
	@Path("{author}")
	@GET
	@Produces("application/json")
	public Response getQuoteFromParameter(@PathParam("author") String author) {
		String quote = null;
		loadCitations();
		Set<String> keySet = quoteByAuthor.keySet();
		if (keySet.contains(author.toLowerCase())) {
			quote = quoteByAuthor.get(author);
		}
		JSONObject json = new JSONObject();
		json.put("author", author);
		json.put("quote", quote);

		String result = "getQuoteService output : \n\n" + author + " : " + json;

		return Response.status(200).entity(result).build();
	}

	/**
	 * TODO : move this in a mongoDB after
	 */
	public void loadCitations() {
		if (quoteByAuthor == null) {
			quoteByAuthor = new HashMap<String, String>();
			quoteByAuthor.put("hugo", "Il vient une heure ou protester ne suffit plus, apres la phylosophie, il faut laction");
			quoteByAuthor.put("verlaine", "Elle ne savait pas que lEnfer c'est l'absence");
		}
	}
}
