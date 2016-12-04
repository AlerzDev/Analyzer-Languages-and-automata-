package crud;

import com.mongodb.BasicDBObject;
import model.User;
import utils.Constans;

/**
 * Created by lemuz on 4/12/16.
 */

public class Insert {

    public void insertUser(User user){

        MongoDBConection mongoDBConection = new MongoDBConection();
        BasicDBObject document = new BasicDBObject();
        document.put("username",user.getUsername());
        document.put("password",user.getUsername());
        document.put("fullName",user.getUsername());
        document.put("phone",user.getUsername());
        document.put("email",user.getUsername());
        document.put("address",user.getUsername());
        mongoDBConection.insert(document, Constans.KEY_COLLECTION_USERS);

    }

}
