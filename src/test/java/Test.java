import org.example.Main;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test {

    @org.junit.jupiter.api.Test
    public void testHelloWorld() {
//        String message = "Hello, World!";
//        assertEquals("Hello, World!", message);
        assertEquals(3, Main.add(1,2));
    }
}
