package com.maven8919.chesschallenge.fen.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven8919.chesschallenge.fen.domain.Fen;
import com.maven8919.chesschallenge.fen.repository.FenRepository;
import com.maven8919.chesschallenge.fen.service.FenImporterService;

@Service
public class FenImporterServiceImpl implements FenImporterService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FenImporterServiceImpl.class);

	@Autowired
	private FenRepository fenRepository;

	@Override
	public Set<Fen> getUniqueFenPositionsFromFile(File fensFile) {
		Set<Fen> result = Collections.emptySet();
		LOGGER.info("Getting fens from {}", fensFile.getName());
		try (Stream<String> lines = Files.lines(Paths.get(fensFile.getAbsolutePath()))) {
			result = lines.map(position -> createFen(position)).collect(Collectors.toSet());
		} catch (IOException e) {
			e.printStackTrace();
		}
		LOGGER.info("Returning {} unique fens", result.size());
		return result;
	}

	private Fen createFen(String position) {
		String[] splittedPosition = position.split(" ");
		return new Fen(splittedPosition[0], splittedPosition[1], splittedPosition[2], splittedPosition[3]);
	}

	@Override
	public void saveFen(Fen fen) {
		LOGGER.info("Saving {}", fen.toString());
		fenRepository.save(fen);
	}

	@Override
	public List<Fen> getAllFens() {
		LOGGER.info("Returning fens from getAllFens");
		return StreamSupport.stream(fenRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public boolean notInDb(Fen fen) {
		return fenRepository
				.findByPositionAndPlayerToMoveAndCastlingPossibilitiesAndEnPassantTargetSquare(fen.getPosition(),
						fen.getPlayerToMove(), fen.getCastlingPossibilities(), fen.getEnPassantTargetSquare())
				.size() == 0;
	}

}
