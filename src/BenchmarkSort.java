import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
class BenchmarkSorts {
    private SortInsertion insertionSort = new SortInsertion();
    private Random random = new Random();

    private int[] dataSize;
    private int numOfDataSets = 50;

    private double[] iterativeCountData = new double[numOfDataSets];
    private double[] iterativeTimeData = new double[numOfDataSets];
    private double[] recursiveCountData = new double[numOfDataSets];
    private double[] recursiveTimeData = new double[numOfDataSets];

    private double[] averageIterativeCount;
    private double[] coefficientIterativeCount;
    private double[] averageIterativeTime;
    private double[] coefficientIterativeTime;

    private double[] averageRecursiveCount;
    private double[] coefficientRecursiveCount;
    private double[] averageRecursiveTime;
    private double[] coefficientRecursiveTime;

    /*
     sizes array of list sizes to be sorted
     */
    BenchmarkSorts(int[] sizes) {
        dataSize = sizes;
        averageIterativeCount = new double[sizes.length];
        averageRecursiveCount = new double[sizes.length];
        coefficientIterativeCount = new double[sizes.length];
        coefficientRecursiveCount = new double[sizes.length];
        averageIterativeTime = new double[sizes.length];
        averageRecursiveTime = new double[sizes.length];
        coefficientIterativeTime = new double[sizes.length];
        coefficientRecursiveTime = new double[sizes.length];
    }

    /*
     Exception is thrown if return list in not sorted
     */
    void runSorts() throws ExceptionSort {

        for (int i = 0; i < dataSize.length; i++) {
            int[] iterativeData = new int[dataSize[i]];
            int[] recursiveData = new int[dataSize[i]];
            for (int setNum = 0; setNum < numOfDataSets; setNum++) {
                for (int j = 0; j < dataSize[i]; j++) {
                    int r = random.nextInt(dataSize[i] + 1);
                    iterativeData[j] = r;
                    recursiveData[j] = r;
                }

                insertionSort.sortIterative(iterativeData);
                iterativeCountData[setNum] = insertionSort.getCount();
                iterativeTimeData[setNum] = insertionSort.getTime();

                insertionSort.sortRecursive(recursiveData);
                recursiveCountData[setNum] = insertionSort.getCount();
                recursiveTimeData[setNum] = insertionSort.getTime();
            }

            averageIterativeCount[i] = getMean(iterativeCountData);
            coefficientIterativeCount[i] = getCoefficientOfVariance(iterativeCountData);
            averageIterativeTime[i] = getMean(iterativeTimeData);
            coefficientIterativeTime[i] = getCoefficientOfVariance(iterativeTimeData);

            averageRecursiveCount[i] = getMean(recursiveCountData);
            coefficientRecursiveCount[i] = getCoefficientOfVariance(recursiveCountData);
            averageRecursiveTime[i] = getMean(recursiveTimeData);
            coefficientRecursiveTime[i] = getCoefficientOfVariance(recursiveTimeData);
        }
    }

    /* Mean of the data */
    private double getMean(double[] data) {
        double sum = 0;
        for (double aData : data) {
            sum += aData;
        }
        return sum / data.length;
    }

    /*
      Gets StandardDeviation of the data    
     */
    private double getStandardDeviation(double[] data) {
        double sum = 0;
        for (double aData : data) {
            sum += (aData - getMean(data)) * (aData - getMean(data));
        }
        return Math.sqrt(sum / (data.length - 1));
    }

    /*
      Gets CoefficientOfVariance of data
    
     */
    private double getCoefficientOfVariance(double[] data) {
        return ((getStandardDeviation(data)) / getMean(data)) * 100;
    }

    /**
     * Displays the benchmark data in the console
     */
    void displayReport() {
        System.out.format("%170s", "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.format("%1s %11s %48s %39s %45s %33s", "|", "|", " Iterative"," |", "\t  Recursive","|");
        System.out.println();
        System.out.format("%1s %11s %160s", "|", "|", "---------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------|");
        System.out.println();
        System.out.format("%1s %4s %20s %18s %18s %23s %5s %19s %22s %16s %22s %3s", "|", "Data Size |", "Average Critical", "Coefficient of", "Average", "Coefficient of", "|","Average Critical", "Coefficient of", "Average", "Coefficient of", "|");
        System.out.println();
        System.out.format("%1s %11s %18s %20s %20s %22s %4s %18s %24s %18s %20s %2s", "|", "|", "Operation Count", "Variance of Count", "Execution Time", "Variance of Time", "|","Operation Count", "Variance of Count", "Execution Time", "Variance of Time", "|");
        System.out.println();
        System.out.println("|-----------|----------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------|");

        try {
        BufferedWriter bw = new BufferedWriter(new FileWriter("d:\\davidSort.txt"));
        for (int i = 0; i < dataSize.length; i++) {
            System.out.format("%1s %6s %4s %15s %25s %15s %25s %4s %15s %26s %14s %25s %2s","|", dataSize[i], "|", averageIterativeCount[i], coefficientIterativeCount[i], averageIterativeTime[i], coefficientIterativeTime[i], "|", averageRecursiveCount[i], coefficientRecursiveCount[i], averageRecursiveTime[i], coefficientRecursiveTime[i], "|");
            System.out.println();
            bw.write(Integer.toString(dataSize[i])); bw.write(",");
            bw.write(Double.toString(averageIterativeCount[i])); bw.write(",");
            bw.write( Double.toString(coefficientIterativeCount[i])); bw.write(",");
            bw.write( Double.toString(averageIterativeTime[i])); bw.write(",");
            bw.write(Double.toString(coefficientIterativeTime[i])); bw.write(",");
            bw.write(Double.toString(averageRecursiveCount[i])); bw.write(",");
            bw.write(Double.toString(coefficientRecursiveCount[i])); bw.write(",");
            bw.write(Double.toString(averageRecursiveTime[i])); bw.write(",");
            bw.write(Double.toString(coefficientRecursiveTime[i])); 
            bw.newLine();
                        
        }
        bw.flush();
        System.out.format("%170s", "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"); 
        } catch (IOException e) {}
        DrawTable();
    }
    void DrawTable() {
    	DrawTable dt = new DrawTable();
        dt.main();
    }
}
