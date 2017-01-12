package com.maven8919.chesschallenge.fengenerator.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.URL;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PgnToFenServiceTest {

	@Autowired
	private PgnToFenService pgnToFenService;

	private File TWIC1157 = readPgnFileFromClasspath("/twic1157.pgn");

	@Test
	public void twic1157ShouldReturn3043Games() {
		assertEquals(3043, pgnToFenService.getAllGames(TWIC1157).size());
	}
	
	@Test
	public void twic1157NumberOfGamesLongerThan10MovesShouldBe3020() {
		List<String> allGames = pgnToFenService.getAllGames(TWIC1157);
		assertEquals(3020, pgnToFenService.getGamesLongerThan10Moves(allGames).size());
	}

	private File readPgnFileFromClasspath(String pgnFileName) {
		URL url = this.getClass().getResource(pgnFileName);
		return new File(url.getFile());
	}
}
