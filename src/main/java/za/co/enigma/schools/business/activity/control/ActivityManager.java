package za.co.enigma.schools.business.activity.control;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collector;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;

import za.co.enigma.schools.business.activity.dao.ActivityDAO;
import za.co.enigma.schools.business.activity.entity.Activity;

@Stateless
public class ActivityManager {

	public static final String CONFIRMATION_ID = "confirmation-id";

/*	@Inject
	Logger tracer;*/

	private ActivityDAO activityDAO;

	public ActivityManager() {}

	@Inject
	public ActivityManager (ActivityDAO activityDAO) {
		this.activityDAO = activityDAO;
	}

	public JsonObject create(Activity request) {
	//	tracer.info("activity to created received: " + request);
		Activity activity = activityDAO.create(request);
	//	tracer.info("activity stored: " + request);
		
		return convert(activity);
	}

	public List<Activity> all(){
		return activityDAO.findWithNamedQuery(Activity.findAll);
	}

    public JsonArray allAsJson() {
        Collector<JsonObject, ?, JsonArrayBuilder> jsonCollector
                = Collector.of(Json::createArrayBuilder, JsonArrayBuilder::add,
                        (left, right) -> {
                            left.add(right);
                            return left;
                        });
        return all().stream().map(this::convert).
                collect(jsonCollector).build();

    }
    
    /**
     * Because the application only offers JAX-RS endpoint and may offer
     * WebSockets in the future, the conversion from domain objects (entities)
     * to JsonObjects happens in the protocol-neutral boundary.
     *
     * You could also convert entities into JsonObject in the JAX-RS / WebSocket
     * endpoints in case you need the domain objects for a serverside Java web
     * framework.
     */
    JsonObject convert(Activity activity) {
        return Json.createObjectBuilder().
                add("name", activity.getName()).
                add(CONFIRMATION_ID, activity.getId()).build();
    }

	public JsonObject findActivity(long activityId) {
		Activity activity = activityDAO.findById(activityId);
		return convert(activity);
	}
}
