package com.maven8919.chesschallenge.fengenerator.service.impl;

import java.io.BufferedWriter;
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

	private static final String STARTING_BRACKET = "[";
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private static final String CONTUMATED_GAME_SEPARATOR = "+/- +/-";
	private static final String SPACE = " ";
	private static final String EMPTY_STRING = "";
	private static final String ALL_POSSIBLE_RESULTS = "1-0|1/2-1/2|0-1";
	private static final String TENTH_MOVE_STRING = "10.";

	@Override
	public List<String> getAllGames(File pgnFile) {
		logger.info("Start getting games from pgn: " + pgnFile.getName());
		List<String> result = new ArrayList<>();
		try (Stream<String> lines = Files.lines(Paths.get(pgnFile.getAbsolutePath()))) {
			String[] filteredLines = lines
					.filter(line -> !line.startsWith(STARTING_BRACKET) && line.length() > 0
							&& line != CONTUMATED_GAME_SEPARATOR)
					.map(line -> line + SPACE).collect(Collectors.joining(EMPTY_STRING)).split(ALL_POSSIBLE_RESULTS);
			result = Arrays.asList(filteredLines).stream().filter(line -> line.length() > 1)
					.map(line -> line.replaceAll(ALL_POSSIBLE_RESULTS, EMPTY_STRING).trim()).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("getAllGames returns: " + result.size() + " games");
		return result;
	}

	@Override
	public List<String> getGamesLongerThan10Moves(List<String> allGames) {
		logger.info("Removing games that are less than 10 moves long.");
		return allGames.stream().filter(game -> game.contains(TENTH_MOVE_STRING)).collect(Collectors.toList());
	}

	@Override
	public long writeGamesToFile(List<String> games, String filename) throws IOException {
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename))) {
			writer.write(games.stream().collect(Collectors.joining("\n", "", "")));
		}
		return Files.lines(Paths.get(filename)).count();
	}

}
