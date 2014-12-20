package jsontobom;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import bom.BSMember;
import brequest.BetaSeriesReq;

public class ConvJToB {

	public void getUserConnectionInfos(BSMember member) throws Exception{
		BetaSeriesReq bsReq = new BetaSeriesReq();
		String response = bsReq.connectBetaseriesAPI(member);
		JSONParser parserJSON = new JSONParser();
		Object jsonRes = parserJSON.parse(response);
		if (jsonRes.getClass() == JSONObject.class)
		{
			JSONObject objRes = ((JSONObject) jsonRes);
			String token = extractString(objRes,"token");
			System.out.println("token : "+token);
			member.setToken(token);
			JSONObject objUser = extractJSONObject(objRes, "user");
			long userId = extractLong(objUser, "id");
			System.out.println("userId : "+userId);
			member.setUserId(userId);
		}

	}

	private String extractString(JSONObject objRes, String key) {
		return (String) objRes.get(key);
	}
	
	private int extractInt(JSONObject objRes, String key) {
		return (int) objRes.get(key);
	}
	
	private long extractLong(JSONObject objRes, String key) {
		return (long) objRes.get(key);
	}
	
	private JSONObject extractJSONObject(JSONObject objRes, String key) {
		return (JSONObject) objRes.get(key);
	}
}
