
/**
 * Created by Hamid on 2/14/17.
 */
public class ABX3 {
    public String name;
    public String el1,el2,el3,el4,el5;
    public double m1,m2,m3,am1,am2,am3;
    public double Fb;
    public double Eg;
    public double OmegaMax;
    public String SpaceGroup;
    public int Natome;
    public double Density;
    public String LattisStruc;


    public ABX3(String name, String el1, String el2, String el3, String el4, String el5, double m1, double m2, double m3, double am1, double am2, double am3, double Fb, double Eg,
                double OmegaMax, int Natome, String SpaceGroup, String LattisStruc) {
        this.name = name;
        this.el1 = el1;
        this.el2 = el2;
        this.el3 = el3;
        this.el4 = el4;
        this.el5 = el5;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.am1 = am1;
        this.am2 = am2;
        this.am3 = am3;
        this.Fb = Fb;
        this.Eg = Eg;
        this.OmegaMax = OmegaMax;
        this.SpaceGroup = SpaceGroup;
        this.Natome = Natome;
        this.Density = Density;
        this.LattisStruc = LattisStruc;
    }

    public ABX3(String[] features) {
        //this.id = Integer.parseInt(features[0].replace("\"",""));
        this.name = features[0];
        this.el1 = features[1];
        this.el2 = features[2];
        this.el3 = features[3];
        this.el4 = features[4];
        this.el5 = features[5];
        this.m1 = Double.parseDouble(features[9]);
        this.m2 = Double.parseDouble(features[10]);
        this.m3 = Double.parseDouble(features[11]);
        this.am1 = Double.parseDouble(features[12]);
        this.am2 = Double.parseDouble(features[13]);
        this.am3 = Double.parseDouble(features[14]);
        this.Fb = Double.parseDouble(features[6]);
        this.Eg = Double.parseDouble(features[7]);
        this.OmegaMax = Double.parseDouble(features[8]);
        this.SpaceGroup = features[15];
        this.Natome = Integer.parseInt(features[16]);
        this.Density = Double.parseDouble(features[17]);
        this.LattisStruc = features[18];
    }
}
