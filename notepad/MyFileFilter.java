package notepad;
import java.io.File;

import javax.swing.filechooser.FileFilter;
public class MyFileFilter extends FileFilter{
    public String getDescription(){
    	return "记事本文件(*.txt)";
    }
    public boolean accept(File f){
    	if (f.isDirectory() || f.getName().endsWith(".txt")) {
			return true;
		}else{
	    	return false;
    }
    }
}
