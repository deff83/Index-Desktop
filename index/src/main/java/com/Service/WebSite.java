package com.Service;

public class WebSite {
	private static WebSite website = new WebSite();
	private String graphickTradViewstart = "<html><head></head><body>\r\n" + 
			"<div class=\"tradingview-widget-container\">\r\n" + 
			"  <div id=\"tradingview_6baf7\"></div>\r\n" + 
			 
			"  <script type=\"text/javascript\" src=\"https://s3.tradingview.com/tv.js\"></script>\r\n" + 
			"  <script type=\"text/javascript\">\r\n" + 
			"  new TradingView.widget(\r\n" + 
			"  {\r\n" + 
			"  \"autosize\": true,\r\n" + 
			"  \"symbol\": \"BITFINEX:";
	
	private String graphickTradViewend = "\",\r\n" + 
			"  \"interval\": \"5\",\r\n" + 
			"  \"timezone\": \"Europe/Moscow\",\r\n" + 
			"  \"theme\": \"Dark\",\r\n" + 
			"  \"style\": \"1\",\r\n" + 
			"  \"locale\": \"ru\",\r\n" + 
			"  \"toolbar_bg\": \"rgba(0, 0, 0, 1)\",\r\n" + 
			"  \"enable_publishing\": false,\r\n" + 
			//"  \"hide_top_toolbar\": true,\r\n" + 
			"  \"watchlist\": [\r\n" + 
			"    \"BITFINEX:BCHUSD\",\r\n" + 
			"    \"BITFINEX:ETHUSD\",\r\n" + 
			"    \"BITFINEX:LTCUSD\",\r\n" + 
			"    \"BITFINEX:XRPUSD\",\r\n" + 
			"    \"BITFINEX:DSHUSD\",\r\n" + 
			"    \"BITFINEX:XMRUSD\",\r\n" + 
			"    \"BITFINEX:BTGUSD\"\r\n" + 
			"  ],\r\n" + 
			"  \"studies\": [\r\n" + 
			"    \"MASimple@tv-basicstudies\"\r\n" + 
			"  ],\r\n" + 
			"  \"container_id\": \"tradingview_6baf7\"\r\n" + 
			"}\r\n" + 
			"  );\r\n" + 
			"  </script>\r\n" + 
			"</div>\r\n" + 
			"</body>";
	private WebSite() {
		// TODO Auto-generated constructor stub
	}
	public static WebSite getWebSite() {
		return website ;
	}
	public String getGraphickTradView(int zCoin) {
		String graphickTradView = graphickTradViewstart;
		switch(zCoin) {
		case 60:graphickTradView += "BTCUSD";
			break;
		case 66:graphickTradView += "BCHUSD";
		break;
		case 64:graphickTradView += "ETHUSD";
		break;
		case 69:graphickTradView += "LTCUSD";
		break;
		case 70:graphickTradView += "XRPUSD";
		break;
		case 71:graphickTradView += "DSHUSD";
		break;
		case 68:graphickTradView += "XMRUSD";
		break;
		case 67:graphickTradView += "BTGUSD";
		break;
		
		default:graphickTradView += "BTCUSD";
			break;
		}
		graphickTradView += graphickTradViewend;
		return graphickTradView;
	}
	
	
}
