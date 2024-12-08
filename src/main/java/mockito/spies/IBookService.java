package mockito.spies;

public interface IBookService {
    public Book findBook(String bookId);

    public int getAppliedDiscount(Book book, int discountRate);
}