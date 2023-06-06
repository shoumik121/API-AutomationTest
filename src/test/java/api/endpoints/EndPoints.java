package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EndPoints {
	public static Map<String, Object> apiHeader(String bearerToken)
	{
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("Content-Type","application/json");
	    map.put("Client-Service","frontend-client");
	    map.put("Authorization","Bearer "+bearerToken);
	    return map;
	}
	
	private static String graphqlToJson(String payload)
	{
	     JSONObject json = new JSONObject();
	     json.put("query",payload);
	     return  json.toString();
	}
	
//1 Email SignIn Response
	public static Response signInWithEmail(JSONObject variables)
	{
		 Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		    .contentType("application/json")
		    .body("{\"query\": \"" + Query.signInWithEmailQuery + "\", \"variables\": " + variables + "}")
		.when()
			.post(Routes.post_url);
		 
		 return response;	
	}
	
//2 Phone SignIn Response
	public static Response signInWithPhone(JSONObject variables)
	{
		 Response response = given()
		    .contentType("application/json")
		    .body("{\"query\": \"" + Query.signInWithPhoneQuery + "\", \"variables\": " + variables + "}")
		.when()
			.post(Routes.post_url);
		 
		 return response;	
	}
	
//3 Social SignIn Response
	public static Response signInWithSocial(JSONObject variables)
	{
		 Response response = given()
		    .contentType("application/json")
		    .body("{\"query\": \"" + Query.signInWithSocialQuery + "\", \"variables\": " + variables + "}")
		.when()
			.post(Routes.post_url);
		 
		 return response;	
	}
	
//4 Email SignUp Response
	public static Response signUpWithEmail(JSONObject variables)
	{
		 Response response = given()
		    .contentType("application/json")
		    .body("{\"query\": \"" + Query.signUpWithEmailQuery + "\", \"variables\": " + variables + "}")
		.when()
			.post(Routes.post_url);
		 
		 return response;	
	}
	
//5 Phone SignUp Response
	public static Response signUpWithPhone(JSONObject variables)
	{
		 Response response = given()
		    .contentType("application/json")
		    .body("{\"query\": \"" + Query.signUpWithPhoneQuery + "\", \"variables\": " + variables + "}")
		.when()
			.post(Routes.post_url);
		 
		 return response;	
	}
	
//6 Social SignUp Response
	public static Response signUpWithSocial(JSONObject variables)
	{
		 Response response = given()
		    .contentType("application/json")
		    .body("{\"query\": \"" + Query.signUpWithSocialQuery + "\", \"variables\": " + variables + "}")
		.when()
			.post(Routes.post_url);
		 
		 return response;	
	}
	
//7  Email SignIn Response
	public static Response signInWithAdmin(String token)
	{
		 Response response = given()
			.headers(apiHeader(token))
		    .body(graphqlToJson(Query.adminSearchProductQuery))
		.when()
			.post(Routes.post_url);
		 
		 return response;	
	}
	
//8 Home_Page>>Contests>>PerticularTypeContests
	public static Response perticularTypeContests() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.perticularTypeContestsQuery))
				.when()
					.post(Routes.post_url);
				 
				 return response;
	}
	
//9 Home_Page>>Brands>>brands (type:video)
	public static Response homepageBrands() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.brandsQuery))
				.when()
					.post(Routes.post_url);
				 
				 return response;
	}
	
//10 home_page>>Offers>>offers
	public static Response homepageOffers() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.offersQuery))
				.when()
					.post(Routes.post_url);
				 
				 return response;
	}
	
//11 home_page>>Top Selling>>TopSellingFromTraffic
	public static Response homepageTopSellingFromTraffic() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.topSellingFromTrafficQuery))
				.when()
					.post(Routes.post_url);
				 
				 return response;
	}
	
//12 home_page>>Trending>>TrendingVideos (TrendingTag)
	public static Response homepageTrendingVideosTrendingTag() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.trendingVideosTrendingTagQuery))
				.when()
					.post(Routes.live_post_url);
				 
				 return response;
	}
	

