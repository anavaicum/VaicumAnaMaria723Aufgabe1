import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
public class main {
    public static void main(String[] args) {
        try {
            // Citirea datelor din fisierul TSV
            String filePath = "spielorte.tsv";
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            List<Map<String, String>> spielorteList = new ArrayList<>();

            // Parsarea fisierului TSV si adaugarea datelor intr-o lista de harti
            String[] headers = lines.get(0).split("\t");
            for (int i = 1; i < lines.size(); i++) {
                String[] values = lines.get(i).split("\t");
                Map<String, String> spielort = new HashMap<>();
                for (int j = 0; j < headers.length; j++) {
                    spielort.put(headers[j], values[j]);
                }
                spielorteList.add(spielort);
            }

            // a) Afisarea locurilor in format brut (pentru verificare)
            System.out.println("Spielorte incarcate:");
            for (Map<String, String> spielort : spielorteList) {
                System.out.println(spielort);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}