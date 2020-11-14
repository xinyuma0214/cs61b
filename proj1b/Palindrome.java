public class Palindrome{
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> worddeque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            worddeque.addLast(word.charAt(i));
        }
        return worddeque;
    }

    //Tast 3B
    public boolean isPalindrome(String word) {
//        两链表地址不同 无法==比较；除非再加两个指针同时往后走-->复杂!
//        但是.equals()比较的不是两个链表地址？为何不行？
//        Deque<Character> worddeque1 = new LinkedListDeque<>();
//        Deque<Character> worddequeReverse = new LinkedListDeque<>();
//        for (int i = 0; i < word.length(); i++){
//            worddequeReverse.addFirst(word.charAt(i));
//        }
//        for(int i = 0;i < word.length();i++){
//            worddeque1.addLast(word.charAt(i));
//        }
//        if(worddequeReverse.equals(worddeque1) || word.length()<=1){
//            return true;
//        } else{
//           return false;
//        }
        Deque<Character> worddeque = wordToDeque(word);
        while (worddeque.size() > 1) {
            if (worddeque.removeFirst() != worddeque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    //Tast 4
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> worddeque = wordToDeque(word);
        while (worddeque.size() > 1) {
            Character x = worddeque.removeFirst();
            Character y = worddeque.removeLast();
            if (!(cc.equalChars(x, y))){
                return false;
            }
        }
        return true;
    }

}



