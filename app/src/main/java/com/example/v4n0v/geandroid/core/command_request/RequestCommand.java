package com.example.v4n0v.geandroid.core.command_request;

abstract class RequestCommand implements CommandRequest{
    Operator operator;

    public RequestCommand(Operator operator) {
        this.operator = operator;
    }
}
