import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import bom.BSMember;
import bom.BSShowCenter;

import org.junit.Test;
import org.junit.Assert;

import factory.FacEpisodes;
import requestbetaseries.BetaseriesRequest;

public class MainTest {
	private static BSMember member = new BSMember("JavaSeriesTest", "xepygement");;
	private static BetaseriesRequest conv = new BetaseriesRequest();

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
			Assert.assertNotNull(BSShowCenter.INSTANCE.dump());
			Assert.assertNotNull(BSShowCenter.INSTANCE.getShowById((Long)(BSShowCenter.INSTANCE.getMappingShow().keySet().toArray()[0])));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void FacEpisodesDate(){
		FacEpisodes.INSTANCE.cleanListEpisodes();
		Assert.assertTrue(true);
	}
}
