package Logger;

import java.util.*;

public interface LogClient {
    //When process starts it calls start method with process id and start time.
    void start(String processId);

    //when process ends it calls end method with process id and end time.
    void end(String processId);

    // polls the first log entry of completed process sorted by start time

    // pid ----- start time ------ end timme
    // 1 ---------12 -----------------15
    // 2 ------------8-----------------12
    // 3----------------7--------------19
    void poll();
}

class LoggerImplementation implements LogClient {

    private Map<String, Process> processes;
//    private final Timer;

    public LoggerImplementation() {
        this.processes = new TreeMap<>();
    }
    @Override
    public void start(String processId) {
        processes.put(processId, new Process(processId,System.currentTimeMillis()));

    }

    @Override
    public void end(String processId) {
        processes.get(processId).setEndTime(System.currentTimeMillis());
    }

    @Override
    public void poll() {

//        final Process process = processes.firstEntry().getValue();
//
//        if(processes.firstEntry().getValue().getEndTime()!=-1)
//        {
//            processes.remove(process.getId());
//        }

    }
}

class Process {

    private final String id;
    private final long startTime;
    private long endTime=0;

    public Process(final String id, final long startTime){
        this.id = id;
        this.startTime = startTime;

    }

    public String getId(){
        return id;
    }

    public long getStartTime(){
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }


    public void setEndTime(long l) {
        this.endTime=l;
    }
}
