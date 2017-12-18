package JSONParser;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Retriever {
    private String ulr;
    private HashMap<String, String> params;

    public Retriever(String ulr, HashMap<String, String> params) {
        this.ulr = ulr;
        this.params = params;
    }
    private String formURL(){
        String str = ulr + "?";
        for (String s : params.keySet()) {
            str += s + "=" + params.get(s) + "&";
        }
        str = str.substring(0, str.length() - 1);
        return str;
    }
    public String get() throws IOException{
        URL oracle = new URL(formURL());
        Scanner in = new Scanner(oracle.openStream());
        String inputLine = "";
        while (in.hasNextLine()){
            inputLine += in.nextLine();
        }
        return inputLine;
    }

}
