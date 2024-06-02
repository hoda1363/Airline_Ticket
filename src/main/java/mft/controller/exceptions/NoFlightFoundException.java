package mft.controller.exceptions;

public class NoFlightFoundException extends Exception{
    public NoFlightFoundException(){
        super("No flight found");
    }
}
