
package com.svashishtha.ws;

import javax.xml.ws.Endpoint;

/**
 * This class was generated by Apache CXF 2.6.2
 * 2012-12-30T12:33:08.185+08:00
 * Generated source version: 2.6.2
 * 
 */
 
public class SimpleService_P1_Server{

    protected SimpleService_P1_Server() throws java.lang.Exception {
        System.out.println("Starting Server");
        Object implementor = new SimpleServiceImpl();
        String address = "http://localhost:8081/ws/p1";
        Endpoint.publish(address, implementor);
    }
    
    public static void main(String args[]) throws java.lang.Exception { 
        new SimpleService_P1_Server();
        System.out.println("Server ready..."); 
        
        Thread.sleep(5 * 60 * 1000); 
        System.out.println("Server exiting");
        System.exit(0);
    }
}
