package pl.java.calculator;

enum Operation {

    NONE(""),ADD("+"),SUBSTRACT("-"),MULTIPLY("*"),DIVIDE("/");

    private final String key;

    private Operation(String s){
        this.key=s;
    }
    public static Operation operationFromKey(String key){
        for(Operation operation:values()){
            if(operation.key.equals(key))
                return operation;
        }
        return NONE;
    }
}
