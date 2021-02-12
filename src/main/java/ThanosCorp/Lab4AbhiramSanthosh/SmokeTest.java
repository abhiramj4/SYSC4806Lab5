package ThanosCorp.Lab4AbhiramSanthosh;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private AddressBookController controller;

    public void contextLoads() throws Exception{
        assertThat(controller).isNotNull();
    }
}
