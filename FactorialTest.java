/**
 * 
 */
package cs361recursion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author cscharff
 *
 */
class FactorialTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link cs361recursion.Factorial#factorial(int)}.
	 */
	@Test
	void testFactorial5() {
		try {
			// factorial(5) is 120
			assertEquals(120, Factorial.factorial(5));
		} catch (Exception e) {
			fail("Exception generated for factorial(5)");
		}
		// We could have used assertTrue
		// assertTrue(Factorial.factorial(5) == 120);
	}
	
	@Test
	void testFactorial14() {
		try {
			Factorial.factorial(14);
			// fail
			fail("factorial(14) does not return the correct result");
		} catch(Exception e) {
			if (e instanceof IllegalArgumentException) {
				// pass
				assertTrue(true);
			} else {
				// fail
				fail("Incorrect exception for factorial(14)");
			}
		}
	}
	
	

}