//13 home_page>>#talent>>VideosByHashTag
	public static Response talentVideosByHashTag() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.talentQuery))
				.when()
					.post(Routes.post_url);
				 
				 return response;
	}

//14 home_page>>#beauty>>VideosByHashTag
	public static Response beautyVideosByHashTag() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.beautyQuery))
				.when()
					.post(Routes.post_url);
				 
				 return response;
	}
	
//15 home_page>>#tech>>VideosByHashTag
	public static Response techVideosByHashTag() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.techQuery))
				.when()
					.post(Routes.post_url);
				 
				 return response;
	}
	
//16 home_page>>#fashion>>VideosByHashTag
	public static Response fashionVideosByHashTag() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.fashionQuery))
				.when()
					.post(Routes.post_url);
				 
				 return response;
	}
	
//17 home_page>>#food>>VideosByHashTag
	public static Response foodVideosByHashTag() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.foodQuery))
				.when()
					.post(Routes.post_url);
				 
				 return response;
	}
	
//18 home_page>>#sports>>VideosByHashTag
	public static Response sportsVideosByHashTag() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.sportsQuery))
				.when()
					.post(Routes.post_url);
				 
				 return response;
	}
	
//19 home_page>>#smartphone>>VideosByHashTag
	public static Response smartphoneVideosByHashTag() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.smartphoneQuery))
				.when()
					.post(Routes.post_url);
				 
				 return response;
	}
	
//20 home_page>>#travel>>VideosByHashTag
	public static Response travelVideosByHashTag() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.travelQuery))
				.when()
					.post(Routes.post_url);
				 
				 return response;
	}
	
//21 home_page>>#decor>>VideosByHashTag
	public static Response decorVideosByHashTag() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.decorQuery))
				.when()
					.post(Routes.post_url);
				 
				 return response;
	}
	
//22 home_page>>#homeappliance>>VideosByHashTag
	public static Response homeapplianceVideosByHashTag() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.homeapplianceQuery))
				.when()
					.post(Routes.post_url);
				 
				 return response;
	}
	
//23 home_page>>Trending>>TrendingVideos (with 'new' tag)
	public static Response homepageTrendingVideosNewTag() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.trendingVideosNewTagQuery))
				.when()
					.post(Routes.live_post_url);
				 
				 return response;
	}
	
//24 Show All Contests>>My Participation>>MyParticipationContests
	public static Response showMyParticipationContests() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.myParticipationContestsQueryMaker("video",FrequentlyUsedFunctions.getUserId())))
				.when()
					.post(Routes.live_post_url);
				 
				 return response;
	}

//25 Show All Contests>>All contest>>PerticularTypeContests
	public static Response perticularTypeContestsCustom() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.perticularTypeContestsCustomQuery))
				.when()
					.post(Routes.live_post_url);
				 
				 return response;
	}
	
//26 Show All Brands>>Click on Show All Brands>>brands
	public static Response showAllBrandsEndpoint() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.showAllBrandsQuery))
				.when()
					.post(Routes.live_post_url);
				 
				 return response;
	}
//27 Show All Brands>>Click on Show All Brands>>brand
	public static Response brandQueryEndpoint() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.brandQueryMaker(FrequentlyUsedFunctions.getBrandId(),"")))
				.when()
					.post(Routes.live_post_url);
				 
				 return response;
	}
//28 Show All Brands>>Click on Show All Brands>>followBrand(brandId: $brandId)
	public static Response followBrandEndpoint(String token) {
		Response response = given()
				.headers(apiHeader(token))
				.contentType("application/json")
			    .body(graphqlToJson(Query.followBrandQueryMaker(FrequentlyUsedFunctions.getBrandId())))
			.when()
				.post(Routes.live_post_url);
			 
			 return response;
	}
//29 Show All Brands>>Click on Show All Brands>>unfollowBrand(brandId: $brandId)
	public static Response unfollowBrandEndpoint(String token) {
		Response response = given()
				.headers(apiHeader(token))
				.contentType("application/json")
			    .body(graphqlToJson(Query.unfollowBrandQueryMaker(FrequentlyUsedFunctions.getBrandId())))
			.when()
				.post(Routes.live_post_url);
			 
			 return response;
	}
