import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

public class CIFReader {

    public ABX3 molecule;
    public String[] features = new String[35];

    public CIFReader(String file) {
        BufferedReader reader;
        String line;
        try {

            reader = new BufferedReader(new FileReader(file));

            line = reader.readLine();

            for (int i = 1; line != null; i++) {
                if (i == 1) {
                    features[0] = line.split("\\s+")[2];
                } else if (5 <= i && i <= 12) {
                    features[i - 4] = line.split("\\s+")[1];
                } else if (26 <= i && i <= 30) {
                    features[4 * i - 95] = line.split("\\s+")[1];
                    for (int j = 3; j <= 5; j++) {
                        features[4 * i + j - 97] = line.split("\\s+")[j];
                    }
                } else if (i == 32) {
                    features[29] = line.split("\\s+")[2];
                } else if (39 <= i && i <= 43) {
                    features[i - 9] = line.split("\\s+")[2];
                }
                line = reader.readLine();
            }
            molecule = new ABX3(features);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(System.getProperty("user.dir") + "/data/CIFABX3.csv");

        for (int j = 1519; j <= 1727; j++){
        String filename = System.getProperty("user.dir") + "/data/ABX3CIF/"+(j)+".cif";
        CIFReader reader = new CIFReader(filename);
            for (int i = 0; i <= reader.features.length - 1; i++) {
                writer.print(reader.features[i] + ",");
            }

            for (int k = 0; k < 4; k++){
                for(int l = 0; l <= 4; l++) {
                    writer.print(reader.molecule.C[k][l] + ",");
                }
            }
            for(int f = 0; f < 4; f++) {
                writer.print(reader.molecule.C[4][f] + ",");
            }
            writer.print(reader.molecule.C[4][4]);
            writer.println();

        }

        writer.close();
}
}