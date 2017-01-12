package com.maven8919.chesschallenge.fengenerator.service;

import java.io.File;
import java.util.List;

public interface PgnToFenService {

	List<String> getAllGames(File pgnFile);
	
}
