package array;

import com.kodilla.array.ArrayOperations;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage(){

        //Given
        int[] intArray = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

        //When

        //Then
        double averageOfIntArray = ArrayOperations.getAverage(intArray);
        assertEquals(10.5 , averageOfIntArray,0.1);
    }
}
