package interfacestaticmethods;

import java.util.List;

public interface Valued {

    double getValue();

    static double totalValue(List<Valued> values){
        double sum = 0;

        for (Valued valued : values) {
            sum += valued.getValue();
        }
return sum;
    };
}
