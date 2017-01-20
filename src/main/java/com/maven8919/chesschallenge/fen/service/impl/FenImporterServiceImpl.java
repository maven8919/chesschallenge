package com.maven8919.chesschallenge.fen.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.maven8919.chesschallenge.fen.domain.Fen;
import com.maven8919.chesschallenge.fen.service.FenImporterService;

@Service
public class FenImporterServiceImpl implements FenImporterService {

	@Override
	public Set<Fen> getUniqueFenPositionsFromFile(File fensFile) {
		Set<Fen> result = Collections.emptySet();
		try (Stream<String> lines = Files.lines(Paths.get(fensFile.getAbsolutePath()))) {
			result = lines
						.map(position -> createFen(position))
						.collect(Collectors.toSet());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	private Fen createFen(String position) {
		String[] splittedPosition = position.split(" ");
		return new Fen(splittedPosition[0], splittedPosition[1], splittedPosition[2], splittedPosition[3]);
	}

}
