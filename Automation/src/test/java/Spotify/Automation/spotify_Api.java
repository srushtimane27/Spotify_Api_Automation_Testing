package Spotify.Automation;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

public class spotify_Api {
	String token = "Bearer BQCxFxfDA-ZiAJeMVIEglYaD49KXWHi6-fqCcxX1huslVY-yUne5Ik"
			+ "K5nzw_grjGylGM2ZyY_DzS2QGpO6DeDsA9wSMCa7t0M0gl_j_qCCumFDJf0BOJNBUGqi4"
			+ "bTy2Gfhu3dvitvAxwjOAQ935lAp62VgjbMwfebI3wtaXxmyIYVM7rl6lKSXqFGgZSBg3GXS"
			+ "XSzYJ75E_J5ZqgVtQsIJR2jQP5tf-YxitpPTS_Xhv0Y2QdsnMLOdwGmGpXYZ9u8HvLgXbeIdW6og";
	String user_Id;
	String playlist_id;
	
	// Users Profile
	
	@Test(priority=1)	
	public void get_current_users_profile() {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/me");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);
		String name = response.path("display_name");
		System.out.println("Display_Name: " +name);
		String url = response.path("external_urls.spotify");
		System.out.println("External_url: " +url);
		user_Id=response.path("id");
		System.out.println(user_Id);
	}
	@Test(priority=2)
	public void get_users_profile() {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/users/"+user_Id);
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);	
	}
	
	//Track

	@Test(priority=3)
	public void get_seversl_tracks() {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/tracks?ids=4iV5W9uYEdYUVa79Axb7Rh");
		response.prettyPrint();	
		response.then().statusCode(200);
	}	
	@Test(priority=4)
	public void get_tracks() {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/tracks/4iV5W9uYEdYUVa79Axb7Rh");
		response.prettyPrint();	
		response.then().statusCode(200);
	}	
	@Test(priority=5)
	public void Get_Track_Audio_Features() {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/audio-features/4iV5W9uYEdYUVa79Axb7Rh");
		response.prettyPrint();	
		response.then().statusCode(200);
	}	
	@Test(priority=6)
	public void Get_Tracks_Audio_Features() {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/audio-features?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ");
		response.prettyPrint();	
		response.then().statusCode(200);
	}
	@Test(priority=7)
	public void Get_Track_Audio_Analysis() {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/audio-analysis/4iV5W9uYEdYUVa79Axb7Rh");
		response.prettyPrint();	
		response.then().statusCode(200);
	}
	
	//Playlists
	
	@Test(priority=8)
	public void create_playlists() {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.body("{\"name\":\"Srushti Mane\",\"description\""
						+ ":\"New playlist description\","
						+ "\"public\":false}")
				.when()
				.post("https://api.spotify.com/v1/users/31okbqd6is5nzyre6nvhqe5cmpgi/playlists");
		response.prettyPrint();	
		playlist_id=response.path("id");
		System.out.println(playlist_id);
		String type = response.path("type");
		System.out.println("type : " +type);
		response.then().statusCode(201);
		Assert.assertEquals(response.statusCode(),201);
	}	
	@Test(priority=9)
	public void Get_Current_User_Playlists() {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/me/playlists");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);
	}	
	@Test(priority=10)
	public void get_plylist_items() {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/playlists/6M6gYnRrxs8ordbUFlkI7f/tracks");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);
	}	
	@Test(priority=11)
	public void get_playlist() {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/playlists/6M6gYnRrxs8ordbUFlkI7f");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);
	}	
	@Test(priority=12)
	public void get_users_playlists() {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/users/smedjan/playlists");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);
	}	
	@Test(priority=13)
	public void change_playlist_details() {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.body("{\"name\":\"Srushti Mane Demo One\","
						+ "\"description\":\"This is Srushti playlist\","
						+ "\"public\":false}")
				.when()
				.put("https://api.spotify.com/v1/playlists/6M6gYnRrxs8ordbUFlkI7f");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);
	}
	
	//Search
	
	@Test(priority=14)
	
	public void search_for_item_query_param() {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.queryParam("q","artist")
				.queryParam("type","track")
				.when()
				.get("https://api.spotify.com/v1/search");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);
	}	
	@Test(priority=15)
	public void search_for_items_path_param() {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.pathParam("q","artist")
				.pathParam("type","track")
				.when()
				.get("https://api.spotify.com/v1/search?q={q}&type={type}");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);
	}
	
	//Shows
	
	@Test(priority=16)
	public void get_several_shows() {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/shows?ids=5CfCWKI5pZ28U0uOzXkDHe");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);
	}	
	@Test(priority=17)
	public void get_show_episodes() {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/shows/5CfCWKI5pZ28U0uOzXkDHe/episodes");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);
	}
	@Test(priority=18)
	public void get_shows() {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/shows/5CfCWKI5pZ28U0uOzXkDHe");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);
	}
	
	//Markets
	
	@Test(priority=19)
	public void get_available_markets() {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/markets");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);
	}
	
	//Episodes
	
	@Test(priority=20)
	public void get_episodes() {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/episodes/512ojhOuo1ktJprKbVcKyQ");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);
	}	
	@Test(priority=21)
	public void get_several_episodes() {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/episodes?ids=0Q86acNRm6V9GYx55SXKwf");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);
	}
	
	//Chapters
	
	@Test(priority=22)
	public void get_several_chapters() {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/chapters?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);
	}
	
	//Audiobooks
	
	@Test(priority=23)
	public void get_several_audiobooks() {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/audiobooks?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);
	}
	
	//Albums
	
	@Test(priority=24)
	public void get_several_albums() {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/albums?ids=382ObEPsp2rxGrnsizN5TX");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);
	}	
	@Test(priority=25)
	public void get_album() {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/albums/382ObEPsp2rxGrnsizN5TX");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);
	}	
	@Test(priority=26)
	public void get_album_tracks() {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/albums/382ObEPsp2rxGrnsizN5TX/tracks");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);
	}
	
	//Player
		
	@Test(priority=27)
	public void get_recently_played__tracks() {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/me/player/recently-played");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);	
	}		
	@Test(priority=28)
	public void get_available_devices() {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/me/player/devices");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);	
	}
	
	//Libraray
	
	@Test(priority=29)
	public void check_users_saved_albums () {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/me/albums/contains?ids=382ObEPsp2rxGrnsizN5TX");
		response.prettyPrint();
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);		
	}
	
	@Test(priority=30)
	public void check_users_saved_tracks () {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/me/tracks/contains?ids=4iV5W9uYEdYUVa79Axb7Rh");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);	
	}
	
	@Test(priority=31)
	public void save_audiobooks_for_current_users () {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.put("https://api.spotify.com/v1/me/audiobooks?ids=7ouMYWpwJ422jRcDASZB7P");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);	
	}
	
	@Test(priority=32)
	public void get_users_saved_shows () {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.put("https://api.spotify.com/v1/me/shows");
		response.prettyPrint();	
	}
	
	@Test(priority=33)
	public void get_users_saved_tracks () {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.put("https://api.spotify.com/v1/me/tracks");
		response.prettyPrint();			
	}
	
	//Follow
	
	@Test(priority=34)
	public void  get_followed_artist () {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.pathParam("type","artist")
				.when()
				.get("https://api.spotify.com/v1/me/following?type={type}");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);			
	}	
	@Test(priority=35)
	public void check_if_user_follows_artists_or_users () {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.pathParam("type","artist")
				.when()
				.get("https://api.spotify.com/v1/me/following/contains?type={type}&ids=74ASZWbe4lXaubB36ztrGX");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);		
	}
	@Test(priority=36)
	public void follow_playlist () {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.body("{\"public\":false}")
				.when()
				.put("https://api.spotify.com/v1/playlists/0IyBR2zrtA1fyhXEWDmP6z/followers");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);	
		
	}
	@Test(priority=37)
	public void follow_arists_or_users () {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.pathParam("type","artist")
				.pathParam("ids","74ASZWbe4lXaubB36ztrGX")
				.when()
				.put("https://api.spotify.com/v1/me/following?type={type}&ids={ids}");
		response.prettyPrint();	
//		response.then().statusCode(204);
//		Assert.assertEquals(response.statusCode(),204);		
	}
	@Test(priority=38)
	public void unfollow_arists_or_users () {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.pathParam("type","artist")
				.pathParam("ids","74ASZWbe4lXaubB36ztrGX")
				.when()
				.delete("https://api.spotify.com/v1/me/following?type={type}&ids={ids}");
		response.prettyPrint();	
		response.then().statusCode(204);
		Assert.assertEquals(response.statusCode(),204);			
	}
	@Test(priority=39)
	public void unfollow_playlist () {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.delete("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/followers");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);	
	}
	
	//Browse
	
	@Test(priority=40)
	public void get_available_genre_seeds () {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/recommendations/available-genre-seeds");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);		
	}
	@Test(priority=41)
	public void get_several_browse_category () {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/browse/categories");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);	
	}
	@Test(priority=42)
	public void get_singal_browse_category () {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/browse/categories/dinner");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);	
	}
	@Test(priority=43)
	public void get_category_playlist () {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/browse/categories/dinner");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);	
	}
	@Test(priority=44)
	public void get_featured_playlist () {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/browse/featured-playlists");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);	
	}
	@Test(priority=45)
	public void get_new_releases () {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/browse/new-releases");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);	
	}
	@Test(priority=46)
	public void get_recommendations () {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.pathParam("seed_artists","4NHQUGzhtTLFvgF5SZesLK")
				.pathParam("seed_genres","classical,country")
				.pathParam("seed_tracks","0c6xIDDpzE81m2q797ordA")
				.when()
				.get("https://api.spotify.com/v1/recommendations?seed_artists={seed_artists}&seed_genres={seed_genres}&seed_tracks={seed_tracks}");
		response.prettyPrint();	
		response.then().statusCode(200);
		Assert.assertEquals(response.statusCode(),200);	
	}	
}
