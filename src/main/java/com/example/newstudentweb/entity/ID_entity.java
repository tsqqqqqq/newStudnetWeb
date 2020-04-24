package com.example.newstudentweb.entity;

import org.springframework.stereotype.Component;

@Component
public class ID_entity {

    private static String key = "1651200220";

    public String keyEntity (String word)
    {
        char k [] = key.toCharArray();
        int e = k.length;
        char c[] = word.toCharArray();
        int w  = c.length;
        for(int i =0; i<w ; i++) {
            int m = c[i]+k[i];
            c[i]=(char)m;
        }

        return new String(c);
    }

    public String keyJM (String word)
    {
        char k [] = key.toCharArray();
        int e = k.length;
        char c[] = word.toCharArray();
        int w  = c.length;
        for(int i =0; i<w ; i++) {
            int m = c[i]-k[i];
            c[i]=(char)m;
        }

        return  new String(c);
    }


    public String birthString(String val)
    {
        String[] arr = val.split("-");
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<arr.length;i++){
            sb.append(arr[i]);
        }
        String birth = sb.toString();
        return birth;
    }
}
