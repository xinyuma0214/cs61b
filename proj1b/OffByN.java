public class OffByN implements CharacterComparator{
    private int targetNum;
    public OffByN(int N){
        targetNum = N;
    }
    @Override
    public boolean equalChars(char x, char y){
        int diff = x - y;
        if (Math.abs(diff) == targetNum) {
            return true;
        }
        return false;

    }
}
