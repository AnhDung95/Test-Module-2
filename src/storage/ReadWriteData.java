package storage;

import model.Book;
import java.io.*;
import java.util.List;

public class ReadWriteData implements RWData{
    private static ReadWriteData instance = null;
    private ReadWriteData() {
    }
    public static ReadWriteData getInstance() {
        if (instance == null) {
            return instance = new ReadWriteData();
        } else return instance;
    }

    public void writeData(List<Book> products) {
        try {
            FileOutputStream fos = new FileOutputStream("manager.csv");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            fos.close();
            oos.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    public List<Book> readData() {
        try {
            FileInputStream fis = new FileInputStream("manager.csv");
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Book> list =  (List<Book>) ois.readObject();
            fis.close();
            ois.close();
            return list;
        } catch (IOException | ClassNotFoundException e){
            System.err.println(e.getMessage());
        }
        return null;
    }
}
