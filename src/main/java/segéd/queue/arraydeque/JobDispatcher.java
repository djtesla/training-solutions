package segéd.queue.arraydeque;

import segéd.queue.priorityqueue.NoJobException;

import java.util.ArrayDeque;
import java.util.Deque;

public class JobDispatcher {



    public Deque<Job> addJob(Job... jobs) {
        Deque<Job> priorities = new ArrayDeque<>();
        for (Job job : jobs) {

            if (job.getPriority() < 5) {
                priorities.addFirst(job);
            } else {
                priorities.addLast(job);
            }

        }
        return priorities;
    }


    public Job dispatchUrgentJob(Deque<Job> jobs) {
        if (jobs.getFirst().isUrgent()) {
            return jobs.pollFirst();
        }
        throw new NoJobException();
    }

    public Job dispatchNotUrgentJob(Deque<Job> jobs) {
        if (!jobs.getLast().isUrgent()) {
            return jobs.pollLast();
        }
        throw new NoJobException();
    }

    public static void main(String[] args) {
        JobDispatcher jd = new JobDispatcher();
        Deque<Job> jobs = jd.addJob(new Job( 6, "alvás"),
                new Job(3, "futás"),
                new Job(2, "tanulás"), new Job(1, "speedrent"), new Job(3, "evés"));
        System.out.println(jd.dispatchUrgentJob(jobs));
        System.out.println(jd.dispatchUrgentJob(jobs));
        System.out.println(jd.dispatchNotUrgentJob(jobs));
        System.out.println(jd.dispatchNotUrgentJob(jobs));
    }
}



 /*   Gyakorlati feladat 1 - JobDispatcher
        A feladatokat (job) tetszés szerinti sorrendben felvisszük egy PriorityQueue típusú kollekcióba, és azt várjuk, hogy mindig a soron következő
        legfontosabb feladatot adja ki. Írj egy JobDispatcher osztályt, amely tárolja és rendezi a Job típusú objektumokat.
        A kollekció feltöltését a (Queue<Job> addJob(Job... jobs)) metódus végzi, amely egy (PriorityQueue<Job>) értéket ad vissza. A soron következő
        feladatot a (Job dispatchNextJob(Queue<Job> jobs) throws NoJobException) metódus adja ki a queue-ból.

        Hibakezelés
        Üres queue dobjon NoJobException kivételt.

        Megvalósítás
        Hozz létre egy saját kivétel osztályt NoJobException néven, ezt akkor dobja a megfelelő metódus, ha a queue üres.

        Hozzunk létre egy Job osztályt, a következők szerint: Legyen 3 final attribútuma:

        int priority // 1 - 10 skálán osztályozzuk a prioritást
        String jobDescription
        boolean urgent // minden olyan job esetén true, ahol a prioritás < 5
        Legyen egy public Job(int priority, String jobDescription) konstruktora. Implementálja a Comparable interfészt, a kisebb számértékű prioritás van előbb a sorban.

        Tippek
        A queue feltöltésekor használj varargs szerkezetet. Így tetszés szerinti számú objektum átadható paraméterként.*/
