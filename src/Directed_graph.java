import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

class Directed_graph {//图的功能
	static final int N=1000;
	static graph G;
	static int random_pos;
	static int time=0;
	static String out="";
	static int[][]visted=new int[N][N];
	public static void CreateGraph(String path) throws IOException//生成有向图的函数
	{	
		int flag,point;
		char []temp_chars=new char[1000];
		FileReader fr=new FileReader(path);
		int num=fr.read(temp_chars);
		String temp_str=new String(temp_chars,0,num);
		fr.close();
		String []words=new String[1000];
		temp_str=temp_str.toLowerCase();
		words=temp_str.split("[^a-z]+");
		G = new graph();
		G.point_num=0;
		point=0;
		for (int i=0;i<words.length;i++)
		{
			flag=0;
			for (int j=0;j<G.point_num;j++)
			{
				if (G.point[j].equals(words[i])==true)
				{
					if (point!=j)
					{
						G.link[point][j]++;
						point=j;
					}
					flag=1;
					break;
				}
			}
			if (flag==0)
			{
				G.point[G.point_num]=new String(words[i]);
				if (i!=0)
				{
					G.link[point][G.point_num]++;
					point=G.point_num;
    			}
				G.point_num++;
			}
		}
	}
	public static void showDirectedGraph() {//展示图的函数主体
    	StringBuffer Order=new StringBuffer("A->t");
    	String Order_r;
    	int i,j;
    	GraphViz gViz=new GraphViz("E:\\JavaCode\\MainWindow\\src","D:\\New Folder\\bin\\dot.exe","graph");
        gViz.start_graph();
        for(i=0;i<G.point_num;i++)
        {
        	for(j=0;j<G.point_num;j++)
        	{
        		if(G.link[i][j]!=0)
        		{
        		Order.delete(0,Order.length());
        		Order.append(G.point[i]);
        		Order.append("->");
        		Order.append(G.point[j]);
        		Order_r=Order.toString();
        		gViz.addln(Order_r);
        		}
        	}
        }
        gViz.end_graph();
        try {
            gViz.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	private static int If_In(String word)
	{
		int result=0;
		for (int i=0;i<G.point_num;i++)
		{
			if (G.point[i].equals(word)==true)
    		{
				result=1;
				break;
    		}
		}
		return result;
	}
	private static int Get_Strslen(String temp[])
	{
		int len;
		for (len=0;;len++)
    	{
    		if (temp[len]==null)
    			break;
    	}
		return len;
	}
	public static String[] Get_bridege_words(String word1, String word2) {//获取桥接词的关键函数
	    int[]words_temp_pos;
	    int i,j,temp_num=0;
	    String []words_out=new String[1000];
		words_temp_pos=G.Show(word1);
		for(i=0;words_temp_pos[i]!=-1;i++)
		{
			for(j=0;G.Show(G.point[words_temp_pos[i]])[j]!=-1;j++)
			{
				if((G.point[
				           G.Show(
				        		   G.point[words_temp_pos[i]]
				        		 )[j]
				        ]).equals(word2)) {
					words_out[temp_num]=G.point[words_temp_pos[i]];
					temp_num++;
				}
			}
		}
		return words_out;
	}
	public static String queryBridgeWords(String word1, String word2)//获取桥接词的函数主体
	{
		String temp[];
		String str_answer,str_result;
		StringBuffer result;
    	int flag1,flag2,answer,len;
    	flag1=If_In(word1);
    	flag2=If_In(word2);
    	temp=Get_bridege_words(word1,word2);
    	len=Get_Strslen(temp);
    	if (flag1==0&&flag2==0)
    		answer=1;//两个词均不存在
    	else if (flag1==1&&flag2==0)
    		answer=2;//第一个词存在，第二个词不存在
    	else if (flag1==0&&flag2==1)
    		answer=3;//第一个词不存在，第二个词存在
    	else
    	{
    		if (len==0)
    			answer=4;//没有桥接词
    		else
    			answer=5;//有桥接词
    	}
		str_answer=String.valueOf(answer);
		result=new StringBuffer();
		result.append(str_answer);
		if (answer==5)
		{
			for (int i=0;i<len;i++)
			{
				result.append(" ");
				result.append(temp[i]);
			}
		}
		str_result=result.toString();
		return str_result;
	}
	public static String outPut2(String temp2,String word1,String word2)//格式化输出桥接词
	{
		String []words=new String[1000];
		String result;
		StringBuffer temp;
		temp=new StringBuffer();
		int answer;
		words=temp2.split("[^a-z0-9]+");
		answer=Integer.parseInt(words[0]);
		if (answer==1)
			temp.append("No “"+word1+"” and “"+word2+"” in the graph!");
		else if (answer==2)
			temp.append("No “"+word2+"” in the graph!");
		else if (answer==3)
			temp.append("No “"+word1+"” in the graph!");
		else if (answer==4)
			temp.append("No bridge words from “"+word1+"” to ”"+word2+"”!");
		else
		{
			temp.append("The bridge words from “"+word1+"” to ”"+word2+"”is:");
			for (int i=1;i<words.length;i++)
				temp.append(words[i]+" ");
		}
		result=temp.toString();
		return result;
	}
	public static String generateNewText(String word1) {//生成新文本的函数
    	int word_num;
    	int i,random_position,real_string_array_length;
    	Random random = new Random();
    	String word_out=new String();
    	String []words=new String[1000];
    	String []bridge_words=new String[1000];
    	word1=word1.toLowerCase();
		words=word1.split("[^a-z]+");
		word_num=words.length;
		if(word_num==1)
		{
			word_out+=words[0];
		}
		else
		{
			for(i=0;i<word_num-1;i++)
			{
				word_out+=words[i];
				word_out+=" ";
				if(G.Search(words[i])!=-1)
				{
					if(G.Search(words[i+1])!=-1)
					{
						bridge_words=Get_bridege_words(words[i],words[i+1]);
						real_string_array_length=Get_real_string_array_length(bridge_words);
						if(real_string_array_length!=0)
						{
						if(Get_real_string_array_length(bridge_words)==1)
						{
							random_position=0;
						}
						else
						{
						random_position=random.nextInt(real_string_array_length-1);
						}
						word_out+=bridge_words[random_position];
						word_out+=" ";
						}
					}
				}
			}
			word_out+=words[i];
			word_out+=" ";
		}
		return word_out;
	}
	
	public static String calcShortestPath(String word1, String word2)//计算最短路径的函数
    {
		int [][]matrix=new int[G.point_num][G.point_num];
    	int [][]temp=new int[G.point_num][G.point_num];
    	int int_word1,int_word2,answer;
    	StringBuffer result;
    	String str_answer,str_result;
    	int_word1=-1;
    	int_word2=-1;
    	for (int i=0;i<G.point_num;i++)
    	{
    		if (G.point[i].equals(word1)==true)
    			int_word1=i;
    		if (G.point[i].equals(word2)==true)
    			int_word2=i;
    	}
    	
    	if (int_word1==-1&&int_word2==-1)
    		answer=1;
    	else if(int_word1!=-1&&int_word2==-1)
    		answer=2;
    	else if ((int_word1==-1&&int_word2!=-1))
    		answer=3;
    	else
    	{
	    	if (G.link[int_word1][int_word2]!=0)
	    		answer=4;
	    	else
	    	{
	    		answer=5;
	    		for (int i=0;i<G.point_num;i++)
		    	{
		    		for (int j=0;j<G.point_num;j++)
		    		{
		    			if (G.link[i][j]!=0)
		    			{
		    				
		    				matrix[i][j]=G.link[i][j];
		    			}
		    			else
		    				matrix[i][j]=1000;
		    			if (i==j)
		    				matrix[i][j]=0;
		    			temp[i][j]=j;
		    		}
		    	}
	    		for (int i=0;i<G.point_num;i++)
	        	{
	        		//System.out.print(G.point[i]);
	        		for (int j=0;j<G.point_num;j++)
	        		{
	        			//System.out.print(" "+temp[i][j]);
	        		}
	        		//System.out.println();
	        	}
		    	for (int k=0;k<G.point_num;k++)
		    	{
		    		for (int i=0;i<G.point_num;i++)
		    		{
		    			for (int j=0;j<G.point_num;j++)
		    			{
		    				if (matrix[i][k]!=1000&&matrix[k][j]!=1000&&matrix[i][k]+matrix[k][j]<matrix[i][j])
		    				{
		    					matrix[i][j]=matrix[i][k]+matrix[k][j];
		    					temp[i][j]=temp[i][k];
		    				}
		    			}
		    		}
		    	}
	    	}
    	}
    	for (int i=0;i<G.point_num;i++)
    	{
    		//System.out.print(G.point[i]);
    		for (int j=0;j<G.point_num;j++)
    		{
    			//System.out.print(" "+temp[i][j]);
    		}
    		//System.out.println();
    	}
    	str_answer=String.valueOf(answer);
		result=new StringBuffer();
		result.append(str_answer);
		if (answer==5)
		{
			int i=int_word1;
			int j=int_word2;
			System.out.println(temp[i][j]);
			while (temp[i][j]!=j)
			{
				result.append(" ");
				result.append(G.point[temp[i][j]]);
		        i=temp[i][j];
			}
		}
		str_result=result.toString();
		//System.out.println(str_result);
		return str_result;
	}
    public static String outPut4(String temp4,String word1,String word2)//最短路径的格式化输出函数
	{
		String []words=new String[1000];
		String result;
		StringBuffer temp;
		temp=new StringBuffer();
		result=new String();
		int answer,len;
		words=temp4.split("[^a-z0-9]+");
		answer=Integer.parseInt(words[0]);
		if (answer==1)
			temp.append("No “"+word1+"” and “"+word2+"” in the graph!");
		else if (answer==2)
			temp.append("No “"+word2+"” in the graph!");
		else if (answer==3)
			temp.append("No “"+word1+"” in the graph!");
		else if (answer==4)
		{
			temp.append("The shortest path from “"+word1+"” to ”"+word2+"”is:");
			temp.append(word1+"->"+word2+"||length:2\n");
		}
		else
		{
			if (words.length==1)
				temp.append("There is no way from“"+word1+"” to “"+word2+"”\n");
			else
			{
				temp.append("The shortest path from “"+word1+"” to ”"+word2+"”is:");
				temp.append(word1+"->");
				for (int i=1;i<words.length;i++)
					temp.append(words[i]+"->");
				len=words.length;
				temp.append(word2+" ||length:"+len+"\n");
			}
		}
		result=temp.toString();
		return result;
	}
    
	public static String randomWalk() throws IOException {//随机游走的函数
		int pre=random_pos;
		Random random1=new Random();
		FileWriter fw=new FileWriter("random walk.txt");
		if(G.point_num==0)
		{
			time=-1;//空图
		}
		else if(time==0)
		{
			if(G.point_num==1)
			{
				random_pos=0;
			}
			else
			{
			random_pos=random1.nextInt(G.point_num-1);
			}
			out=out+G.point[random_pos];
			out=out+" ---> ";
			time++;
		}
		else if(get_real_int_array_length(G.Show(G.point[random_pos]))==0)
		{
			time=-2;//无出边
		}
		else
		{
			if(get_real_int_array_length(G.Show(G.point[random_pos]))==1)
			{
				random_pos=G.Show(G.point[random_pos])[0];
			}
			else
			{
				random_pos=G.Show(G.point[random_pos])
						[random1.nextInt(get_real_int_array_length(G.Show(G.point[random_pos]))-1)];
			}
			if(visted[pre][random_pos]!=0)
			{
				time=-3;//边重复
			}
			visted[pre][random_pos]++;
			out=out+G.point[random_pos];
			out=out+" ---> ";
			time++;
		}
		fw.write(out);
		fw.close();
		return out;
	}
	public static int get_real_int_array_length(int []A)//获得数组实际长度的函数
	{
		int i;
		for(i=0;i<A.length;i++)
		{
			if(A[i]==-1)
			{
				return i;
			}
		}
		return A.length;
	}
    public static int Get_real_string_array_length(String[]A)//获取字符串实际长度的函数
    {
    	int i;
    	for(i=0;i<A.length;i++)
    	{
    		if(A[i]==null||A[i].length()<=0)
    		{
    			return i;
    		}
    	}
		return A.length;
    }
    public static String Effectivestring(String temp)
    {
    	String result="";
    	String []words=new String[100];
    	temp=temp.toLowerCase();
    	words=temp.split("[^a-z]+");
    	for(String a:words) {
    		result=result+a;
    	}
    	
    	return result;
    }
    public static int Jugdge_Length(String temp)
    {
    	if (temp.length()==0||temp.length()>50)
    		return 0;
    	else
    		return 1;
    }
       
}
class  GraphViz{
    private String runPath = "";
    private String dotPath = ""; 
    private String runOrder="";
    private String dotCodeFile="dotcode.txt";
    private String resultGif="dotGif";
    private StringBuilder graph = new StringBuilder();

    Runtime runtime=Runtime.getRuntime();

    public void run() {
        File file=new File(runPath);
        file.mkdirs();
        writeGraphToFile(graph.toString(), runPath);
        creatOrder();
        try {
            runtime.exec(runOrder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void creatOrder(){
        runOrder+=dotPath+" ";
        runOrder+=runPath;
        runOrder+="\\"+dotCodeFile+" ";
        runOrder+="-T jpg ";
        runOrder+="-o ";
        runOrder+=runPath;
        runOrder+="\\"+resultGif+".jpg";
        System.out.println(runOrder);
    }

    public void writeGraphToFile(String dotcode, String filename) {
        try {
            File file = new File(filename+"\\"+dotCodeFile);
            if(!file.exists()){
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(dotcode.getBytes());
            fos.close();
        } catch (java.io.IOException ioe) { 
            ioe.printStackTrace();
        }
     }  

    public GraphViz(String runPath,String dotPath,String nameGraph) {
        this.runPath=runPath;
        this.dotPath=dotPath;
		this.resultGif=nameGraph;
    }

    public void add(String line) {
        graph.append("\t"+line);
    }

    public void addln(String line) {
        graph.append("\t"+line + "\n");
    }

    public void addln() {
        graph.append('\n');
    }

    public void start_graph() {
        graph.append("digraph G {\n") ;
    }

    public void end_graph() {
        graph.append("}") ;
    }   
}

