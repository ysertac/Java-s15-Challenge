package model;

import utils.Constants;

import java.util.Arrays;

public class User extends Person {
    private Double balance;
    private Book[] books;

    public User(Integer id, String name, Double balance) {
        super(id, name);
        this.books = new Book[5];
        this.balance = balance;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void takeBook(Book book) {
        if (getBooks()[4] != null) {
            System.out.println(Constants.BOOK_LIMIT);
        } else {
            for (int i = 0; i < 5; i++) {
                if (getBooks()[i] == null) {
                    getBooks()[i] = book;
                    break;
                }
            }
            setBalance(getBalance() - book.getDeposit());
            book.setAvailable(false);
        }
    }

    public void replace(Book book) {
        if (getBooks()[0] == null) {
            System.out.println(Constants.INVALID_REPLACE);
        } else {
            for (int i = 0; i < 5; i++) {
                if (getBooks()[i].equals(book)) {
                    getBooks()[i] = null;
                    break;
                }
            }
            setBalance(getBalance() + book.getDeposit());
            book.setAvailable(true);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", books=" + Arrays.toString(books) +
                ", balance=" + balance +
                '}';
    }
}
