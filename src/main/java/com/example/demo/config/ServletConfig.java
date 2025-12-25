package com.example.demo.config;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean<HttpServlet> helloServlet() {

        HttpServlet servlet = new HttpServlet() {
            @Override
            protected void doGet(
                    HttpServletRequest request,
                    HttpServletResponse response
            ) throws IOException {

                response.setContentType("text/plain");
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().write("Hello from simple servlet");
            }
        };

        return new ServletRegistrationBean<>(servlet, "/hello-servlet");
    }
}
