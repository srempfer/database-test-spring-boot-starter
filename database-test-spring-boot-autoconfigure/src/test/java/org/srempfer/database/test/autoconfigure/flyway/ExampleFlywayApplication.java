package org.srempfer.database.test.autoconfigure.flyway;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;


/**
 * Example {@link SpringBootApplication} used with {@link FlywayTest} tests.
 *
 * @author Stefan Rempfer
 */
@SpringBootApplication
public class ExampleFlywayApplication {

    @Bean
    public DataSource dataSource () {
        return new EmbeddedDatabaseBuilder ().generateUniqueName ( true )
            .setType ( EmbeddedDatabaseType.HSQL ).build ();
    }
}
