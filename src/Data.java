import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {

    private ArrayList<double[]> info = new ArrayList();
    private ArrayList<String> resault=new ArrayList<>();
    private ArrayList<Integer> resaultInt=new ArrayList<>();
    private String vTrue,vFalse;

    public void load(String file) {
        try {

            Scanner scanner = new Scanner(new File(file));

            while (scanner.hasNextLine()) {
                String tmp = scanner.nextLine();
                String[] info = tmp.split(",");
                double[] infoDouble = new double[info.length - 1];
                for (int i = 0; i < infoDouble.length; i++) {
                    infoDouble[i] = Double.parseDouble(info[i]);
                }
                this.info.add(infoDouble);
                this.resault.add(info[info.length-1]);
                if(info[info.length-1].equals(resault.get(0))){
                    resaultInt.add(1);
                    vTrue=info[info.length-1];
                }else {
                    resaultInt.add(0);
                    vFalse=info[info.length-1];
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getvTrue() {
        return vTrue;
    }

    public void setvTrue(String vTrue) {
        this.vTrue = vTrue;
    }

    public String getvFalse() {
        return vFalse;
    }

    public void setvFalse(String vFalse) {
        this.vFalse = vFalse;
    }

    public ArrayList<Integer> getResaultInt() {
        return resaultInt;
    }

    public void setResaultInt(ArrayList<Integer> resaultInt) {
        this.resaultInt = resaultInt;
    }

    public ArrayList<double[]> getInfo() {
        return info;
    }

    public void setInfo(ArrayList<double[]> info) {
        this.info = info;
    }

    public ArrayList<String> getResault() {
        return resault;
    }

    public void setResault(ArrayList<String> resault) {
        this.resault = resault;
    }
}
