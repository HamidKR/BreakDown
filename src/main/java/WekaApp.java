import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.evaluation.RegressionAnalysis;
import weka.classifiers.functions.LinearRegression;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.lazy.IBk;
import weka.classifiers.pmml.consumer.Regression;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.RandomForest;
import weka.classifiers.trees.RandomTree;
import weka.core.Instance;
import weka.core.Instances;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * Created by Hamid on 3/15/17.
 */
public class WekaApp
{

    public static void main(String [ ] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader("/Users/Hamid/Documents/MachineLearning/ABX3Data12.arff"));
        Instances data = new Instances(reader);
        reader.close();
        for(int i=0; i<=5; i++)
        {data.deleteAttributeAt(0);}
        for(int i=3; i<12; i++)
        {data.deleteAttributeAt(3);}
        Instances train = data.trainCV(3,1);
        Instances test = data.testCV(3,1);
        // setting class attribute
        train.setClassIndex(1);
        test.setClassIndex(1);
        Classifier cls = new MultilayerPerceptron();
        cls.buildClassifier(train);
        // evaluate classifier and print some statistics
        Evaluation eval = new Evaluation(train);
        eval.evaluateModel(cls, test);
        System.out.println(eval.toSummaryString("\nResults\n======\n", false));
    }

}