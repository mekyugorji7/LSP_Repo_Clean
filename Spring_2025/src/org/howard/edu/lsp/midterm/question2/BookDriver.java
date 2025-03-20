package org.howard.edu.lsp.midterm.question2;

class Book {
    private String title;
    private String author;
    private String ISBN;
    private int yearPublished;

    /**
     * Constructor to initialize a Book object.
     * @param title The title of the book.
     * @param author The author of the book.
     * @param ISBN The ISBN number of the book.
     * @param yearPublished The year the book was published.
     */
    public Book(String title, String author, String ISBN, int yearPublished) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.yearPublished = yearPublished;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }


    public int getYearPublished() {
        return yearPublished;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    /**
     * Checks if two books are equal based on ISBN and author.
     * @param obj The object to compare.
     * @return true if the books have the same ISBN and author, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return this.ISBN.equals(book.ISBN) && this.author.equals(book.author);
    }

    /**
     * Returns a string representation of the book.
     * @return A formatted string containing book details.
     */
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN + ", Year Published: " + yearPublished;
    }
}

// BookDriver class to test the Book class
public class BookDriver {
    /**
     * Main method to test the Book class functionality.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789", 1925);
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789", 1925);
        Book book3 = new Book("A Promised Land", "Barack Obama", "9780593239681", 2020);

        System.out.println(book1.equals(book2)); // true
        System.out.println(book1.equals(book3)); // false
        System.out.println(book1); // Output: Title: The Great Gatsby, Author: F. Scott Fitzgerald, ISBN: 123456789, Year Published: 1925
    }
}