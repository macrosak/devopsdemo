package com.tado

import groovy.util.logging.Slf4j
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping

import javax.servlet.http.HttpServletRequest

@Slf4j
@RestController
@RequestMapping(value = 'devops')
class DevOpsController {

   @RequestMapping(value = "/**")
   String sendRequestToDevice(HttpServletRequest request) {
      log.info("hello devops request: ${request.method} ${request.servletPath} from ${request.remoteAddr}")
      return "Hello DevOps!"
   }

}