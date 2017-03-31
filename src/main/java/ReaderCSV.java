

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Hamid on 2/14/17.
 */
public class ReaderCSV{
    public ArrayList<ABX3> molecules;

    public ReaderCSV() {
        molecules = new ArrayList<ABX3>();

        String data = System.getProperty("user.dir") + "/data/ABX3Data1.csv";
        BufferedReader reader;
        String line;
        //int counter=0;
        try {

            reader = new BufferedReader(new FileReader(data));

            //line = reader.readLine();
            line = reader.readLine();

            while (line != null) {
                //counter= counter+1;
                //String trimmed = line.replace("\"\"","");
                String[] facilityAttributes = line.split(",");
                ABX3 facilityObject = new ABX3(facilityAttributes);
                //if (counter== 195)
                //    System.out.print("stop");
                molecules.add(facilityObject);

                line = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello World!"); // Display the string.
        ReaderCSV myreader = new ReaderCSV();
        // System.out.println(myreader.molecules.get(200).m1);

        try{
            PrintWriter writer = new PrintWriter(System.getProperty("user.dir") + "/data/myNewData.csv");
            for(int i=0;i<myreader.molecules.size();i++){
                writer.print(myreader.molecules.get(i).el1 + "," + myreader.molecules.get(i).el2 + "," + myreader.molecules.get(i).el3 + "," + myreader.molecules.get(i).el4 + "," + myreader.molecules.get(i).el5 + "," + myreader.molecules.get(i).Natome + "," + myreader.molecules.get(i).Density + ",");
                String s = "";if(myreader.molecules.get(i).Fb < 100){
                    s = "0";
                }if (myreader.molecules.get(i).Fb >= 100 && myreader.molecules.get(i).Fb < 500){
                    s = "1";
                }if(myreader.molecules.get(i).Fb >= 500 && myreader.molecules.get(i).Fb < 1000){
                    s = "2";
                }else{
                    s="3";
                }
                writer.println(s);
            } writer.close();} catch (IOException e){

        }
    }
}
