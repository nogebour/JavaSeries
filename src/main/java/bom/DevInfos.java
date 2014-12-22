package bom;

public class DevInfos {
	private String version;
	private String devKey;
	private static DevInfos INSTANCE;
	
	
	public String getVersion() {
		return version;
	}

	public String getDevKey() {
		return devKey;
	}

	private DevInfos(String version, String devKey) {
		super();
		this.version = version;
		this.devKey = devKey;
	}

	public static DevInfos getInstance(){
		if (INSTANCE == null)
		{
			INSTANCE = new DevInfos("2.2", "a71be26370dc");
		}
		return INSTANCE;
	}

}
