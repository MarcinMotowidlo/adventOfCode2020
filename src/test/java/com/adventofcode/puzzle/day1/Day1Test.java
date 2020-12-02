package com.adventofcode.puzzle.day1;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;

@Slf4j
public class Day1Test {

  @Test
  @SneakyThrows
  public void testDay1PuzzlePart1() {
    //given:
    ClassLoader classLoader = getClass().getClassLoader();
    URL url = classLoader.getResource("day1/input.txt");
    File inputFile = new File(url.toURI());
    Day1 puzzle = new Day1();
    //when:
    int result = puzzle.part1(inputFile);
    //then:
    log.debug("Day1 pt 1 result: " + result);
  }

  @Test
  @SneakyThrows
  public void testDay1PuzzlePart2() {
    //given:
    ClassLoader classLoader = getClass().getClassLoader();
    URL url = classLoader.getResource("day1/input.txt");
    File inputFile = new File(url.toURI());
    Day1 puzzle = new Day1();
    //when:
    int result = puzzle.part2(inputFile);
    //then:
    log.debug("Day1 pt 2 result: " + result);
  }
}
