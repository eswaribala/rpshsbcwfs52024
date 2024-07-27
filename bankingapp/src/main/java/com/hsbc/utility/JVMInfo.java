package com.hsbc.utility;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class JVMInfo {

    public static void main(String[] args){
        Properties properties=System.getProperties();

        Set<Map.Entry<Object,Object>> mapEntry= properties.entrySet();

        Iterator itr=mapEntry.iterator();
        while(itr.hasNext()){
          System.out.println(itr.next());

        }

        /*
       System.out.println( properties.getProperty("java.version"));
        System.out.println( properties.getProperty("java.vendor"));
        System.out.println( properties.getProperty("java.class.path"));
        System.out.println( properties.getProperty("java.home"));
        System.out.println( properties.getProperty("os.name"));
        System.out.println( properties.getProperty("os.version"));

         */
    }
}
