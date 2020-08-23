package java8.designpatterns.chain.of.responsibility;

public enum WashState {
    INITIAL,
    INITIAL_WASH,
    SOAP,
    RINSED,
    POLISHED,
    DRIED
}
