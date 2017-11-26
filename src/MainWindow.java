//import java.util.Scanner;
import java.io.File;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.*;
//import java.awt.event.*;
//import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;
//import javax.swing.JButton; 
import javax.swing.JPanel; 
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent; 
import javax.swing.JFileChooser; 
import javax.swing.JFrame;
import javax.swing.JLabel; 


class FunctionWindows extends Frame implements ActionListener//GUI主体框架定义
{
	private static final long serialVersionUID = 1L;
	static FunctionWindows frm1=new FunctionWindows();
	static FunctionWindows frm2=new FunctionWindows();
	static FunctionWindows frm3=new FunctionWindows();
	static FunctionWindows frm4=new FunctionWindows();
	static FunctionWindows frm5=new FunctionWindows();
	
	static Button btn11=new Button("展示");
	static Button btn12=new Button("退出");
	static TextArea txa11=new TextArea("",6,10,TextArea.SCROLLBARS_NONE);
	
	static TextArea txa211=new TextArea("",6,10,TextArea.SCROLLBARS_NONE);
	static TextArea txa212=new TextArea("",6,10,TextArea.SCROLLBARS_NONE);
	static TextArea txa22=new TextArea("",6,10,TextArea.SCROLLBARS_VERTICAL_ONLY);
	static Button btn21=new Button("确定");
	static Button btn22=new Button("退出");
	
	static TextArea txa31=new TextArea("",6,10,TextArea.SCROLLBARS_VERTICAL_ONLY);
	static TextArea txa32=new TextArea("",6,10,TextArea.SCROLLBARS_VERTICAL_ONLY);
	static Button btn31=new Button("开始生成");
	static Button btn32=new Button("退出");
	
	static TextArea txa411=new TextArea("",6,10,TextArea.SCROLLBARS_NONE);
	static TextArea txa412=new TextArea("",6,10,TextArea.SCROLLBARS_NONE);
	static TextArea txa42=new TextArea("",6,10,TextArea.SCROLLBARS_VERTICAL_ONLY);
	static Button btn41=new Button("确定");
	static Button btn42=new Button("退出");
	
