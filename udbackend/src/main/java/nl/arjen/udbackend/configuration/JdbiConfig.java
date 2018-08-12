package nl.arjen.udbackend.configuration;

import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by arjen on 8/12/18.
 */
@Configuration
public class JdbiConfig {

    @Value("${db.user}")
    private String user;

    @Value("${db.password}")
    private String pass;

    @Value("${db.jdbc}")
    private String jdbc;

    @Bean
    public Jdbi creatJdbiBean() {
        return Jdbi.create(jdbc, user, pass);
    }
}
