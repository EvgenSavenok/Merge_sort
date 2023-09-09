package by.eugen;

import java.util.Random;

public class Main {
    public static void sortByMerge(int[] inputArr) {
        int arrayLength = inputArr.length;
        if (arrayLength < 2) {
            return;
        }
        int middleOfArr = arrayLength / 2;
        int[] leftSide = new int[middleOfArr];
        int[] rightSide = new int[arrayLength - middleOfArr];

        for (int i = 0; i < middleOfArr; i++) {
            leftSide[i] = inputArr[i];
        }
        for (int i = middleOfArr; i < arrayLength; i++) {
            rightSide[i - middleOfArr] = inputArr[i];
        }
        sortByMerge(leftSide);
        sortByMerge(rightSide);
        merge(inputArr, leftSide, rightSide);
    }

    public static void merge(int[] inputArr, int[] leftSide, int[] rightSide)  {
        int i = 0;
        int j = 0;
        int k = 0;
        int leftSize = leftSide.length;
        int rightSize = rightSide.length;
        while (i < leftSize && j < rightSize) {
            if (leftSide[i] <= rightSide[j]) {
                inputArr[k] = leftSide[i];
                i++;
            } else {
                inputArr[k] = rightSide[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            inputArr[k] = leftSide[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            inputArr[k] = rightSide[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] inputArr = new int[1000];
        for (int i = 0; i < inputArr.length; i++) {
            inputArr[i] = rand.nextInt(100000);
        }
        final long startTime = System.currentTimeMillis();
        sortByMerge(inputArr);
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time:" + (endTime - startTime));
        for (int i = 0; i < inputArr.length; i++) {
            System.out.println(inputArr[i]);
        }

    }
}