package gyakorlás.vizsga2felkészülés.isahasa;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrainerTest {

    @Test
    public void testCreate () {

        Trainer trainer = new Trainer(new ComplexWork(List.of(new TakeCourse(), new CreateMaterials())));

        System.out.println(trainer.doWork());

        trainer.setWork(new CreateMaterials());

        System.out.println(trainer.doWork());

    }

}