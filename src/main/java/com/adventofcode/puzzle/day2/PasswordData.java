package com.adventofcode.puzzle.day2;

import lombok.Data;

@Data
public class PasswordData {
  int min;
  int max;
  String letter;
  String password;

  public PasswordData(String[] input) {
    String[] minMax = input[0].split("-");
    this.min = Integer.parseInt(minMax[0]);
    this.max = Integer.parseInt(minMax[1]);
    this.letter = input[1].substring(0, 1);
    this.password = input[2];
  }
}
