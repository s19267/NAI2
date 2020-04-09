import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Data data = new Data();
    static Perceptron perceptron = new Perceptron();

    public static void main(String[] args) {
        data.load("perceptron.data");
        System.out.println("1.test z pliku\n2.test z klawiatury\n0.koniec:");
        int tmp = scanner.nextInt();
        System.out.println("podaj wartość stałej uczenia:");
        double con=scanner.nextDouble();
        perceptron.setLearningFactor(con);
        perceptron.teach(data);
        if (tmp == 1) {
            int correct=0;
            Data testData = new Data();
            testData.load("perceptron.test.data");
            for (int i = 0; i < testData.getInfo().size(); i++) {
                boolean y = perceptron.calculateY(testData.getInfo().get(i));
                if(y){
                    System.out.println("resault:"+data.getvTrue()+" correct:"+testData.getResault().get(i));
                    if(data.getvTrue().equals(testData.getResault().get(i)))
                        correct++;
                }else{
                    System.out.println("resault:"+data.getvFalse()+" correct:"+testData.getResault().get(i));
                    if(data.getvFalse().equals(testData.getResault().get(i)))
                        correct++;
                }
            }
            System.out.println(correct+"/"+testData.getResault().size());
        } else if (tmp == 2) {
            do {
                System.out.println("podaj dane(podaj 0 aby zakończyć):");
                double[] dane = new double[data.getInfo().get(0).length];
                for (int i = 0; i < data.getInfo().get(0).length; i++) {
                    dane[i] = scanner.nextDouble();
                    if(dane[0]==0)
                        return;
                }
                ;
                boolean y = perceptron.calculateY(dane);
                if (y)
                    System.out.println("resault:" + data.getvTrue());
                else
                    System.out.println("resault:" + data.getvFalse());
            }while (true);
        }
    }
}
