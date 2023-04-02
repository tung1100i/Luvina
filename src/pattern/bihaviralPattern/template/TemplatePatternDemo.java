/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pattern.bihaviralPattern.template;

import java.lang.reflect.InvocationTargetException;

public class TemplatePatternDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException 
                 {
       Class c=Class.forName("pattern.bihaviralPattern.template.Chess");//Class.forName(args[0]);
       Game g= (Game) c.getConstructor().newInstance();
       g.play();
    }
} 