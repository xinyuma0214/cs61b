public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> worddeque = new LinkedListDeque<>();
        for(int i = 0;i < word.length();i++){
            worddeque.addLast(word.charAt(i));

        }
        return worddeque;
    }
}
