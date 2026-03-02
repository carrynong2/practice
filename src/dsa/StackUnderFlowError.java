package dsa;

public class StackUnderFlowError extends VirtualMachineError {
    public StackUnderFlowError() {
        super();
    }
    public StackUnderFlowError(String message) {
        super(message);
    }
}
