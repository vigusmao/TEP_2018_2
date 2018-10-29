import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {

    private Trie trie;

    @Before
    public void setUp() {
        trie = new Trie();
    }

    private void adicionarPalavras() {
        trie.adicionarPalavra("");
        trie.adicionarPalavra("ar");
        trie.adicionarPalavra("aro");
        trie.adicionarPalavra("areia");
        trie.adicionarPalavra("aroma");
        trie.adicionarPalavra("gol");
        trie.adicionarPalavra("gelo");
        trie.adicionarPalavra("aba");
        trie.adicionarPalavra("gim");
        trie.adicionarPalavra("gole");
    }

    @Test
    public void testeContemPalavra() {
        adicionarPalavras();
        assertTrue(trie.contemPalavra("gol"));
        assertTrue(trie.contemPalavra("areia"));
        assertFalse(trie.contemPalavra("go"));
        assertFalse(trie.contemPalavra("golll"));
    }

    @Test
    public void testeContemPrefixo() {
        assertFalse(trie.contemPrefixo(""));

        adicionarPalavras();

        assertTrue(trie.contemPrefixo(""));
        assertTrue(trie.contemPrefixo("gol"));
        assertTrue(trie.contemPrefixo("go"));
        assertFalse(trie.contemPrefixo("llll"));
    }
}