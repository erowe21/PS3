package pkgLibrary;

public class BookException extends Exception{
	private Book notBook;
	private Catalog cat;

	public BookException(Catalog cat, String id){
		super();
		this.notBook = new Book();
		notBook.setId(id);
	}
	
	public BookException(Book book){
		super();
		this.notBook = book;
	}

	public Book getnotBook() {
		return notBook;
	}
	
	
}

