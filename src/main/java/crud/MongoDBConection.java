package crud;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import utils.Constans;

/**
 * Created by lemuz on 4/12/16.
 */

public class MongoDBConection {

    private MongoClient mongoClient;
    private DB db;
    private DBCollection dbCollection;

    public void insert(BasicDBObject data, String nameCollection){

        mongoClient = new MongoClient();
        db = mongoClient.getDB(Constans.KEY_MONGODB);
        dbCollection = db.getCollection(nameCollection);
        dbCollection.insert(data);
        mongoClient.close();

    }

}
