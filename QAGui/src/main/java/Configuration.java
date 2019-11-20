import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Configuration {
    private static final Config CONFIG = ConfigFactory.load("config.conf");
    private static final String ENVIRONMENT = CONFIG.getString("environment");
    private static final Config ENV = CONFIG.getConfig("environments").getConfig(ENVIRONMENT);

    private static final String BROWSER = CONFIG.getString("browser");
    private static final String MACHINE = CONFIG.getString("machine");

    private static final String BASE_URL = ENV.getString("baseUrl");
    private static final String LOGIN = ENV.getString("login");
    private static final String PASSWORD = ENV.getString("password");

}
