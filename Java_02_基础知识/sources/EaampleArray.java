
public class EaampleArray{

    public static void main(String[] args)
    {
        /**一维数组 */
        int[] arr1 = new int[10];
        for(int i = 0; i < arr1.length; i++){
            arr1[i] = i;
        }
        showArray(arr1);

        int[] arr2 = {1,2,3,4,5};
        //showArray(arr2);
        int arr3[] = {1,2,3,4,5,6,7};
        //showArray(arr3);
        
        /**二维数组 */
        int[][] arr4 = new int[3][4];
        int[][] arr5 = new int[3][];
        arr5[0] = arr1;
        arr5[1] = arr2;
        arr5[1] = arr3;
        showArray(arr5[0]);
        //3
        System.out.println(arr5.length);

        System.out.println(arr5[0].length);

    }

    public static void showArray(int[] array){
        for (int i : array) {
            System.out.println(array[i]);
        }
    }
}