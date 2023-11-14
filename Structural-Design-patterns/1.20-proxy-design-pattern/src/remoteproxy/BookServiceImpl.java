package remoteproxy;

//BookServiceImpl.java (Remote Service Implementation)
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class BookServiceImpl extends UnicastRemoteObject implements BookService {
	private static final long serialVersionUID = 1L;
	private Map<String, String> bookDatabase;

	protected BookServiceImpl() throws RemoteException {
		super();
		// Initialize the book database
		bookDatabase = new HashMap<>();
		bookDatabase.put("Java101", "Author: John Doe, Pages: 300");
		bookDatabase.put("DesignPatterns", "Author: Jane Smith, Pages: 250");
		bookDatabase.put("DataScienceGuide", "Author: Alan Johnson, Pages: 400");
	}

	@Override
	public String getBookInfo(String bookTitle) throws RemoteException {
		return bookDatabase.getOrDefault(bookTitle, "Book not found");
	}

	public static void main(String[] args) {
		try {
			// Register the remote service in the RMI registry
			BookService bookService = new BookServiceImpl();
			java.rmi.Naming.rebind("BookService", bookService);
			System.out.println("BookService is ready.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
