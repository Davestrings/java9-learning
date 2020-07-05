package chapter3;

import java.util.Comparator;

public interface Sort {
    void sort (SortableCollection collection);
    void setSwapper(Swapper swap);
    void setComparator(Comparator compare);
}
