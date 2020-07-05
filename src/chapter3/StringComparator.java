package chapter3;

import java.util.Comparator;

public class StringComparator implements Comparator {
    @Override
    public int compare(Object first, Object second) {
        try{
            String sFirst = (String) first;
            String sSecond = (String) second;
            return sFirst.compareTo(sSecond);
        }catch(ClassCastException exception){
            throw new NonStringElementInCollectionException(
                    "There are mixed elements in the collection.", exception);
        }

    }
}
