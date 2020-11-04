package test;

import fosalgo.Data;
import fosalgo.DataReader;
import fosalgo.Individu;
import fosalgo.Vertex;
import java.io.File;

public class GA_Elitism {

    public static void main(String[] args) {
        //Siapkan Dataset
        File file = new File("burma14.tsp");
        Vertex[] arrayVertex = DataReader.read(file);
        Data data = new Data(arrayVertex);
        System.out.println(data.toString());

        //Tentukan Parameter Algoritma Genetika
        int nGenerasi = 10;
        int nPopulasi = 100;

        //Inisialisasi Best Individu / Solusi
        double bestFitness = 0;
        double bestTotalJarak = 0;
        Individu bestIndividu = null;

        //Memulai Proses Evolusi
        for (int g = 1; g <= nGenerasi; g++) {
            System.out.println("=============================================================================================");
            System.out.println("Generasi-" + g);
            Individu[] populasi = new Individu[nPopulasi];
            for (int p = 0; p < populasi.length; p++) {
                populasi[p] = new Individu(data);
                populasi[p].generateRandomKromosom();
                populasi[p].hitungNilaiFitness();

                //cetak populasi hasil generate secara random
                //System.out.print("Individu: ");
                //System.out.print(populasi[p].toString());
                //System.out.print(" jarak: " + populasi[p].getTotalJarak());
                //System.out.println(" fitness: " + populasi[p].getNilaiFitness());
                //=================================================

                //Operasi Elitisme
                //evaluasi fitness terbaik
                if (populasi[p].getNilaiFitness() > bestFitness) {
                    bestFitness = populasi[p].getNilaiFitness();
                    bestTotalJarak = populasi[p].getTotalJarak();
                    bestIndividu = populasi[p];//Individu Elitisme
                }

            }

            System.out.println("Current Best Individu: ");
            System.out.print("Individu: ");
            System.out.print(bestIndividu.toString());
            System.out.print(" jarak: " + bestIndividu.getTotalJarak());
            System.out.println(" fitness: " + bestIndividu.getNilaiFitness());
            System.out.println("----------------------------------------------------------------------------------------------");

        }//end of proses evolusi

        //Print hasil pencarian Solusi GA
        System.out.println("Best Solution");
        System.out.print("Individu: ");
        System.out.print(bestIndividu.toString());
        System.out.print(" jarak: " + bestIndividu.getTotalJarak());
        System.out.println(" fitness: " + bestIndividu.getNilaiFitness());

    }
}
