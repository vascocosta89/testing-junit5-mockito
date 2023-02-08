package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import org.mockito.Mock;

import java.util.Map;
@Disabled
@ExtendWith(MockitoExtension.class)
public class JUnitExtensionTest {

    @Mock
    Map<String, Object> mapMock;

    @Test
    void testMock() {
        mapMock.put("keyvalue", "foo");
    }
}
