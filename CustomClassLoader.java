import java.io.*;
public class CustomClassLoader extends ClassLoader {

    
    @Override
    public Class findClass(String name) throws ClassNotFoundException {
        // System.out.println("load class");
        byte[] b = loadClassFromFile(name);
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassFromFile(String fileName)  {

        byte[] buffer;
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        int nextValue = 0;
        try {
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(   "./B/" +fileName.replace('.', File.separatorChar) + ".class"));
          
            while ( (nextValue = inputStream.read()) != -1 ) {
                byteStream.write(nextValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        buffer = byteStream.toByteArray();
        return buffer;
    }

    public static void main(String[] argv){
        try{
        ClassLoader cloader1 = new CustomClassLoader();
        ClassLoader cloader2 = new CustomClassLoader();

        Class c1 =  cloader1.loadClass("A");
        Class c2 = cloader2.loadClass("A");
        // System.out.println(c1);
        System.out.println(c1 == c2 ? 1 :0); 
        }catch(Exception e){
            System.out.println(e);
        }
    }
}