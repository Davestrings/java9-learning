package chapter3.quickSort;

import chapter3.Swapper;

import java.util.Comparator;

public class Partitioner<E> {
    private final Comparator<E> comparator;
    private final Swapper swapper;


    public Partitioner(Comparator<E> comparator, Swapper swapper) {
        this.comparator = comparator;
        this.swapper = swapper;
    }

}
