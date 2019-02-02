package indi.wh.aop;

import java.io.FileOutputStream;
import java.io.IOException;

import sun.misc.ProxyGenerator;

@SuppressWarnings("restriction")
public class ProxyUtils {
	
	public static void generateClassFile(Class<?> clazz,String proxyName) throws IOException
    {
        //根据类信息和提供的代理类名称，生成字节码
        byte[] classFile = ProxyGenerator.generateProxyClass(proxyName,new Class[]{clazz});
        String paths = clazz.getResource(".").getPath();  
        System.out.println(paths);  
        FileOutputStream out = null;     
       
        //保留到硬盘中  
        out = new FileOutputStream(paths+proxyName+".class");  
        out.write(classFile);
        out.write(classFile);    
        out.flush(); 
        out.close();
    }
}
