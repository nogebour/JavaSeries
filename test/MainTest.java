import java.io.InputStream;
import junit.framework.TestCase;
import jsontobom.ConvJSONToBOM;
import bom.BSMember;
import bom.BSShowCenter;
import brequest.BetaSeriesReq;
import brequest.HttpURLConnectionImpl;

public class Main {
	@test
	public void mainTest() throws Exception {
		System.out.println("Init Main");
		BSMember member = new BSMember("Dev010", "developer");
		ConvJSONToBOM conv = new ConvJSONToBOM();
		BetaSeriesReq req = new BetaSeriesReq();
		System.out.println("\nTesting 1 - Send Connection request to BetaSeries");
		conv.getUserConnectionInfos(member);
		assertNotNull(member.getToken());
		System.out.println("\nTesting 1 - Send Remaining Episodes request to BetaSeries");
		conv.getUserRemainingEpisodes(member);
		System.out.println(BSShowCenter.INSTANCE.dump());
	}
}
