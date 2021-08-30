package com.curso.m16.controller.common;

import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.curso.m16.model.AuditModel;
import com.curso.m16.model.Players;

 
 @Component
 public class GenerateUUIDListener extends AbstractMongoEventListener<AuditModel> {

     @Override
     public void onBeforeConvert(BeforeConvertEvent<AuditModel> event) {
    	 AuditModel customer = event.getSource();
         if (customer.isNew()) {
             customer.setId(UUID.randomUUID());
         }
     }

 }