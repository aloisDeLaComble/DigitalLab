package JSON;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import mySQL.MySQLProject;
import pojos.Project;

@Path("/projects")
public class JSONProject {

		  @Context
		  UriInfo uriInfo;
		  @Context
		  Request request;
		  
		  
		  @GET
		  @Produces(MediaType.APPLICATION_JSON)
		  public Response DisplayProjects() {
				ResponseBuilder response = Response.ok().entity(MySQLProject.GetLastProject());
				Response ret = makeCORS(response);
				return ret;
			  //return MySQLProject.GetLastProject();
		  }
		  
		  private Response makeCORS(ResponseBuilder req) {
			   ResponseBuilder rb = req
					   .header("Access-Control-Allow-Origin", "*")
					   .header("Access-Control-Allow-Methods", "GET, POST, OPTIONS")
					   .header("Access-Control-Allow-Headers", "content-type");
			   return rb.build();
			}
		  
		  
	
}
