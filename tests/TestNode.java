import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestNode {
    Node<Integer> nodeInt;
    Node<String> nodeString;

    @Before
    public void setup() {
        nodeInt = new Node<>(5);
        nodeString = new Node<>("5");
    }

    @Test
    public void testFives() {
        Assert.assertEquals(5, (int)nodeInt.getData());
        Assert.assertEquals("5", nodeString.getData());
        Assert.assertNull(null, nodeInt.getNext());
        Assert.assertNull(null, nodeString.getNext());
    }

    @Test
    public void testSetters() {
        nodeInt.setNext(new Node<>(6));
        nodeString.setNext(new Node<>("6"));
        Assert.assertEquals(6, (int)nodeInt.getNext().getData());
        Assert.assertEquals("6", nodeString.getNext().getData());
    }
}
