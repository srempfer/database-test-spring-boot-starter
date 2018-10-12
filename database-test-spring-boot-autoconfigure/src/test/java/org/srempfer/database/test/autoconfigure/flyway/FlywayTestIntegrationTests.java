package org.srempfer.database.test.autoconfigure.flyway;

import static org.assertj.core.api.Assertions.assertThat;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationInfo;
import org.flywaydb.core.api.MigrationInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith ( SpringRunner.class )
@FlywayTest
@AutoConfigureTestDatabase
@TestPropertySource ( properties = { "flyway.locations=db/migration/{vendor}" } )
public class FlywayTestIntegrationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private Flyway flyway;

    @Test
    public void contextLoads () {
    }

    @Test
    public void validateThatMigrationWasDone() {
        MigrationInfoService info = flyway.info ();

        MigrationInfo [] all = info.all ();
        assertThat ( all ).as ( "Migrations should be available!" ).hasSize ( 1 );

        MigrationInfo [] pending = info.pending ();
        assertThat ( pending ).as ( "No pending migrations must be exists!" ).hasSize ( 0 );

        MigrationInfo [] applied = info.applied ();
        assertThat ( applied ).as ( "All available migrations should be applied!" ).containsOnly ( all );

        flyway.validate ();
    }

    @Test
    public void replacesDefinedDataSourceWithEmbeddedDefault () throws Exception {
        String product = this.dataSource.getConnection ().getMetaData ().getDatabaseProductName ();
        assertThat ( product ).isEqualTo ( "H2" );
    }

    @Test ( expected = NoSuchBeanDefinitionException.class )
    public void didNotInjectExampleComponent () {
        this.applicationContext.getBean ( ExampleComponent.class );
    }

}
