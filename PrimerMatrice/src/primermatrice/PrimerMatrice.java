package primermatrice;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class PrimerMatrice {

    public static void main(String[] args) {
        String ime = JOptionPane.showInputDialog(null, "Unesite vase ime: ");
        String prezime = JOptionPane.showInputDialog(null, "Unesite vase prezime: ");

        JOptionPane.showMessageDialog(null, "Dobrodosli " + ime + " " + prezime + ""
                + "\n Proverite vase znanje iz Osnova Java Programiranja!!");

        JOptionPane.showMessageDialog(null, "Unesite podatke za niz i matricu sa okojima cete raditi: ");
        int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Unesite broj elemenata niza: "));
        int nizA[] = new int[n];
        JOptionPane.showMessageDialog(null, "Hvala, unesli ste broj elemenata niza");
        ucitajNiz(nizA, n);
        int n1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Unesite bro redova matrice"));
        int m = Integer.parseInt(JOptionPane.showInputDialog(null, "Unesite broj kolona matrice"));
        int[][] mat = new int[n][m];
        ucitajMatricu(mat, n1, m);

        while (true) {
            int izbor = Integer.parseInt(JOptionPane.showInputDialog(null, "Izaberite iz menija neku od opciju:\n"
                    + "1. prikaz sortiranog niza\n"
                    + "2. zbir svih clanova niza\n"
                    + "3. prikaz clanova niza sa glavne dijagonalew\n"
                    + "4. prikaz najamanjeg i naveceg clana matrce"));
            switch (izbor) {
                case 1:
                    sortirajNiz(nizA, n);
                    stampajNiz(nizA, n);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Zbir svih clanova niza " + zbirNiza(nizA));
                    break;
                case 3:
                    prikaziGlavnuDijagonalu(mat, n1, m);
                    break;
                case 4:
                    minMaxMatrice(mat, n1, m);
                    break;

            }
            String ponovo = JOptionPane.showInputDialog(null,"Da li zelite ponovo\n (da ili ne)");
            if(ponovo.equals("da")){
            continue;
            }
            else{
            break;
            }
            

        }

    }

    private static void ucitajNiz(int[] a, int n) {
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "[" + i + "] = " + " clan niza"));
        }
    }

    private static void ucitajMatricu(int[][] mat, int n1, int m) {
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = Integer.parseInt(JOptionPane.showInputDialog(null, "mat (" + i + ")" + "(" + j + ") = "));
            }
        }
    }

    private static void sortirajNiz(int[] nizA, int n) {
        Arrays.sort(nizA);
    }

    private static void stampajNiz(int[] nizA, int n) {
        String msg = "";
        for (int i = 0; i < nizA.length; i++) {
            msg += (nizA[i] + ",");

        }
        JOptionPane.showMessageDialog(null, "Dobili ste niz: " + msg.substring(0, msg.length() - 1));
    }

    private static int zbirNiza(int nizA[]) {
        int zbir = 0;
        for (int i : nizA) {
            zbir += i;
        }

        return zbir;

    }

    private static void prikaziGlavnuDijagonalu(int[][] mat, int n1, int m) {
        String msg = "";
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m; j++) //provera da li je broj vrste jednak broju kolone - 
            // osobina elemenata glavne dijagonale matrice
            {
                if (i == j) {
                    msg += ("a (" + i + ", " + j + ") = " + mat[i][j] + "\n");
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Elementi glavne dijagonale su:\n" + msg);
    }

    private static void minMaxMatrice(int[][] mat, int n1, int m) {
        int min = mat[0][0];
        int max = mat[0][0];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] < min) {
                    min = mat[i][j];
                }
                if (mat[i][j] > max) {
                    max = mat[i][j];
                }

            }
        }
        JOptionPane.showMessageDialog(null, "Najveći član matrice je : " + max
                + "\nNajmanji član matrice je: " + min);

    }

}
