package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import javax.swing.JFrame;
import loader.ClassLoaderr;

public class MainClass {

	public static final void main(String[] args) throws FileNotFoundException {

		File file = new File(
				"d:\\workspace\\Lift\\Lift\\bin\\Graphics\\DrawingPanel.class");
		ClassLoaderr loader = new ClassLoaderr(file,
				ClassLoader.getSystemClassLoader());
		Class newClass = null;
		newClass = loader.findClass();
		String classname = newClass.getName();
		String s1 = newClass.getSimpleName();
		System.out.printf(classname + "\n" + s1 + "\n");

		Method[] methods = newClass.getMethods();
		for (Method method : methods) {
			if(Modifier.isStatic(method.getModifiers())){
			System.out.print("\n");
			System.out.print(method.getName());
			}
		}
		Field[] fields = newClass.getFields();
		for (Field field : fields) {
			if(Modifier.isStatic(field.getModifiers())){
			System.out.print("\n");
			System.out.print(field.getName());
			}
		}

	}

}
