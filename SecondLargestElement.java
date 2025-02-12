import java.util.*;
public class SecondLargestElement {
    public static void main(String[] args) {
        int []arr = {13, 47, 3, 9, 11, 45, 1, 20, 67, 31};
        int largest = 0;
        int slargest = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > largest){
                slargest = largest;
                largest = arr[i];
            }
            if(arr[i] > slargest && arr[i] < largest){
                slargest = arr[i];
            }
        }
        System.out.println("The second largest element in the array is: " + slargest);
    }
}