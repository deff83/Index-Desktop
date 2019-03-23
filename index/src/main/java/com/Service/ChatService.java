package com.Service;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTML;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import javafx.application.Platform;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebEngine;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ChatService implements Runnable {

	private WebEngine chatView;
	private OkHttpClient client2 = new OkHttpClient();
	private String content;
	private int url_length;

	public ChatService(WebEngine chatView) {
		// TODO Auto-generated constructor stub
		this.chatView = chatView;
	}

	@Override
	public void run() {
		
		// TODO Auto-generated method stub
		Chat chat = Chat.getChat();
		try{
			String lastId = chat.getLastId();
			if(lastId.equals("x"))	lastId = getlasthundrid();
			
			if(lastId==null) return;
			
			//id в чате
			String urlmes = "http://events.webmoney.ru/api/discuss/GetListPushes?eventId=268270102&groupUid=6be4dadf-c7ab-44e1-a1bc-b5ba4fa961c0&lastId="+lastId+"";
			//RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
			Request requesturl = new Request.Builder()
				.url(urlmes)

				.build();
			Response responseurl = null;
			
			
			
			responseurl = client2.newCall(requesturl).execute();
			//System.out.println(response);
			//ответ тела post запроса
			String answirurl = responseurl.body().string(); 
			try{

				JSONArray jsonArray;
				jsonArray = new JSONArray(answirurl);
				url_length = jsonArray.length();
				int jstart=0;
				if (url_length > 100){jstart=url_length - 100;}
				
				String idmesstr = "";
				
				List<MessChat> listmesschat = new ArrayList<>();
				content = Chat.getChat().getHeadhtml();
				content +=  Chat.getChat().getBodyhtml();
				for (int j = jstart; j<url_length; j++){

					JSONObject idmesobj = jsonArray.getJSONObject(j);
					Integer idmes = idmesobj.getInt("discusId");
					idmesstr = idmes.toString();
					Chat.getChat().setLastId(idmesstr);
					


					//запрос текста сообщения
					try {
						String urlmesriv = "http://events.webmoney.ru/api/discuss/get2?discussId="+idmesstr+"&groupUid=6be4dadf-c7ab-44e1-a1bc-b5ba4fa961c0";
						//RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
						Request requestmesriv = new Request.Builder()
							.url(urlmesriv)
							.build();
						Response responsemesriv = null;



						responsemesriv = client2.newCall(requestmesriv).execute();
						String answirmesriv = responsemesriv.body().string(); 
						try{
							JSONObject jsonObjectmes;
							jsonObjectmes = new JSONObject(answirmesriv);
							String textmes = jsonObjectmes.getString("message");
							String datecreated = jsonObjectmes.getString("datecreated");
							JSONObject author = jsonObjectmes.getJSONObject("author");
							String nickname = author.getString("nickname");
							String wmidmes = author.getString("wmid");
							String attestat = author.getString("attestat");
							JSONObject imgjson = author.getJSONObject("icon");
							String urlimg = imgjson.getString("normal");
							MessChat messchat = new MessChat(textmes, nickname, wmidmes, urlimg, datecreated, attestat,idmesstr);
							
							Document doc = Jsoup.parse(textmes);
							//builder.parse(new InputSource(new StringReader(mess)));
							//NodeList as = doc.getElementsByTagName("a");
						Elements as = doc.select("a.user-link");
						for (Element a: as){
						String texta = a.attr("nickname");
						a.text(texta);
							//a.attr("style", "color: #ffffff");
						a.attr("href", "");
							
							listmesschat.add(messchat);
						}
						content +="<div class='mesblock'><div class='img'><img src = '"+urlimg+"' width='30' + height='30'></div><div class='mess'>"+"" + nickname +":" + doc.toString() + "</div></div>"
								+ "<div class='separator'>&nbsp</div>";
						}
						catch (JSONException e){
							e.printStackTrace();

						}

					} catch (Exception e){
						e.printStackTrace();
					}
					




				}
				content += Chat.getChat().getEndhtml();
				
				Chat.getChat().setBodyhtml(content);
				if(url_length!=0) {
				Platform.runLater(()->{
					
					chatView.loadContent(content);
					});
				}


			}
			catch (JSONException e){
				System.out.println("Error ChatService JSON:"+e.toString());
			}

			
		}catch(Exception e){
			System.out.println("Error ChatService:"+e.toString());
		}
		
		
	}
	private String getlasthundrid(){
		String lastid = null;
		try{
			String urlmeshund = "http://events.webmoney.ru/api/discuss/Paging?eventId=268270102&direction=0&pageSize=90";
		//RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
			
			Request requesturlhund = new Request.Builder()
			.url(urlmeshund)

			.build();
		Response responseurlhund = null;


		responseurlhund = client2.newCall(requesturlhund).execute();
			String answirmesrivhund = responseurlhund.body().string();
			try{
				JSONArray jsonArrayhund;
				jsonArrayhund = new JSONArray(answirmesrivhund);
				JSONObject jsonobj = jsonArrayhund.getJSONObject(0);
				lastid = jsonobj.getInt("id")+"";
				Chat.getChat().setLastId(lastid);
		}catch(JSONException e){System.out.println("Error ChatService JSON: "+e.toString());}
		}catch(Exception e){
			System.out.println("Error ChatService: "+e.toString());
		}
		System.out.println(lastid);
		
		return lastid;
	}
	

}
