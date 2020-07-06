package chapter3.genericVersion;

import chapter3.Swapper;

import java.util.Comparator;

public interface Sort<E> {
    void setComparator(Comparator<E> compare);
    void setSwapper(Swapper swap);
    void sort(SortableCollection<E> collection);
}
