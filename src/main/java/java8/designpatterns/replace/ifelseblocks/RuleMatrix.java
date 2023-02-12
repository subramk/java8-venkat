package java8.designpatterns.replace.ifelseblocks;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class RuleMatrix {

    private RuleMatrix(){

    }

    private static Map<Predicate, Function> ruleMatrix = new HashMap<>();

    static{
        //ruleMatrix.put(CartPredicates)
    }

}
