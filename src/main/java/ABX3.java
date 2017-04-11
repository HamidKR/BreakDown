import java.util.Arrays;

public class ABX3 {
    public String name,SpaceGroup,LatticeStruc;
    public double[] cell_lengths,cell_angles;
    public String[] elements;
    public double[][] r,pos;
    public int Natoms;
    public double Eg,Atomization,OmegaMax,Fb,Density;

    public ABX3(String name, double[] cell_lengths, double[] cell_angles, String SpaceGroup, String LatticeStruc, String[] elements,
                double[][] r, int Natoms, double Eg, double Atomization, double OmegaMax, double Fb, double Density) {
        this.name = name;
        this.cell_lengths = cell_lengths;
        this.cell_angles = cell_angles;
        this.SpaceGroup = SpaceGroup;
        this.LatticeStruc = LatticeStruc;
        this.elements = elements;
        this.r = r;
        for(int i=0; i<5; i++){
            for(int j=0; j<3; j++){
                pos[i][j] = r[i][j]*cell_lengths[j];
            }
        }
        this.Natoms = Natoms;
        this.Eg = Eg;
        this.Atomization = Atomization;
        this.OmegaMax = OmegaMax;
        this.Fb = Fb;
        this.Density = Density;
    }

    public ABX3(String[] features) {
        this.name = features[0];
        double[] cell_lengths = {Double.parseDouble(features[1]), Double.parseDouble(features[2]), Double.parseDouble(features[3])};
        this.cell_lengths = cell_lengths;
        double[] cell_angles = {Double.parseDouble(features[4]), Double.parseDouble(features[5]), Double.parseDouble(features[6])};
        this.cell_angles = cell_angles;
        this.SpaceGroup = features[7];
        this.LatticeStruc = features[8];
        String[] elements = new String[5];
        double[][] r = new double[5][3];
        double[][] pos = new double[5][3];
        for(int i=0; i<5; i++){
            elements[i] = features[9+4*i];
            for(int j=0; j<3; j++){
                r[i][j] = Double.parseDouble(features[10+4*i+j]);
                pos[i][j] = r[i][j]*cell_lengths[j];
            }
        }
        this.elements = elements;
        this.r = r;
        this.pos = pos;
        this.Natoms = Integer.parseInt(features[29]);
        this.Eg = Double.parseDouble(features[30]);
        this.Atomization = Double.parseDouble(features[31]);
        this.OmegaMax = Double.parseDouble(features[32]);
        this.Fb = Double.parseDouble(features[33]);
        this.Density = Double.parseDouble(features[34]);
    }
}
