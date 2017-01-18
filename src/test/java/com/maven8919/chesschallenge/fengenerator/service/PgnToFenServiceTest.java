package com.maven8919.chesschallenge.fengenerator.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

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
	private String exampleGame = "1. d4 d5 2. Bf4 c5 3. e3 Nc6 4. c3 Nf6 5. Nd2 a6 6. Ngf3 cxd4 7. exd4 g6 8. h3 Bg7 9. Be2 O-O 10. O-O Ne8 11. Re1 Kh8 12. Bf1 f6 13. Qb3 e6 14. a4 Nd6 15. Rad1 Nf7 16. Bg3 b6 17. c4 Nh6 18. cxd5 exd5 19. Rc1 Bb7 20. Re6";
	private String FILE_NAME = "twic1157";
	
	@Test
	public void twic1157ShouldReturn3043Games() {
		assertEquals(3043, pgnToFenService.getAllGames(TWIC1157).size());
	}

	@Test
	public void twic1157NumberOfGamesLongerThan10MovesShouldBe3020() {
		List<String> allGames = pgnToFenService.getAllGames(TWIC1157);
		assertEquals(3020, pgnToFenService.getGamesLongerThan10Moves(allGames).size());
		assertThat(allGames.stream().map(String::trim).collect(Collectors.toList()).contains(exampleGame));
	}
	
	@Test
	public void writeGamesToFileShouldCreateFile() {
		List<String> allGames = pgnToFenService.getAllGames(TWIC1157);
		List<String> gamesLongerThan10Games = pgnToFenService.getGamesLongerThan10Moves(allGames);
		try {
			assertEquals(3020L, pgnToFenService.writeGamesToFile(gamesLongerThan10Games, FILE_NAME));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private File readPgnFileFromClasspath(String pgnFileName) {
		URL url = this.getClass().getResource(pgnFileName);
		return new File(url.getFile());
	}
}