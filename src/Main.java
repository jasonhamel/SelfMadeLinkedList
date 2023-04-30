
public class Main {
    public static void main(String[] args) {
        String[] notPalindrome = new String[] {
                "ta",
                "five",
                "george",
                "jason",
                "bryan",
        };
        String[] isPalindrome = new String[] {
                "t",
                "tat",
                "abba",
                "texttxet",
                "textxet"
        };
        checker(notPalindrome);
        System.out.println();
        checker(isPalindrome);
    }

    public static void checker(String[] mightBePalindrome) {
        for (int i = 0; i < mightBePalindrome.length; i++) {
            NewLinkedList<String> toCheck= NewLinkedList.loopingAppend(mightBePalindrome[i]);
            toCheck.reverse();
            String stringToCheck = NewLinkedList.linkedListtoString(toCheck, mightBePalindrome[i].length());
            if (NewLinkedList.checkPalindrome(mightBePalindrome[i], stringToCheck)) {
                System.out.println(mightBePalindrome[i] + " and " + stringToCheck + " are palindromes!");
            } else {
                System.out.println(mightBePalindrome[i] + " and " + stringToCheck + " are NOT palindromes!");
            }
        }
    }
}