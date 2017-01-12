package com.maven8919.chesschallenge.fengenerator.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.URL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.maven8919.chesschallenge.fengenerator.service.impl.PgnToFenServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PgnToFenServiceTest {

	@Autowired
	private PgnToFenServiceImpl pgnToFenService;

	private File BAKOS_BALOGH_PGN = readPgnFileFromClasspath("/bakos_balogh.pgn");
	private File TWIC1157 = readPgnFileFromClasspath("/twic1157.pgn");

	@Test
	public void bakosBaloghPgnShouldReturn1game() {
		assertEquals(1, pgnToFenService.getAllGames(BAKOS_BALOGH_PGN).size());
	}

	@Test
	public void bakosTwic1157ShouldReturn3075games() {
		assertEquals(3043, pgnToFenService.getAllGames(TWIC1157).size());
	}

	private File readPgnFileFromClasspath(String pgnFileName) {
		URL url = this.getClass().getResource(pgnFileName);
		return new File(url.getFile());
	}
}
