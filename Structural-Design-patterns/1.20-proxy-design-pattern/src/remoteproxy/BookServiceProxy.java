package remoteproxy;

//BookServiceProxy.java (Remote Proxy)
import java.rmi.Naming;
import java.rmi.RemoteException;

public class BookServiceProxy implements BookService {
	private BookService bookService;

	public BookServiceProxy() {
		try {
			// Lookup the remote service from the RMI registry
			this.bookService = (BookService) Naming.lookup("rmi://localhost/BookService");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getBookInfo(String bookTitle) {
		try {
			// Delegate the request to the real remote service
			return bookService.getBookInfo(bookTitle);
		} catch (Exception e) {
			e.printStackTrace();
			return "Error fetching book information";
		}
	}

	public static void main(String[] args) throws RemoteException {
		// Client code using the remote proxy
		BookService bookService = new BookServiceProxy();
		System.out.println(bookService.getBookInfo("Java101"));
		System.out.println(bookService.getBookInfo("NonexistentBook"));
	}
}
