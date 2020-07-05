package chapter1;

public class Sort {
    private int[] integers = new int[10];
    private String[] strings = new String[10];

    public Sort(int[] integer){
        for (int i=0; i< integers.length; i++)
            this.integers[i] = integer[i];
    }
    public Sort(String[] strings){
        for (int i=0; i< strings.length; i++)
            this.strings[i] = strings[i];
    }
    public void sort(String[] stringArr){
        int n = stringArr.length;
        while(n>1){
            for (int j = 0; j < n-1; j++){
                if(stringArr[j].compareTo(stringArr[j+1]) > 0){
                    final String temp = stringArr[j+1];
                    stringArr[j+1] = stringArr[j];
                    stringArr[j] = temp;
                }
            }
            n--;
        }
    }

    public  int[] sort(){

        for(int fIndex=0; fIndex < integers.length-1;fIndex++){
            int checker=fIndex;

            for(int sIndex=checker+1; sIndex < integers.length; sIndex++){
                if(integers[checker]>integers[sIndex]){
                    swap(integers, checker, sIndex);
                }

            }

        }

        return integers;
    }
    public static void swap(int[] data, int checker, int nIndex){
        int temp = data[checker];
        data[checker] = data[nIndex];
        data[nIndex] = temp;
    }


}
