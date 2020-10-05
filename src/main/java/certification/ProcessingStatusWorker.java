package certification;

import static java.util.stream.Collectors.toList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class ProcessingStatusWorker {

  public static void main(String[] args) {
    ProcessingStatusWorker ps = new ProcessingStatusWorker();
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


    // List<List<ProcessingStatus>>  listOfLists

    listOfLists =  rsList
                  .stream()
                  .map(ruleSet1 -> {
                      Set<JobExecution> jobExecutions = getJobExecutions();
                      return
                        jobExecutions
                          .stream()
                          .map(job -> new ProcessingStatus(job.getId(), job.getName()))
                          .collect(toList());
                    }).collect(toList());


    /*  We get a List of List<ProcessingStatus> because , we loop through each RuleSet and build a list of ProcessingStatus by
     pulling out value from the JobExecution object .

    Like this ::

        RuleSet STD -> converted to  List<ProcessingStatus>
        RuleSET ISO - converted to  List<ProcessingStatus>
        RuleSET ROM - converted to  List<ProcessingStatus>

     */

   return listOfLists.stream()
                .flatMap( x -> x.stream())
                .collect( toList());

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
