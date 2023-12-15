import enums.Category;
import model.Author;
import model.Book;
import interfaces.Finder;
import model.User;
import utils.Constants;

import java.util.*;

public class BookController implements Finder {
    private Map<Integer, Book> allBooks;
    private List<User> userList;
    private Map<Integer, Author> allAuthors;
    private List<Book> availableBooks;

    public BookController() {
        this.allBooks = new TreeMap<>();
        this.userList = new LinkedList<>();
        this.allAuthors = new TreeMap<>();
        this.availableBooks = new LinkedList<>();
    }

    public Map<Integer, Book> getAllBooks() {
        return allBooks;
    }

    public void setAllBooks(Map<Integer, Book> books) {
        this.allBooks = books;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> users) {
        this.userList = users;
    }

    public Map<Integer, Author> getAllAuthors() {
        return allAuthors;
    }

    public void setAllAuthors(Map<Integer, Author> allAuthors) {
        this.allAuthors = allAuthors;
    }

    public void addBook(Book book) {
        if (allBooks.containsKey(book.getId())) {
            System.out.println(Constants.EXIST);
        } else {
            allBooks.put(allBooks.size() + 1, book);
        }
    }

    public void printAllBooks() {
        int x = allBooks.size();
        for (int i = 0; i < x; i++) {
            if (allBooks.containsKey(i + 1)) {
                System.out.println(getBook(i + 1));
            } else {
                x++;
            }
        }
    }

    public Map<Integer, Book> categoryFilter(Category category) {
        Map<Integer, Book> filteredBooks = new HashMap<>();
        if (category == null) {
            System.out.println(Constants.CATEGORY_ERR);
        } else {
            for (int i = 0; i < allBooks.size(); i++) {
                if (getBook(i + 1).getCategory() == category) {
                    filteredBooks.put(getBook(i + 1).getId(), getBook(i + 1));
                }
            }
        }
        return filteredBooks;
    }

    public Map<Integer, Book> authorFilter(Author author) {
        Map<Integer, Book> filteredBooks = new HashMap<>();
        if (author == null) {
            System.out.println(Constants.INVALID_AUTHOR);
        } else {
            for (int i = 0; i < allBooks.size(); i++) {
                if (getBook(i + 1).getAuthor() == author) {
                    filteredBooks.put(getBook(i + 1).getId(), getBook(i + 1));
                }
            }
        }
        return filteredBooks;
    }

    public void updateBook(Scanner scanner) {
        System.out.println(Constants.SCANNER_ID);
        int id = scanner.nextInt();
        scanner.nextLine();
        Book chosenBook = getBook(id);

        if (chosenBook != null) {
            System.out.println(chosenBook);
            System.out.println(Constants.UPDATE_QUESTION);
            String prop = scanner.nextLine();
            switch (prop) {
                case "1":
                    System.out.println(Constants.NEW_VALUE);
                    String nameValue = scanner.nextLine();
                    chosenBook.setName(nameValue);
                    break;
                case "2":
                    System.out.println(Constants.NEW_VALUE);
                    String authorName = scanner.nextLine();
                    for (int i = 0; i < allAuthors.size(); i++) {
                        if (allAuthors.get(i + 1).getName().equalsIgnoreCase(authorName)) {
                            Author newAuthor = allAuthors.get(i + 1);
                            chosenBook.setAuthor(newAuthor);
                        }}
                    break;
                case "3":
                    System.out.println(Constants.NEW_VALUE);
                    String depositValue = scanner.nextLine();
                    chosenBook.setDeposit(Double.valueOf(depositValue));
                    break;
                case "4":
                    System.out.println(Constants.NEW_VALUE);
                    String categoryName = scanner.nextLine();
                    try {
                        for (Category c : Category.values()) {
                            if (c.name().equalsIgnoreCase(categoryName)) {
                                chosenBook.setCategory(c);
                            }
                        }
                    } catch (NullPointerException e) {
                        System.out.println(Constants.CATEGORY_ERR);
                    }
                    break;
                case "5":
                    System.out.println(Constants.NEW_VALUE);
                    String isAvailable = scanner.nextLine();
                    if (isAvailable.equalsIgnoreCase("true") || isAvailable.equalsIgnoreCase("false")) {
                        chosenBook.setAvailable(Boolean.valueOf(isAvailable));
                    } else {
                        System.out.println(Constants.INVALID_IN);
                    }
                    break;
                default:
                    System.out.println(Constants.INVALID_IN);
                    break;
            }
        }
    }

    public void deleteBook(Integer id) {
        if (!(allBooks.containsKey(id))) {
            System.out.println(Constants.INVALID_ID);
        } else {
            allBooks.keySet().remove(id);
            System.out.println(Constants.SUCCESS);
        }
    }

    public void addAuthor(Author author) {
        if (allAuthors.containsKey(author.getId())) {
            System.out.println(Constants.INVALID_AUTHOR);
        } else {
            allAuthors.put(allAuthors.size() + 1, author);
        }
    }

    public void printAllAuthors() {
        int x = allAuthors.size();
        for (int i = 0; i < x; i++) {
            if (allAuthors.containsKey(i + 1)) {
                System.out.println(getAuthor(i + 1));
            } else {
                x++;
            }
        }
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void printAllUsers() {
        for (User u : userList) {
            System.out.println(u);
        }
    }

    @Override
    public Book getBook(Integer id) {
        if (allBooks.containsKey(id)) {
            return allBooks.get(id);
        } else {
            return null;
        }
    }

    @Override
    public User getUser(Integer id) {
        for (User u : userList) {
           if (u.getId() == id) {
               return u;
           }
        }
        return null;
    }

    @Override
    public Author getAuthor(Integer id) {
        if (allAuthors.containsKey(id)) {
            return allAuthors.get(id);
        } else {
            return null;
        }
    }
}
