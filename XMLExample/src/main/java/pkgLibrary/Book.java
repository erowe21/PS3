package pkgLibrary;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import pkgException.BookException;

public class Book {

	private String id;
	private String author;
	private String title;
	private String genre;
	private double price;
	private Date publish_date;
	private String description;
	private double cost;

	public Book() {

	}

	public Book(String id, String author, String title, String genre, double price, Date publish_date, String description)
	{
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.genre = genre;		
		this.price = price;
		this.publish_date = publish_date;
		this.description = description;
	}
	
	//No longer used. Moved the finding of books into Catalog. Keeping in case of need to re-instantiate.
	/*
	public Book(String id, Catalog cat) throws BookException{ 

		boolean isFound = false;
		for (Book b: cat.getBooks()){
			if (b.getId().equals(id)) {
				isFound = true;
				this.id = b.getId();
				this.author = b.getAuthor();
				this.title = b.getTitle();
				this.genre = b.getGenre();
				this.price = b.getPrice();
				this.publish_date = b.getPublish_date();
				this.description = b.getDescription();
				this.cost = b.getCost();
			}
			if(!isFound){
				throw new BookException(id);
			}
		}
	}*/


	public String getId() {
		return id;
	}

	@XmlAttribute
	public void setId(String id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	@XmlElement
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	@XmlElement
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getPrice() {
		return price;
	}

	@XmlElement
	public void setPrice(double price) {
		this.price = price;
	}

	public Date getPublish_date() {
		return publish_date;
	}

	@XmlElement
	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}





}
