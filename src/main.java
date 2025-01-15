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

            // d) Calcularea numarului de meciuri pentru fiecare oras si salvarea in fisier
            Map<String, Integer> orteCounts = new TreeMap<>();
            for (Map<String, String> meci : spielorteList) {
                String orte = meci.get("Spielort");
                orteCounts.put(orte, orteCounts.getOrDefault(orte, 0) + 1);
            }


            BufferedWriter writer = new BufferedWriter(new FileWriter("spielanzahl.txt"));
            writer.write("Spiel\tAnzahl\n");
            for (Map.Entry<String, Integer> entry : orteCounts.entrySet()) {
                writer.write(entry.getKey() + "%" + entry.getValue());
                writer.newLine();
            }
            writer.close();

            System.out.println("Fisierul ergebnis.txt a fost creat cu succes.");




        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}