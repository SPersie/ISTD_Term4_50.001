package PS3PartAHW.Q1FindX;
import junit.framework.*;
import junit.framework.Test;

public class TestFindX extends TestCase {

    // constructor
    public TestFindX (String name) {
        super(name);
    }

    @org.junit.Test
    // Insert your code for the first test
    public void testCountingVisits1() {
        FindX f =new FindX();
        int[] a ={4,5,6};
        assertEquals("Failed Assertion for FindX", 0, f.findX(4, a));
        assertEquals("Failed Assertion for FindX", 1, f.findX(5, a));
        assertEquals("Failed Assertion for FindX", 2, f.findX(6, a));
        assertEquals("Failed Assertion for FindX", -1, f.findX(9, a));
    }

    @org.junit.Test
    public void testCountingVisits2() {
        FindX f =new FindX();
        assertEquals("Failed Assertion for Counting Number of Visits", 1, f.getVisitNumber());
        int[] P ={4,5,6};
        int v1 =f.findX(4, P);
        assertEquals("Failed Assertion for Counting Number of Visits", 2, f.getVisitNumber());
        int v2 =f.findX(5, P);
        assertEquals("Failed Assertion for Counting Number of Visits", 3, f.getVisitNumber());
    }

    // method create a test suite
    public static Test suite() {
        return new TestSuite(TestFindX.class);
    }

    // the main method
    public static void main(String args[]) {
        junit.textui.TestRunner.run(suite());
    }
}
