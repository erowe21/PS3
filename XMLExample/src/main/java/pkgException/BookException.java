package pkgException;

import pkgLibrary.Book;
import pkgLibrary.Catalog;

public class BookException extends Exception{
	private Book badBook;
	private Catalog cat;

	public BookException(Catalog cat, String id){
		super();
		this.badBook = new Book();
		badBook.setId(id);
	}
	
	public BookException(Book book){
		super();
		this.badBook = book;
	}

	public Book getBadBook() {
		return badBook;
	}
	
	
}
