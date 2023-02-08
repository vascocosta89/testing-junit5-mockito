package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InlineMockTest {

    @Test
    void testInlineMock() {
        Map mapMock = mock(Map.class);

        assertEquals(mapMock.size(), 0);
    }
}