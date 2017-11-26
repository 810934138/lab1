class graph {//ͼ�Ľṹ
	static final int M=50;
	int [][]link=new int[M][M];
	String []point=new String[50];
    int point_num;
    graph() {
    	int i,j;
    	this.point_num=0;
    	for(i=0;i<M;i++)
    	{
    		this.point[i]=null;
    		for(j=0;j<M;j++)
    		{
    			this.link[i][j]=0;
    		}
    	}
    }
    int Search(String ipt)
    {
    	int i;
    	for(i=0;i<this.point_num;i++)
    	{
    		if(this.point[i].equals(ipt))
    		   return i;
    	}
    	return -1;
    }
    int[] Show(String A)
    {
    	int[] ans=new int[M];
    	int i,posA,posAns=0;
    	for(i=0;i<this.point_num;i++)
    	{
    		ans[i]=-1;
    	}
    	posA=this.Search(A);
    	if(posA==-1)
    	{
    		return ans;
    	}
    	for(i=0;i<this.point_num;i++)
    	{
    		if(this.link[posA][i]>0) 
    		{
    			ans[posAns]=i;
    			posAns++;
    		}
    	}
    	return ans;
    }
    
}