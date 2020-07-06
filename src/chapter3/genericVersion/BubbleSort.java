package chapter3.genericVersion;

import chapter3.Swapper;

import java.util.Comparator;

public class BubbleSort<E> implements Sort {
    private Comparator comparator;
    private Swapper swapper;

    @Override
    public void setComparator(Comparator compare) {
        comparator = compare;
    }

    @Override
    public void setSwapper(Swapper swap) {
        swapper = swap;
    }

    @Override
    public void sort(SortableCollection collection) {
        int num = collection.size();
        while (num > 1){
            for (int count =0; count < num-1; count++){
                if(comparator.compare(collection.get(count), collection.get(count+1))>0){
                    swapper.swap(count, count+1);
                }
            }
            num--;
        }
    }
}
