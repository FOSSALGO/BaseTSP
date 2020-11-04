package test;

import fosalgo.Data;
import fosalgo.DataReader;
import fosalgo.Individu;
import fosalgo.Vertex;
import java.io.File;

public class Test01 {
    public static void main(String[] args) {
        File file = new File("burma14.tsp");
        Vertex[] arrayVertex = DataReader.read(file);
        Data data = new Data(arrayVertex);
        System.out.println(data.toString());
        
        Individu indv01 = new Individu(data);
        indv01.generateRandomKromosom();
        indv01.hitungNilaiFitness();
        
        System.out.print("Individu: ");
        System.out.print(indv01.toString());
        System.out.print(" jarak: "+indv01.getTotalJarak());
        System.out.println(" fitness: "+indv01.getNilaiFitness());   
    }
}
