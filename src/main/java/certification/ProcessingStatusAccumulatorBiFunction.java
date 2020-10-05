package certification;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;

public class ProcessingStatusAccumulatorBiFunction implements BiFunction<List<RuleSet> , Set<JobExecution> ,List<ProcessingStatus>>  {

  @Override
  public List<ProcessingStatus> apply(final List<RuleSet> ruleSets, final Set<JobExecution> jobExecutions) {

    List<List<ProcessingStatus>>  listOfLists = new ArrayList<>();

    listOfLists =  ruleSets
      .stream()
      .map(ruleSet1 -> {
        //jobExecutions = getJobExecutions();
        return
          jobExecutions
            .stream()
            .map(job -> new ProcessingStatus(job.getId(), job.getName()))
            .collect(toList());
      }).collect(toList());

    return listOfLists.stream()
      .flatMap( x -> x.stream())
      .collect( toList());
  }

}
