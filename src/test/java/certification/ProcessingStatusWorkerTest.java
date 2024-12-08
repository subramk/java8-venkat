package certification;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ProcessingStatusWorkerTest {

  public ProcessingStatusWorker ps = new ProcessingStatusWorker();



  @Test
  public void testWithOneRuleSet(){
    RuleSet r = RuleSet.ISO ;

   List<ProcessingStatus> result =  ps.doWork(r);
   assertEquals(2,result.size());


  }

  @Test
  public void  testWithTwoRuleSets(){
    List<ProcessingStatus> result =  ps.doWork(null);
    assertEquals(8,result.size());
  }


}
