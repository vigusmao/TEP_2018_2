import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class RetanguloPalavrasTest {
    /*
         cats
         aces
         reds
    */

    private static List<String> palavrasValidas;
    private RetanguloMagico retanguloMagico;

    @BeforeClass
    public static void setUpClass() {
        palavrasValidas = new ArrayList<>();
        palavrasValidas.add("cats");
        palavrasValidas.add("trouble");
        palavrasValidas.add("dlfhsdf");
        palavrasValidas.add("toy");
        palavrasValidas.add("goiaba");
        palavrasValidas.add("car");
        palavrasValidas.add("aces");
        palavrasValidas.add("ace");
        palavrasValidas.add("ted");
        palavrasValidas.add("sss");
        palavrasValidas.add("reds");
        palavrasValidas.add("redsssss");
    }

    @Before
    public void setUp() {
        retanguloMagico = new RetanguloMagico(palavrasValidas);
    }

    @Test
    public void testeEhPrefixo() {
        assertFalse(retanguloMagico.ehPrefixoUsandoTrie("can", 3));
        assertFalse(retanguloMagico.ehPrefixoUsandoTrie("can", 4));
        assertFalse(retanguloMagico.ehPrefixoUsandoTrie("cats", 5));

        assertTrue(retanguloMagico.ehPrefixoUsandoTrie("cat", 4));
        assertTrue(retanguloMagico.ehPrefixoUsandoTrie("cats", 4));
        assertTrue(retanguloMagico.ehPrefixoUsandoTrie("", 4));
    }

    @Test
    public void testeEhPromissor() {
        List<String> retangulo = new ArrayList<>();
        assertTrue("Um retângulo vazio deve ser considerado promissor",
                retanguloMagico.ehPromissor(retangulo, 3));

        retangulo.add("cats");
        assertTrue(retanguloMagico.ehPromissor(retangulo, 3));
        assertFalse(retanguloMagico.ehPromissor(retangulo, 5));

        retangulo.add("aces");
        assertTrue(retanguloMagico.ehPromissor(retangulo, 3));

        retangulo.add("reds");
        assertTrue(retanguloMagico.ehPromissor(retangulo, 3));
    }

    @Test
    public void testeEncontrarRetanguloMagico() {
        assertNull(retanguloMagico.encontrarRetanguloMagico(2, 2));
        assertNotNull(retanguloMagico.encontrarRetanguloMagico(3, 4));
        assertNotNull(retanguloMagico.encontrarRetanguloMagico(4, 3));
        assertNull(retanguloMagico.encontrarRetanguloMagico(4, 4));
    }
}