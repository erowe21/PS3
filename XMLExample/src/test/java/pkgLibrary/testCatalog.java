package pkgLibrary;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class testCatalog {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddBook() {
		boolean pass = false;
		Catalog cat = ReadXMLFile();
		int sizeInitial = cat.books.size();
		Date d = new Date();
		Book newBook = new Book("bk113", "Jared Glaser", "CISC 181 Lab", "Computer Science", 100.00, d, "Book about a lab" );

		cat.addBook("bk113", newBook);
		WriteXMLFile(cat);
		cat = ReadXMLFile();

		if(cat.books.size() > sizeInitial){
			pass = true;
		}

		assertEquals(true, pass);

	}

	@Test
	public void testAddBook2(){
		boolean pass = false;
		Catalog cat = ReadXMLFile();
		int sizeInitial = cat.books.size();
		Date d = new Date();
		Book newBook = new Book("bk112", "Galos, Mike", "Visual Studio 7: A Comprehensive Guide", "Computer", 49.95, d, "Microsoft Visual Studio 7 is explored in depth, looking at how Visual Basic, Visual C++, C#, and ASP+ are integrated into a comprehensive development environment." );

		cat.addBook("bk112", newBook);
		WriteXMLFile(cat);
		cat = ReadXMLFile();

		if(cat.books.size() == sizeInitial){
			pass = true;
		}

		assertEquals(true, pass);

	}

	@Test
	public void testGetBook(){
		boolean pass = false;
		Catalog cat = ReadXMLFile();
		Book test = cat.getBook("bk112");
		if(test.getId().equals("bk112") && test.getGenre().equals("Computer")){ //threw in the computer just to double check.
			pass = true;
		}

		assertEquals(true, pass);
	}

	@Test
	public void testGetBook2(){
		boolean pass = false;
		Catalog cat = ReadXMLFile();
		if(cat.getBook("bk298") == null)
			pass = true;

		assertEquals(true, pass);
	}

	private Catalog ReadXMLFile() {

		Catalog cat = null;

		String basePath = new File("").getAbsolutePath();
		basePath = basePath + "\\src\\main\\resources\\XMLFiles\\Books.xml";
		File file = new File(basePath);

		System.out.println(file.getAbsolutePath());
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			cat = (Catalog) jaxbUnmarshaller.unmarshal(file);
			System.out.println(cat);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return cat;

	}

	private void WriteXMLFile(Catalog cat) {
		try {

			String basePath = new File("").getAbsolutePath();
			basePath = basePath + "\\src\\main\\resources\\XMLFiles\\Books.xml";
			File file = new File(basePath);

			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(cat, file);
			jaxbMarshaller.marshal(cat, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
