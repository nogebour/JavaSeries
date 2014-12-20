package brequest;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpURLConnectionImpl {

	private final String USER_AGENT = "NogebourJavaApi/0.1";

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
	public String sendPost(String url, String urlParam, boolean https) throws Exception {
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
		return request(url, post, urlParameters, false);
	}
	
	private String sendSecureRequest(String url, RequestType post,
			String urlParameters) throws MalformedURLException, IOException,
			ProtocolException {
		return request(url, post, urlParameters, true);
	}

	private String request(String url, RequestType typeReq, String urlParameters,
			boolean isSecure) throws ProtocolException, IOException {
		URL obj = new URL(url);
		if(typeReq == RequestType.GET && urlParameters != null){
			obj = new URL(url+"?"+urlParameters);
		}
		HttpURLConnection con = null;
		if(isSecure){
			con = (HttpsURLConnection) obj.openConnection();
		}else{
			con = (HttpURLConnection) obj.openConnection();
		}

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