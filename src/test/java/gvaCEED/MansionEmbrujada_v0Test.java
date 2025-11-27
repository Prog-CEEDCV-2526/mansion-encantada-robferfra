package gvaCEED;
import gvaCEED.MansionEmbrujada_v0;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import src.main.java.gvaCEED.MansionEmbrujada_v0;

public class MansionEmbrujada_v0Test {



    @Test
    public void testMostraMissatgeInicial() throws Exception {
        // Simulem algunes entrades perquè el programa no es quede esperant
        String input = "1\n1\n1\n1\n1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Capturem l'eixida per comprovar el text
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        MansionEmbrujada_v0.main(new String[]{});

        String resultat = out.toString();

        // Comprovar que mostra el missatge inicial
        assertTrue(resultat.contains("Benvingut a la Mansió Embruixada"),
                "El missatge de benvinguda no apareix o està mal escrit.");
        assertTrue(resultat.contains("Tens 5 passos per trobar l’eixida")
                        || resultat.contains("Tens 5 passos per trobar l'eixida"),
                "El missatge amb els passos inicials no apareix o està mal escrit.");
    }

    @Test
    public void testDemanaPorta() throws Exception {
        String input = "1\n1\n1\n1\n1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        MansionEmbrujada_v0.main(new String[]{});

        String resultat = out.toString();

        // Hauria de demanar almenys una volta la porta
        assertTrue(resultat.contains("Porta esquerra (1) o dreta (2)?")
                        || resultat.toLowerCase().contains("porta esquerra"),
                "No pareix que es demane a l'usuari que trie porta.");
    }

    @Test
    public void testMostraFinalSiNoEscapa() throws Exception {
        // Donem sempre la mateixa entrada; amb el random d'ells potser escapen o no,
        // però com a mínim comprovem que el programa arriva a algun final amb passos 0 o eixida trobada.
        String input = "1\n1\n1\n1\n1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        MansionEmbrujada_v0.main(new String[]{});

        String resultat = out.toString();

        // Acceptem qualsevol dels dos finals possibles
        boolean haEscapat = resultat.contains("Has trobat l’eixida")
                            || resultat.contains("Has trobat l'eixida");
        boolean haPerdut = resultat.contains("S’han acabat els passos")
                            || resultat.contains("S'han acabat els passos");

        assertTrue(haEscapat || haPerdut,
                "El programa no mostra cap missatge de final (ni guanya ni perd).");
    }

    @Test
    public void testValidacioEntradaRepetida() throws Exception {
        // Simulem una entrada incorrecta (9) i després una correcta (2)
        String input = "9\n2\n2\n2\n2\n2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        MansionEmbrujada_v0.main(new String[]{});

        String resultat = out.toString();

        // Comptem quantes vegades es mostra la pregunta de la porta
        int count = resultat.split("Porta esquerra").length - 1;

        // Hauria d'aparéixer almenys 2 vegades si el do-while funciona
        assertTrue(count >= 2,
                "Pareix que no es repeteix la pregunta quan l'entrada és incorrecta (do-while?).");
    }
}
