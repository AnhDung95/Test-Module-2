package controller;
import storage.ReadWriteData;

import model.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookManager {
    public List<Book> bookList = new ArrayList<>();
    public void display(){
        for (Book x : bookList
        ) {
            System.out.println(x.toString());
        }
    }
    public void addBook(Book book) {
        bookList.add(book);
    }
    public void editBook(int id, Book book) {
        bookList.set(id,book);
    }
    public void deleteBook(int id_book) {
        bookList.remove(id_book);
    }
    public int checkID(String id){
        int check = -1;
        for (int i = 0; i < bookList.size(); i++) {
            if (id.equals(bookList.get(i).getID())){
                check = i;
            }
        }
        return check;
    }

    public void sortByPriceLowtoHight(){
        bookList.sort(Comparator.comparingDouble(Book::getPrice));
    }
}
