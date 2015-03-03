import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import bom.Member;
import bom.ShowCenter;
import bom.ShowCenterLimited;

import org.junit.Test;
import org.junit.Assert;

import factory.FacEpisodes;
import factory.FacShowCenter;
import requestbetaseries.BetaseriesRequest;

public class MainTest {
	private static Member member = new Member("JavaSeriesTest", "xepygement");;
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
			//System.out.println(FacShowCenter.INSTANCE.getShowCenter().dump());
			Assert.assertNotNull(FacShowCenter.INSTANCE.getShowCenter().dump());
			Assert.assertNotNull(FacShowCenter.INSTANCE.getShowCenter().getShowById((Long)(FacShowCenter.INSTANCE.getShowCenter().getMappingShow().keySet().toArray()[0])).shortDump());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void FacEpisodesDate(){
		System.out.println("->Testing 3 - Send Remaining Episodes request to BetaSeries");
		if (FacShowCenter.INSTANCE.getShowCenter() instanceof ShowCenterLimited){
			System.out.println("->Instance of ShowCenterLimited");
			((ShowCenterLimited)FacShowCenter.INSTANCE.getShowCenter()).cleanListEpisodes();
			Assert.assertTrue(true);
		}else{
			System.out.println("->not an instance of ShowCenterLimited");
			Assert.assertTrue(false);
		}
	}
}
