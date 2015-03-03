package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ConvertJSON {
	public static JSONArray extractArray(JSONObject objRes, String key) {
		return (JSONArray) objRes.get(key);
	}

	public static String extractString(JSONObject objRes, String key) {
		return (String) objRes.get(key);
	}

	public static int extractInt(JSONObject objRes, String key) {
		return ((Number) objRes.get(key)).intValue();
	}

	public static long extractLong(JSONObject objRes, String key) {
		return ((Number) objRes.get(key)).intValue();
	}

	public static JSONObject extractJSONObject(JSONObject objRes, String key) {
		return (JSONObject) objRes.get(key);
	}
}
