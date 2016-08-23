package _09_Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class _05_MethodWithArray {
	
    static int[] modifyArray(int[] array, int modifier) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * modifier;
        }

        return array;
    }

    @Test
	public void Tst1() {
        int[] myArray = {1, 2, 3, 4, 5};

        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + ", ");
        }
        
        myArray = modifyArray(myArray, 5);
        
        System.out.println("");
        
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + ", ");
        }
        /*
        1, 2, 3, 4, 5, 
		5, 10, 15, 20, 25, 
        */
    }
}
