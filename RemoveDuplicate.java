import java.util.Arrays;

public class RemoveDuplicate{
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 5, 5, 3, 2, 7, 2, 8, 7, 5};

        Arrays.sort(arr);

        int n = arr.length;
        int[] temp = new int[n];
        int j = 0;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                temp[j++] = arr[i];
            }
        }
        temp[j++] = arr[n - 1];

        int[] uniqueArray = Arrays.copyOf(temp, j);

        System.out.println("Unique sorted array: " + Arrays.toString(uniqueArray));
    }
}
