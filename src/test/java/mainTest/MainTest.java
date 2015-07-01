package mainTest;

import bom.Member;
import bom.ShowCenterLimited;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.Assert;

import factory.FacShowCenter;
import requestbetaseries.BetaseriesRequest;
import utils.LoggerUtils;

public class MainTest {
	final static Logger logger = Logger.getLogger(MainTest.class);
	private static Member member = new Member("JavaSeriesTest", "xepygement");
	private static BetaseriesRequest conv = new BetaseriesRequest();

	@Test
	public void connectTest(){
		logger.info("->Testing 1 - Connection to BetaSeries");
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
		logger.info("->Testing 2 - Send Remaining Episodes request to BetaSeries");
		try {
			conv.getUserConnectionInfos(member);
			conv.getUserRemainingEpisodes(member);
			Assert.assertNotNull(FacShowCenter.INSTANCE.getShowCenter().dump());
			logger.info(FacShowCenter.INSTANCE.getShowCenter().getShowById((Long)(FacShowCenter.INSTANCE.getShowCenter().getMappingShow().keySet().toArray()[0])).shortDump());
			Assert.assertNotNull(FacShowCenter.INSTANCE.getShowCenter().getShowById((Long)(FacShowCenter.INSTANCE.getShowCenter().getMappingShow().keySet().toArray()[0])).shortDump());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void FacEpisodesDate(){
		logger.info("->Testing 3 - Send Remaining Episodes request to BetaSeries");
		if (FacShowCenter.INSTANCE.getShowCenter() instanceof ShowCenterLimited){
			logger.debug("->Instance of ShowCenterLimited");
			((ShowCenterLimited)FacShowCenter.INSTANCE.getShowCenter()).cleanListEpisodes();
			Assert.assertTrue(true);
		}else{
			logger.error("->not an instance of ShowCenterLimited");
			Assert.assertTrue(false);
		}
	}
}
