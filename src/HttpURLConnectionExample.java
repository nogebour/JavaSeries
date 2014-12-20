import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class HttpURLConnectionExample {

	private final String USER_AGENT = "NogebourJavaApi/0.1";

	public static void main(String[] args) throws Exception {

		HttpURLConnectionExample http = new HttpURLConnectionExample();

		System.out.println("Testing 1 - Send Http GET request");
		http.sendGet("http://www.google.com/search?q=mkyong", null, false);

		System.out.println("\nTesting 2 - Send Http POST request");
		http.sendPost("https://selfsolve.apple.com/wcResults.do", "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345", true);

		System.out.println("\nTesting 3 - Send Http POST request to BetaSeries");
		http.connectBetaseriesAPI();

	}

	// HTTP GET request
	public String sendGet(String url, String urlParam, boolean https) throws Exception {
		String response = null;
		if(https)
		{
			response = sendSecureRequest(url, RequestType.GET, urlParam);
		}else{
			response = sendRequest(url, RequestType.GET, urlParam);
		}
		System.out.println(response);
		return response;
	}

	// HTTP POST request
	private String sendPost(String url, String urlParam, boolean https) throws Exception {
		String response = null;
		if(https)
		{
			response = sendSecureRequest(url, RequestType.POST, urlParam);
		}else{
			response = sendRequest(url, RequestType.POST, urlParam);
		}
		System.out.println(response);
		return response;
	}

	private String sendRequest(String url, RequestType post,
			String urlParameters) throws MalformedURLException, IOException,
			ProtocolException {
		URL obj = new URL(url);
		
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		return request(url, post, urlParameters, con);
	}
	
	private String sendSecureRequest(String url, RequestType post,
			String urlParameters) throws MalformedURLException, IOException,
			ProtocolException {
		URL obj = new URL(url);
		
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		return request(url, post, urlParameters, con);
	}

	private String request(String url, RequestType typeReq, String urlParameters,
			HttpURLConnection con) throws ProtocolException, IOException {
		//add reuqest header
		con.setRequestMethod(typeReq.getValue());
		con.setRequestProperty("User-Agent", USER_AGENT);

		if(typeReq == RequestType.POST && urlParameters != null){
			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();			
		}

		int responseCode = con.getResponseCode();
		System.out.println("\nSending '"+typeReq.getValue()+"' request to URL : " + url);
		System.out.println("URL parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		con.disconnect();
		return response.toString();
	}
	
	// HTTP POST request
	private void connectBetaseriesAPI() throws Exception {

		String url = "https://api.betaseries.com/members/auth";
		String urlParameters = "key=a71be26370dc&v=2.2&login=nogebour&password=";
		boolean https = true;
		String response = this.sendPost(url, urlParameters, https);

		JSONParser parserJSON = new JSONParser();
		Object jsonRes = parserJSON.parse(response);
		if (jsonRes.getClass() == JSONObject.class)
		{
			JSONObject objRes = ((JSONObject) jsonRes);
			String token = ((String) objRes.get("token"));
			System.out.println("token : "+token);
		}
	}
	
	private static enum RequestType {
        POST("POST"),
        DELETE("DELETE"),
        GET("GET");

        private final String value;

        RequestType(String value) {
            this.value = value;
        }

        String getValue() {
            return value;
        }
    }

}