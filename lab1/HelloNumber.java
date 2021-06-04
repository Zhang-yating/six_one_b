public class HelloNumber{
    public static void main(String[] args){
        int j = 0;
        while (j < 10) {
            int i = 0;
            int sum = 0;
            while (i <= j) {
                sum = sum + i;
                i = i + 1;
            }
            System.out.print(sum + " ");
            j = j + 1;
        }

    }
}