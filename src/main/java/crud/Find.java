package crud;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import model.User;

/**
 * Created by lemuz on 4/12/16.
 */

public class Find {

    public boolean findUserLogin(User u){

        boolean success=false;
        BasicDBObject jquery = new BasicDBObject();
        jquery.put("username",u.getUsername());
        MongoDBConection mongoDBConection = new MongoDBConection();
        DBObject user = mongoDBConection.find(jquery,"users");

        if(user != null){
            if(user.get("username").equals(u.getUsername())){
                if(user.get("password").equals(u.getPassword())){
                    success = true;
                }
            }
        }

        return success;
    }

}
