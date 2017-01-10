package com.maven8919.chesschallenge.fengenerator.service;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.net.URL;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PgnToFenServiceTest {

	@Autowired
	private PgnToFenService pgnToFenService;

	private File BAKOS_BALOGH_PGN = null;
	
	@Before
	public void setup() {
		URL url = this.getClass().getResource("/bakos_balogh.pgn");
		BAKOS_BALOGH_PGN = new File(url.getFile());
	}

	@Test
	public void bakosBaloghPgnShouldReturn66Fens() {
		assertEquals(66, pgnToFenService.getAllFens(BAKOS_BALOGH_PGN));
	}
}
