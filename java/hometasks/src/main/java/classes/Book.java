package classes;

public class Book {
    private long bookId;
    private String bookName;
    private String bookAuthor;
    private String bookPublisher;
    private short bookYearOfPublishing;
    private int bookPages;
    private int bookPrice;
    private String bookCoverType;

    public Book(long bookId, String bookName, String bookAuthor, String bookPublisher, short bookYearOfPublishing, int bookPages, int bookPrice, String bookCoverType) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
        this.bookYearOfPublishing = bookYearOfPublishing;
        this.bookPages = bookPages;
        this.bookPrice = bookPrice;
        this.bookCoverType = bookCoverType;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public short getBookYearOfPublishing() {
        return bookYearOfPublishing;
    }

    public void setBookYearOfPublishing(short bookYearOfPublishing) {
        this.bookYearOfPublishing = bookYearOfPublishing;
    }

    public int getBookPages() {
        return bookPages;
    }

    public void setBookPages(int bookPages) {
        this.bookPages = bookPages;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookCoverType() {
        return bookCoverType;
    }

    public void setBookCoverType(String bookCoverType) {
        this.bookCoverType = bookCoverType;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPublisher='" + bookPublisher + '\'' +
                ", bookYearOfPublishing=" + bookYearOfPublishing +
                ", bookPages=" + bookPages +
                ", bookPrice=" + bookPrice +
                ", bookCoverType='" + bookCoverType + '\'' +
                '}';
    }
}