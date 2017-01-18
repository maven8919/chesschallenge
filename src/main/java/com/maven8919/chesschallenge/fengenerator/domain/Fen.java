package com.maven8919.chesschallenge.fengenerator.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String position;
	private String playerToMove;
	private String castlingPossibilities;
	private String enPassantTargetSquare;
	private int halfMove;
	private int fullMove;

	public Fen(String position, String playerToMove, String castlingPossibilities, String enPassantTargetSquare) {
		super();
		this.position = position;
		this.playerToMove = playerToMove;
		this.castlingPossibilities = castlingPossibilities;
		this.enPassantTargetSquare = enPassantTargetSquare;
		this.halfMove = 0;
		this.fullMove = 0;
	}

	public Fen(Fen otherFen) {
		this.position = otherFen.getPosition();
		this.playerToMove = otherFen.getPlayerToMove();
		this.castlingPossibilities = otherFen.getCastlingPossibilities();
		this.enPassantTargetSquare = otherFen.getEnPassantTargetSquare();
		this.halfMove += 1;
		this.fullMove = 0;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlayerToMove() {
		return playerToMove;
	}

	public void setPlayerToMove(String playerToMove) {
		this.playerToMove = playerToMove;
	}

	public String getCastlingPossibilities() {
		return castlingPossibilities;
	}

	public void setCastlingPossibilities(String castlingPossibilities) {
		this.castlingPossibilities = castlingPossibilities;
	}

	public String getEnPassantTargetSquare() {
		return enPassantTargetSquare;
	}

	public void setEnPassantTargetSquare(String enPassantTargetSquare) {
		this.enPassantTargetSquare = enPassantTargetSquare;
	}

	public int getHalfMove() {
		return halfMove;
	}

	public void setHalfMove(int halfMove) {
		this.halfMove = halfMove;
	}

	public int getFullMove() {
		return fullMove;
	}

	public void setFullMove(int fullMove) {
		this.fullMove = fullMove;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getNthRankPosition(int targetRank) {
		return position.split("/")[targetRank - 1];
	}

}
