import java.util.*;

public class RetanguloMagico {

    Map<Integer, List<String>> palavrasByTamanho;
    Map<Integer, Trie> triesByTamanho;
    StringBuilder sb;

    public RetanguloMagico(Collection<String> palavrasValidas) {
        palavrasByTamanho = new HashMap<>();
        triesByTamanho = new HashMap<>();

        // particiona as palavras por tamanho
        for (String palavra : palavrasValidas) {
            int tamanho = palavra.length();

            // adiciona à lista
            List<String> palavras = palavrasByTamanho.get(tamanho);
            if (palavras == null) {
                palavras = new ArrayList<>();
                palavrasByTamanho.put(tamanho, palavras);
            }
            palavras.add(palavra);

//            // adiciona à trie
//            Trie trie = triesByTamanho.get(tamanho);
//            if (trie == null) {
//                trie = new Trie();
//                triesByTamanho.put(tamanho, trie);
//            }
//            trie.adicionarPalavra(palavra);
        }
        sb = new StringBuilder();
    }

    public List<String> encontrarRetanguloMagico(int linhas, int colunas) {
        List<String> retangulo = new ArrayList<>(linhas);
        boolean encontrou = backtrack(retangulo, linhas, colunas);
        if (encontrou) {
            return retangulo;
        }
        return null;
    }

    private boolean backtrack(List<String> estadoCorrente, int linhas, int colunas) {
        // é um estado final?
        if (estadoCorrente.size() == linhas) {
            return true;
        }
        List<String> candidatas = palavrasByTamanho.get(colunas);
        if (candidatas == null) {
            return false;
        }

        for (String candidata : candidatas) {

            estadoCorrente.add(candidata);
            if (ehPromissor(estadoCorrente, linhas)) {
                boolean resultado = backtrack(estadoCorrente, linhas, colunas);
                if (resultado) {
                    return true;
                }
            }
            estadoCorrente.remove(estadoCorrente.size() - 1);
        }
        return false;
    }

    boolean ehPromissor(List<String> retangulo, int tamanhoDesejado) {
        int tamanhoPrefixos = retangulo.size();
        if (tamanhoPrefixos == 0) {
            return true;
        }
        int tamanhoPalavras = retangulo.get(0).length();

        for (int coluna = 0; coluna < tamanhoPalavras; coluna++) {
            sb.setLength(0);
            for (int linha = 0; linha < tamanhoPrefixos; linha++) {
                String palavraDaLinha = retangulo.get(linha);
                sb.append(palavraDaLinha.charAt(coluna));
            }
            String prefixo = sb.toString();
            if (!ehPrefixo(prefixo, tamanhoDesejado)) {
                return false;
            }
        }
        return true;
    }

    boolean ehPrefixo(String prefixo, int tamanhoDesejado) {
        List<String> palavras = palavrasByTamanho.get(tamanhoDesejado);
        if (palavras == null) {
            return false;
        }
        for (String palavra : palavras) {
            if (palavra.startsWith(prefixo)) {
                return true;
            }
        }
        return false;
    }

    boolean ehPrefixoUsandoTrie(String prefixo, int tamanhoDesejado) {
        Trie trie = triesByTamanho.get(tamanhoDesejado);
        if (trie == null) {
            return false;
        }
        return trie.contemPrefixo(prefixo);
    }

}
