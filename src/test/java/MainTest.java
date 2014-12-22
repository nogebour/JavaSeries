import jsontobom.ConvJSONToBOM;
import bom.BSMember;
import bom.BSShowCenter;
import org.junit.Test;
import org.junit.Assert;

public class MainTest {
	private static BSMember member = new BSMember("JavaSeriesTest", "xepygement");;
	private static ConvJSONToBOM conv = new ConvJSONToBOM();
	private static String responseRemaining = "There are 4 shows in the BSShowCenter:\n	-> id: 23 corresponds to \"Stargate SG-1\" with this values: Imbd_id/72449\n	-> id: 9 corresponds to \"24\" with this values: Imbd_id/76290\n	-> id: 527 corresponds to \"Stargate Universe\" with this values: Imbd_id/83237\n	-> id: 28 corresponds to \"Stargate Atlantis\" with this values: Imbd_id/70851";

	@Test
	public void connectTest(){
		System.out.println("->Testing 1 - Connection to BetaSeries");
		try {
			conv.getUserConnectionInfos(member);
			Assert.assertNotNull(member.getToken());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	@Test
	public void remainingEpisodes(){
		System.out.println("->Testing 2 - Send Remaining Episodes request to BetaSeries");
		try {
			conv.getUserConnectionInfos(member);
			conv.getUserRemainingEpisodes(member);
			Assert.assertTrue(BSShowCenter.INSTANCE.dump().equals(responseRemaining));
			System.out.println(BSShowCenter.INSTANCE.dump());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}
}
