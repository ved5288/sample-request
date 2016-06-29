/**
 * Created by vedant on 28/6/16.
 */
import com.google.gson.Gson;
import com.project.Hasura;
import static com.project.db.Tables.USERS;
import com.project.db.tables.records.UsersRecord;
import com.project.jsonResponse;
import com.project.GetExample;
import static spark.Spark.*;
import com.project.db.tables.Users;
import io.hasura.db.DBException;
import io.hasura.db.SelectQuery;
import java.util.List;
import io.hasura.core.Callback;

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

        Hasura.setCurrentSession(<User-Id>,<User-role>,<adminAPIKey>);

        get("/use-hasura-insert", ((request, response) -> {
            try {

                 Hasura.db.insert(USERS)
                        .set(USERS.USER_ID,insert-user_id)
                        .set(USERS.USERNAME,insert-username)
                        .build().execute();
                return ("Successfully Inserted !");
            }
            catch (DBException e) {
                e.printStackTrace();
                return (e.toString());
            }
        }));

        get("/use-hasura-select" ,((request,response) -> {
            try {
                List<UsersRecord> users = Hasura.db.select(USERS)
                        .columns(USERS.USER_ID,USERS.USERNAME)
                        .build().execute();
                return "Select Query Executed";
            }
            catch (DBException e){
                e.printStackTrace();
                return "Error in making the query !";
            }
        }));
    }
}
