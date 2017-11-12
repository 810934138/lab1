import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class tst5 {

	
	@Test
	public void testCalcShortestPath5() {
		org.junit.Assert.assertEquals("3",Directed_graph.calcShortestPath("thisjthisjthisjthisjthisjthisjthisjthisjthisjthisjthisjthisjthisjthisj","in"));
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
