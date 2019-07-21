package one.jamaa.appjamaa.utils;

import android.app.Application;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;

import io.kuzzle.sdk.core.Kuzzle;
import io.kuzzle.sdk.core.Collection;
import io.kuzzle.sdk.core.Document;
import io.kuzzle.sdk.core.Room;
import io.kuzzle.sdk.enums.Event;
import io.kuzzle.sdk.listeners.EventListener;
import io.kuzzle.sdk.listeners.ResponseListener;
import io.kuzzle.sdk.responses.NotificationResponse;
import io.kuzzle.sdk.responses.SearchResult;
import io.kuzzle.sdk.security.User;
import one.jamaa.appjamaa.R;


public class ServerModule extends Application {

    Kuzzle serverDB;

    public void initLogin() {
        try {


            final JSONObject credentials = new JSONObject();
            credentials.put("username", getString(R.string.uidlog)).put("password", getString(R.string.plog));
            final int expiresIn = 60 * 60 * 1000;//token expires in 1 hour

            //Instantiate and connect to Server Backend DB
            serverDB = new Kuzzle(getString(R.string.server_url), new ResponseListener<Void>() {
                @Override
                public void onSuccess(Void object) {
                    // invoked once connected, object contains the kuzzle instance
                    serverDB.login("local", credentials, expiresIn);
                }
                @Override
                public void onError(JSONObject error) {
                    // Handle connection error
                }
            });


        }catch (Exception e) {
            //handleError(e);
        }
    }




    public void createUser(String username,String password){
        try {
            JSONObject userContent = new JSONObject()
                    // A "profile" field is required to bind a user to an existing profile
                    .put("profileIds", new JSONArray().put("default"))
                    .put("username",username)
                    // The "local" authentication strategy requires a password
                    //.put("password", password)
                    // You can also set custom fields to your user
                    .put("email", username);

            // Using the KuzzleSecurity factory:
            User user = serverDB.security.user(username, userContent);

            JSONObject
                    strategyCredentials = new JSONObject().put("username", username).put("password",password),
                    credentials = new JSONObject().put("local", strategyCredentials);
            user.setCredentials(credentials);


            user.create(new ResponseListener<User>() {
                @Override
                public void onSuccess(User user) {
                    Toast.makeText(getApplicationContext(),"Successful User registration",Toast.LENGTH_SHORT).show();
                }
                @Override
                public void onError(JSONObject error) {
                    Toast.makeText(getApplicationContext(),"Error during registration!",Toast.LENGTH_SHORT).show();
                }
            });

        }
        catch (Exception e){

        }

    }

}
