package vizsgafelkészülés04.queue.priorityqueue;

public class Job implements  Comparable<Job>{

    private int priority; // 1 - 10 skálán osztályozzuk a prioritást
    private String jobDescription;
    private boolean urgent; // minden olyan job esetén true, ahol a prioritás < 5

    public Job(int priority, String jobDescription) {
        if (!(priority >= 1 && priority <= 10)) {
            throw new IllegalArgumentException("Priority must be between 1 and 10");
        }
        this.priority = priority;
        this.jobDescription = jobDescription;
        if (priority < 5) {
            this.urgent = true;
        }
    }

    @Override
    public int compareTo(Job anotherJob) {
        if (priority == anotherJob.priority) {
            return jobDescription.compareTo(anotherJob.jobDescription);

        }
        return priority - anotherJob.priority;
    }

    @Override
    public String toString() {
        return
                "priority=" + priority +
                ", jobDescription='" + jobDescription + '\'' +
                ", urgent=" + urgent;

    }
}
