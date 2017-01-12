package com.maven8919.chesschallenge.fengenerator.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.maven8919.chesschallenge.fengenerator.service.PgnToFenService;

@Service
public class PgnToFenServiceImpl implements PgnToFenService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<String> getAllGames(File pgnFile) {
		logger.info("Start getting games from pgn: " + pgnFile.getName());
		List<String> result = new ArrayList<>();
		try (Stream<String> lines = Files.lines(Paths.get(pgnFile.getAbsolutePath()))) {
			String[] filteredLines = lines
					.filter(line -> !line.startsWith("[") && line.length() > 0 && line != "+/- +/-")
					.map(line -> line.replaceAll("\\s", "")).collect(Collectors.joining("")).split("1-0|1/2-1/2|0-1");
			result = Arrays.asList(filteredLines).stream().filter(line -> line.length() > 0)
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<String> getGamesLongerThan10Moves(List<String> allGames) {
		return allGames.stream().filter(game -> game.contains("10.")).collect(Collectors.toList());
	}

}
