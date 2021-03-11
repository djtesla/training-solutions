package vizsgafelkészülés04.queue.priorityqueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class JobDispatcher {



    public Queue<Job> addJob(Job... jobs) {
        Queue<Job> priorities = new PriorityQueue<>();
        for (Job job : jobs) {
            priorities.add(job);
        }
        return priorities;



    }


    public Job dispatchNextJob(Queue<Job> jobs) {
        return jobs.poll();
    }


    public static void main(String[] args) {
        JobDispatcher jd = new JobDispatcher();
        Queue<Job> jobs = jd.addJob(new Job( 5, "alvás"),
                new Job(4, "futás"),
                new Job(1, "tanulás"), new Job(2, "speedrent"), new Job(1, "evés"));
        System.out.println(jd.dispatchNextJob(jobs));
        System.out.println(jd.dispatchNextJob(jobs));
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
