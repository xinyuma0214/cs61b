import org.junit.Test;
import static org.junit.Assert.*;


public class testUnionfind {
    @Test
    public void testUnionfind(){
        UnionFind mxy = new UnionFind(10);
        //1.
//        boolean a1 = mxy.connected(1,2);
//        assertFalse(a1);
        //2.
        mxy.union(1,2);
        mxy.union(2,5);

        boolean a2 = mxy.connected(2,5);
        assertTrue(a2);
        //3.
        int a4 = mxy.parent(1);
        int a5 = mxy.parent(2);

        int e4 = 2;
        int e5 = -3;
        assertEquals(e4, a4);
        assertEquals(e5, a5);

        mxy.union(1, 0);
        mxy.union(5, 7);

        int a6 = mxy.parent(0);
        assertEquals(2, a6);
        assertEquals(2, mxy.parent(7));

        // case 4; sizeOf.
        int a7 = mxy.sizeOf(0);
        assertEquals(5, a7);

    }
}
