package weka.attributeSelection;

/**
 *
 * @author Data Science & Big Data Lab, Pablo de Olavide University
 *
 * Parallel Coronavirus Optimization Algorithm
 * Version 2.5 
 * Academic version for a binary codification
 *
 * March 2020
 *
 */

public class Individual implements Comparable<Individual> {

    protected int[] data;
    protected double fitness;

    public Individual(int[] data) {
        super();
        this.data = data;
    }

    public Individual() {
        super();
        this.fitness = Double.MIN_VALUE;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    @Override
    public int compareTo(Individual o) {
        if (fitness > o.getFitness()) {
            return 1;
        } else if (fitness == o.getFitness()) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public boolean equals(Object obj) {
        Individual indiv = (Individual) obj;
        int i = 0, diff = 0;

        while (diff == 0 && i < data.length) {
            diff = data[i] - indiv.data[i];
            i++;
        }

        return diff == 0;
    }

    @Override
    public String toString() {
        String res = "";
        int i;
        if (data != null) {
            res = "[" + data[0];
            for (i = 1; i < data.length; i++) {
                res += "," + data[i];
            }

            res += "]";
        }
        res+=" -- F = " + this.fitness;
        return res;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

}
