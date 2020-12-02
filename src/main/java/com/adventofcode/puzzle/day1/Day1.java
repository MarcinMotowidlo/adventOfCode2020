package com.adventofcode.puzzle.day1;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.math.util.MathUtils;

import java.io.File;
import java.util.Scanner;
import java.util.Vector;

@Slf4j
public class Day1 {

  private static final int EXPECTED_SUM = 2020;

  @SneakyThrows
  public int part1(File file) {
    Vector<Integer> loadedData = new Vector<>();
    Integer result = null;

    Scanner scanner = new Scanner(file);
    while (scanner.hasNextLine() && result == null) {
      int currentElement = Integer.parseInt(scanner.nextLine());
      result = calculateForCurrentElement(loadedData, currentElement);
      if (null == result) {
        loadedData.add(currentElement);
      }
    }
    scanner.close();
    return result;
  }

  @SneakyThrows
  public int part2(File file) {
    Vector<Integer> data = new Vector<>();
    Integer result = null;

    Scanner scanner = new Scanner(file);
    while (scanner.hasNextLine() && result == null) {
      int currentElement = Integer.parseInt(scanner.nextLine());
      data.add(currentElement);
    }
    scanner.close();
    return findTripple(data);

  }

  private int findTripple(Vector<Integer> data) {
    Vector<Pair<Integer, Integer>> pairs = new Vector<>();
    for (int firstElement : data) {
      for (int secondElement : data) {
        if (firstElement + secondElement < EXPECTED_SUM) {
          pairs.add(new ImmutablePair<>(firstElement, secondElement));
        }
      }
    }
    for (int thirdElement : data) {
      for (Pair<Integer, Integer> pair : pairs) {

        if ((thirdElement + pair.getLeft() + pair.getRight()) == EXPECTED_SUM) {
          log.debug("Triple: " + thirdElement + " | " + pair.getLeft() + " | " + pair.getRight());
          return thirdElement * pair.getLeft() * pair.getRight();
        }
      }
    }
    throw new IllegalStateException("not found");
  }

  private Integer calculateForCurrentElement(Vector<Integer> vector, int element) {
    for (Integer vectorElement : vector) {
      if (EXPECTED_SUM == vectorElement + element) {
        log.debug("Pair: " + vectorElement + " | " + element);
        return MathUtils.mulAndCheck(vectorElement, element);
      }
    }
    return null;
  }
}
