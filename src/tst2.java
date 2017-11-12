import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class tst2 {

	@Test
	public void testCalcShortestPath2() {
		org.junit.Assert.assertEquals("2",Directed_graph.calcShortestPath("it",""));
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
