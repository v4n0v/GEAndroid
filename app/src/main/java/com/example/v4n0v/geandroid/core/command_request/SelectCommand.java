package com.example.v4n0v.geandroid.core.command_request;

class SelectCommand extends RequestCommand{

    public SelectCommand(Operator operator) {
        super(operator);
    }

    @Override
    public void execute() {
        operator.select();
    }
}
