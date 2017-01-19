package com.maven8919.chesschallenge.fengenerator.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface PgnToFenService {

	List<String> getAllGames(File pgnFile);
	List<String> getGamesLongerThan10Moves(List<String> allGames);
	long writeGamesToFile(List<String> games, String filename) throws IOException;
	List<String> getFensFromGame(String game);
	
	
}
