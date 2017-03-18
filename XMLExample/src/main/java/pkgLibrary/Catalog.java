package pkgLibrary;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;

import org.xml.sax.XMLReader;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Catalog {

	@XmlAttribute
	int id;	

	@XmlElement(name="book")
	ArrayList<Book> books;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}


	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	public Book getBook(String id){
		try{
		for(Book b : this.getBooks()){
			if(b.getId().equals(id)){
				return b;
			}
		}
		throw new BookException(this, id);
		}
		catch (BookException bex){
			System.out.println("No book with ID: " + id);
		}
		catch (Exception e){
			throw e;
		}
		return null;
	}

	public void addBook(String id, Book book){
		try{ 
			for (Book b: this.getBooks()){
				if(b.getId().equals(id)){
					throw new BookException(this, id);
				}
			}
			this.getBooks().add(book);
			
		}
		catch (BookException bex){
			System.out.println(bex.getnotBook().getId() + " Can't add book");
		}
		catch (Exception e){
			throw e;
		}
	}

}
