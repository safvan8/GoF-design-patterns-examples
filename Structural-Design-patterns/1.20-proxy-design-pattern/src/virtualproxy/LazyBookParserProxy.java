package virtualproxy;

//Virtual proxy that acts as a placeholder for the real BookParserImpl object.
class LazyBookParserProxy implements IBookParser {

	private IBookParser parser = null;

	private String bookContent;

	public LazyBookParserProxy(String bookContent) {
		this.bookContent = bookContent;
	}

	@Override
	public int getNumberOfPages() {
		// Create a new BookParserImpl object only if it's not already created.
		if (parser == null) {
			// This is the actual creation of the expensive BookParserImpl object.
			parser = new BookParserImpl(bookContent);
		}
		// Delegate the method call to the real object.
		int numberOfPages = parser.getNumberOfPages();
		return numberOfPages;
	}
}