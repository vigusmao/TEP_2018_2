import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        List<String> palavrasValidas = new ArrayList<>();

        System.out.println("Carregando palavras...");
        long start = System.currentTimeMillis();

        File f = new File("palavras.txt");
        try {
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String palavra = sc.nextLine();
                palavrasValidas.add(palavra);
            }
            sc.close();

            long duracao = System.currentTimeMillis() - start;
            imprimirDuracao(duracao);

            System.out.println("Encontrando retângulo mágico...");
            start = System.currentTimeMillis();

            RetanguloMagico ret = new RetanguloMagico(palavrasValidas);
            List<String> resultado = ret.encontrarRetanguloMagico(6, 6);

            duracao = System.currentTimeMillis() - start;
            imprimirDuracao(duracao);

            if (resultado != null) {
                for (String linha : resultado) {
                    System.out.println(linha);
                }
            } else {
                System.out.println("Não encontrei.");
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void imprimirDuracao(long duracao) {
        System.out.printf("Pronto. Tempo = %.3f segundos\n",
                (duracao / 1000.0));
    }
}
