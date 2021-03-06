package receiver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import receiver.Buffer;

/**
 * Classe de test sur le buffer
 * @author Gossan Adja, Florent Le Boulch, Ammar Barry
 */
public class TestBuffer {

	private Buffer buffer;
	private IMoteurEdition moteurEdition;
	@Before
	/**
	 * This is executed before each test case execution
	 * @throws Exception
	 */
	public void setUp() throws Exception {
		buffer = new Buffer();
	}
	
	@Test
	/**
	 * Test l'insertion de texte dans le buffer
	 */
	public void testInsert() {
		assertNotNull("L'objet est null lors de l'initialisation", buffer);
		String txt1 = "toto";
		buffer.insert(0, 0, txt1);
		assertNotNull("Le buffer est null", buffer);
		assertEquals("Le buffer n'est pas de taille "+txt1.length(), buffer.getContenu().length(), txt1.length());
		assertTrue("Le contenu du buffer est diff�rent de celui du texte ins�r�", buffer.getContenu().toString().equals(txt1));
		
		String txt2 = "dupont";
		buffer.insert(2, 2, txt2);
		int lengTxt = txt1.length()+ txt2.length();
		assertEquals("Le buffer n'est pas de taille "+lengTxt, buffer.getContenu().length(), lengTxt);
		assertTrue("Le contenu du buffer est diff�rent de celui des textes ins�r�s", buffer.getContenu().toString().equals("todupontto"));
	}
	
	@Test
	/**
	 * Test la suppression de texte dans le buffer
	 */
	public void testDelete() {
		assertNotNull("L'objet est null lors de l'initialisation", buffer);
		
		// 1er test : suppression totale du buffer
		String txt1 = "tpACO";
		buffer.insert(0,0, txt1);
		
		buffer.delete(0, txt1.length());
		assertEquals("Le buffer n'est pas vide", buffer.getContenu().length(), 0);
		assertTrue("Le contenu du buffer n'est pas �gal � celui effac�", buffer.getContenu().toString().isEmpty());
		
		// 2�me test : suppression partielle du buffer
		buffer.insert(0,0, txt1);
		
		int indiceFin = txt1.length()-3;
		buffer.delete(0, indiceFin); // indiceFin exclu
		System.out.println(buffer.getContenu());
		assertEquals("Le buffer n'a pas la m�me longueur que celle du texte supprim�", buffer.getContenu().length(), indiceFin+1);
		assertTrue("Le contenu du buffer n'est pas �gal � celui effac�", buffer.getContenu().toString().equals(txt1.substring(2, txt1.length())));
	}
	
	@Test
	public void TestSubString() throws Exception
	{
		buffer.insert(0, 0, "test");
		assertTrue("wrong subString",buffer.subString(0, 2).equalsIgnoreCase("te"));
	}
}
