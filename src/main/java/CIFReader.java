import java.io.BufferedReader;
import java.io.FileReader;

public class CIFReader{

public ABX3 molecule;

    public CIFReader(String file) {
        String[] features = new String[19];
        BufferedReader reader;
        String line;
        int num=0;
        try {

            reader = new BufferedReader(new FileReader(file));

            line = reader.readLine();

            while (line != null) {
                num = num + 1;
                switch(num) {
                    case 0:
                        features[0] = line.split("\\s+")[2];
                        break;
                    case 26:
                        features[1] = line.split("\\s+")[1];
                        break;
                    case 27:
                        features[2] = line.split("\\s+")[1];
                        break;
                    case 28:
                        features[3] = line.split("\\s+")[1];
                        break;
                    case 29:
                        features[4] = line.split("\\s+")[1];
                        break;
                    case 30:
                        features[5] = line.split("\\s+")[1];
                        break;
                    case 42:
                        features[6] = line.split("\\s+")[2];
                        break;
                    case 39:
                        features[7] = line.split("\\s+")[2];
                        break;
                    case 41:
                        features[8] = line.split("\\s+")[2];
                        break;
                    case 5:
                        features[9] = line.split("\\s+")[1];
                        break;
                    case 6:
                        features[10] = line.split("\\s+")[1];
                        break;
                    case 7:
                        features[11] = line.split("\\s+")[1];
                        break;
                    case 8:
                        features[12] = line.split("\\s+")[1];
                        break;
                    case 9:
                        features[13] = line.split("\\s+")[1];
                        break;
                    case 10:
                        features[14] = line.split("\\s+")[1];
                        break;
                    case 11:
                        features[15] = line.split("\\s+")[1];
                        break;
                    case 33:
                        features[16] = line.split("\\s+")[2];
                        break;
                    case 43:
                        features[17] = line.split("\\s+")[2];
                        break;
                    case 12:
                        features[18] = line.split("\\s+")[1];
                        break;
                }
                line = reader.readLine();
            }
            molecule = new ABX3(features);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String filename = System.getProperty("user.dir") + "/data/1519.cif";
        CIFReader reader = new CIFReader(filename);
    }
}