//30 Show All Brands>>Click on Show All Brands>>brandContests(brandId: $brandId, endIndex: $endIndex, startIndex:$startIndex)
	public static Response brandContestsEndpoint() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.brandContestsQueryMaker(FrequentlyUsedFunctions.getBrandId())))
				.when()
					.post(Routes.live_post_url);
				 
				 return response;
	}
//31 Contest Detail>>Contests>>ContestDetails($contestDetailsId: String)
	public static Response contestDetailsEndpoint() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.contestDetailsQueryMaker(FrequentlyUsedFunctions.getContestId())))
				.when()
					.post(Routes.live_post_url);
				 
				 return response;
	}
//32 Contest Detail>>Contest Detail Page>>contestVideos(campaignId:$campaignId, endIndex:$endIndex, startIndex:$startIndex)
	public static Response detailPageContestVideosEndpoint() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.detailPageContestVideosQueryMaker(FrequentlyUsedFunctions.getContestId())))
				.when()
					.post(Routes.live_post_url);
				 
				 return response;
	}
//33 Playlist>>Top Users>>topUsers
	public static Response topUsersEndpoint() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.topUsersQuery))
				.when()
					.post(Routes.live_post_url);
				 
				 return response;
	}
//34 Playlist>>Playlist videos>>videoList(videoListInputDto: $videoListInputDto)
//35 Playlist>>List Video Types>>listVideoTypes
	public static Response listVideoTypesEndpoint() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.listVideoTypesQuery))
				.when()
					.post(Routes.post_url);
				 
				 return response;
	}

//36 Search>>Search User>>searchUser(endIndex: 10,  startIndex: 1, query:"")
	public static Response searchUserEndpoint() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.searchUserQueryMaker(FrequentlyUsedFunctions.getSearchQuery())))
				.when()
					.post(Routes.post_url);
				 
				 return response;
	}
//37 Search>>Search Video Hashtag>>searchVideoHashtag(endIndex: $endIndex, query: $query, startIndex: $startIndex)
	public static Response searchVideoHashtagEndpoint() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.searchVideoHashtagQueryMaker(FrequentlyUsedFunctions.getHashtag())))
				.when()
					.post(Routes.post_url);
				 
				 return response;
	}
//38 Search>>Search Video>>searchVideo(endIndex: 10, query: "Biriyani", startIndex: 1)
	public static Response searchVideoEndpoint() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.searchVideoQueryMaker(FrequentlyUsedFunctions.getVideoTitle())))
				.when()
					.post(Routes.post_url);
				 
				 return response;
	}
//39 Search>>Search Contest>>searchContest(endIndex: 10, query: "My Cell", startIndex: 1)
	public static Response searchContestEndpoint() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.searchContestQueryMaker(FrequentlyUsedFunctions.getContestTitle())))
				.when()
					.post(Routes.post_url);
				 
				 return response;
	}
//40 Video>>Click on Video Comments>>showCommentsForVideo(videoId: $showCommentsForVideoId)
	public static Response showCommentsForVideoEndpoint() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.showCommentsForVideoQueryMaker(FrequentlyUsedFunctions.getVideoId())))
				.when()
					.post(Routes.post_url);
				 
				 return response;
	}
//41 Video>>Get Video Details>>singleVideo(videoId: $videoId) 
	public static Response singleVideoEndpoint() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.singleVideoQueryMaker(FrequentlyUsedFunctions.getVideoId())))
				.when()
					.post(Routes.post_url);
				 
				 return response;
	}
//42 Notification>>On Fetching Notification>>showNotificationList(endIndex: $endIndex, showNotificationTypeInput: $showNotificationTypeInput, startIndex: $startIndex)	
	public static Response showNotificationListEndpoint(String token) {
		Response response = given()
				.headers(apiHeader(token))
				.contentType("application/json")
			    .body(graphqlToJson(Query.showNotificationListQuery))
			.when()
				.post(Routes.post_url);
			 
			 return response;
	}
//43 Fshop>>cart>>cartProducts
	public static Response fshopcartProducts(String token) {
		Response response = given()
				.headers(apiHeader(token))
				.contentType("application/json")
			    .body(graphqlToJson(Query.cartProductsQuery))
			.when()
				.post(Routes.post_url);
			 
			 return response;
	}

