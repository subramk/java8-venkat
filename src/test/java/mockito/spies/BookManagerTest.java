package mockito.spies;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookManagerTest {

	@InjectMocks
	private BookManager bookManager;
	
	@Spy
	private BookService bookService ;
	
	@Test
	public void testMockitoSpy(){

		// We need to mock findBook because it is communicating to database or not implemented
		// We need to call getAppliedDiscount to calculate the discounted price
		Book book = new Book("1234", "Mockito In Action", 500, LocalDate.now());
		doReturn(book).when(bookService).findBook(anyString());
		// use doReturn() syntax when working with Spy()
		// use when(...).thenReturn(....) when working with mocks.

		//when(bookService.findBook("1234")).thenReturn(book); // use doReturn when working with Spy()
		int actualDiscount = bookManager.applyDiscountOnBook("1234", 10);
		assertEquals(450, actualDiscount);
	}
	
}
