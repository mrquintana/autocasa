package demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.autocasa.AutocasaApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AutocasaApplication.class)
@WebAppConfiguration
public class AutocasaApplicationTests {

	@Test
	public void contextLoads() {
	}

}
