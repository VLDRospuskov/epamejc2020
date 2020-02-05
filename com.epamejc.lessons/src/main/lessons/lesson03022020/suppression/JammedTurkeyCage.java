package main.lessons.lesson03022020;

public class JammedTurkeyCage implements AutoCloseable{

    @Override
    public void close() throws IllegalStateException {
        throw new MyException("Cage door does not close", null, true, false);
    }
}
