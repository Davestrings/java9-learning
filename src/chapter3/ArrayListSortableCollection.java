package chapter3;

import java.util.ArrayList;

public class ArrayListSortableCollection implements SortableCollection {
    private final ArrayList actualnames;

    public ArrayListSortableCollection(ArrayList actualnames){
        this.actualnames = actualnames;
    }

    @Override
    public Object get(int i) {
        return actualnames.get(i);
    }

    @Override
    public int size() {
        return actualnames.size();
    }
}
