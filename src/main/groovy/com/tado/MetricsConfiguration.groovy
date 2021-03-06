package com.tado

import com.codahale.metrics.MetricRegistry
import com.codahale.metrics.Slf4jReporter
import com.readytalk.metrics.StatsDReporter
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

import javax.annotation.PostConstruct
import java.util.concurrent.TimeUnit

@Configuration
@ConfigurationProperties(prefix = "metrics", ignoreUnknownFields = true)
class MetricsConfiguration {

   int reportInterval

   boolean statsDEnabed
   String statsDHost
   int statsDPort
   String statsDPrefix

   @Autowired
   MetricRegistry metricRegistry

   @PostConstruct
   void init() {
      Slf4jReporter.forRegistry(metricRegistry)
         .outputTo(LoggerFactory.getLogger('com.tado.metrics'))
         .withLoggingLevel(Slf4jReporter.LoggingLevel.INFO)
         .convertRatesTo(TimeUnit.SECONDS)
         .convertDurationsTo(TimeUnit.MILLISECONDS)
         .build()
         .start(reportInterval, TimeUnit.SECONDS)

      if (statsDEnabed) {
         StatsDReporter.forRegistry(metricRegistry)
            .prefixedWith(statsDPrefix)
            .build(statsDHost, statsDPort)
            .start(reportInterval, TimeUnit.SECONDS);
      }
   }
}
