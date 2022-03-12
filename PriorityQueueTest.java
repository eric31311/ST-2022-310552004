import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.*;

import java.lang.reflect.Executable;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PriorityQueueTest {
    static Stream<Arguments> streamProvider() {
        return Stream.of(
                Arguments.of(new int[]{5, 4, 8, 7}, new int[]{4, 5, 7, 8}),
                Arguments.of(new int[]{5, 9, 2, 0}, new int[]{0, 2, 5, 9}),
                Arguments.of(new int[]{9, 4, 5, 3}, new int[]{3, 4, 5, 9}),
                Arguments.of(new int[]{1, 4, 2, 3}, new int[]{1, 2, 3, 4}),
                Arguments.of(new int[]{8, 0, 5, 3}, new int[]{0, 3, 5, 8}),
                Arguments.of(new int[]{5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5})
                );
    }

    @ParameterizedTest(name="#{index} - Test with Argument={0},{1}")
    @MethodSource("streamProvider")
    public void PriorityQueue_RunTest(int[] random_array, int[] correct_array){
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        int index = 0;
        Integer s;
        int[] result = new int[random_array.length];

        //TODO: random_array add to PriorityQueue;
        for(int i = 0; i < random_array.length; ++i){
            test.add(random_array[i]);
        }
        //TODO: get PriorityQueue result
        for(int i = 0; i < random_array.length; ++i){
            result[i] = test.poll();
        }
        assertArrayEquals(correct_array, result);

    }

    //TODO: 3 unique Exceptions
    @Test
    public void whenExceptionThrown_CAPACITY() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PriorityQueue test = new PriorityQueue(0);
        });
    }

    @Test
    public void whenExceptionThrown_ADD() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            PriorityQueue<String> test = new PriorityQueue<String>();
            String s = null;
            test.add(s);
        });
    }

    @Test
    public void whenExceptionThrown_TOARRAY() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            PriorityQueue<Integer> test = new PriorityQueue<Integer>();
            test.add(1);
            test.add(2);
            Integer [] arr1 = new Integer[2];
            arr1 = null;
            Integer [] arr2 = test.toArray(arr1);
        });
    }
}
