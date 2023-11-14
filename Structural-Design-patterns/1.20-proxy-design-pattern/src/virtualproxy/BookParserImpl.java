package virtualproxy;

//Concrete implementation of IBookParser that represents an actual book parser.
class BookParserImpl implements IBookParser {

	private String bookContent;

	private int numberOfPages;

	// Constructor initializes the book content and performs the expensive page
	// counting.
	public BookParserImpl(String bookContent) {
		this.bookContent = bookContent;

		// Simulate an expensive operation: counting the number of pages in the book.
		numberOfPages = 5657;
	}

	@Override
	public int getNumberOfPages() {
		return numberOfPages;
	}
}
