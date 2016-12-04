package utils;

/**
 * Created by lemuz on 4/12/16.
 */

public class RegularExpression {

    public boolean expression_FullName(String name){
        boolean result = false;
        if(name.matches("(([A-Z][a-z]*([á-ú]{1}[a-z]*)?[\\.]?)|(([Á-Ú])[a-z]+[\\.]?))(([\\s][A-Z][a-z]*([á-ú][a-z]*)?[\\.]?)|([\\s][Á-Ú][a-z]+[\\.]?))*")){
            result = true;
        }
        return result;
    }

    public boolean expression_address(String address){
        boolean result = false;

        if(address.matches("(([A-Z][a-z]*([á-ú]{1}[a-z]*)?[\\.]?)|(([Á-Ú])[a-z]+[\\.]?))(([\\s][\\#][1-9][0-9]*([\\-][A-Z])?))(([\\s][A-Z][a-z]*([á-ú][a-z]*)?[\\.]?)|([\\s][Á-Ú][a-z]+[\\.]?))*")){
            result = true;
        }
        return result;
    }

    public boolean expression_phone(String phone){
        boolean result = false;
        if(phone.matches("(\\d){3}(\\-)(\\d){3}(\\-)(\\d){2}(\\-)(\\d){2}")){
            result = true;
        }
        return result;
    }

    public boolean expression_email(String email){
        boolean result = false;
        if(email.matches("[A-Za-z0-9]+[\\_-]?[a-zA-Z0-9]+[\\@](hotmail|yahoo|gmail){1}+\\.[a-zA-Z]+")){
            result = true;
        }

        return result;
    }

}
