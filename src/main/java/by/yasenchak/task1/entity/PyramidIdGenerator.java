package by.yasenchak.task1.entity;

public class PyramidIdGenerator {
    private static final int MAX_ID = 10000;
    private static long id = 0;

    public static long increaseId(){
        if(id + 1 < MAX_ID){
            id++;
        }else{
            id = 0;
        }
        return id;
    }

    private PyramidIdGenerator(){}
}
