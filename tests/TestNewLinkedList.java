import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestNewLinkedList {
    NewLinkedList<Integer> nll;
    String notPalindrome = "sdafsdajklfhdsafkj";
    String isPalindrome = "amanama";

    NewLinkedList<String> nllPalindrome;
    NewLinkedList<String> nllNotPalindrome;
    @Before
    public void setup() {
        nll = new NewLinkedList<>();
        nll.append(1);
        nllPalindrome = new NewLinkedList<>();
        nllNotPalindrome = new NewLinkedList<>();
    }

    @Test
    public void testCreate() {
        Assert.assertEquals( 1, (int)nll.head.data);
        Assert.assertEquals(1, (int)nll.tail.data);
        Assert.assertNull(nll.head.next);
    }

    @Test
    public void testAppend() {
        nll.append(3);
        Assert.assertEquals(3, (int)nll.head.next.data);
        Assert.assertEquals(3, (int)nll.tail.data);
        Assert.assertNull(nll.tail.next);
    }

    @Test
    public void testPrepend() {
        nll.prepend(100);
        Assert.assertEquals(100, (int)nll.head.data);
        Assert.assertEquals(1, (int)nll.head.next.data);
        Assert.assertEquals(1, (int)nll.tail.data);
        Assert.assertNull(nll.tail.next);
    }

    @Test
    public void testInsert() {
        nll.append(3);
        nll.append(100);
        nll.append(74);
        nll.insert(2, 99);
        Assert.assertEquals(99, (int)nll.head.next.next.data);
    }

    @Test
    public void testRemove() {
        nll.append(3);
        nll.append(100);
        nll.remove(1);
        Assert.assertEquals(100, (int)nll.head.next.data);
    }

    @Test
    public void testReverse() {
        nll.append(2);
        nll.append(3);
        nll.prepend(0);
        nll.print();
        nll.reverse();
        nll.print();
        Assert.assertEquals(3, (int)nll.head.data);
        Assert.assertEquals(2, (int)nll.head.next.data);
        Assert.assertEquals(1, (int)nll.head.next.next.data);
        Assert.assertEquals(0, (int)nll.head.next.next.next.data);
        Assert.assertEquals(0, (int)nll.tail.data);
    }

    @Test
    public void testReverseWord() {
        nllPalindrome = NewLinkedList.loopingAppend(isPalindrome);
        nllPalindrome.reverse();
        String reverse = NewLinkedList.linkedListtoString(nllPalindrome, isPalindrome.length());
        Assert.assertEquals(isPalindrome, reverse);

        nllNotPalindrome = NewLinkedList.loopingAppend(notPalindrome);
        nllNotPalindrome.reverse();
        reverse = NewLinkedList.linkedListtoString(nllNotPalindrome, notPalindrome.length());
        Assert.assertNotEquals(notPalindrome, reverse);
    }

    @Test
    public void testCheckPalindrome() {
        nllPalindrome = NewLinkedList.loopingAppend(isPalindrome);
        nllPalindrome.reverse();
        String reverse = NewLinkedList.linkedListtoString(nllPalindrome, isPalindrome.length());
        Assert.assertTrue(NewLinkedList.checkPalindrome(isPalindrome, reverse));

        nllNotPalindrome = NewLinkedList.loopingAppend(notPalindrome);
        nllNotPalindrome.reverse();
        reverse = NewLinkedList.linkedListtoString(nllNotPalindrome, notPalindrome.length());
        Assert.assertFalse(NewLinkedList.checkPalindrome(notPalindrome, reverse));
    }
}