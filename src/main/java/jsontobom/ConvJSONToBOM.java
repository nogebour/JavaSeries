package jsontobom;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import bom.BSMember;
import bom.BSShow;
import bom.BSShowCenter;
import brequest.BetaSeriesReq;

public class ConvJSONToBOM {

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
	
	public void getUserRemainingEpisodes(BSMember member) throws Exception{
		BetaSeriesReq bsReq = new BetaSeriesReq();
		String response = bsReq.getUsersEpisodesList(member);
		JSONParser parserJSON = new JSONParser();
		Object jsonRes = parserJSON.parse(response);
		if (jsonRes.getClass() == JSONObject.class)
		{
			JSONObject objRes = ((JSONObject) jsonRes);
			JSONArray shows = extractArray(objRes,"shows");
			System.out.println("There are "+shows.size()+" shows");
			for(int itShows = 0; itShows < shows.size(); itShows++){
				JSONObject show = ((JSONObject) shows.get(itShows));
				BSShow bomShow = new BSShow();
				bomShow.setId(extractLong(show, "id"));
				bomShow.setImdb_id(extractLong(show, "thetvdb_id"));
				bomShow.setTitle(extractString(show, "title"));
				BSShowCenter.INSTANCE.addShow(bomShow);
			}
			
		}
	}

	private JSONArray extractArray(JSONObject objRes, String key) {
		return (JSONArray) objRes.get(key);
	}

	private String extractString(JSONObject objRes, String key) {
		return (String) objRes.get(key);
	}
	
	private int extractInt(JSONObject objRes, String key) {
		return ((Number) objRes.get(key)).intvalue();
	}
	
	private long extractLong(JSONObject objRes, String key) {
		return ((Number) objRes.get(key)).intvalue();
	}
	
	private JSONObject extractJSONObject(JSONObject objRes, String key) {
		return (JSONObject) objRes.get(key);
	}
}
