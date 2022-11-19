import java.util.Scanner;

public class ExL {
    static Scanner scanner = new Scanner(System.in);
    static final int MAX = 30;

    public static void main(String[] args) {
        int[] numeros = new int[MAX];
        int nNumeros = lerArray(numeros);
        verVizinhos(numeros, nNumeros);
    }

    private static void verVizinhos(int[] numeros, int N) {
        for (int i = 1; i < N-1; i++) {
            if (numeros[i] > numeros[i-1] && numeros[i] > numeros[i+1]){
                System.out.println(numeros[i]);
            }

        }
    }

    private static int lerArray(int[] numeros) {
        int i = 0;
        numeros[i] = scanner.nextInt();
        while (i < MAX && numeros[i] > 0) {
            i++;
            numeros[i] = scanner.nextInt();
        }
        return i;
    }
}
