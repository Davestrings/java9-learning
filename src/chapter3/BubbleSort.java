package chapter3;

import java.util.Comparator;

public class BubbleSort implements Sort {
    private Comparator comparator = null;
    private Swapper swapper = null;
    @Override
    public void sort(SortableCollection collection){
        int n = collection.size();
        while (n > 1){
            for (int j = 0; j < n - 1; j++){
                if (comparator.compare(collection.get(j), collection.get( j+1)) > 0){
                    swapper.swap(j, j + 1);
                }
            }
            n--;
        }
    }

    @Override
    public void setSwapper(Swapper swap) {
        swapper = swap;
    }

    @Override
    public void setComparator(Comparator compare) {
        comparator = compare;
    }
}