	static TextArea txa51=new TextArea("",6,10,TextArea.SCROLLBARS_NONE);
	static TextArea txa52=new TextArea("",6,10,TextArea.SCROLLBARS_VERTICAL_ONLY);
	static Button btn51=new Button("游走");
	static Button btn52=new Button("退出");
	
	
	public static void CreateGraphWindow() throws IOException{//GUI：文件读取
		File f;
		String path ="";
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "仅限txt文件", "txt");//建立过滤器，只显示jpg和gif
		    chooser.setFileFilter(filter);//开始过滤
		int returnVal = chooser.showOpenDialog(null);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	    	f=chooser.getSelectedFile();
	    	path=path+f.getPath();
	    }
	    path=path.replaceAll("\\\\","\\\\\\\\");
	    System.out.println(path);
	    Directed_graph.CreateGraph(path);		
	}
	public static void showDirectedGraph() {//GUI：展示图窗口
	    Directed_graph.showDirectedGraph();
		frm1.setLayout(null);
		frm1.setSize(640, 480);
		btn11.addActionListener(frm1);
		btn11.setBounds(280, 160, 80, 40);
		txa11.setBounds(200, 240, 240, 40);
		btn12.addActionListener(frm1);
		btn12.setBounds(280,320, 80, 40);
		txa11.setEditable(false);
		frm1.add(btn11);
		frm1.add(btn12);
		frm1.add(txa11);
		frm1.setVisible(true);
		
	}
	public static void queryBridgeWordsWindow()//GUI：获取桥接词的窗口
	{
		frm2.setLayout(null);
		frm2.setSize(640, 480);
		btn21.addActionListener(frm2);
		btn22.addActionListener(frm2);
		txa211.setBounds(220, 80, 80, 40);
		txa212.setBounds(340, 80, 80, 40);
		btn21.setBounds(280, 160, 80, 40);
		txa22.setBounds(200, 240, 240, 40);
		btn22.setBounds(280, 320, 80, 40);
		txa22.setEditable(false);
		frm2.add(txa211);
		frm2.add(txa212);
		frm2.add(txa22);
		frm2.add(btn21);
		frm2.add(btn22);
		frm2.setVisible(true);
	}
	public static void generateNewTextWindow() {//GUI：生成新文本窗口
		frm3.setLayout(null);
		frm3.setSize(640,480);
		btn31.addActionListener(frm3);
		btn32.addActionListener(frm3);
		txa31.setBounds(100, 80, 440, 100);
		btn31.setBounds(80, 350, 80, 40);
		txa32.setBounds(100, 240, 440, 100);
		btn32.setBounds(480, 350, 80, 40);
		txa32.setEditable(false);
		frm3.add(txa31);
		frm3.add(txa32);
		frm3.add(btn31);
		frm3.add(btn32);
		frm3.setVisible(true);
	}
	public static void calcShortestPathWindow()//GUI：计算最短路径窗口
	{
		frm4.setLayout(null);
		frm4.setSize(640, 480);
		btn41.addActionListener(frm4);
		btn42.addActionListener(frm4);
		txa411.setBounds(220, 80, 80, 40);
		txa412.setBounds(340, 80, 80, 40);
		btn41.setBounds(280, 160, 80, 40);
		txa42.setBounds(120, 240, 400, 120);
		btn42.setBounds(280, 400, 80, 40);
		txa42.setEditable(false);
		frm4.add(txa411);
		frm4.add(txa412);
		frm4.add(txa42);
		frm4.add(btn41);
		frm4.add(btn42);
		frm4.setVisible(true);
		
	}
	public static void randomWalkWindow() {//GUI：随机游走窗口
		frm5.setLayout(null);
		frm5.setSize(640, 480);
		btn51.addActionListener(frm5);
		btn52.addActionListener(frm5);
		txa51.setBounds(200, 80, 240, 40);
		txa51.setEditable(false);
		btn51.setBounds(280, 160, 80, 40);
		txa52.setBounds(100, 240, 440, 90);
		txa52.setEditable(false);
		btn52.setBounds(280, 420, 80, 40);
		frm5.add(btn51);
		frm5.add(btn52);
		frm5.add(txa51);
		frm5.add(txa52);
		frm5.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)//GUI：主窗口
	{
		Button btn=(Button) e.getSource();
		if(btn==btn11)
		{
			ShowPhoto.showpho();
			txa11.setText("图片已保存于E:\\JavaCode\\MainWindow\\src\\graph.jpg");
		}
		else if(btn==btn12)
		{
			frm1.dispose();
		}
		else if (btn==btn21)
		{
			String temp2,word1,word2;
			word1=txa211.getText();
			word2=txa212.getText();
			if (word1!=null && word2!=null)
			{
				temp2=Directed_graph.queryBridgeWords(word1,word2);
				txa22.setText(Directed_graph.outPut2(temp2, word1, word2));
			}
			else
				txa22.setText("error!");
		}
		else if (btn==btn22)
			frm2.dispose();
		else if(btn==btn31)
		{
			txa32.setText(Directed_graph.generateNewText(txa31.getText()));
		}
		else if(btn==btn32)
		{
			frm3.dispose();
		}
		else if(btn==btn41)
		{
			String temp4,word1,word2;
			StringBuffer temp4_buf;
			word1=txa411.getText();
			word2=txa412.getText();
			word1=Directed_graph.Effectivestring(word1);
			word2=Directed_graph.Effectivestring(word2);
			int flag=-1;
			if (Directed_graph.Jugdge_Length(word1)!=0 && Directed_graph.Jugdge_Length(word2)!=0)
			{
				temp4=Directed_graph.calcShortestPath(word1,word2);
				txa42.setText(Directed_graph.outPut4(temp4, word1, word2));
			}
			else if(Directed_graph.Jugdge_Length(word1)!=0 && Directed_graph.Jugdge_Length(word2)==0)
			{
				for (int i=0;i<Directed_graph.G.point_num;i++)
				{
					if (Directed_graph.G.point[i].equals(word1)==true)
					{
						flag=i;
						break;
					}
				}
				if (flag==-1)
				{
					temp4=Directed_graph.calcShortestPath(word1,Directed_graph.G.point[0]);
					txa42.setText(Directed_graph.outPut4(temp4,word1,Directed_graph.G.point[0]));
				}
				else
				{
					temp4_buf=new StringBuffer(10000);
					for (int i=0;i<Directed_graph.G.point_num-1;i++)
					{
						temp4=new String();
						if (i!=flag)
						{
							temp4=Directed_graph.calcShortestPath(word1,Directed_graph.G.point[i]);
							temp4_buf.append(Directed_graph.outPut4(temp4,word1,Directed_graph.G.point[i]));
						}
					}
					txa42.setText(temp4_buf.toString());
				}
			}
			else if(Directed_graph.Jugdge_Length(word1)==0 && Directed_graph.Jugdge_Length(word2)!=0)
			{
				for (int i=0;i<Directed_graph.G.point_num;i++)
				{
					if (Directed_graph.G.point[i].equals(word2)==true)
					{
						flag=i;
						break;
					}
				}
				if (flag==-1)
				{
					temp4=Directed_graph.calcShortestPath(word2,Directed_graph.G.point[0]);
					txa42.setText(Directed_graph.outPut4(temp4,word2,Directed_graph.G.point[0]));
				}
				else
				{
					temp4_buf=new StringBuffer();
					for (int i=0;i<Directed_graph.G.point_num;i++)
					{
						temp4=new String();
						if (i!=flag)
						{
							temp4=Directed_graph.calcShortestPath(word2,Directed_graph.G.point[i]);
							temp4_buf.append(Directed_graph.outPut4(temp4,word2,Directed_graph.G.point[i]));
						}
					}
					txa42.setText(temp4_buf.toString());
				}
			}
			else
				txa42.setText("error!");
		}
		else if(btn==btn42)
			frm4.dispose();
		else if(btn==btn51)
		{
			if(Directed_graph.time==-1)
			{
				txa51.setText("这是空图  游走结束");
			}
			else if(Directed_graph.time==-2)
			{
				txa51.setText("无出边  游走结束");
			}
			else if(Directed_graph.time==-3)
			{
				txa51.setText("边重复  游走结束");
			}
			else
			{
				try {
					txa52.setText(Directed_graph.randomWalk());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		else if(btn==btn52)
		{
			frm5.dispose();
			//System.exit(0);
		}
	}
}
 public class MainWindow extends Frame implements ActionListener//GUI：监听器注册
{	
	private static final long serialVersionUID = 1L;
	   static MainWindow frm=new MainWindow();
	   static Button btn1=new Button("展示图");
	   static Button btn2=new Button("求桥接词");
	   static Button btn3=new Button("生成新文本");
	   static Button btn4=new Button("计算两个单词最短路径");
	   static Button btn5=new Button("随机游走");
	   static Button btn6=new Button("退出");
	   public static void main(String args[]) throws IOException
	   {
		   btn1.addActionListener(frm); // 把事件监听器frm向btn1注册
		   btn2.addActionListener(frm); // 把事件监听器frm向btn2注册
		   btn3.addActionListener(frm); // 把事件监听器frm向btn3注册
		   btn4.addActionListener(frm); // 把事件监听器frm向btn1注册
		   btn5.addActionListener(frm);
		   btn6.addActionListener(frm);// 把事件监听器frm向btn2注册
		   frm.setTitle("Action Event");
		   frm.setLayout(null);
		   frm.setSize(900,600);
		   btn1.setBounds(350,20,200,100);
		   btn2.setBounds(50,170,200,100);
		   btn3.setBounds(650,170,200,100);
		   btn4.setBounds(200,295,200,100);
		   btn5.setBounds(500,295,200,100);
		   btn6.setBounds(250,450,400,100);
		   frm.setVisible(true);
		   frm.add(btn1);
		   frm.add(btn2);
		   frm.add(btn3);
		   frm.add(btn4);
		   frm.add(btn5); 
		   frm.add(btn6); 
		   FunctionWindows.CreateGraphWindow();
	   }
	public void actionPerformed(ActionEvent e)
	   {
	      Button btn=(Button) e.getSource();  // 取得事件来源对象
	      if(btn==btn1) {           // 如果是按下btn1按钮
	    	  FunctionWindows.showDirectedGraph();
	      }
	      else if(btn==btn2)     // 如果是按下btn2按钮
	    	  FunctionWindows.queryBridgeWordsWindow();
	      else if(btn==btn3)                     // 如果是按下btn3按钮
	    	  FunctionWindows.generateNewTextWindow();
	      else if(btn==btn4)
	    	  FunctionWindows.calcShortestPathWindow();
	      else if(btn==btn5)
	    	  FunctionWindows.randomWalkWindow();
	      else if(btn==btn6)
	    	  frm.dispose();
	   }
	}
 class ShowPhoto extends JFrame {//GUI：打开有向图保存的文件
	private static final long serialVersionUID = 1L;
	public static void showpho() {
		JFrame mainframe = new JFrame("graph");
	    JPanel cp = (JPanel) mainframe.getContentPane();
	    cp.setLayout(new BorderLayout());
	    ImageIcon background = new ImageIcon("E:\\JavaCode\\MainWindow\\src\\graph.jpg");
	    JLabel label=new JLabel(background);
	    cp.add("Center", label);
	    mainframe.pack();
	    mainframe.setVisible(true);
		}
	}
