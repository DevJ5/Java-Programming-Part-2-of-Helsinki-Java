package moving.logic;

import moving.domain.Box;
import moving.domain.Thing;

import java.util.ArrayList;
import java.util.List;

public class Packer {
    private final int boxesVolume;

    public Packer(int boxesVolume) {
        this.boxesVolume = boxesVolume;
    }

    public List<Box> packThings(List<Thing> things) {
        ArrayList<Box> boxes = new ArrayList<Box>();

        Box box = new Box(boxesVolume);

        for (Thing thing : things) {
            if(!box.addThing(thing)) {
                boxes.add(box);
                box = new Box(boxesVolume);
                box.addThing(thing);
            }
        }
        boxes.add(box);

        return boxes;
    }
}
