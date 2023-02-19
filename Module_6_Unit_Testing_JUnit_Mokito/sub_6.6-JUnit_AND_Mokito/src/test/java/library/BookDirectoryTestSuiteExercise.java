package library;

import com.kodilla.library.Book;
import com.kodilla.library.BookLibrary;
import com.kodilla.library.LibraryDatabase;
import com.kodilla.library.LibraryUser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuiteExercise {

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    private BookLibrary bookLibrary;

    private static List<LibraryUser> libraryUsers = new ArrayList<>();

    @BeforeAll
    public static void init() {
        libraryUsers.add(new LibraryUser("Johny", "Deep", "5562"));
        libraryUsers.add(new LibraryUser("Emily", "Grey", "6969"));
        libraryUsers.add(new LibraryUser("Bulbi", "The Mighty", "9999"));
    }

    @BeforeEach
    public void before(){
        bookLibrary = new BookLibrary(libraryDatabaseMock);
    }

    @DisplayName("The test will check whether testListBooksInHandsOf() from BookLibrary class" +
            "returns List with a correct number of Books. In this test - 0")
    @Test
    void testListBooksInHandsReturnListOf0(){
        // Given
        List<Book> resultListOf0Books = generateListOfNBooks(0);

        when(libraryDatabaseMock.listBooksInHandsOf(libraryUsers.get(0))).thenReturn(resultListOf0Books);

        // When
        List<Book> theListOf0Books = bookLibrary.listBooksInHandsOf(libraryUsers.get(0));

        // Then
        assertEquals(0, theListOf0Books.size());

    }

    @DisplayName("The test will check whether testListBooksInHandsOf() from BookLibrary class" +
            "returns List with a correct number of Books. In this test - 1")
    @Test
    void testListBooksInHandsReturnListOf1(){
        // Given
        List<Book> resultListOf1Books = generateListOfNBooks(1);

        when(libraryDatabaseMock.listBooksInHandsOf(libraryUsers.get(1))).thenReturn(resultListOf1Books);

        // When
        List<Book> theListOf1Books = bookLibrary.listBooksInHandsOf(libraryUsers.get(1));

        // Then
        assertEquals(1, theListOf1Books.size());
        }

    @DisplayName("The test will check whether testListBooksInHandsOf() from BookLibrary class" +
            "returns List with a correct number of Books. In this test - 5")
    @Test
    void testListBooksInHandsReturnListOf5(){
        // Given
        List<Book> resultListOf5Books = generateListOfNBooks(5);

        when(libraryDatabaseMock.listBooksInHandsOf(libraryUsers.get(2))).thenReturn(resultListOf5Books);

        // When
        List<Book> theListOf5Books = bookLibrary.listBooksInHandsOf(libraryUsers.get(2));

        // Then
        assertEquals(5, theListOf5Books.size());
    }

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }
}
