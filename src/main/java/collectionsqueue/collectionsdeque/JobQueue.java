package collectionsqueue.collectionsdeque;

import collectionsqueue.job.Job;
import collectionsqueue.job.NoJobException;

import java.util.*;

public class JobQueue {


    public Deque<Job> addJobByUrgency(Job... jobs) {

        Deque<Job> mixedPriorityList = new ArrayDeque<>();

        for (Job job : jobs) {
            if (job.getPriority() < 5) {
                mixedPriorityList.addFirst(job);

            } else {
                mixedPriorityList.addLast(job);

            }
        }
        return mixedPriorityList;
    }



    public Job dispatchUrgentJob(Deque<Job> jobs) {

        if (jobs.isEmpty()) {
            throw new NoJobException("No job available, get a rest!");
        }
        return jobs.getFirst();
    }


    public Job dispatchNotUrgentJob(Deque<Job> jobs) {

        if (jobs.isEmpty()) {
            throw new NoJobException("No job available, get a rest!");
        }
        return jobs.getLast();
    }

}


