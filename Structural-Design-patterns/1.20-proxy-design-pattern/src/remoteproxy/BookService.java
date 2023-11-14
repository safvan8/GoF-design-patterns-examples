package remoteproxy;

//BookService.java (Remote Interface)
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BookService extends Remote {
	String getBookInfo(String bookTitle) throws RemoteException;
}