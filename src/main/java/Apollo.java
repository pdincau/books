import com.spotify.apollo.Environment;
import com.spotify.apollo.httpservice.HttpService;
import com.spotify.apollo.httpservice.LoadingException;
import com.spotify.apollo.route.Route;

public class Apollo {

    public static void main(String[] args) throws LoadingException {
        HttpService.boot(Apollo::init, "apollo", args);
    }

    static void init(Environment environment) {
        environment.routingEngine()
                .registerAutoRoute(Route.sync("GET", "/", context -> "hello world"))
                .registerAutoRoute(Route.sync("GET", "/hello", context -> "bye"));
    }
}
