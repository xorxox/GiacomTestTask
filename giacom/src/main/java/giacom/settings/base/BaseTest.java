package giacom.settings.base;

import giacom.settings.configuration.ChromeDriverBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ChromeDriverBean.class)
public abstract class BaseTest {

    protected static final Logger LOG = LogManager.getLogger(BaseTest.class);
}
