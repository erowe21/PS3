package pkgException;

import pkgLibrary.Book;

public class BookException extends Exception{
	private Book badBook;

	public BookException(){
		super();
	}

	public BookException(String id){
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
