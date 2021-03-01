package mp2;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
 
/**
 * This class is used for HTML parsing from URL using Jsoup.
 * @author w3spoint
 */
class BookInfo {
  public static void main(String args[]){
    Document document;
    try {
        document = Jsoup.connect("https://www.barnesandnoble.com/b/books/_/N1fZ29Z8q8").get();
 
	String title = document.title();
	System.out.println("Title: " + title);
    } catch (IOException e) {
	e.printStackTrace();
    }		
  }
}


public class Problem20 {
	public static void main(String[] args) {
		ArrayList<BookInfo> books;
		books = BookReader.readBooksJsoup("https://www.barnesandnoble.com/b/books/_/N1fZ29Z8q8");
		Collections.sort(books);
		for(int i=0; i<books.size(); i++) {
			BookInfo book = books.get(i);
			System.out.println(book);
		}
	}
}