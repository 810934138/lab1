import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class tst6 {

	@Test
	public void testCalcShortestPath1() {
		org.junit.Assert.assertEquals("1",Directed_graph.calcShortestPath("",""));
	}
	@BeforeClass  
    public static void testBeforeClass() throws IOException{//必须为静态方法  
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
    public static void testAfterClass(){//必须为静态方法  
        System.out.println("@AfterClass");  
    }  
}
