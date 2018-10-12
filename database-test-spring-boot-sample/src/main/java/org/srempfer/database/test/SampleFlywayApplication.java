package org.srempfer.database.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Sample {@link SpringBootApplication} to show how {@link FlywayTest} could be used..
 *
 * @author Stefab Rempfer
 */
@SpringBootApplication
public class SampleFlywayApplication {

    public static void main ( String [] args ) throws Exception {
        SpringApplication.run ( SampleFlywayApplication.class, args );
    }

}
