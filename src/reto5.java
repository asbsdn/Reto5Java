import java.text.DecimalFormat;
import java.util.Scanner;

public class reto5 {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int entradas = teclado.nextInt();
        teclado.nextLine();
        DensidadPoblacional[] listaEntrada = new DensidadPoblacional[entradas];
        double nivel = 0;
        double suma = 0;
        DecimalFormat df = new DecimalFormat("#.00");

        for (int i = 0; i < listaEntrada.length; i++) {
            String[] entrada = teclado.nextLine().split(" ");
            listaEntrada[i] = new DensidadPoblacional(entrada[0], Integer.parseInt(entrada[1]), entrada[2], entrada[3],
                    entrada[4], Double.parseDouble(entrada[5]), Integer.parseInt(entrada[6]));
        }
        teclado.close();

        for (int i = 0; i < listaEntrada.length; i++) {
            listaEntrada[i].imprimir();
        }

        for (int i = 0; i < listaEntrada.length; i++) {
            if (listaEntrada[i].nivel() == "medio") {
                nivel += 1;
            }
        }
        System.out.println(df.format(nivel));

        for (int i = 0; i < listaEntrada.length; i++) {
            listaEntrada[i].imprimirMedios();
            suma += listaEntrada[i].indice;            
        }
        System.out.println();
        double prom = suma / listaEntrada.length;
        System.out.println(df.format(prom));

        for (int i = 0; i < listaEntrada.length; i++) {
            int pob;
            pob = listaEntrada[i].poblacion;
            System.out.println(listaEntrada[i].afeccion(pob));
        }
    }
}