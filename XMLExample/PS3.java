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
		Book newBook = new Book("bk121", "Smith, Joe", "Eagles Football", "Horror", 21.00, d, "Decades of suffering" );

		cat.addBook("bk121", newBook);
		WriteXMLFile(cat);
		cat = ReadXMLFile();

		if(cat.books.size() > sizeInitial){
			pass = true;
		}

		assertEquals(true, pass);

	}

	@Test
	public void testAddBook1(){
		boolean pass = false;
		Catalog cat = ReadXMLFile();
		int sizeInitial = cat.books.size();
		Date d = new Date();
		Book newBook = new Book("bk108", "Knorr, Stefan", "Creepy Crawlies", "Horror", 8.79, d, "An anthology of horror stories about roaches, centipedes, scorpions and other insects.");

		cat.addBook("bk108", newBook);
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
		Book test = cat.getBook("bk108");
		if(test.getId().equals("bk108")){ 
			pass = true;
		}

		assertEquals(true, pass);
	}

	@Test
	public void testGetBook1(){
		boolean pass = false;
		Catalog cat = ReadXMLFile();
		if(cat.getBook("bk2121") == null)
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


			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(cat, file);
			jaxbMarshaller.marshal(cat, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
