package tool;

public class CommonFacebook {
	public static String URL_HOME = "https://m.facebook.com";
	public static String URL_PROFILE = "https://m.facebook.com/profile.php";
	
	
	public static String getPostId(String str) {
		if(str!= null && !str.isEmpty() && str.indexOf("story.php?story_fbid") != -1) {
						
			int end = str.lastIndexOf("&id=");
			int start = str.indexOf("fbid=");
			str = str.substring(start+5, end);
			
			return str;
		}
		return null;
	}
	
	public static String getPostUrl(String str) {
		if(str != null && !str.isEmpty() && str.indexOf("story.php?story_fbid") != -1) {
			
			String dk = "&refid";
			int end = str.indexOf(dk);
			str = str.substring(0, end);
			
			return str;
		}
		return null;
	}
}
