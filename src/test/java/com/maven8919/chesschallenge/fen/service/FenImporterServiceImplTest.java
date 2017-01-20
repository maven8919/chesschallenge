package com.maven8919.chesschallenge.fen.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.URL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FenImporterServiceImplTest {

	@Autowired
	private FenImporterService fenImporterService;

	private File EXAMPLE_FENS = readPgnFileFromClasspath("/exampleFens");

	@Test
	public void exampleFensShouldReturn23UniqueFens() {
		assertEquals(23, fenImporterService.getUniqueFenPositionsFromFile(EXAMPLE_FENS).size());
	}

	private File readPgnFileFromClasspath(String pgnFileName) {
		URL url = this.getClass().getResource(pgnFileName);
		return new File(url.getFile());
	}

}
