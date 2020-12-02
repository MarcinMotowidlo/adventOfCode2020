package com.adventofcode.puzzle.day2;

import com.adventofcode.puzzle.day1.Day1;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;

@Slf4j
public class Day2Test {

  @Test
  @SneakyThrows
  public void testDay1PuzzlePart1() {
    //given:
    ClassLoader classLoader = getClass().getClassLoader();
    URL url = classLoader.getResource("day2/input.txt");
    File inputFile = new File(url.toURI());
    Day2 puzzle = new Day2();
    //when:
    Pair<Integer, Integer> result = puzzle.part1(inputFile);
    //then:
    log.debug("Day2 resuls: " + result);
  }

}
