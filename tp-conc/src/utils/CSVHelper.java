package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVHelper {

    public static String[][] read(String filePath, int lineas){
        String[][] res = new String[lineas][];
        try (BufferedReader br = new BufferedReader (new FileReader( filePath ))) {
            String line ;
            for (int i =0; i < lineas ; i ++) {
                line = br.readLine();
                String[] valsStr = line.split(",");
                res[i] = valsStr;
                // En el array vals_str estan los valores , en tipo String
            }
            return res;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e); // TODO: ver que tirar aca
        } catch (IOException e) {
            throw new RuntimeException(e); // TODO: Idem de arriba
        }
    }
}