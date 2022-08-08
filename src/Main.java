import controller.BookManager;
import model.Book;
import storage.ReadWriteData;
import storage.RWData;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static BookManager bookManager = new BookManager();
    static RWData readWrite = ReadWriteData.getInstance();

    public static void main(String[] args) {
        menu();
    }
    public static void menu() {
        try {
            do {
                System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM ----");
                System.out.println("Chọn chức năng theo số (để tiếp tục)");
                System.out.println("1. Xem danh sách");
                System.out.println("2. Thêm mới");
                System.out.println("3. Cập nhật");
                System.out.println("4. Xóa");
                System.out.println("5. Sắp xếp");
                System.out.println("6. Tìm sản phẩm có giá đắt nhất");
                System.out.println("7. Đọc từ file");
                System.out.println("8. Ghi vào file");
                System.out.println("9. Thoát");
                System.out.println("Nhập lựa chọn: ");
                Scanner scanner = new Scanner(System.in);
                Scanner scanner1 = new Scanner(System.in);
                int sc = scanner1.nextInt();
                switch (sc) {
                    case 1:
                        bookManager.display();
                        break;
                    case 2:
                        System.out.println("Hãy nhập ID");
                        String ID = scanner.nextLine();
                        System.out.println("Hãy nhập tên");
                        String name = scanner.nextLine();
                        System.out.println("Hãy nhập giá");
                        double price = scanner1.nextDouble();
                        System.out.println("Hãy nhập số lượng");
                        int quantity = scanner1.nextInt();
                        System.out.println("Hãy nhập mô tả");
                        String description = scanner.nextLine();
                        Book book = new Book(ID, name, price, quantity, description) {
                        };
                        bookManager.addBook(book);
                        break;
                    case 3:
                        try {
                            System.out.println("Nhập ID");
                            String id = scanner.nextLine();
                            int check = bookManager.checkID(id);
                            if (check == -1) {
                                System.out.println("Không có sản phẩm theo ID");
                            } else {
                                System.out.println("Hãy tạo ID ");
                                String newID = scanner1.nextLine();
                                System.out.println("Hãy tạo tên ");
                                String newName = scanner.nextLine();
                                System.out.println("Hãy tạo giá ");
                                double newPrice = scanner1.nextDouble();
                                System.out.println("Hãy nhập số lượng ");
                                int newQuantity = scanner.nextInt();
                                System.out.println("Tạo mô tả cho sách");
                                String newDescription = scanner1.nextLine();
                                Book book1 = new Book(newID, newName, newPrice, newQuantity, newDescription) {
                                };
                                bookManager.editBook(check, book1);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Mời nhập lại dữ liệu");
                            System.out.println("------------------------------");
                        }
                        break;
                    case 4:
                        try {
                            System.out.print("Mời nhập ID: ");
                            String id = scanner.nextLine();
                            int checkID = bookManager.checkID(id);
                            if (checkID == -1) {
                                System.out.println("Không tìm thấy sản phẩm");
                                System.out.println("----------------------------------");
                            } else {
                                bookManager.deleteBook(checkID);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Mời nhập liệu");
                            System.out.println("------------------------------");
                        }
                        break;
                    case 5:
                        try {
                            System.out.println("1. Sắp xếp");
                            System.out.println("2. Hiển thị danh sách đã sắp xếp");
                            System.out.println("3. Trở về menu chính");
                            int case5 = scanner.nextInt();
                            switch (case5){
                                case 1:
                                    bookManager.sortByPriceLowtoHight();
                                    break;
                                case 2:
                                    bookManager.display();
                                    break;
                                case 3:
                                    menu();
                                    break;
                            }
                        } catch (InputMismatchException e){
                            System.out.println("Mời nhập lại");
                            System.out.println("------------------------------");
                        }
                        break;
                    case 6:
                        bookManager.sortByPriceLowtoHight();
                        List<Book> bookListInMain = bookManager.bookList;
                        for (int i = 0; i < bookListInMain.size(); i++) {
                            System.out.println(bookListInMain.get(bookListInMain.size()-1));
                        }
                        break;
                    case 7:
                        readWrite.writeData(bookManager.bookList);
                        break;
                    case 8:
                        bookManager.bookList = readWrite.readData();
                        break;
                    case 9:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Mời nhập lại ");
                        break;
                    }
                } while (true) ;
            } catch(Exception e){
                    System.err.println("Hãy nhập số!");
                    menu();
            }
        }
}