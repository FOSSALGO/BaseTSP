package test;

import fosalgo.Data;
import fosalgo.DataReader;
import fosalgo.Individu;
import fosalgo.Vertex;
import java.io.File;

public class Test02 {

    public static void main(String[] args) {
        File file = new File("burma14.tsp");
        Vertex[] arrayVertex = DataReader.read(file);
        Data data = new Data(arrayVertex);
        System.out.println(data.toString());

        int numIndividu = 239;
        Individu[] populasi = new Individu[numIndividu];

        double bestFitness = 0;
        double bestTotaljarak = 0;
        Individu bestIndividu = null;

        for (int p = 0; p < populasi.length; p++) {
            populasi[p] = new Individu(data);
            populasi[p].generateRandomKromosom();
            populasi[p].hitungNilaiFitness();

            //cetak solusi
            System.out.print("Individu: ");
            System.out.print(populasi[p].toString());
            System.out.print(" jarak: " + populasi[p].getTotalJarak());
            System.out.println(" fitness: " + populasi[p].getNilaiFitness());

            //evaluasi fitness terbaik
            if (populasi[p].getNilaiFitness() > bestFitness) {
                bestFitness = populasi[p].getNilaiFitness();
                bestTotaljarak = populasi[p].getTotalJarak();
                bestIndividu = populasi[p];
            }
        }

        System.out.println("Best Solution");
        System.out.print("Individu: ");
        System.out.print(bestIndividu.toString());
        System.out.print(" jarak: " + bestIndividu.getTotalJarak());
        System.out.println(" fitness: " + bestIndividu.getNilaiFitness());
    }
}
