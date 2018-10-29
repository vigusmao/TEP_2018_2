import java.util.HashMap;
import java.util.Map;

public class Trie {

    TrieNode raiz = new TrieNode();

    public void adicionarPalavra(String palavra) {
        TrieNode noCorrente = raiz;
        for (char c : palavra.toCharArray()) {
            TrieNode noFilho = noCorrente.filhos.get(c);
            if (noFilho == null) {
                noFilho = new TrieNode();
                noCorrente.filhos.put(c, noFilho);
            }
            noCorrente = noFilho;
        }
        noCorrente.terminacao = true;
    }

    private TrieNode getUltimoNoPrefixo(String prefixo) {
        if (isVazia()) {
            return null;
        }
        TrieNode noCorrente = raiz;
        for (char c : prefixo.toCharArray()) {
            TrieNode noFilho = noCorrente.filhos.get(c);
            if (noFilho == null) {
                return null;
            }
            noCorrente = noFilho;
        }
        return noCorrente;
    }

    public boolean contemPrefixo(String prefixo) {
        return getUltimoNoPrefixo(prefixo) != null;
    }

    public boolean contemPalavra(String palavra) {
        TrieNode ultimoNoPrefixo = getUltimoNoPrefixo(palavra);
        return ultimoNoPrefixo != null && ultimoNoPrefixo.terminacao;
    }

    private  boolean isVazia() {
        return raiz.filhos.isEmpty();
    }

    private class TrieNode {
        boolean terminacao = false;
        Map<Character, TrieNode> filhos = new HashMap<>();
    }
}
