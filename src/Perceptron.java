import java.util.Random;

public class Perceptron {

    private double learningFactor = 0.5;
    private double weight[];
    private double deviation = 0;
    private int errorIteration=0;

    public void teach(Data data) {
        randWeight(data.getInfo().size());
        for (int i = 0; i < data.getInfo().size(); i++) {
            boolean y = calculateY(data.getInfo().get(i));
            if(y){
                updateWeights(1,data.getResaultInt().get(i),data.getInfo().get(i));
                updateDeviation(1,data.getResaultInt().get(i));
            }else {
                updateWeights(0,data.getResaultInt().get(i),data.getInfo().get(i));
                updateDeviation(0,data.getResaultInt().get(i));
            }
        }
    }

    private void updateDeviation(int y,int resault) {
        deviation=deviation-learningFactor*(resault-y);
        if(resault-y!=0)
            errorIteration++;
    }

    public void updateWeights(int y,int resault,double[] vector){
        for(int i=0;i<vector.length;i++){
            weight[i]=weight[i]+learningFactor*(resault-y)*vector[i];
        }
    }

    public boolean calculateY(double[] vector) {
        double net = 0;
        for (int i = 0; i < vector.length; i++) {
            net += getWeight()[i] * vector[i];
        }
        net -= deviation;
        if (net >= 0)
            return true;
        else
            return false;
    }

        public void randWeight(int count) {
            weight = new double[count];
            for (int i = 0; i < count; i++) {
                weight[i] = Math.random() * 1;
            }
        }

    public double[] getWeight() {
        return weight;
    }

    public void setWeight(double[] weight) {
        this.weight = weight;
    }

    public double getDeviation() {
        return deviation;
    }

    public void setDeviation(double deviation) {
        this.deviation = deviation;
    }

    public double getLearningFactor() {
        return learningFactor;
    }

    public void setLearningFactor(double learningFactor) {
        this.learningFactor = learningFactor;
    }
}
