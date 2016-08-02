package hr.scraper;

import java.io.IOException;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlData {

	public void getHtmlData(String uRl) {
		try {

			Document doc = Jsoup.connect(uRl).userAgent("Mozilla").get();

			String title = doc.title();
			System.out.println("title : " + title);

			Elements img = doc.getElementsByTag("img");

			for (Element el : img) {
				String src = el.absUrl("src");
				System.out.println(src);
				System.out.println(src);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getHtmlDataAll(String uRl) {
		try {
			Document doc = Jsoup.connect(uRl).userAgent("Mozilla").get();
			// System.out.println(doc);

			try (PrintWriter out = new PrintWriter("filename.txt")) {
				out.println(doc);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getNjuskaloCarData(String uRl) {
		try {

			Document docNumber = Jsoup.connect(uRl).userAgent("Mozilla").get();
			Element text = docNumber.select("strong.entities-count").first();
			String pageNumber = text.text();
			System.out.println(pageNumber);
			int numberPage = Integer.parseInt(pageNumber);
			int pages = (numberPage / 25) + 1;
			String newUrl = uRl;
			
			for (int i = 1; i <= pages; i++) {
				try {
					String newPageNumber = Integer.toString(i);
					String deletePageNumber = Integer.toString(i-1);
					String subString = "&page="+deletePageNumber;
					newUrl = newUrl.replace(subString,"");
					newUrl = newUrl+"&page="+newPageNumber;
					Document doc = Jsoup.connect(newUrl).userAgent("Mozilla").get();

					Elements links = doc.select("div.EntityList--Regular").select("div.entity-thumbnail")
							.select("a.link").select("a[href]");

					for (Element link : links) {
						String absHref = link.attr("abs:href");
						System.out.println(absHref);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
