package pkgLibrary;

public class BookException_ extends Exception{
	private Book notBook;
	private Catalog cat;

	public BookException_(Catalog cat, String id){
		super();
		this.notBook = new Book();
		notBook.setId(id);
	}
	
	public BookException_(Book book){
		super();
		this.notBook = book;
	}

	public Book getnotBook() {
		return notBook;
	}
	
	
}

