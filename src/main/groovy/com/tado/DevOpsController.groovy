package com.tado

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.actuate.metrics.CounterService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.servlet.http.HttpServletRequest

@Slf4j
@RestController
@RequestMapping(value = 'devops')
class DevOpsController {
   private static final String REQUEST_COUNTER_NAME = 'request.devops.star-star'

   @Autowired
   CounterService counterService

   @RequestMapping(value = "/**")
   String sendRequestToDevice(HttpServletRequest request) {
      counterService.increment(REQUEST_COUNTER_NAME)

      log.info("hello devops request: ${request.method} ${request.servletPath} from ${request.remoteAddr}")

      return "Hello DevOps!"
   }

}