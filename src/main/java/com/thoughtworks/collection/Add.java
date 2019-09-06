package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder)
    {
        IntStream intStream = (leftBorder < rightBorder) ? IntStream.rangeClosed(leftBorder, rightBorder) : IntStream.rangeClosed(rightBorder, leftBorder);
        return intStream.filter(it -> it % 2 == 0).sum();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        IntStream intStream = (leftBorder < rightBorder) ? IntStream.rangeClosed(leftBorder, rightBorder) : IntStream.rangeClosed(rightBorder, leftBorder);
        return intStream.filter(it -> it % 2 == 1).sum();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().mapToInt(it -> it*3+2).sum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().mapToInt(Integer::intValue).mapToObj(it -> (it % 2 == 1) ? it*3+2 : it).collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().mapToInt(it -> (it % 2 == 1) ? it*3+5 : 0).sum();
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> even = arrayList.stream().filter(it -> it % 2 == 0).sorted().collect(Collectors.toList());
        return (even.get((int)Math.floor((even.size()-1) / 2.0)) + even.get((int)Math.ceil((even.size()-1) / 2.0))) / 2.0;
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return  arrayList.stream().mapToDouble(Integer::intValue).filter(it -> it % 2 == 0).average().orElse(0.0);
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream().filter(it -> it % 2 == 0).collect(Collectors.toList()).contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(it -> it % 2 == 0).distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> even = arrayList.stream().filter(it -> it % 2 == 0).sorted().collect(Collectors.toList());
        List<Integer> odd = arrayList.stream().filter(it -> it % 2 == 1).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        even.addAll(odd);
        return even;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        return IntStream.range(1, arrayList.size()).mapToObj(i -> (arrayList.get(i) + arrayList.get(i-1)) *3).collect(Collectors.toList());
    }
}
