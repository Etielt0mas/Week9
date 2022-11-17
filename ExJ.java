import java.util.Scanner;

public class ExJ {
    static Scanner scanner = new Scanner(System.in);

    static final int PESSOAS = 40;

    public static void main(String[] args) {
        String[] nome = new String[PESSOAS];
        double[] salario = new double[PESSOAS];
        int nPessoas = lerNomeESalario(nome, salario);
        int nMaiorSalario = verNumeroDoSalarioMaior(nome, salario, nPessoas);
        int nSegundoSalario = verNumeroDoSalarioSeg(nome, salario, nPessoas, nMaiorSalario);
        int nTerceiroSalario = verNumeroDoSalarioTer(nome, salario, nPessoas, nMaiorSalario, nSegundoSalario);;
        display(nome, salario, nMaiorSalario, nSegundoSalario, nTerceiroSalario, nPessoas);
    }

    private static void display(String[] nome, double[] salario, int nMaiorSalario, int nSegundoSalario, int nTerceiroSalario, int nPessoas) {
        if (nPessoas == 1){
            System.out.printf("#1:%s:%.0f%n", nome[nMaiorSalario], salario[nMaiorSalario]);
        } else if(nPessoas == 2){
            System.out.printf("#1:%s:%.0f%n", nome[nMaiorSalario], salario[nMaiorSalario]);
            System.out.printf("#2:%s:%.0f%n", nome[nSegundoSalario], salario[nSegundoSalario]);
        }else{
            System.out.printf("#1:%s:%.0f%n", nome[nMaiorSalario], salario[nMaiorSalario]);
            System.out.printf("#2:%s:%.0f%n", nome[nSegundoSalario], salario[nSegundoSalario]);
            System.out.printf("#3:%s:%.0f%n", nome[nTerceiroSalario], salario[nTerceiroSalario]);

        }
    }

    private static int verNumeroDoSalarioTer(String[] nome, double[] salario, int nPessoas, int nMaiorSalario, int nSegunSalario) {
        int numero = 0;
        double maiorSalario = 0;
        for (int i = 0; i < nPessoas; i++) {
            if (salario[i] > maiorSalario && i != nMaiorSalario && i != nSegunSalario) {
                maiorSalario = salario[i];
                numero = i;
            } else if (salario[i] == maiorSalario && i != nMaiorSalario && i != nSegunSalario) {
                if (nome[i].compareTo(nome[numero]) < 0){
                    numero = i;
                }
            }
        }

        return numero;
    }

    private static int verNumeroDoSalarioSeg(String[] nome, double[] salario, int nPessoas, int nMax) {
        int numero = 0;
        double maiorSalario = 0;
        for (int i = 0; i < nPessoas; i++) {
            if (salario[i] > maiorSalario && i != nMax) {
                maiorSalario = salario[i];
                numero = i;
            } else if (salario[i] == maiorSalario && i != nMax) {
                if (nome[i].compareTo(nome[numero]) < 0){
                    numero = i;
                }
            }
        }

        return numero;
    }

    private static int verNumeroDoSalarioMaior(String[] nome, double[] salario, int nPessoas) {
        int numero = 0;
        double maiorSalario = 0;
        for (int i = 0; i < nPessoas; i++) {
            if (salario[i] > maiorSalario) {
                maiorSalario = salario[i];
                numero = i;
            } else if (salario[i] == maiorSalario) {
                //  ERTA              NA
                if (nome[i].compareTo(nome[numero]) < 0){
                    numero = i;
                }
            }
        }

        return numero;
    }

    // Vai dar return ao número de pessoas
    private static int lerNomeESalario(String[] nome, double[] salario) {
        int i = 0;
        nome[i] = scanner.nextLine();
        salario[i] = scanner.nextDouble();
        while (!nome[i].equals("END") && i < PESSOAS) {
            i++;
            scanner.nextLine();
            nome[i] = scanner.nextLine();
            if (!nome[i].equals("END")) {
                salario[i] = scanner.nextDouble();
            }
        }

        return i;
    }
}