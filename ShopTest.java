import static org.junit.Assert.*;

import org.junit.Test;

public class ShopTest {

	@Test
	public void testGetCustomer() {

		Shop shop = new Shop("Alex");
		assertEquals("Testing existing customer AB-303666 (Brian)", "Brian", shop.getCustomer("AB-303666").getFirstName());
		assertEquals("Testing existing customer AB-457628 (Alex)", "Alex", shop.getCustomer("AB-457628").getFirstName());
		assertEquals("Testing existing customer AB-152346 (David)", "David", shop.getCustomer("AB-152346").getFirstName());
		assertEquals("Testing existing customer AB-096104 (Sara)", "Sara", shop.getCustomer("AB-096104").getFirstName());
		assertEquals("Testing non-existing customer AB-111 ", null, shop.getCustomer("AB-111"));
	}
	
	@Test
	public void testGetCustomerNumber(){
		Shop shop = new Shop("Alex");
		assertEquals("Testing total number of customers ", 5, shop.getCustomerMap().size());
	}
	
	

}
