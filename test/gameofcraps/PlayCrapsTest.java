package gameofcraps;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.AllOf.allOf;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;


public class PlayCrapsTest {
    @Test
    public void playingCrapsGeneratesGameStatistics() {
        final int numberOfGames = 1;
        PlayCraps playing = new PlayCraps();

        GameStatistics statistics = playing.play(numberOfGames);

        assertNotNull(statistics);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void playingCannotStartWithNumberOfGamesLessThanOne() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("numberOfGames must be at least one");

        final int numberOfGames = -1;
        PlayCraps playing = new PlayCraps();

        playing.play(numberOfGames);
    }

    @Test
    public void playingCannotStartWithArgumentNotInteger() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Argument is not an integer");

        String[] numberOfGames = {"Not an integer"};

        PlayCraps.main(numberOfGames);
    }

    @Test
    public void tryParseStringToIntegerSuccessfulParse() {
        String numberOfGames = "100";

        int parsedOutput = PlayCraps.tryParseStringToInteger(numberOfGames);

        assertThat(parsedOutput, instanceOf(Integer.class));
    }

    @Test
    public void checkPrintedGreetingsContainsExpectedBody() {
        OutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        PlayCraps.printGreeting();

        assertThat(outputStream.toString(), allOf(
                containsString("Welcome to Craps!"),
                containsString("Enter number of games: ")));

        PrintStream originalOutput = System.out;
        System.setOut(originalOutput);
    }

    @Test
    public void checkPrintedGameStatisticsContainsExpectedBody() {
        OutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        final int numberOfGames = 1;
        PlayCraps playing = new PlayCraps();

        GameStatistics statistics = playing.play(numberOfGames);
        PlayCraps.printGameStatistics(statistics);

        assertThat(outputStream.toString(), allOf(
                containsString("Played games: "),
                containsString("Winning probability games: "),
                containsString("Rolls per game: "),
                containsString("Longest played game: "),
                containsString("Winning probability in coming roll out: "),
                containsString("Lose probability in coming roll out: ")));

        PrintStream originalOutput = System.out;
        System.setOut(originalOutput);
    }

}