package pkgLibrary;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;

import org.xml.sax.XMLReader;

import pkgException.BookException;

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
		throw new BookException(id);
		}
		catch (BookException be){
			System.out.println("could not find matching book with ID: " + id);
		}
		return null;
	}

	public void addBook(String id, Book book){
		try{ 
			for (Book b: this.getBooks()){
				if(b.getId().equals(id)){
					throw new BookException(b);
				}
			}
			this.getBooks().add(book);
			WriteXMLFile();
		}
		catch (BookException be){
			System.out.println(be.getBadBook().getId() + " could not be added due to another book containing the same ID.");
		}
	}

	private void WriteXMLFile() {
		try {

			String basePath = new File("").getAbsolutePath();
			basePath = basePath + "\\src\\main\\resources\\XMLFiles\\Books.xml";
			File file = new File(basePath);

			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(this, file);
			jaxbMarshaller.marshal(this, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}












}
