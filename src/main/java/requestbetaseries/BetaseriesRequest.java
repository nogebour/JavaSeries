package requestbetaseries;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import factory.FacEpisodes;
import factory.FacShow;
import factory.FacShowCenter;
import requestbetaseries.networkconnection.BetaSeriesConnection;
import utils.ConvertJSON;
import utils.ConvertString;
import utils.LoggerUtils;
import DB.DbSetUp;
import bom.Episode;
import bom.Member;
import bom.Show;
import bom.ShowCenter;

public class BetaseriesRequest {

	final static Logger logger = LoggerUtils.getLogger(BetaseriesRequest.class);
	
	public void getUserConnectionInfos(Member member) throws Exception{
		BetaSeriesConnection bsReq = new BetaSeriesConnection();
		String response = bsReq.connectBetaseriesAPI(member);
		JSONParser parserJSON = new JSONParser();
		Object jsonRes = parserJSON.parse(response);
		if (jsonRes.getClass() == JSONObject.class)
		{
			JSONObject objRes = ((JSONObject) jsonRes);
			String token = ConvertJSON.extractString(objRes,"token");
			logger.debug("token : "+token);
			member.setToken(token);
			JSONObject objUser = ConvertJSON.extractJSONObject(objRes, "user");
			long userId = ConvertJSON.extractLong(objUser, "id");
			logger.debug("userId : "+userId);
			member.setUserId(userId);
		}
	}

	public void getUserRemainingEpisodes(Member member) throws Exception{
		BetaSeriesConnection bsReq = new BetaSeriesConnection();
		String response = bsReq.getUsersEpisodesList(member);
		JSONParser parserJSON = new JSONParser();
		Object jsonRes = parserJSON.parse(response);
		if (jsonRes.getClass() == JSONObject.class)
		{
			JSONObject objRes = ((JSONObject) jsonRes);
			JSONArray shows = ConvertJSON.extractArray(objRes,"shows");
			logger.info("There are "+shows.size()+" shows");
			for(int itShows = 0; itShows < shows.size(); itShows++){
				JSONObject show = ((JSONObject) shows.get(itShows));
				logger.debug("Dump JSON Show -- "+show.toString());
				Show bomShow = FacShow.INSTANCE.getNewShow();
				bomShow.setId(ConvertJSON.extractLong(show, "id"));
				bomShow.setImdbId(ConvertJSON.extractLong(show, "thetvdb_id"));
				bomShow.setTitle(ConvertString.replaceBackToLine(ConvertJSON.extractString(show, "title")));
				JSONArray unseen = ConvertJSON.extractArray(show,"unseen");
				if (unseen != null){
					logger.info("There are "+unseen.size()+" unseen epsiodes for the show \""+ConvertJSON.extractString(show, "title")+"\"");
					for (int itUnseen = 0; itUnseen < unseen.size(); itUnseen++){
						JSONObject episode = ((JSONObject) unseen.get(itUnseen));
						Episode bomEpisode = FacEpisodes.INSTANCE.getNewEpisode();
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
				FacShowCenter.INSTANCE.getShowCenter().addShow(bomShow);
			}
		}
	}


}
