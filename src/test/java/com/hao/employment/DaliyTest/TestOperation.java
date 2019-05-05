package com.hao.employment.DaliyTest;

import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.codehaus.groovy.runtime.powerassert.SourceText;

import javax.sound.midi.Soundbank;
import java.text.DecimalFormat;

/*@author haoxueqiao
  @date 2019/4/22 20:31*/
public class TestOperation {
    public static void main(String[] args) {
        int a =45;
        int b=158;
        String format="0.00";
        DecimalFormat dec = new DecimalFormat(format);
        String c =  dec.format((double) a / b*100);
        Double d=Double.parseDouble(c);
//        System.out.println(d);
        String fileName="abc.txt";
        String fileType = fileName.substring(fileName.lastIndexOf("c"));
        System.out.println(fileType);
    }


}
