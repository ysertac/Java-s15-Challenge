import enums.Category;
import model.Author;
import model.Book;
import model.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookController library = new BookController();
        Author dostoyevski = new Author(1, "Dostoyevski", "Russia");
        Author leibniz = new Author(5, "Leibniz", "England");
        Book sucVeCeza = new Book(1, "Suç ve Ceza", dostoyevski, 21.90, Category.NOVEL);
        Book diferansiyelDenklemler = new Book(2, "Diferansiyel Denklemler", leibniz, 90d, Category.MATHS);
        Book olulerEvindenAnilar = new Book(3, "Ölüler Evinden Anılar", dostoyevski, 90d, Category.MATHS);
        User sertac = new User(1, "Sertaç YILDIRIR", 100d);
        User ahmet = new User(2, "Ahmet ANTA", 50d);
        library.addAuthor(dostoyevski);
        library.addAuthor(leibniz);
        library.addUser(sertac);
        library.addUser(ahmet);
        library.addBook(sucVeCeza);
        library.addBook(diferansiyelDenklemler);
        library.addBook(olulerEvindenAnilar);
        library.printAllBooks();
        System.out.println(library.categoryFilter(Category.MATHS));
        System.out.println(library.authorFilter(dostoyevski));
        library.printAllAuthors();
        library.printAllUsers();
        sertac.takeBook(sucVeCeza);
        System.out.println(sertac);
        sertac.replace(sucVeCeza);
        System.out.println(sertac);
        library.updateBook(new Scanner(System.in));
        library.printAllBooks();
    }
}