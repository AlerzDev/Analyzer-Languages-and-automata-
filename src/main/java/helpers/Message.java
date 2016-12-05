package helpers;

/**
 * Created by lemuz on 4/12/16.
 */
public class Message {

    private static Message instance;

    private String message;
    private String result;
    private String error;

    public static Message getInstance() {
        if (instance == null) {
            instance = new Message();
        }
        return instance;
    }

    public static void setInstance(Message instance) {
        Message.instance = instance;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
