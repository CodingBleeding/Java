package notepad;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.chrono.JapaneseDate;
import java.awt.Font;

import javax.annotation.processing.Filer;
import javax.imageio.stream.FileCacheImageInputStream;
import javax.naming.spi.DirStateFactory;
import javax.swing.Action;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class NotePad extends JFrame implements ActionListener{
    File file = null;
    Color color = Color.black;
    JTextPane textPane = new JTextPane();
    JDialog about = new JDialog(this);
    JFileChooser fileChooser = new JFileChooser();   //  Open /save file  Filechooser
    GraphicsEnvironment getFont = GraphicsEnvironment.getLocalGraphicsEnvironment();
    Font[] fonts = getFont.getAllFonts();
    JColorChooser colorChooser = new JColorChooser();
                                                      //颜色选择器对象 colorChooser
    //创建菜单的成员变量
    //File
    private JMenuItem jminew, jmiopen, jmisave, jmisaves;
    //Edit菜单的成员变量
    private JMenuItem jmicut, jmicopy, jmiplaster, jmiall;
    //Format菜单的成员变量
    private JMenuItem jmifont, jmicolor;
    //Tool菜单的成员变量
    private JMenuItem jminotepad, jmicalculator;
    //Help菜单的成员变量
    private JMenuItem jmiabout;
    //Exit菜单的成员变量
    private JMenuItem jmiexit;
                                                         //创建各个菜单的成员变量
    public static void main(String[] args) {
		NotePad frame = new NotePad();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
    public NotePad(){
    	setTitle("记事本");
    	setLocation(50,50);
    	//创建菜单，设置菜单栏
    	JMenuBar jMenuBar = new JMenuBar();
    	setJMenuBar(jMenuBar);  //设置菜单栏到菜单中
    	
    	//创建生成各个菜单并设置热键（Hotkey)
    	JMenu filemenu = new JMenu("File");
    	filemenu.setMnemonic('F');
    	jMenuBar.add(filemenu);
    	JMenu editmenu = new JMenu("Edit");
    	editmenu.setMnemonic('E');
    	jMenuBar.add(editmenu);
    	JMenu formatmenu = new JMenu("Format");
    	formatmenu.setMnemonic('T');
    	jMenuBar.add(formatmenu);
    	JMenu helpmenu = new JMenu("Help");
    	helpmenu.setMnemonic('H');
    	jMenuBar.add(helpmenu);
    	JMenu exitmenu = new JMenu("Exit");
    	exitmenu.setMnemonic('X');
    	jMenuBar.add(exitmenu);
    	
    	//创建File菜单的成员变量
        filemenu.add(jminew = new JMenuItem("New"));
        filemenu.add(jmiopen = new JMenuItem("Open"));
        filemenu.add(jmisave = new JMenuItem("Save"));
        filemenu.add(jmisaves = new JMenuItem("Save as"));
        //创建Edit菜单的成员变量
        editmenu.add(jmicut = new JMenuItem("Cut"));
        editmenu.add(jmicopy = new JMenuItem("Copy"));
        editmenu.add(jmiplaster = new JMenuItem("Plaster"));
        editmenu.add(jmiall = new JMenuItem("All"));
        //Format
        formatmenu.add(jmifont = new JMenuItem("Font"));
        formatmenu.add(jmicolor = new JMenuItem("Color"));
        //Help
        helpmenu.add(jmiabout = new JMenuItem("About"));
        //Exit
        exitmenu.add(jmiexit = new JMenuItem("Exit"));
        
        //设置和初始化文本对象text
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setPreferredSize(new Dimension(600, 500));
        getContentPane().add(scrollPane);
        
        //为File菜单注册事件
        jminew.addActionListener(this);
        jmiopen.addActionListener(this);
        jmisave.addActionListener(this);
        jmisaves.addActionListener(this);
        jmicut.addActionListener(this);
        jmicopy.addActionListener(this);
        jmiplaster.addActionListener(this);
        jmiall.addActionListener(this);
        jmifont.addActionListener(this);
        jmicolor.addActionListener(this);
        jmiabout.addActionListener(this);
        jmiexit.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){  //事件监听器
    	String name = e.getActionCommand();
    	if (e.getSource() instanceof JMenuItem) {
			if ("New".equals(name)) {
				textPane.setText("");
				file = null;
			}
			if ("Open".equals(name)) {
				if (file != null) {
					fileChooser.setSelectedFile(file);
				}
				int value = fileChooser.showOpenDialog(this);
						if (value == JFileChooser.APPROVE_OPTION) {
							file = fileChooser.getSelectedFile();
							try {
								//创建一个输入流对象
								FileReader fileReader = new FileReader(file);
								int len = (int) file.length();
								char[] buffer = new char[len];
								fileReader.read(buffer,0,len);
								fileReader.close();
                                textPane.setText(new String(buffer));
							} catch (Exception e2) {
								// TODO: handle exception
								e2.printStackTrace();
							}
						}
			}
			if ("Save" == name) {
				if (file != null) {
					fileChooser.setSelectedFile(file);
				int value = fileChooser.showSaveDialog(this);
				//当单击保存按钮时
				if (value == JFileChooser.APPROVE_OPTION) {
					file = fileChooser.getSelectedFile();
				}
				try {
					FileWriter fileWriter = new FileWriter(file);
					fileWriter.write(textPane.getText());
					fileWriter.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				}
			}
			if ("Cut" == name) {
				textPane.cut();
			}
			if ("Copy".equals(name)) {
				textPane.copy();
			}
			if ("Plaster".equals(name)) {
				textPane.paste();
			}
			if ("All".equals(name)) {
				textPane.selectAll();
			}
			if ("Font".equals(name)) {
				
			}
			if ("Color".equals(name)) {
				color = JColorChooser.showDialog(this, "ColorChooser", color);
				textPane.setForeground(color);
			}
			if ("About".equals(name)) {
				about.setTitle("About");
				about.setSize(300,300);
				about.getContentPane().setBackground(Color.black);
				JLabel jlbfirst = new JLabel();
				about.getContentPane().add(jlbfirst);//将标签添加到对话框（容器）中
				jlbfirst.setText("Thank you for use");
				about.setModal(true);
				about.show();
			}
			if ("Exit".equals(name)) {
				System.exit(0);
			}
		}
    }
}
