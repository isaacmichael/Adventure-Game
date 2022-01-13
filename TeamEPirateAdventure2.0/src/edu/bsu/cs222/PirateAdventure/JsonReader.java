package edu.bsu.cs222.PirateAdventure;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

@SuppressWarnings("rawtypes")
public class JsonReader
{
//methods
public String readJsonFile(String SceneNumber) throws IOException, ParseException
    {
         Object obj = new JSONParser().parse(new FileReader("Scenes.json"));

         String y = "Scene";
         String z = y + SceneNumber;

         JSONObject jsonObject = (JSONObject) obj;
         JSONArray jsonArray = (JSONArray) jsonObject.get(z);

         Iterator itr2;
         itr2 = jsonArray.iterator();

        while(itr2.hasNext()){
            for (Object o : ((Map) itr2.next()).entrySet()) {
                Map.Entry pair = (Map.Entry) o;
                return ("    " + pair.getValue());
            }
        }
         return y;
     }
    public String readSeaJsonFile(String SceneNumber) throws IOException, ParseException
    {
        Object obj = new JSONParser().parse(new FileReader("SeaMapScenes.json"));

        String y = "Scene";
        String z = y + SceneNumber;

        JSONObject jsonObject = (JSONObject) obj;
        JSONArray jsonArray = (JSONArray) jsonObject.get(z);

        Iterator itr2;
        itr2 = jsonArray.iterator();

        while(itr2.hasNext()){
            for (Object o : ((Map) itr2.next()).entrySet()) {
                Map.Entry pair = (Map.Entry) o;
                return ("    " + pair.getValue());
            }
        }
        return y;
    }
    public String readStoryJsonFile(String SceneNumber) throws IOException, ParseException
    {
        Object obj = new JSONParser().parse(new FileReader("storylines.json"));

        String y = "Scene";
        String z = y + SceneNumber;

        JSONObject jsonObject = (JSONObject) obj;
        JSONArray jsonArray = (JSONArray) jsonObject.get(z);

        Iterator itr2;
        itr2 = jsonArray.iterator();

        while(itr2.hasNext()){
            for (Object o : ((Map) itr2.next()).entrySet()) {
                Map.Entry pair = (Map.Entry) o;
                return ("    " + pair.getValue());
            }
        }
        return y;
    }
}
