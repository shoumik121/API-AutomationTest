package api.endpoints;

import java.util.Map;
import java.util.Set;
import io.restassured.path.json.JsonPath;

public class FrequentlyUsedFunctions {
 static public Object dataNullChecker(JsonPath path) {
	 Object firstKeyValue = "";
	 
	 if(path.getString("data") == null) {
		String errString = path.getString("errors.extensions.response.statusCode[0]");
		String errorMessageString = path.getString("errors[0].message");
		System.out.println("Msg:"+ errorMessageString + "StatusCode" + errString);
	 }
	 else { 
		Map<String, String> applicationsMap = path.getMap("data");
		Set<String> applicationKeys = applicationsMap.keySet();
//		System.out.println(applicationKeys.toArray()[0]);
		firstKeyValue = applicationKeys.toArray()[0];
	 }
	 return (firstKeyValue); 
 }
 
 static public Object dataNullChecker(JsonPath path,int controlVar) {
	 Object firstKeyValue = "";
	 
	 if(path.getString("data") == null) {
		String errString = path.getString("errors.extensions.response.statusCode[0]");
		String errorMessageString = path.getString("errors[0].message");
		System.out.println("Msg:"+ errorMessageString + "StatusCode" + errString);
	 }
	 else { 
		Map<String, String> applicationsMap = path.getMap("data");
		Set<String> applicationKeys = applicationsMap.keySet();
//		System.out.println(applicationKeys.toArray()[0]);
		firstKeyValue = applicationKeys.toArray()[controlVar];
	 }
	 return (firstKeyValue); 
 }
 
 static public String dataNullCheckerString(JsonPath path) {

		String dataString = path.getString("data."+dataNullChecker(path).toString()+"._id"); 
//		System.out.println(dataString);
//		System.out.println("String length:" + dataString.length());
		return dataString;
 }
 
 // VALIDATOR
 static public void matchFunction(int resultValue, int expectedValue) {
	 if(resultValue == expectedValue) {
		 System.out.println("Content.Size 🟰 Expected.Size ✅");
	 }else {
		System.out.println("Content.Size ❌ Expected.Size ⛔");
	}
	 
 }
 
 static public void matchStringFunction(String resultValue, String expectedValue) {
	 System.out.println("Token Match Indication ---" + resultValue.equals(expectedValue));
	 if(resultValue.equals(expectedValue)) {
		 System.out.println("Content.Size 🟰 Expected.Size ✅");
	 }else {
		System.out.println("Content.Size ❌ Expected.Size ⛔");
	}
	 
 }
 
 //tokenStringGenerator HANDELER
 static public void tokenStringGeneratorSignUp(JsonPath path) {

		String dataString = path.getString("data."+dataNullChecker(path).toString()+".access_token"); 
//		System.out.println(dataString);
		setSignUpToken(dataString);
}
 
 static public void tokenStringGeneratorSignIn(JsonPath path) {

		String dataString = path.getString("data."+dataNullChecker(path).toString()+".access_token"); 
//		System.out.println(dataString);
		setSignInToken(dataString);
}

 static String AdminLiveToken = "";
 static String SignUpToken ="";
 static String SignInToken ="";
 static String CategoryId = "";
 static String ParentId = "";
 static String BannerId = "";
 static String ProductId = "";
 static String SearchQuery = "red";
 static String UserId = "";
 static String BrandId = "";
 static String ContestId = "";
 static String Hashtag = "";
 static String VideoTitle = "";
 static String ContestTitle = "";
 static String VideoId = "";
 
 
public static String getSignUpToken() {
	return SignUpToken;
}
public static void setSignUpToken(String signUpToken) {
	SignUpToken = signUpToken;
}
//⚡
public static String getSignInToken() {
	return SignInToken;
}
public static void setSignInToken(String signInToken) {
	SignInToken = signInToken;
}
//⚡
public static String getCategoryId() {
	return CategoryId;
}
public static void setCategoryId(String categoryId) {
	CategoryId = categoryId;
}
//⚡
public static String getParentId() {
	return ParentId;
}
public static void setParentId(String parentId) {
	ParentId = parentId;
}
//⚡ 
public static String getBannerId() {
	return BannerId;
}
public static void setBannerId(String bannerId) {
	BannerId = bannerId;
}
//⚡
public static String getProductId() {
	return ProductId;
}
public static void setProductId(String productId) {
	ProductId = productId;
}
//⚡
public static String getSearchQuery() {
	return SearchQuery;
}
public static void setSearchQuery(String searchQuery) {
	SearchQuery = searchQuery;
}
//⚡
public static String getAdminLiveToken() {
	return AdminLiveToken;
}
public static void setAdminLiveToken(String adminLiveToken) {
	AdminLiveToken = adminLiveToken;
}
//⚡
public static String getUserId() {
	return UserId;
}
public static void setUserId(String userId) {
	UserId = userId;
}
//⚡
public static String getBrandId() {
	return BrandId;
}
public static void setBrandId(String brandId) {
	BrandId = brandId;
}
//⚡
public static String getContestId() {
	return ContestId;
}
public static void setContestId(String contestId) {
	ContestId = contestId;
}
//⚡
public static String getHashtag() {
	return Hashtag;
}
public static void setHashtag(String hashtag) {
	Hashtag = hashtag;
}
//⚡
public static String getVideoTitle() {
	return VideoTitle;
}
public static void setVideoTitle(String videoTitle) {
	VideoTitle = videoTitle;
}
//⚡
public static String getContestTitle() {
	return ContestTitle;
}
public static void setContestTitle(String contestTitle) {
	ContestTitle = contestTitle;
}
//⚡
public static String getVideoId() {
	return VideoId;
}
public static void setVideoId(String videoId) {
	VideoId = videoId;
}
}
