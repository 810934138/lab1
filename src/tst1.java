import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class tst1 {

	@Test
	public void testCalcShortestPath1() {
		org.junit.Assert.assertEquals("5 the format",Directed_graph.calcShortestPath("in","of"));
	}
	@BeforeClass  
    public static void testBeforeClass() throws IOException{//����Ϊ��̬����  
        Directed_graph.CreateGraph("D:\\words(1).txt");  
    }
	
	@Before  
    public void testBefore(){  
        System.out.println("@Before");  
    }     
    @After  
    public void testAfter(){  
        System.out.println("@After");  
    }  
    @AfterClass  
    public static void testAfterClass(){//����Ϊ��̬����  
        System.out.println("@AfterClass");  
    }  
}
