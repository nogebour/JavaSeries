import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import bom.BSMember;
import bom.BSShowCenter;

import org.junit.Test;
import org.junit.Assert;

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
			//PrintWriter writer = new PrintWriter("dumpRemainingEpisodes.txt", "UTF-8");
			//writer.print(BSShowCenter.INSTANCE.dump());
			//writer.close();
			//InputStream inStream =  Thread.currentThread().getContextClassLoader().getResourceAsStream("dumpRemainingEpisodes.txt");
			//Scanner scan = new Scanner(inStream);
			//Scanner scanBis = scan.useDelimiter("\\A");
			//String resultToCompare = scanBis.hasNext() ? scanBis.next() : "";
			//scanBis.close();
			//scan.close();
			//inStream.close();
			//System.out.println(resultToCompare);
			//Assert.assertTrue(BSShowCenter.INSTANCE.dump().equals(resultToCompare));
			Assert.assertNotNull(BSShowCenter.INSTANCE.dump());
			Assert.assertNotNull(BSShowCenter.INSTANCE.getShowById((Long)(BSShowCenter.INSTANCE.getMappingShow().keySet().toArray()[0])));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}
}
