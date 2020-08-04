package arrays;

import java.util.Arrays;

public class A6_Arrange_Max_Min
{
    // Prints max at first position, min at second position
    // second max at third position, second min at fourth
    // position and so on.
    static int[] rearrange(int[] arr, int n)
    {
        // Auxiliary array to hold modified array
        int temp[] = new int[n];

        // Indexes of smallest and largest elements
        // from remaining array.
        int small=0, large=n-1;

        // To indicate whether we need to copy rmaining
        // largest or remaining smallest at next position
        boolean flag = true;

        // Store result in temp[]
        for (int i=0; i<n; i++)
        {
            if (flag)
                temp[i] = arr[large--];
            else
                temp[i] = arr[small++];

            flag = !flag;
        }

        // Copy temp[] to arr[]
        arr = temp.clone();
        return arr;
    }

    // Driver method to test the above function
    public static void main(String[] args)
    {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6};

        System.out.println("Original Array ");
        System.out.println(Arrays.toString(arr));

        rearrange(arr,arr.length);

        System.out.println("Modified Array ");
        System.out.println(Arrays.toString(rearrange(arr,arr.length)));

    }
}
