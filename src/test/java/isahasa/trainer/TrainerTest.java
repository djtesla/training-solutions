package isahasa.trainer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TrainerTest {

    @Test
    public void testWorkHasCalled() {

        WorkStub workStub = new WorkStub();
        Trainer trainer = new Trainer(workStub);
        trainer.doWork();
        assertTrue(workStub.isCalled());

        Trainer trainer2 = new Trainer(new TakeCourse());
        assertEquals("Happy Students", trainer2.doWork());

        Trainer trainer3 = new Trainer(new ComplexWork(Arrays.asList(new CreateMaterial(), new TakeCourse())));
        assertEquals("Materials, Happy Students", trainer3.doWork());


    }

}