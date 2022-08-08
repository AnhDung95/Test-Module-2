package storage;
import model.Book;
import java.util.List;

public interface RWData {
    public void writeData(List<Book> products);
    public List<Book> readData();
}
