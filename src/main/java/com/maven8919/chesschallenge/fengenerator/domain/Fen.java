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

	private String rank8;
	private String rank7;
	private String rank6;
	private String rank5;
	private String rank4;
	private String rank3;
	private String rank2;
	private String rank1;
	private String playerToMove;
	private String castlingPossibilities;
	private String enPassantTargetSquare;
	private int halfMove;
	private int fullMove;

	public Fen(String rank8, String rank7, String rank6, String rank5, String rank4, String rank3, String rank2,
			String rank1, String playerToMove, String castlingPossibilities, String enPassantTargetSquare) {
		super();
		this.rank8 = rank8;
		this.rank7 = rank7;
		this.rank6 = rank6;
		this.rank5 = rank5;
		this.rank4 = rank4;
		this.rank3 = rank3;
		this.rank2 = rank2;
		this.rank1 = rank1;
		this.playerToMove = playerToMove;
		this.castlingPossibilities = castlingPossibilities;
		this.enPassantTargetSquare = enPassantTargetSquare;
		this.halfMove = 0;
		this.fullMove = 0;
	}

	public Fen(Fen otherFen) {
		this.rank8 = otherFen.getRank8();
		this.rank7 = otherFen.getRank7();
		this.rank6 = otherFen.getRank6();
		this.rank5 = otherFen.getRank5();
		this.rank4 = otherFen.getRank4();
		this.rank3 = otherFen.getRank3();
		this.rank2 = otherFen.getRank2();
		this.rank1 = otherFen.getRank1();
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

	public String getRank8() {
		return rank8;
	}

	public void setRank8(String rank8) {
		this.rank8 = rank8;
	}

	public String getRank7() {
		return rank7;
	}

	public void setRank7(String rank7) {
		this.rank7 = rank7;
	}

	public String getRank6() {
		return rank6;
	}

	public void setRank6(String rank6) {
		this.rank6 = rank6;
	}

	public String getRank5() {
		return rank5;
	}

	public void setRank5(String rank5) {
		this.rank5 = rank5;
	}

	public String getRank4() {
		return rank4;
	}

	public void setRank4(String rank4) {
		this.rank4 = rank4;
	}

	public String getRank3() {
		return rank3;
	}

	public void setRank3(String rank3) {
		this.rank3 = rank3;
	}

	public String getRank2() {
		return rank2;
	}

	public void setRank2(String rank2) {
		this.rank2 = rank2;
	}

	public String getRank1() {
		return rank1;
	}

	public void setRank1(String rank1) {
		this.rank1 = rank1;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((castlingPossibilities == null) ? 0 : castlingPossibilities.hashCode());
		result = prime * result + ((enPassantTargetSquare == null) ? 0 : enPassantTargetSquare.hashCode());
		result = prime * result + fullMove;
		result = prime * result + halfMove;
		result = prime * result + ((playerToMove == null) ? 0 : playerToMove.hashCode());
		result = prime * result + ((rank1 == null) ? 0 : rank1.hashCode());
		result = prime * result + ((rank2 == null) ? 0 : rank2.hashCode());
		result = prime * result + ((rank3 == null) ? 0 : rank3.hashCode());
		result = prime * result + ((rank4 == null) ? 0 : rank4.hashCode());
		result = prime * result + ((rank5 == null) ? 0 : rank5.hashCode());
		result = prime * result + ((rank6 == null) ? 0 : rank6.hashCode());
		result = prime * result + ((rank7 == null) ? 0 : rank7.hashCode());
		result = prime * result + ((rank8 == null) ? 0 : rank8.hashCode());
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
		if (fullMove != other.fullMove)
			return false;
		if (halfMove != other.halfMove)
			return false;
		if (playerToMove == null) {
			if (other.playerToMove != null)
				return false;
		} else if (!playerToMove.equals(other.playerToMove))
			return false;
		if (rank1 == null) {
			if (other.rank1 != null)
				return false;
		} else if (!rank1.equals(other.rank1))
			return false;
		if (rank2 == null) {
			if (other.rank2 != null)
				return false;
		} else if (!rank2.equals(other.rank2))
			return false;
		if (rank3 == null) {
			if (other.rank3 != null)
				return false;
		} else if (!rank3.equals(other.rank3))
			return false;
		if (rank4 == null) {
			if (other.rank4 != null)
				return false;
		} else if (!rank4.equals(other.rank4))
			return false;
		if (rank5 == null) {
			if (other.rank5 != null)
				return false;
		} else if (!rank5.equals(other.rank5))
			return false;
		if (rank6 == null) {
			if (other.rank6 != null)
				return false;
		} else if (!rank6.equals(other.rank6))
			return false;
		if (rank7 == null) {
			if (other.rank7 != null)
				return false;
		} else if (!rank7.equals(other.rank7))
			return false;
		if (rank8 == null) {
			if (other.rank8 != null)
				return false;
		} else if (!rank8.equals(other.rank8))
			return false;
		return true;
	}

}
