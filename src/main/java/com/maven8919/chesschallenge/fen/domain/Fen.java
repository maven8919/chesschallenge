package com.maven8919.chesschallenge.fen.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "position", "playerToMove", "castlingPossibilities",
		"enPassantTargetSquare" }))
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((castlingPossibilities == null) ? 0 : castlingPossibilities.hashCode());
		result = prime * result + ((enPassantTargetSquare == null) ? 0 : enPassantTargetSquare.hashCode());
		result = prime * result + ((playerToMove == null) ? 0 : playerToMove.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fen other = (Fen) obj;
		if (castlingPossibilities == null) {
			if (other.castlingPossibilities != null)
				return false;
		} else if (!castlingPossibilities.equals(other.castlingPossibilities))
			return false;
		if (enPassantTargetSquare == null) {
			if (other.enPassantTargetSquare != null)
				return false;
		} else if (!enPassantTargetSquare.equals(other.enPassantTargetSquare))
			return false;
		if (playerToMove == null) {
			if (other.playerToMove != null)
				return false;
		} else if (!playerToMove.equals(other.playerToMove))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}

}
