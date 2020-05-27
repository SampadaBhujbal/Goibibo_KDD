package com.goibibo.searchFlight;

import com.goibibo.keyword.Keyword;

public class SearchFlight extends Keyword {
	public static void searchFlight() {
		openBrowser("chrome");
		launchUrl("https://www.goibibo.com");
		implicitWait(3);
		maximize();
		enterText("from","Mumbai");
		mouseHoverClick("citysource");
		enterText("from","Pune");
		mouseHoverClick("citydest");
		click("date");
		click("currentDate");
		click("search");


	
	
	}

}
