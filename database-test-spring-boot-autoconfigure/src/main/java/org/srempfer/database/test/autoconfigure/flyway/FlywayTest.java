package org.srempfer.database.test.autoconfigure.flyway;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.OverrideAutoConfiguration;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.filter.TypeExcludeFilters;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.test.context.BootstrapWith;
import org.springframework.transaction.annotation.Transactional;


/**
 * Annotation that can be used in combination with {@code @RunWith(SpringRunner.class)} for a typical Flyway based test.<br>
 * Using this annotation will disable full auto-configuration and instead apply only configuration relevant to Flyway based tests.
 *
 * @author Stefan Rempfer
 */
@Target ( ElementType.TYPE )
@Retention ( RetentionPolicy.RUNTIME )
@Documented
@Inherited
@BootstrapWith ( SpringBootTestContextBootstrapper.class )
@OverrideAutoConfiguration ( enabled = false )
@TypeExcludeFilters ( FlywayTypeExcludeFilter.class )
@Transactional
@AutoConfigureCache
@AutoConfigureFlyway
@ImportAutoConfiguration
public @interface FlywayTest {

    /**
     * Determines if default filtering should be used with {@link SpringBootApplication @SpringBootApplication}. By default no beans are included.
     * 
     * @see #includeFilters()
     * @see #excludeFilters()
     * @return if default filters should be used
     */
    boolean useDefaultFilters () default true;

    /**
     * A set of include filters which can be used to add otherwise filtered beans to the application context.
     * 
     * @return include filters to apply
     */
    Filter [] includeFilters () default {};

    /**
     * A set of exclude filters which can be used to filter beans that would otherwise be added to the application context.
     * 
     * @return exclude filters to apply
     */
    Filter [] excludeFilters () default {};

}