//44 Fshop>>dashboard>>shippingAddresses
	public static Response fshopDashboardShippingAddresses(String token) {
		Response response = given()
				.headers(apiHeader(token))
				.contentType("application/json")
			    .body(graphqlToJson(Query.shippingAddressesQuery))
			.when()
				.post(Routes.post_url);
			 
			 return response;
	}

//45 Fshop>>dashboard>>reviewByUser
	public static Response fshopDashboardReviewByUser(String token) {
		Response response = given()
				.headers(apiHeader(token))
				.contentType("application/json")
			    .body(graphqlToJson(Query.reviewByUserQuery))
			.when()
				.post(Routes.post_url);
			 
			 return response;
	}

//46 Fshop>>dashboard>>supportTickets(endIndex: $endIndex, startIndex: $startIndex)
	public static Response fshopDashboardSupportTickets(String token) {
		Response response = given()
				.headers(apiHeader(token))
				.contentType("application/json")
			    .body(graphqlToJson(Query.supportTicketsQuery))
			    .when()
				.post(Routes.post_url);
			 
			 return response;
	}

//47 Fshop>>home>>parentCategories(endIndex: $endIndex, startIndex: $startIndex)
	public static Response fshopHomeParentCategories() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.parentCategoriesQuery))
				 .when()
					.post(Routes.post_url);
				 
				 return response;
	
	}

//48 Fshop>>home>>flashSales(endIndex: $endIndex, startIndex: $startIndex)
	public static Response fshopHomeFlashSales() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.flashSalesQuery))
				 .when()
					.post(Routes.post_url);
				 
				 return response;
	}

//49 Fshop>>home>>promotionalOffers(offerType: $offerType, pageNumber:$pageNumber, perPage: $perPage)
	public static Response fshopHomePromotionalOffers() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.promotionalOffersQuery))
				 .when()
					.post(Routes.post_url);
				 
				 return response;
	}

//50 Fshop>>home>>topSellingBrands(endIndex: $endIndex, startIndex: $startIndex)
	public static Response fshopHomeTopSellingBrands() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.topSellingBrandsQuery))
				 .when()
					.post(Routes.post_url);
				 
				 return response;
	}

//51 Fshop>>home>>productsByCategory(endIndex: $endIndex, startIndex: $startIndex, categoryId: $categoryId)
	public static Response fshopHomeProductsByCategory() {
		String categoryIdForQuery = FrequentlyUsedFunctions.getCategoryId();
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.productsByCategoryQueryMaker(categoryIdForQuery)))
				 .when()
					.post(Routes.post_url);
				 
				 return response;
	}
	
//52 Fshop>>home>>mainBanners(endIndex: $endIndex, startIndex: $startIndex)
	public static Response fshopHomeMainBanners() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.mainBannersQuery))
				 .when()
					.post(Routes.post_url);
				 
				 return response;
	}

//53 Fshop>>home>>offerBanners(endIndex: $endIndex, startIndex: $startIndex)
	public static Response fshopHomeOfferBanners() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.offerBannersQuery))
				 .when()
					.post(Routes.post_url);
				 
				 return response;
	}

//54 Fshop>>home>>categoryChildrens(parentId: $parentId)
	public static Response fshopHomeCategoryChildrens() {
		String parentIdForQuery = FrequentlyUsedFunctions.getParentId();
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.categoryChildrensQueryMaker(parentIdForQuery)))
				 .when()
					.post(Routes.post_url);
				 
				 return response;
	}

//55 Fshop>>home>>filterHotdeals(hotDealFilterInput: \$hotDealFilterInput)
	public static Response fshopHomeFilterHotdeals() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.filterHotdealsQuery))
				.when()
					.post(Routes.post_url);
				 
				 return response;
	}

//56 Fshop>>home>>bannerProducts(bannerId: $bannerId, pageNumber: $pageNumber, perPage: $perPage)
	public static Response fshopHomeBannerProducts() {
		String bannerIdForQuery = FrequentlyUsedFunctions.getBannerId();
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.bannerProductsQueryMaker(bannerIdForQuery)))
				 .when()
					.post(Routes.post_url);
				 
				 return response;
	}
