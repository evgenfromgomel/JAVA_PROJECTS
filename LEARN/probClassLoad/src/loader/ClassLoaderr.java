package loader;


import java.io.*;
import java.lang.ClassLoader;

public class ClassLoaderr extends ClassLoader {

	private File byteFile; 
	
	public ClassLoaderr(File byteFile, ClassLoader parent) {
		super(parent);
		this.byteFile = byteFile;
	}
	
	public Class<?> findClass() throws FileNotFoundException{
		byte classInByteCode[] = getClassInByteCode();
		//String className = byteFile.getName().substring(0, byteFile.getName().length() - 6);
		return defineClass(null , classInByteCode, 0, classInByteCode.length);
	}
	
	private byte[] getClassInByteCode() throws FileNotFoundException{
		
			InputStream input = new FileInputStream(byteFile);
			
			long fileLengh = byteFile.length();
			
			byte[] byteCode = new byte[(int) fileLengh];
			
		    int offset = 0;
		    int numRead = 0;
        	try {
				while (offset < byteCode.length
						&& (numRead = input.read(byteCode, offset, byteCode.length - offset)) >= 0) {
						offset += numRead;
				}
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return byteCode; 
	}
}
