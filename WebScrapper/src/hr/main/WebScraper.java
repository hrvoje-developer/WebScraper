package hr.main;

import java.util.Scanner;

import hr.parser.ParserUrl;
import hr.scraper.HtmlData;

public class WebScraper {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Give me URL for processing: ");
		
		String enteredUrl = sc.next();
		
		sc.close();

		ParserUrl startParser = new ParserUrl();

		startParser.setURL(enteredUrl);

		System.out.println(startParser.getURL());

		HtmlData loadHtml = new HtmlData();
		
		loadHtml.getHtmlData(enteredUrl);

	}

}