package za.co.enigma.schools.business.activity.boundary;

import java.net.URI;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;

import za.co.enigma.schools.business.activity.control.ActivityManager;
import za.co.enigma.schools.business.activity.entity.Activity;

@Stateless
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Path("activity")
public class ActivityResource {

	private ActivityManager activityManager;
	
	public ActivityResource() {}

/*    @Inject
    Logger tracer;*/
    
	@Inject
	public ActivityResource(ActivityManager activityManager) {
		this.activityManager = activityManager;
	}
	

    @POST
    public Response create(Activity request, @Context UriInfo info, 
    		@HeaderParam("tenant") String tenant,
    		@HeaderParam("user-agent") String userAgent) {
    	request.setTenant(Integer.valueOf(tenant));
    	System.out.println(userAgent);
    	JsonObject activity = activityManager.create(request);
        long id = activity.getInt(activityManager.CONFIRMATION_ID);
        URI uri = info.getAbsolutePathBuilder().path("/" + id).build();
        return Response.created(uri).entity(activity).build();
    }
	

    @GET
    @Path("{id}")
    public Response find(@PathParam("id") long activityId,@HeaderParam("tenant") String tenant,
    		@HeaderParam("user-agent") String userAgent) {
    	JsonObject activity =  activityManager.findActivity(activityId);
    	System.out.println(userAgent);
    	return Response.ok(activity).build();
    }
    
    @GET
    @Path("/ip")
 //   @Produces(MediaType.TEXT_PLAIN)
    public Response getIp(@Context HttpServletRequest req) {
        String remoteHost = req.getRemoteHost();
        String remoteAddr = req.getRemoteAddr();
        int remotePort = req.getRemotePort();
        String msg = remoteHost + " (" + remoteAddr + ":" + remotePort + ")";
        return Response.ok(msg).build();
    }
}
