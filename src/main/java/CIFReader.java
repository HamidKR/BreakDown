import java.io.BufferedReader;
import java.io.FileReader;

public class CIFReader{

public ABX3 molecule;

    public CIFReader(String file) {
        String[] features = new String[35];
        BufferedReader reader;
        String line;
        try {

            reader = new BufferedReader(new FileReader(file));

            line = reader.readLine();

            for(int i=1; line != null; i++) {
                if(i==1){
                    features[0] = line.split("\\s+")[2];
                } else if(5<=i && i<=12){
                    features[i-4] = line.split("\\s+")[1];
                } else if(26<=i && i<=30){
                    features[4*i-95] = line.split("\\s+")[1];
                    for(int j=3; j<=5; j++) {
                        features[4*i+j-97] = line.split("\\s+")[j];
                    }
                } else if(i==32){
                    features[29] = line.split("\\s+")[2];
                } else if(39<=i && i<=43){
                    features[i-9] = line.split("\\s+")[2];
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