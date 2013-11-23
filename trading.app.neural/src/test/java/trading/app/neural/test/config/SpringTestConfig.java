package trading.app.neural.test.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import trading.app.history.HistoryProvider;

@Configuration
@Profile("test")
public class SpringTestConfig {

}
