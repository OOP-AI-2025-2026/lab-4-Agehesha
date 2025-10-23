package org.example.lab4.bank;

import ua.opnu.java.inheritance.account.Operation;

public class MinMaxAccount {

    private Operation minOperation;
    private Operation maxOperation;

    public MinMaxAccount() {
    }

    public void accept(Operation op) {
        if (op == null) {
            return;
        }

        if (minOperation == null) {
            minOperation = op;
        } else {
            minOperation = pickMin(minOperation, op);
        }

        if (maxOperation == null) {
            maxOperation = op;
        } else {
            maxOperation = pickMax(maxOperation, op);
        }
    }

    public Operation getMinOperation() {
        return minOperation;
    }

    public Operation getMaxOperation() {
        return maxOperation;
    }

    private Operation pickMin(Operation a, Operation b) {
        return cmp(a, b) <= 0 ? a : b;
    }

    private Operation pickMax(Operation a, Operation b) {
        return cmp(a, b) >= 0 ? a : b;
    }


    private int cmp(Operation a, Operation b) {
        return Integer.compare(a.hashCode(), b.hashCode());
    }
}
