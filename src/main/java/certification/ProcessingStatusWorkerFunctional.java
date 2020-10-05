package certification;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;


public class ProcessingStatusWorkerFunctional {

  public static void main(String[] args) {
    ProcessingStatusWorkerFunctional ps = new ProcessingStatusWorkerFunctional();
  }

  public List<ProcessingStatus> doWork(RuleSet ruleSet) {

    List<List<ProcessingStatus>>  listOfLists = new ArrayList<>();

    List<RuleSet> rsList = new ArrayList<>();

    //  Start : for Testing only .
    if( ruleSet == null )
      rsList = Arrays.asList(ruleSet.values()) ;
    else {
      rsList.add(RuleSet.ROM);
    }
    //  End : for Testing only .

    ProcessingStatusAccumulatorBiFunction biFunction = new ProcessingStatusAccumulatorBiFunction();
    return biFunction.apply(rsList, getJobExecutions());

  }

  // some TestData .

  private Set<JobExecution> getJobExecutions(){

    JobExecution je1 = new JobExecution();
    je1.setId("1");
    je1.setName("JobNumber1");

    JobExecution je2 = new JobExecution();
    je2.setId("2");
    je2.setName("JobNumber2");

    Set jeSet = new HashSet();
    jeSet.add(je1);
    jeSet.add(je2);

    return jeSet;





  }

}
