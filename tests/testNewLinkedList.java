import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testNewLinkedList {
    NewLinkedList nll;
    @Before
    public void setup() {
        nll = new NewLinkedList(45);
    }

    @Test
    public void testCreate() {
        Assert.assertEquals( 45, nll.head.data);
        Assert.assertEquals(45, nll.tail.data);
        Assert.assertNull(nll.head.next);
    }

    @Test
    public void testAppend() {
        nll.append(3);
        Assert.assertEquals(3, nll.head.next.data);
        Assert.assertEquals(3, nll.tail.data);
        Assert.assertNull(nll.tail.next);
    }

    @Test
    public void testPrepend() {
        nll.prepend(100);
        Assert.assertEquals(100, nll.head.data);
        Assert.assertEquals(45, nll.head.next.data);
        Assert.assertEquals(45, nll.tail.data);
        Assert.assertNull(nll.tail.next);
    }

    @Test
    public void testInsert() {
        nll.append(3);
        nll.append(100);
        nll.append(74);
        nll.insert(2, 99);
        Assert.assertEquals(99, nll.head.next.next.data);
    }

    @Test
    public void remove() {
        nll.append(3);
        nll.append(100);
        nll.remove(1);
        Assert.assertEquals(100, nll.head.next.data);
    }
}