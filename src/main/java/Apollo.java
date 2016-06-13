import actions.RateBook;
import actions.BooksActiondHandler;
import com.spotify.apollo.Environment;
import com.spotify.apollo.RequestContext;
import com.spotify.apollo.Response;
import com.spotify.apollo.Status;
import com.spotify.apollo.httpservice.HttpService;
import com.spotify.apollo.httpservice.LoadingException;
import com.spotify.apollo.route.Route;
import okio.ByteString;


public class Apollo {

    private static BooksActiondHandler actiondHandler = new BooksActiondHandler();

    public static void main(String[] args) throws LoadingException {
        HttpService.boot(Apollo::init, "apollo", args);
    }

    static void init(Environment environment) {
        environment.routingEngine()
                .registerAutoRoute(Route.sync("GET", "/books/1/rate", Apollo::rateBook));
    }

    private static Response<ByteString> rateBook(RequestContext context)  {
        actiondHandler.handle(new RateBook("a book id", "a description", 5, "a user id"));
        return Response.forStatus(Status.CREATED);
    }
}
