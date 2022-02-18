package src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class decode {

    URL url;
    JSONParser parser = new JSONParser();

    public Vector<String> homeTeams = new Vector<String>();
    public Vector<String> awayTeams = new Vector<String>();

    public Map<String, Float> h2h = new LinkedHashMap<String, Float>();
    public Map<String, Float[]> spread = new LinkedHashMap<String, Float[]>();
    public Map<String, Float[]> totals = new LinkedHashMap<String, Float[]>();
    
    public static void main(String[] args) throws Exception{
        decode p = new decode("https://api.the-odds-api.com/v4/sports/basketball_nba/odds/?apiKey=5081c089e598260629a5e8f81e9eccca&regions=us&markets=h2h,spreads,totals&oddsFormat=american");
    }

    public decode(String str) throws Exception{
        try{
            url = new URL(str);
            URLConnection yc = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

            String inputLine;
            while((inputLine = in.readLine()) != null){
                JSONArray a = (JSONArray) parser.parse(inputLine);
                for(Object g : a){
                    JSONObject game = (JSONObject) g;

                    // Vector of team names
                    homeTeams.add((String) game.get("home_team"));
                    awayTeams.add((String) game.get("away_team"));
                    
                    // Access "bookmakers" array
                    JSONArray b = (JSONArray) game.get("bookmakers");
                    for(Object c : b){
                        // Access specific books
                        JSONObject books = (JSONObject) c;
                        // Select only the fanduel book
                        if("fanduel".equals((String) books.get("key"))){
                            JSONArray markets = (JSONArray) books.get("markets");
                            // Loop through the three markets, h2h, spread, totals
                            for(Object m : markets){
                                // Select each market
                                JSONObject types = (JSONObject) m;
                                // If the market is h2h
                                if("h2h".equals((String) types.get("key"))){
                                    JSONArray outcomes = (JSONArray) types.get("outcomes");
                                    // Add each team and their odds to win in the h2h list.
                                    for(Object o : outcomes){
                                        JSONObject odds = (JSONObject) o;

                                        h2h.put((String) odds.get("name"), ((Number) odds.get("price")).floatValue()); 
                                    }
                                }
                                // If the market is spread
                                if("spreads".equals((String) types.get("key"))){
                                    JSONArray outcomes = (JSONArray) types.get("outcomes");
                                    // Get each team and their spread amount and price
                                    for(Object o : outcomes){
                                        JSONObject odds = (JSONObject) o;

                                        Float price = ((Number) odds.get("price")).floatValue();
                                        Float point = ((Number) odds.get("point")).floatValue();

                                        Float[] pp = {price, point};

                                        spread.put((String) odds.get("name"), pp);
                                    }
                                }
                                // If the market is totals
                                if("totals".equals((String) types.get("key"))){
                                    JSONArray outcomes = (JSONArray) types.get("outcomes");
                                    // Get each over under in the same order
                                    for(Object o : outcomes){
                                        JSONObject odds = (JSONObject) o;

                                        Float price = ((Number) odds.get("price")).floatValue();
                                        Float point = ((Number) odds.get("point")).floatValue();

                                        Float[] pp = {price, point};

                                        totals.put((String) odds.get("name") + game.get("home_team"), pp);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            in.close();
            System.out.println(h2h);
            System.out.println(spread);
            System.out.println(totals);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }  
    }
}
