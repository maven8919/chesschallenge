package com.maven8919.chesschallenge.fen.service;

import java.io.File;
import java.util.List;
import java.util.Set;

import com.maven8919.chesschallenge.fen.domain.Fen;

public interface FenImporterService {
	
	Set<Fen> getUniqueFenPositionsFromFile(File fensFile);
	void saveFen(Fen fen);
	List<Fen> getAllFens();
	boolean notInDb(Fen fen);
	
}
