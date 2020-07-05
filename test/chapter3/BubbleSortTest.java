package chapter3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @BeforeEach
    void setUp() {
    }
    @Test
    void canSortString(){
        ArrayList actualNames = new ArrayList(Arrays.asList(
           "Johnson", "Wilson", "Wilkinson", "Abraham", "Dagobert"
        ));

        SortableCollection namesCollection = new SortableCollection() {
            @Override
            public Object get(int i) {
                return actualNames.get(i);
            }

            @Override
            public int size() {
                return actualNames.size();
            }
        };

        class SwapActualNamesArrayElements implements Swapper{

            @Override
            public void swap(int i, int j) {
                final Object tmp = actualNames.get(i);
                actualNames.set(i, actualNames.get(j));
                actualNames.set(j, tmp);
            }
        }// end of swapper anonymous class implementation

        Comparator stringCompare = new Comparator() {
            @Override
            public int compare(Object first, Object second) {
                final String f = (String) first;
                String s = (String) second;
                return f.compareTo(s);
            }
        };
        Sort iSort = new BubbleSort();
        iSort.setComparator(stringCompare);
        iSort.setSwapper(new SwapActualNamesArrayElements());
        iSort.sort(namesCollection);

        assertEquals(Arrays.asList("Abraham", "Dagobert","Johnson",
                "Wilkinson", "Wilson"), actualNames);
    }// end of canSortString

    @Test // refactored
    void refactoredCanSortString(){
        ArrayList actualNames = new ArrayList(Arrays.asList(
                "Johnson", "Wilson", "Wilkinson", "Abraham", "Dagobert"
        ));
        ArrayList expctedNames = new ArrayList(
                Arrays.asList("Abraham", "Dagobert","Johnson", "Wilkinson", "Wilson")
        );
        ArrayListSwapper swapper = new ArrayListSwapper(actualNames);
        StringComparator sCompare = new StringComparator();
        SortableCollection names = new ArrayListSortableCollection(actualNames);
        Sort iSort = new BubbleSort();
        iSort.setComparator(sCompare);
        iSort.setSwapper(swapper);
        iSort.sort(names);

        assertEquals(expctedNames, actualNames);
    }
    @Test
    void canNotSortMixedElements(){
        ArrayList actualNames = new ArrayList(Arrays.asList(
                42, "Wilson", "Wilkinson", "Abraham", "Dagobert"
        ));
        ArrayList expctedNames = new ArrayList(
                Arrays.asList(42, "Abraham", "Dagobert", "Wilkinson", "Wilson")
        );
        ArrayListSwapper swapper = new ArrayListSwapper(actualNames);
        StringComparator sCompare = new StringComparator();
        SortableCollection names = new ArrayListSortableCollection(actualNames);
        Sort iSort = new BubbleSort();
        iSort.setComparator(sCompare);
        iSort.setSwapper(swapper);


        Exception exception = assertThrows(NonStringElementInCollectionException.class, () ->{
            iSort.sort(names);
        });

        String expectedMessage = "There are mixed elements in the collection.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
//        assertEquals(expectedNames, actualNames);
    }

}