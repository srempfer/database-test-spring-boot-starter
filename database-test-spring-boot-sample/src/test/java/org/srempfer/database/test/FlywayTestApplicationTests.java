package org.srempfer.database.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationInfo;
import org.flywaydb.core.api.MigrationInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.srempfer.database.test.autoconfigure.flyway.FlywayTest;

@RunWith ( SpringRunner.class )
@FlywayTest
@TestPropertySource ( properties = { "flyway.locations=db/migration/{vendor}" } )
public class FlywayTestApplicationTests {

    @Autowired
    private Flyway flyway;

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

}
