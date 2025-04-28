

package com.clientservice.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

  private static final Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    // Log para las peticiones entrantes
    logger.info("Incoming Request: {} {} | Remote Address: {}", request.getMethod(), request.getRequestURI(),
        request.getRemoteAddr());
    // Guarda cuando se inicia la peticion
    request.setAttribute("startTime", System.currentTimeMillis());
    return true;
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
      @Nullable Exception ex) throws Exception {
    // Log para las peticiones salientes
    logger.info("Outgoing Response: {} | Status: {}", request.getRequestURI(), response.getStatus());

    // Calcula y hace log al tiempo requerido
    long startTime = (Long) request.getAttribute("startTime");
    long duration = System.currentTimeMillis() - startTime;
    logger.info("Response Time: {} ms", duration);

    // Log si alguna exepcion ocurrio
    if (ex != null) {
      logger.error("Exception: {}", ex.getMessage(), ex);
    }
  }
}
