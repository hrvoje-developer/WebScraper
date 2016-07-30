/* Hrvoje Vlahovic © */

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

		startParser.setUrl(enteredUrl);
		startParser.glueCarUrl("10000", "20000", "2010", "2016", "600", "45", "150", "50000", "150000");

		System.out.println(startParser.getUrl());

		HtmlData loadHtml = new HtmlData();
		
		//loadHtml.getHtmlData(enteredUrl);
		//loadHtml.getHtmlDataAll(enteredUrl);
		loadHtml.getNjuskaloCarData(enteredUrl);

	}

}