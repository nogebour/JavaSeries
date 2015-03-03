package requestbetaseries;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import factory.FacShowCenter;
import requestbetaseries.networkconnection.BetaSeriesConnection;
import utils.ConvertJSON;
import utils.ConvertString;
import bom.Episode;
import bom.Member;
import bom.Show;
import bom.ShowCenter;

public class BetaseriesRequest {

	public void getUserConnectionInfos(Member member) throws Exception{
		BetaSeriesConnection bsReq = new BetaSeriesConnection();
		String response = bsReq.connectBetaseriesAPI(member);
		JSONParser parserJSON = new JSONParser();
		Object jsonRes = parserJSON.parse(response);
		if (jsonRes.getClass() == JSONObject.class)
		{
			JSONObject objRes = ((JSONObject) jsonRes);
			String token = ConvertJSON.extractString(objRes,"token");
			System.out.println("token : "+token);
			member.setToken(token);
			JSONObject objUser = ConvertJSON.extractJSONObject(objRes, "user");
			long userId = ConvertJSON.extractLong(objUser, "id");
			System.out.println("userId : "+userId);
			member.setUserId(userId);
		}
	}

	public void getUserRemainingEpisodes(Member member) throws Exception{
		BetaSeriesConnection bsReq = new BetaSeriesConnection();
		String response = bsReq.getUsersEpisodesList(member);
		System.out.println(response);
		JSONParser parserJSON = new JSONParser();
		Object jsonRes = parserJSON.parse(response);
		if (jsonRes.getClass() == JSONObject.class)
		{
			JSONObject objRes = ((JSONObject) jsonRes);
			JSONArray shows = ConvertJSON.extractArray(objRes,"shows");
			System.out.println("There are "+shows.size()+" shows");
			for(int itShows = 0; itShows < shows.size(); itShows++){
				JSONObject show = ((JSONObject) shows.get(itShows));
				Show bomShow = new Show();
				bomShow.setId(ConvertJSON.extractLong(show, "id"));
				bomShow.setImdbId(ConvertJSON.extractLong(show, "thetvdb_id"));
				bomShow.setTitle(ConvertString.replaceBackToLine(ConvertJSON.extractString(show, "title")));
				FacShowCenter.INSTANCE.getShowCenter().addShow(bomShow);
				JSONArray unseen = ConvertJSON.extractArray(show,"unseen");
				if (unseen != null){
					System.out.println("There are "+unseen.size()+" unseen epsiodes for the show \""+ConvertJSON.extractString(show, "title")+"\"");
					for (int itUnseen = 0; itUnseen < unseen.size(); itUnseen++){
						JSONObject episode = ((JSONObject) unseen.get(itUnseen));
						Episode bomEpisode = new Episode();
						bomEpisode.setId(ConvertJSON.extractLong(episode, "id"));
						bomEpisode.setTheTvDbId(ConvertJSON.extractLong(episode, "thetvdb_id"));
						bomEpisode.setTitle(ConvertString.replaceBackToLine(ConvertJSON.extractString(episode, "title")));
						bomEpisode.setSeason(ConvertJSON.extractLong(episode, "season"));
						bomEpisode.setEpisode(ConvertJSON.extractLong(episode, "episode"));
						bomEpisode.setIdShow(ConvertJSON.extractLong(episode, "show_id"));
						bomEpisode.setCode(ConvertString.replaceBackToLine(ConvertJSON.extractString(episode, "code")));
						bomEpisode.setGlobalNumber(ConvertJSON.extractLong(episode, "global"));
						bomEpisode.setDescription(ConvertString.replaceBackToLine(ConvertJSON.extractString(episode, "description")));
						bomEpisode.setDate(ConvertString.replaceBackToLine(ConvertJSON.extractString(episode, "date")));
						bomShow.addEpisode(bomEpisode);
						
					}
				}
			}
		}
	}


}
