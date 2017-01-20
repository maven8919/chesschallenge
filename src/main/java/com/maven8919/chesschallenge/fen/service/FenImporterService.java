package com.maven8919.chesschallenge.fen.service;

import java.io.File;
import java.util.Set;

import com.maven8919.chesschallenge.fen.domain.Fen;

public interface FenImporterService {
	
	Set<Fen> getUniqueFenPositionsFromFile(File fensFile);
	
}
