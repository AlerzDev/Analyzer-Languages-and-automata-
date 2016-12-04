package crud;

import com.mongodb.*;
import utils.Constans;

/**
 * Created by lemuz on 4/12/16.
 */

class MongoDBConection {

    private MongoClient mongoClient;
    private DB db;
    private DBCollection dbCollection;

    void insert(BasicDBObject data, String nameCollection){

        mongoClient = new MongoClient();
        db = mongoClient.getDB(Constans.KEY_MONGODB);
        dbCollection = db.getCollection(nameCollection);
        dbCollection.insert(data);
        mongoClient.close();

    }

     DBObject find(BasicDBObject findJquery, String nameCollection) {

        mongoClient = new MongoClient();
        db = mongoClient.getDB(Constans.KEY_MONGODB);
        dbCollection = db.getCollection(nameCollection);
        DBObject data = dbCollection.findOne(findJquery);
        mongoClient.close();
        return data;

    }

}
