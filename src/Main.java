import jsontobom.ConvJToB;
import bom.BSMember;
import brequest.BetaSeriesReq;
import brequest.HttpURLConnectionImpl;


public class Main {
	public static void main(String[] args) throws Exception {

		HttpURLConnectionImpl http = new HttpURLConnectionImpl();

		System.out.println("Testing 1 - Send Http GET request");
		http.sendGet("http://www.google.com/search?q=mkyong", null, false);

		System.out.println("\nTesting 2 - Send Http POST request");
		http.sendPost("https://selfsolve.apple.com/wcResults.do", "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345", true);

		System.out.println("\nTesting 3 - Send Http POST request to BetaSeries");
		BSMember member = new BSMember("nogebour", "");
		ConvJToB conv = new ConvJToB();
		conv.getUserConnectionInfos(member);
		BetaSeriesReq req = new BetaSeriesReq();
		System.out.println("Episodes:\n"+req.getUsersEpisodesList(member));
	}

}
