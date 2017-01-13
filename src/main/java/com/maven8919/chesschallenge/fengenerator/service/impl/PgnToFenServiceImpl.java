package com.maven8919.chesschallenge.fengenerator.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.maven8919.chesschallenge.fengenerator.domain.Fen;
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
	private static final int LENGTH_OF_1_DOT_SPACE = 3;
	private static final String MOVE_SPLIT_REGEX = "\\s\\d+\\.\\s";
	private static final Fen STARTING_FEN_POSITION = new Fen("rnbqkbnr", "pppppppp", "8", "8", "8", "8", "PPPPPPPP", "RNBQKBNR", 
			"w", "KQkq", "-");

	@Override
	public List<String> getAllGames(File pgnFile) {
		logger.info("Start getting games from pgn: " + pgnFile.getName());
		List<String> result = new ArrayList<>();
		try (Stream<String> lines = Files.lines(Paths.get(pgnFile.getAbsolutePath()))) {
			String[] filteredLines = lines
					.filter(line -> !line.startsWith(STARTING_BRACKET) && line.length() > 0 && line != CONTUMATED_GAME_SEPARATOR)
					.map(line -> line + SPACE)
					.collect(Collectors.joining(EMPTY_STRING)).split(ALL_POSSIBLE_RESULTS);
			result = Arrays.asList(filteredLines).stream().filter(line -> line.length() > 1)
					.map(line -> line.replaceAll(ALL_POSSIBLE_RESULTS, EMPTY_STRING))
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("getAllGames returns: " + result.size() + " games");
		return result;
	}

	@Override
	public List<String> getGamesLongerThan10Moves(List<String> allGames) {
		return allGames.stream().filter(game -> game.contains(TENTH_MOVE_STRING)).collect(Collectors.toList());
	}

	@Override
	public List<Fen> getAllFens(String game) {
		List<Fen> result = new ArrayList<>();
		result.add(STARTING_FEN_POSITION);
		List<String> pairOfMoves = getPairOfMoves(game);
		pairOfMoves.stream()
			.forEach(pair -> {
				result.add(createFenPosition(getLastFen(result), pair.split(" ")[0]));
				if (pairMoveHasBlackMove(pair)) {
					result.add(createFenPosition(getLastFen(result), pair.split(" ")[1]));					
				}
			});
		return result.size() >= 19 ? result.subList(19, result.size()) : Collections.<Fen>emptyList();
	}

	private boolean pairMoveHasBlackMove(String pair) {
		return pair.split(" ").length == 2;
	}

	private Fen createFenPosition(Fen previousFen, String move) {
		Fen result = new Fen(previousFen);
		return result;
	}

	private List<String> getPairOfMoves(String game) {
		String gameWOFirstMovenindicator = game.substring(LENGTH_OF_1_DOT_SPACE);
		return Arrays.asList(gameWOFirstMovenindicator.split(MOVE_SPLIT_REGEX));
	}
	
	private Fen getLastFen(List<Fen> fens) {
		return fens.get(fens.size() - 1);
	}

}
