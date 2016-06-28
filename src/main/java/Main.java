/**
 * Created by vedant on 28/6/16.
 */
import com.google.gson.Gson;
import com.project.jsonResponse;
import com.project.GetExample;
import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {

        get("/test-json", ((request,response) -> {
            Gson gson = new Gson();
            jsonResponse response1 = new jsonResponse();
            response1.setResponse("Hello World !");
            return gson.toJson(response1);
        }));

        get("/test-get", ((request, response) -> {
            GetExample example_request = new GetExample();
            return example_request.run("http://localhost:4567/test-json");
        }));
    }
}
