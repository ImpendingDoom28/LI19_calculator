package com.simbirsoft.calculator.core;

import java.util.HashMap;
import java.util.Map;

import com.simbirsoft.calculator.exception.NotFoundOperationException;

public class Calculator {

    private Map<String, Operation> operations;

    public Calculator() {
        operations = new HashMap<String, Operation>();
        operations.put(PlusOperation.SYMBOL, new PlusOperation());
        operations.put(DivideOperation.SYMBOL, new DivideOperation());
        operations.put(SqrtOperation.SYMBOL, new SqrtOperation());
    }

    public int executeOperation(int a, String symbol, int b) {
        Operation operation = operations.get(symbol);
        if (operation != null) {
            return operation.execute(a, b);
        }
        throw new NotFoundOperationException(symbol);
    }
}
