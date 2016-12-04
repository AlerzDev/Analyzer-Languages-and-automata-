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
        document.put("password",user.getPassword());
        document.put("fullName",user.getFullName());
        document.put("phone",user.getTel());
        document.put("email",user.getEmail());
        document.put("address",user.getAddress());
        mongoDBConection.insert(document, Constans.KEY_COLLECTION_USERS);

    }

}
