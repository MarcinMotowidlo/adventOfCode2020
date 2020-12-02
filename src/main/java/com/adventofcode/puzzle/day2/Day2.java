package com.adventofcode.puzzle.day2;

import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.io.File;
import java.util.Scanner;

public class Day2 {

  @SneakyThrows
  public Pair<Integer, Integer> part1(File file) {
    Scanner scanner = new Scanner(file);
    int countPt1 = 0;
    int countPt2 = 0;
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      String[] inputData = line.split(" ");
      PasswordData passwordData = new PasswordData(inputData);
      if (isPasswordCorrectPt1(passwordData)) {
        countPt1++;
      }
      if (isPasswordCorrectPt2(passwordData)) {
        countPt2++;
      }
    }
    return new ImmutablePair<>(countPt1, countPt2);
  }

  private boolean isPasswordCorrectPt1(PasswordData passwordData) {
    int count = StringUtils.countMatches(passwordData.getPassword(), passwordData.getLetter());
    return count >= passwordData.getMin() && count <= passwordData.getMax();
  }

  private boolean isPasswordCorrectPt2(PasswordData passwordData) {
    String minChar = passwordData.getPassword().substring(passwordData.getMin() -1, passwordData.getMin());
    String maxChar = passwordData.getPassword().substring(passwordData.getMax() -1, passwordData.getMax());

    return 0 == StringUtils.compare(minChar, passwordData.getLetter()) ^
        0 == StringUtils.compare(maxChar, passwordData.getLetter());
  }
}
