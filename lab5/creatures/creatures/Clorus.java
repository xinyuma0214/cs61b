package creatures;

import huglife.Action;
import huglife.Creature;
import huglife.Direction;
import huglife.Occupant;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

import static huglife.HugLifeUtils.randomEntry;

public class Clorus extends Creature {
    private int r;
    private int g;
    private int b;
    public Clorus(double e){
        super("Clorus");
        energy = e;
    }
    public void move() {
        this.energy -= 0.03;
        if (energy < 0){
            energy = 0;
        }
    }

    @Override
    public void attack(Creature c) {
        energy += c.energy;
    }

    @Override
    public Creature replicate() {
        energy = 0.5 * energy;
        double littleClorusEnergy = energy;
        return new Clorus(littleClorusEnergy);
    }

    @Override
    public void stay() {
        this.energy -= 0.01;

    }


    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        Deque<Direction> emptyNeighbors = new ArrayDeque<>();
        Deque<Direction> emptyPlip = new ArrayDeque<>();
        for(Direction d : neighbors.keySet()){
            Occupant name = neighbors.get(d);
            if(neighbors.get(d).name().equals("empty")){
                emptyNeighbors.addLast(d);
            }else if (neighbors.get(d).name().equals("plip")){
                emptyPlip.addLast(d);
            }
        }
        //rule 1
        if(emptyNeighbors.size() == 0){
            return new Action(Action.ActionType.STAY);
        } else if(emptyPlip.size() > 0){
            return new Action(Action.ActionType.ATTACK,randomEntry(emptyPlip));
        }else if (energy >= 1){
            return new Action(Action.ActionType.REPLICATE,randomEntry(emptyNeighbors));
        }
        return new Action(Action.ActionType.MOVE,randomEntry(emptyNeighbors));
    }



    @Override
    public Color color() {
        r = 34;
        g = 0;
        b = 231;

        return color(r, g, b);
    }
}
