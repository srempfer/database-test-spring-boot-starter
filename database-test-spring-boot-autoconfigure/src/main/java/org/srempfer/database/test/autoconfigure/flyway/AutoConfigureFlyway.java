package org.srempfer.database.test.autoconfigure.flyway;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;


/**
 * {@link ImportAutoConfiguration Auto-configuration imports} for Flyway based tests.<br>
 * Most tests should consider using {@link FlywayTest @FlywayTest} rather than using this annotation directly.
 *
 * @author Stefan Rempfer
 * @see FlywayTest
 */
@Target ( ElementType.TYPE )
@Retention ( RetentionPolicy.RUNTIME )
@Documented
@Inherited
@ImportAutoConfiguration
public @interface AutoConfigureFlyway {

}
