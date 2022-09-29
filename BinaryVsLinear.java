// Michael Fisher
// Purpose: Binary search Vs Linear search

public class BinaryVsLinear
{
    // Declare and define linearSearch method.
    private static int linearSearch(int key, int[] array)
    {
        // declare and define variable for counting # of comparisons.
        int count = 0;

        // For loop to iterate through array[] and compare.
        for(int i = 0; i < (array.length - 1); i++)
        {
            // If current iterated element is equal to int key...
            if(array[i] == key)
            {
                count++;                // Increment count variable.
                return count;           // Return count.
            }

            // Else if array[] element is not equal to int key.
            else if(array[i] != key)
            {
                count++;                // Increment count here since comparison is made
            }
        }

        // If int key was not found in array, return count.
        return count;
    }

    // Declare and define binarySearch method.
    private static int binarySearch(int key, int[] array)
    {
        int left = 0;                   // var for left-most element being compared
        int mid;                        // var for middle element between left and right most elements being compared
        int right = array.length - 1;   // var for right-most element being compared
        int count = 0;                  // var for counting the # of comparisons made

        // Infinite while loop until int key is found in array[]
        while(true)
        {
            // Error/Failure if left-most element is greater than right-most element
            if(left>right)
            {
                mid = -1; // set mid to -1 for failure
                break;    // exit while loop
            }

            // Else if no error exists...
            else
            {
                mid = (left+right) / 2;     // mid gets int avg of left-most and right-most elements

                // If key is found somewhere between elements mid and left...
                if (key < array[mid])
                {
                    count++;                // Increment count of comparisons
                    right = mid - 1;        // Reduce array to just left half of array
                }

                // Else if key is found somewhere between elements mid and right...
                else if(key > array[mid])
                {
                    count = count + 2;      // Increment count + 2 ("if" & "else if" comparisons)
                    left = mid + 1;
                }

                // No comparisons here, but key has been found in mid element
                else
                {
                    count = count + 2;      // Increment count +2 ("if" & "else if" comparisons)
                    break;                  // success case (elmt found), array[mid] = key
                }
            }
        }

        // Return # of comparisons
        return count;
    }

    public static void main(String[] args)
    {
        for (int length = 1; length <= 30; length += 1)
        {
            int[] array = new int[length];
            for (int index = 0; index < length; index += 1)
            {
                array[index] = index;
            }

            double linearTotal = 0.0;
            double binaryTotal = 0.0;
            for (int element = 0; element < length; element += 1)
            {
                linearTotal += linearSearch(element, array);
                binaryTotal += binarySearch(element, array);
            }

            double linearAverage = linearTotal / length;
            double binaryAverage = binaryTotal / length;
            System.out.println(length + " " + linearAverage + " " + binaryAverage);
        }
    }
}
