import creatures.Clorus;
import creatures.Plip;
import huglife.*;
import huglife.Action;
import huglife.Empty;
import huglife.Impassible;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class TestClorus {
    @Test
    public void testMove(){
        Clorus c = new Clorus(0.8);
        HashMap<Direction, Occupant> surrounded = new HashMap<Direction, Occupant>();
        surrounded.put(Direction.TOP, new Impassible());
        surrounded.put(Direction.BOTTOM, new Impassible());
        surrounded.put(Direction.LEFT, new Impassible());
        surrounded.put(Direction.RIGHT, new Empty());
        Action actual = c.chooseAction(surrounded);
        Action expected = new Action(Action.ActionType.MOVE,Direction.RIGHT);
        assertEquals(expected, actual);
    }

    @Test
    public void testChoose() {
        // No empty adjacent spaces; stay.
        Clorus c = new Clorus(2);
        HashMap<Direction, Occupant> surrounded = new HashMap<Direction, Occupant>();
        surrounded.put(Direction.TOP, new Impassible());
        surrounded.put(Direction.BOTTOM, new Impassible());
        surrounded.put(Direction.LEFT, new Impassible());
        surrounded.put(Direction.RIGHT, new Impassible());

        Action actual = c.chooseAction(surrounded);
        Action expected = new Action(Action.ActionType.STAY);

        assertEquals(expected, actual);

        //Plip nearby; attack one of them randomly.
        c = new Clorus(2);
        HashMap<Direction, Occupant> topPlip = new HashMap<Direction, Occupant>();
        topPlip.put(Direction.TOP, new Plip(1));
        topPlip.put(Direction.BOTTOM, new Empty());
        topPlip.put(Direction.LEFT, new Impassible());
        topPlip.put(Direction.RIGHT, new Impassible());

         actual = c.chooseAction(topPlip);
         expected = new Action(Action.ActionType.ATTACK, Direction.TOP);

        assertEquals(expected, actual);

        // Energy >= 1; replicate towards an empty space.
        c = new Clorus(2);
        HashMap<Direction, Occupant> topEmpty = new HashMap<Direction, Occupant>();
        topEmpty.put(Direction.TOP, new Empty());
        topEmpty.put(Direction.BOTTOM, new Impassible());
        topEmpty.put(Direction.LEFT, new Impassible());
        topEmpty.put(Direction.RIGHT, new Impassible());

        actual = c.chooseAction(topEmpty);
        expected = new Action(Action.ActionType.REPLICATE, Direction.TOP);

        assertEquals(expected, actual);

        // Energy < 1; move towards a random empty space.
        c = new Clorus(.99);
        actual = c.chooseAction(topEmpty);
        expected = new Action(Action.ActionType.MOVE, Direction.TOP);
        assertEquals(expected, actual);

    }


}
