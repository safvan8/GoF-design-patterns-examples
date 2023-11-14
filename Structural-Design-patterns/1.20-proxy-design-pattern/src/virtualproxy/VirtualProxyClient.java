package virtualproxy;

public class VirtualProxyClient {

	public static void main(String[] args) {
		// Example usage of LazyBookParserProxy

		String bookContent = "This is the content of the book.";

		// Create a virtual proxy for the book parser.
		LazyBookParserProxy bookParserProxy = new LazyBookParserProxy(bookContent);

		// At this point, no BookParserImpl object is created yet.

		// When getNumberOfPages() is called, the BookParserImpl object will be created.
		int numberOfPages = bookParserProxy.getNumberOfPages();

		// Display the result.
		System.out.println("Number of Pages: " + numberOfPages);
	}
}
