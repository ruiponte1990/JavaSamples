import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

import org.junit.*;

public class UserKeyTests {
	@Test
	public void testGetName() {
		UserKey b1 = new UserKey("Bill Smith", "BSMITH");
		assert(b1.getName().equals("Bill Smith"));
	}
	@Test
	public void testGetUserID() {
		UserKey b1 = new UserKey("Bill Smith", "BSMITH");
		assert(b1.getUserID().equals("BSMITH"));
	}
	@Test
	public void testEquals() {
		UserKey b1 = new UserKey("Bill Smith", "BSMITH");
		UserKey b2 = new UserKey("Bill Smith", "BSMITH");
		assert(b1.equals(b1)); 
		assert(b1.equals(b2));
		UserKey b3 = new UserKey("Susan Smith", "SSMITH");
		assert(!b1.equals(b3));
		assert(!b1.equals(null));
		assert(!b1.equals("Some String"));
		UserKey b4 = new UserKey(null,null);
		assert(!b4.equals(b1));
		
	}
	@Test
	public void testHashCode() {
		UserKey b1 = new UserKey("Bill Smith", "BSMITH");
		java.util.Hashtable ht = new java.util.Hashtable();
		ht.put(b1,"Some Data");
		String s = (String) ht.get(b1);
		assert( s.equals("Some Data"));
		UserKey b2 = new UserKey("Bill Smith", "BSMITH");
		assert(b1.hashCode() == b2.hashCode());
	}
	@Test
	public void testSerializable() {
		try {
			UserKey b1 = new UserKey("Bill Smith", "BSMITH");
			new ObjectOutputStream(new ByteArrayOutputStream()).writeObject(b1);
		}
		catch (Exception e){
			 Assert.fail("Test failed : " + e.getMessage());
		}
		
	}
}
