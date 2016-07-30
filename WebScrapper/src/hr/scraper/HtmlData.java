package hr.scraper;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlData {

	public void getHtmlData(String uRl){
		try {

			Document doc = Jsoup
					.connect(uRl)
					.userAgent("Mozilla").get();

			String title = doc.title();
			System.out.println("title : " + title);

			Elements img = doc.getElementsByTag("img");
			
			for (Element el : img) {
				String src = el.absUrl("src");
				System.out.println(src);
				
				}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
