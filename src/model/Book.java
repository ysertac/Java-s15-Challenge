package model;

import enums.Category;

import java.util.Objects;

public class Book implements Comparable<Book> {
    private Integer id;
    private String name;
    private Author author;
    private Double deposit;
    private Boolean isAvailable;
    private User user;
    private Category category;

    public Book(Integer id, String name, Author author, Double deposit, Category category) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.deposit = deposit;
        this.category = category;
        isAvailable = true;
        user = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Book book) {
        return this.name.compareTo(book.name);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author.getName() +
                ", deposit=" + deposit +
                ", isAvailable=" + isAvailable +
                ", user=" + user +
                ", category=" + category +
                '}';
    }
}
