package com.maven8919.chesschallenge.fengenerator.service;

import java.io.File;
import java.util.List;

import com.maven8919.chesschallenge.fengenerator.domain.Fen;

public interface PgnToFenService {

	List<String> getAllGames(File pgnFile);
	List<String> getGamesLongerThan10Moves(List<String> allGames);
	List<Fen> getAllFens(String game);
	
}
