import java.util.Random;
import java.util.Arrays;
public class MergeSort
{
   public static void main(String[] args)
   {
       int size = 10000;
       int start = 1;
       int end = 10000;
       
       int[] randomArray = RandomizedArray(size, start, end);
       
       long startTime = System.nanoTime();
       
       
       mergeSort(randomArray, start, end-1);
       
       long endTime = System.nanoTime();
       long elapsedTime = endTime - startTime;
       
       System.out.println("Sorting through an array of size " + size + " took merge sort " + elapsedTime + " nanoseconds to sort.");
       
   }
    public static int[] RandomizedArray(int size, int start, int end)
    {
        int[] arrayResult = new int[size];
        Random random = new Random(); 
        
        for(int i = 0; i < size; i++)
        {
            int randomVal = random.nextInt(end) + start;
            arrayResult[i] = randomVal;
        }
        return arrayResult;
    }
    static void merge(int arr[], int start, int mid,int end)
    {
        int start2 = mid + 1;
        if (arr[mid] <= arr[start2]) 
        {
            return;
        }
        while (start <= mid && start2 <= end) 
        {
            if (arr[start] <= arr[start2]) 
            {
                start++;
            }
            else 
            {
                int value = arr[start2];
                int index = start2;
 
                while (index != start) 
                {
                    arr[index] = arr[index - 1];
                    index--;
                }
                arr[start] = value;
                start++;
                mid++;
                start2++;
            }
        }
    }
     static void mergeSort(int arr[], int l, int r)
    {
        if (l < r) 
        {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }
}
