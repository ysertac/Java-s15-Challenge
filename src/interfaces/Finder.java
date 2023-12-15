package interfaces;

import model.Author;
import model.Book;
import model.User;

public interface Finder {
    Book getBook(Integer id);
    User getUser(Integer id);
    Author getAuthor(Integer id);
}