//57 Fshop>>order>>ordersByUser
	public static Response fshopOrdersByUser(String token) {
		Response response = given()
				.headers(apiHeader(token))
				.contentType("application/json")
			    .body(graphqlToJson(Query.ordersByUserQuery))
			.when()
				.post(Routes.post_url);
			 
			 return response;
	}

//58 Fshop>>product>>product(id: $productId)
	public static Response fshopOrdersProductById() {
		String productIdForQuery = FrequentlyUsedFunctions.getProductId();
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.productByIdQueryMaker(productIdForQuery)))
				 .when()
					.post(Routes.post_url);
				 
				 return response;
	}
//59 Fshop>>product>>productFaqs(endIndex: $endIndex, productId: $productId, startIndex: $startIndex)
	public static Response fshopProductFaqsById() {
		String productIdForQuery = FrequentlyUsedFunctions.getProductId();
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.productFaqsByIdQueryMaker(productIdForQuery)))
				 .when()
					.post(Routes.post_url);
				 
				 return response;
	}
//60 Fshop>>product>>productReview(endIndex: $endIndex, productId: $productId, startIndex: $startIndex)
	public static Response fshopProductReviewById() {
		String productIdForQuery = FrequentlyUsedFunctions.getProductId();
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.productReviewQueryMaker(productIdForQuery)))
				 .when()
					.post(Routes.post_url);
				 
				 return response;
	}
//61 Fshop>>search>>searchProduct(endIndex: $endIndex, query: $query, startIndex: $startIndex)
	public static Response fshopSearchProductByQuery() {
		// default value "Red"
		String searchQueryForQuery = FrequentlyUsedFunctions.getSearchQuery();
		 
		Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.searchProductQueryMaker(searchQueryForQuery)))
				 .when()
					.post(Routes.live_post_url);
				 
				 return response;
	}
	
//62 Fshop>>wishList>>wishlistProducts(endIndex: $endIndex, startIndex: $startIndex)
	public static Response fshopWishlistProducts(String token) {
		Response response = given()
				.headers(apiHeader(token))
				.contentType("application/json")
			    .body(graphqlToJson(Query.wishlistProductsQuery))
			.when()
				.post(Routes.post_url);
			 
			 return response;
	}

//⚡⚡⚡Custom Endpoints I Use ⚡⚡⚡

//QueryName >> brandsproducts
	public static Response toGetCategoryIdEndpoint() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.toGetCategoryIdQuery))
				.when()
					.post(Routes.post_url);
				 
				 return response;
	}
//QueryName >> parentCategories	
	public static Response toGetParentIdEndpoint() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.toGetparentIdQuery))
				.when()
					.post(Routes.post_url);
				 
				 return response;
	}
//QueryName >> offerBanners	
	public static Response toGetOfferBannerIdEndpoint() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.toGetOfferBannersQuery))
				.when()
					.post(Routes.post_url);
				 
				 return response;
	}
//QueryName >> adminProductSearch
	public static Response toGetadminProductSearchIdEndpoint(String token) {
		Response response = given()
				.headers(apiHeader(token))
				.contentType("application/json")
			    .body(graphqlToJson(Query.toGetadminProductSearchId))
			.when()
				.post(Routes.post_url);
			 
			 return response;
	}
//QueryName >> signInToLiveApiAsAdminEndpoint
	public static Response signInToLiveApiAsAdminEndpoint(JSONObject variables)
	{
		 Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		    .contentType("application/json")
		    .body("{\"query\": \"" + Query.signInWithEmailQuery + "\", \"variables\": " + variables + "}")
		.when()
			.post(Routes.live_post_url);
		 
		 return response;	
	}
//QueryName >> getUserListInfo	
	public static Response togetUserListInfoEndpoint() {
		 Response response = given() //Public API
				 .contentType("application/json")
				 .body(graphqlToJson(Query.toGetUserListInfoQuery))
				.when()
					.post(Routes.live_post_url);
				 
				 return response;
	}
}
