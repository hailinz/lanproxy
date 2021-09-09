package org.fengfei.lanproxy.server.config.web;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class URLHelper {

    public static Set<String> generateURLMap(Set<String> s, String rfloader, String folder){
        if(s==null){
            s=new HashSet<String>();
        }
        File file  = new File(folder);
        File[] t = file.listFiles();
        if (t != null && t.length !=0){
            s.add("/lanproxy-config/");
            for(File sfile: t)
            {
                if(sfile.isFile()){
                    s.add(sfile.getAbsolutePath().substring(sfile.getAbsolutePath().indexOf(rfloader) + rfloader.length()+1).replaceAll("\\\\","/"));
                }else{
                    generateURLMap(s,rfloader,sfile.getAbsolutePath());
                }
            }
        }
        return s;
    }

}

