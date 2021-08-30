package com.curso.m16.controller.common;

import java.util.Optional;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;


public class AuditorAwareImpl implements AuditorAware<String> {
/***** IF USE SPRING SECURITY for @CreatedBy @LastModifiedBy **********/
//    @Override
//    public Optional<String> getCurrentAuditor() {
//        return Optional.ofNullable(SecurityContextHolder.getContext())
//                .map(SecurityContext::getAuthentication)
//                .filter(Authentication::isAuthenticated)
//                .map(Authentication::getName);
//    }

/***** MOCK TO USE MY OWN NAME for @CreatedBy @LastModifiedBy  ********/
	 @Override
	    public Optional<String> getCurrentAuditor() {
	        return Optional.of("Toni");
	    }
}