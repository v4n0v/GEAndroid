package com.example.v4n0v.geandroid.core.command_request;

class InsertCommand extends RequestCommand{

    public InsertCommand(Operator operator) {
        super(operator);
    }

    @Override
    public void execute() {
        operator.insert();
    }
}
