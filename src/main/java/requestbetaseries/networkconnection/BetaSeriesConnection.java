package requestbetaseries.networkconnection;

import bom.BSMember;
import bom.DevInfos;

public class BetaSeriesConnection {
	private HttpURLConnectionImpl httpCon;
	private DevInfos infos;
	private static String BASEURL = "https://api.betaseries.com/";
	public BetaSeriesConnection(HttpURLConnectionImpl httpCon) {
		super();
		this.httpCon = httpCon;
		this.infos = DevInfos.getInstance();
	}
	
	public BetaSeriesConnection() {
		super();
		this.httpCon = new HttpURLConnectionImpl();
		this.infos = DevInfos.getInstance();
	}
	
	// HTTP POST request
	public String connectBetaseriesAPI(BSMember member) throws Exception {
		String url = BASEURL+"members/auth";
		String urlParameters = "key="+this.infos.getDevKey()+"&v="+this.infos.getVersion()+"&login="+member.getPseudo()+"&password="+member.getPassword();
		boolean https = true;
		return this.httpCon.sendPost(url, urlParameters, https);		
	}
	
	// HTTP POST request
	public String getUsersEpisodesList(BSMember member) throws Exception {
		String url = BASEURL+"episodes/list";
		String urlParameters = "key="+this.infos.getDevKey()+"&v="+this.infos.getVersion()+"&userid="+member.getUserId()+"&token="+member.getToken();
		boolean https = true;
		return this.httpCon.sendGet(url, urlParameters, https);		
	}
}
