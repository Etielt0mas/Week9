import java.util.Arrays;
import java.util.Scanner;

public class ExK {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        int[] arr = new int[N];
        int[] novoArr = new int[N];
        lerArray(arr);
        int nNumeros = calcular(arr, novoArr);
        display(novoArr, nNumeros, N);
    }

    private static void display(int[] novoArr, int n, int NTotal) {
        for (int i = 0; i < novoArr.length; i++) {
            if (novoArr[i] != -1){
                System.out.println(novoArr[i]);
            }
        }
    }

    private static int calcular(int[] arr, int[] novoArr) {
        int contador = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            boolean igual = false;
            for (int j = 0; j < i && !igual; j++) {
                if (arr[i] == arr[j]){
                    igual = true;
                }
            }
            if (!igual){
                contador++;
                novoArr[i] = arr[i];
            } else{
                novoArr[i] = -1;
            }
        }
        return contador;
    }

    private static void lerArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
    }


}
