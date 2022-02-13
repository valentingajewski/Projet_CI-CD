import picocli.CommandLine;

import java.io.PrintStream;
import org.junit.jupiter.api.*;
import org.testng.ITest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class MenucliTest {
    

    CommandLine cmd;
    final PrintStream originalOut = System.out;

    @Test
    @DisplayName("check menu")
    public void checkMenu() {
        int exitCode = cmd.execute("checksum");
        assertEquals(0, exitCode);
}

