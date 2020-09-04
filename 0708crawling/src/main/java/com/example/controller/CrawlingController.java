package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.AirVO;
import com.example.mapper.AirMapper;

@Controller
public class CrawlingController {
	@Autowired
	AirMapper mapper;
	
	//무비차트 크롤링
	   @RequestMapping("/movie.json")
	   @ResponseBody
	   public HashMap<String, Object> movieJson()throws Exception{
	      HashMap<String, Object> map=new HashMap<String, Object>();
	      Document doc=Jsoup.connect("http://www.cgv.co.kr/movies/").get();
	      Elements es=doc.select(".sect-movie-chart");      
	      ArrayList<HashMap<String,Object>> array=
	            new ArrayList<HashMap<String,Object>>();   
	      for(Element e:es.select("li")){
	         HashMap<String, Object> m=new HashMap<String, Object>();
	         m.put("rank",  e.select(".rank").text());
	         m.put("title", e.select(".title").text());
	         m.put("image", e.select("img").attr("src"));
	         m.put("date", e.select(".txt-info").text());
	         if(!e.select(".title").text().equals("")){
	            array.add(m);
	         }
	      }
	      map.put("array", array);
	      return map;
	   }
	   
	   
	   //다음날씨
	   @RequestMapping("/weather.json")
	   @ResponseBody
	   public HashMap<String, Object> weatherJson()throws Exception{
	      HashMap<String, Object> map=new HashMap<String, Object>();
	      Document doc=Jsoup.connect("http://www.daum.net").get();
	      Elements today=doc.select(".info_today");
	      map.put("date", today.select(".date_today").text());
	      
	      Elements es=doc.select(".list_weather");
	      ArrayList<HashMap<String,Object>> array=
	            new ArrayList<HashMap<String,Object>>();   
	      for(Element e:es.select("li")){
	         HashMap<String, Object> m=new HashMap<String, Object>();
	         m.put("part", e.select(".txt_part").text());
	         m.put("temper", e.select(".txt_temper").text());
	         m.put("wa", e.select(".ir_wa").text());
	         m.put("ico", e.select(".ico_ws").text());
	         array.add(m);
	      }
	      map.put("array", array);
	      return map;
	   }
	   
	   
	   @RequestMapping("/finance.json")
	   @ResponseBody
	   public HashMap<String, Object> financeJSON()throws Exception{
	      HashMap<String, Object> map=new HashMap<String, Object>();
	      Document doc=Jsoup.connect("https://finance.naver.com/").get();
	      
	      Elements es=doc.select("#_topItems1");
	      ArrayList<HashMap<String,Object>> array=
	            new ArrayList<HashMap<String,Object>>();   
	      for(Element e:es.select("tr")){
	         HashMap<String, Object> m=new HashMap<String, Object>();
	         m.put("company", e.select("a").text());
	         m.put("no1", e.select("td:nth-child(2)").text());
	         m.put("no2", e.select("td:nth-child(3)").text());
	         m.put("no3", e.select("td:nth-child(4)").text());
	         array.add(m);
	      }
	      map.put("array", array);
	      return map;
	   }
	   
	   @RequestMapping("/list")
	   public void list(){
	      
	   }
	   
	   //에어비앤비 크롤링
	   @RequestMapping("/airbnb.json")
	   @ResponseBody
	   public HashMap<String, Object> airbnbJson()throws Exception{
	      HashMap<String, Object> map=new HashMap<String, Object>();
	      Document doc=Jsoup.connect("https://www.airbnb.co.kr/s/Incheon--South-Korea/homes").get();
	      //System.out.println(doc);
	      Elements es=doc.select("._1gw6tte");
	      //System.out.println(es);
    	  ArrayList<HashMap<String,Object>> array=
	  	            new ArrayList<HashMap<String,Object>>();  
	      for(Element e:es.select("._gig1e7")) {
	    	  //e의 갯수만큼 찍기
	    	 //System.out.println("-------------");
	    	  HashMap<String,Object> m=new HashMap<String,Object>();
	    	  String title=e.select("a").attr("aria-label");
	    	  String image=e.select("._91slf2a").attr("src");
	    	  String info=e.select("._kqh46o").text();
	    	  String rating=e.select("._10fy1f8").text();
	    	  
	    	  m.put("title", title);
	    	  m.put("image", image);
	    	  m.put("info", info);
	    	  m.put("rating", rating);
	    	  array.add(m);
	    	  
	    	  AirVO vo=new AirVO();
	    	  vo.setCity("인천");
	    	  vo.setTitle(e.select("a").attr("aria-label"));
	    	  AirController air=new AirController();
	    	  image=air.download(image);
	    	  vo.setImage(image);
	    	  vo.setInfo(info);
	    	  vo.setRating(rating);
	    	  mapper.insert(vo);
	      }
	      map.put("array", array);
	      return map;
	   }
	   
	   @RequestMapping("/airbnb")
	   public void airbnb(){
		   
	      
	   }

}
