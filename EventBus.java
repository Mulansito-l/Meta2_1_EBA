import java.util.ArrayList;
import java.util.HashMap;

/**
 * EventBus
 */
public class EventBus {
    private static volatile ArrayList<Event> events = new ArrayList<Event>(); 
    private static HashMap<Class<? extends Event>, ArrayList<Consumer>> subscriptions = new HashMap<Class<? extends Event>,ArrayList<Consumer>>();

    public static void publish(Event e){
        events.add(e);
    }

    public static boolean subscribe(Consumer c, Class<? extends Event> e){
        if(subscriptions.get(e) == null)
            subscriptions.put(e, new ArrayList<Consumer>());

        if(subscriptions.get(e).contains(c))
            return false;

        subscriptions.get(e).add(c);
        System.out.println("Subscribed consumer: " + c + " to event: " + e.getName());
        return true;
    }

    public static void dispatch(){
        while (events.iterator().hasNext()) {
            Event event = events.iterator().next();
            for (Consumer c: subscriptions.get(event.getClass())) {
                c.handle(event); 
            }
            events.remove(event);
        }
    }
}
