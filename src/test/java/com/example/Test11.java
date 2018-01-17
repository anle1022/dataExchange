package com.example;

import gz.jszx.entity.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;


public class Test11 {
	
	@Test
	public void test3(){
		try {
//			BdcRec rec = new BdcRec();
			Class<?> class1 = null;    
            Person person1 = null;    
            Person person2 = null;    
                
            class1 = Class.forName("gz.jszx.entity.Person");    
            //得到一系列构造函数集合    
            Constructor<?>[] constructors = class1.getConstructors();    
                
            for(int i=0;i<constructors.length;i++){  
                System.out.println("constructors= "+i+"  "+constructors[i].toGenericString()+"\t"+constructors[i].getName()+"\t"+constructors[i].toString());  
            }  
            Constructor<?>[] c1 = class1.getDeclaredConstructors();
            for (int i = 0; i < c1.length; i++) {
                System.out.println("getDeclaredConstructors= "+i+"  "+c1[i].toGenericString()+"\t"+c1[i].getName()+"\t"+c1[i].toString());  
			}
            Method[] methods = class1.getDeclaredMethods();
            for (int i = 0; i < methods.length; i++) {
                System.out.println("methood= "+i+"  "+methods[i].toGenericString()+"\t"+methods[i].getName()+"\t"+methods[i].toString());  
			}
            person2 = (Person) constructors[1].newInstance("andy",20);    
              
            person1 = (Person) constructors[0].newInstance();    
            person1.setAge(30);    
            person1.setName("leeFeng");    
                
                
            System.out.println("Demo4: " + person1.getName() + " : " + person1.getAge()    
                    + "  ,   " + person2.getName() + " : " + person2.getAge()    
                    ); 
            Field[] fields = class1.getDeclaredFields();
            for (Field field : fields) {
				System.out.println(field.getName());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
