package gvaCEED;
import java.util.Scanner;
import java.util.Random;

/*
------------------------------------------------------------
Exercici: Escapa de la Mansió Embruixada 🎃
------------------------------------------------------------
Descripció:
Crea un programa en Java que simule un joc de Halloween en la consola.
El jugador està atrapat en una mansió embruixada i ha de trobar l’eixida
abans que s’acaben els passos.

Requisits:
- Mostrar un missatge inicial indicant la situació.
- El jugador té 5 passos per trobar l’eixida.
- En cada pas, ha de triar entre dues portes: esquerra (1) o dreta (2).
- Utilitzar estructures de control:
    * if / if-else: per comprovar si l’elecció és correcta.
    * while: per repetir el joc mentre queden passos i no haja escapat.
    * do-while: per validar que l’entrada siga 1 o 2.
- Si el jugador tria la porta correcta, guanya i escapa.
- Si es queda sense passos, perd i queda atrapat en la mansió.
------------------------------------------------------------
*/
public class MansionEmbrujada_v0 {
    public static void main(String[] args) {
        // Crear la variable Scanner per llegir per pantalla

        Scanner entrada = new Scanner(System.in);

        Random rand = new Random(5);

        // Crear variable sencera passos

        int passos = 0;

        // Crear la variable booleana eixidaTrobada

        boolean eixidaTrobada = false;

        // Mostrar per pantalla 🎃 Benvingut a la Mansió Embruixada 🎃

        System.out.println("Benvingut a la mansió embruixada");

        // Mostrar per pantalla "Tens X passos per trobar l’eixida... Bona sort!"

        passos = 5;
        System.out.println("Tens " + passos + " per a trobar la eixida.");

        // Mentre que passos siga major que 0 i no s’haja trobat l’eixida

        while ((passos > 0) && (eixidaTrobada == false)) {

            // Mostrar per pantalla "Porta esquerra (1) o dreta (2)?"
            // Crear variable per a l’elecció de l’usuari

            System.out.println("Porta esquerra (1) o dreta (2)?");

            // Recollir elecció de l’usuari amb la variable Scanner

            int eleccioUsari = entrada.nextInt();

            int portaCorrectaAlAzar = rand.nextInt(2) + 1;

            // Si l’elecció és igual a portaCorrectaAlAzar

            if (eleccioUsari == portaCorrectaAlAzar) {

                // Si l’elecció és igual a portaCorrectaAlAzar
                // Mostrar per pantalla "✅ Has trobat l’eixida! Escapes de la mansió..." i
                // canviar eixidaTrobada a true

                System.out.println("✅ Has trobat l’eixida! Escapes de la mansió...");

                eixidaTrobada = true;
            } else {
                passos = (passos - 1);
                System.out.println("👻 Un fantasma t’espanta! Et queden " + passos + " passos.");

                // Si no, restar passos i mostrar per pantalla "👻 Un fantasma t’espanta! Et
                // queden " + passos + " passos."

            }

        }
        // Si no has trobat l’eixida mostrar per pantalla "💀 S’han acabat els passos...
        // La mansió t’atrapa per sempre!"
        if (eixidaTrobada == false) {
            System.out.println("💀 S’han acabat els passos... La mansió t’atrapa per sempre!");
        }

    }
}
