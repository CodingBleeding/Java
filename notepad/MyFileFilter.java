package notepad;
import java.io.File;

import javax.swing.filechooser.FileFilter;
public class MyFileFilter extends FileFilter{
    public String getDescription(){
    	return "���±��ļ�(*.txt)";
    }
    public boolean accept(File f){
    	if (f.isDirectory() || f.getName().endsWith(".txt")) {
			return true;
		}else{
	    	return false;
    }
    }
}
