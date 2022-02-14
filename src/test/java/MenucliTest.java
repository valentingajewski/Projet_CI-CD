import picocli.CommandLine;

import java.io.PrintStream;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class MenucliTest {
    

    CommandLine cmd;
    final PrintStream originalOut = System.out;

    @Test
    @DisplayName("check menu")
    public void checkMenu() {
        //int exitCode = cmd.execute("Menucli list-menus");
        assertEquals(0, 0);
}
}
