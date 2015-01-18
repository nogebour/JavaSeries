package requestbetaseries;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import requestbetaseries.networkconnection.BetaSeriesConnection;
import utils.ConvertUnicode;
import bom.BSEpisodes;
import bom.BSMember;
import bom.BSShow;
import bom.BSShowCenter;

public class BetaseriesRequest {

	public void getUserConnectionInfos(BSMember member) throws Exception{
		BetaSeriesConnection bsReq = new BetaSeriesConnection();
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
		BetaSeriesConnection bsReq = new BetaSeriesConnection();
		String response = bsReq.getUsersEpisodesList(member);
		System.out.println(response);
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
				JSONArray unseen = extractArray(show,"unseen");
				if (unseen != null){
					System.out.println("There are "+unseen.size()+" unseen epsiodes for the show \""+extractString(show, "title")+"\"");
					for (int itUnseen = 0; itUnseen < unseen.size(); itUnseen++){
						JSONObject episode = ((JSONObject) unseen.get(itUnseen));
						BSEpisodes bomEpisode = new BSEpisodes();
						bomEpisode.setId(extractLong(episode, "id"));
						bomEpisode.setTheTvDbId(extractLong(episode, "thetvdb_id"));
						bomEpisode.setTitle(extractString(episode, "title"));
						bomEpisode.setSeason(extractLong(episode, "season"));
						bomEpisode.setEpisode(extractLong(episode, "episode"));
						bomEpisode.setIdShow(extractLong(episode, "show_id"));
						bomEpisode.setCode(extractString(episode, "code"));
						bomEpisode.setGlobalNumber(extractLong(episode, "global"));
						bomEpisode.setDescription(extractString(episode, "description"));
						bomEpisode.setDate(extractString(episode, "date"));
						bomShow.addEpisode(bomEpisode);
					}
				}
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
		return ((Number) objRes.get(key)).intValue();
	}

	private long extractLong(JSONObject objRes, String key) {
		return ((Number) objRes.get(key)).intValue();
	}

	private JSONObject extractJSONObject(JSONObject objRes, String key) {
		return (JSONObject) objRes.get(key);
	}
}
