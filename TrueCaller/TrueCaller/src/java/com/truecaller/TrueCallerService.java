/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.truecaller;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author gmka2
 */
@WebService(serviceName = "TrueCallerService")
public class TrueCallerService {


    /**
     * Web service operation
     * @param number
     * @return 
     */
    @WebMethod(operationName = "trueCaller")
    public String trueCaller(@WebParam(name = "number") String number) {
        
        String callerID = "";
        
        if ("01118899598".equals(number))
        {
            
           callerID = "Abdelrahman Awdalla";
        } else if ("01275592233".equals(number))
        {
            
           callerID = "Mostafa Tarek";
            } else if ("01156675600".equals(number))
        {
            
           callerID = "Motaz Ramadan";
        } else if ("3".equals(number))
        {
            
           callerID = "D";
        } else if ("4".equals(number))
        {
            
           callerID = "E";
        } else if ("5".equals(number))
        {
            
           callerID = "F";
        } else if ("6".equals(number))
        {
            
           callerID = "G";
        } else if ("7".equals(number))
        {
            
           callerID = "H";
        } else if ("8".equals(number))
        {
            
           callerID = "I";
        } else if ("9".equals(number))
        {
            
           callerID = "J";
        }
        
        return callerID;
    }
}
