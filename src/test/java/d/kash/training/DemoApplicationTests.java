package d.kash.training;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// Connect JUnit 4 to Spring so the test can use a real application context.
@RunWith(SpringRunner.class)
// Start the application with its normal configuration, including the greeting runner.
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
		// No assertion is needed: a failure to start Spring fails this smoke test.
		// This checks startup, not the exact text printed by the greeting runner.
	}

}
