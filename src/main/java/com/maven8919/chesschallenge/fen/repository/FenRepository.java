package com.maven8919.chesschallenge.fen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maven8919.chesschallenge.fen.domain.Fen;

public interface FenRepository extends JpaRepository<Fen, Long> {
	
	List<Fen> findByPositionAndPlayerToMoveAndCastlingPossibilitiesAndEnPassantTargetSquare(String position, String playerToMove, String castlingPossibilities, String enPassantTargetSquare);
	
}
