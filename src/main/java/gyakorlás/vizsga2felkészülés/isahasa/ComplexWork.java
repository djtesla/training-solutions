package gyakorlás.vizsga2felkészülés.isahasa;

import java.util.List;

public class ComplexWork implements Work{

    private List<Work> works;

    public ComplexWork(List<Work> works) {
        this.works = works;
    }

    @Override
    public String complete() {
        String result = "";
        for (Work work: works) {
            result += work.complete();
        }
        return result;
    }
}
