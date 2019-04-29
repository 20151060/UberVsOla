/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author rohanarora
 */
import java.util.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
 import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class uberApi {
    private final String USER_AGENT = "Mozilla/5.0";
   
    public ArrayList<rideInfo> getPrice(String slat, String slog , String elat, String elog) throws Exception{
    //String url = "https://api.lyft.com/v1/eta?lat=37.7833&lng=-122.4167"/*"https://api.uber.com/v1.2/estimates/price?start_latitude=37.7752315&start_longitude=-122.418075&end_latitude=37.7752415&end_longitude=-122.518075" /*"http://www.google.com/search?q=rahul+dravid"*/;
		//String slat1 = Double.toString(slat);
                //String slog1 = Double.toString(slog);
                //String elat1 = Double.toString(elat);
                //String elog1 = Double.toString(elog);       
    String url = "https://api.uber.com/v1.2/estimates/price?start_latitude=" + slat + "&start_longitude=" + slog + "&end_latitude=" + elat + "&end_longitude=" + elog + "";
		URL obj = new URL(url);
                //URL obj1 = new URL(url1);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                //HttpURLConnection con1 = (HttpURLConnection) obj1.openConnection();
		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		//con.setRequestProperty("User-Agent", USER_AGENT);
                //con.setRequestProperty("Authorization", "Bearer gNpCOOmiKsFcSpw9G0Sfe0Ap72vQMCBoJKscbIJs408Pnbnd6J+ilM7tZqi3v33iejAJfPwNLTHwqTyCnSdygazBoKHqb3Ssw/RvmtBRZ5gws6ZS8rAGY2w=" /*"5lUuTIfyhHdcWTLxe5WLRA2ff8XtTJpcaBoz5UUB"*/); 
                
                con.setRequestProperty("User-Agent", USER_AGENT);
                con.setRequestProperty("Authorization", /*"Bearer gNpCOOmiKsFcSpw9G0Sfe0Ap72vQMCBoJKscbIJs408Pnbnd6J+ilM7tZqi3v33iejAJfPwNLTHwqTyCnSdygazBoKHqb3Ssw/RvmtBRZ5gws6ZS8rAGY2w=" */"Token 5lUuTIfyhHdcWTLxe5WLRA2ff8XtTJpcaBoz5UUB"); 
		
                int responseCode = con.getResponseCode();
                //int responseCode1 = con1.getResponseCode();
                
		//System.out.println("\nSending 'GET' request to URL : " + url);
		//System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
                
                /*System.out.println("\nSending 'GET' request to URL : " + url1);
		System.out.println("Response Code : " + responseCode1);

		BufferedReader in1 = new BufferedReader(
		        new InputStreamReader(con1.getInputStream()));
		String inputLine1;
		StringBuffer response1 = new StringBuffer();

		while ((inputLine1 = in1.readLine()) != null) {
			response1.append(inputLine1);
		}
		in1.close();*/

		//print result
		 String x = response.toString() ;
                 ArrayList<rideInfo> arr = jsonParser(x);
                 return arr;
                 /*Iterator itr = arr.iterator();
                 while(itr.hasNext()){
                     rideInfo r = (rideInfo) itr.next();
                 System.out.println(r.getrideType() + " : " + r.getprice());
                 }*/
                 //String y = response1.toString();
                 //String z = "                                     ";
                 //return x +"<br>"+ y ;
	
    }
    
    private ArrayList<rideInfo> jsonParser(String x) {
      ArrayList<rideInfo> arr = new ArrayList<rideInfo>();
        try {
            Object obj;
            //System.out.println(x);
            obj = new JSONParser().parse(x);
            
            JSONObject jo = (JSONObject) obj;
            JSONArray ja = (JSONArray) jo.get("prices");
            
            for(int i=0;i<ja.size();i++)
{
   JSONObject jo1 = (JSONObject)ja.get(i);
    String s = (String) jo1.get("localized_display_name");
    String y = (String) jo1.get("estimate");
    rideInfo r = new rideInfo(s,y);
    arr.add(r);
}
            
        } catch (ParseException ex) {
            Logger.getLogger(uberApi.class.getName()).log(Level.SEVERE, null, ex);
        }
     return arr;   
    }
}

