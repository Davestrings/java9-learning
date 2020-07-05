package chapter1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {
    int[] numbers;
    SecureRandom random;
    @BeforeEach
    void setUp(){
        numbers = new int[10];
        random = new SecureRandom();
    }
    @Test
    void sortTest(){
        for(int i=0; i < numbers.length; i++){
            numbers[i] = random.nextInt(50);
        }
        Sort aSorter = new Sort(numbers);

        int[] copyNum = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(copyNum);

        assertArrayEquals(copyNum, aSorter.sort());
    }
    @Test
    void canSortStrings(){
        ArrayList actualNames = new ArrayList(Arrays.asList(
                "Johnson", "Wilson", "Wilkinson", "Abraham", "Dagobert"
        ));
        Collections.sort(actualNames);
        assertEquals(new ArrayList<String>(Arrays.<String>asList("Abraham",
                "Dagobert","Johnson", "Wilkinson","Wilson")),actualNames);
    }
}