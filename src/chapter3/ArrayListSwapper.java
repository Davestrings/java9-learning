package chapter3;

import java.util.ArrayList;

public class ArrayListSwapper implements Swapper{
    private final ArrayList actualnames;

    public ArrayListSwapper(ArrayList actualNames){
        this.actualnames = actualNames;
    }

    @Override
    public void swap(int i, int j) {
        final Object temp = actualnames.get(i);
        actualnames.set(i, actualnames.get(j));
        actualnames.set(j, temp);

    }
}
