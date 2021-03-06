package challenges.fizz.buzz.solution.two;

public class Operation {
    private int number;
    private String marking;
    private OperationType operationType;

    public Operation(int number, String marking, OperationType operationType) {
        this.number = number;
        this.marking = marking;
        this.operationType = operationType;
    }

    public int getNumber() {
        return number;
    }

    public String getMarking() {
        return marking;
    }

    public OperationType operationType() {
        return operationType;
    }
}
