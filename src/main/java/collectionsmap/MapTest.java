package collectionsmap;

import java.util.*;

public class MapTest {


    public static void main(String[] args) {

        Map<String, String> codes = new HashMap<>();
        codes.put("202","OK");
        codes.put("404","Not found");

        //System.out.println(codes);

        Map<String, String> codes2 = new HashMap<>();
        codes2.put("202","OK");
        //codes2.put("404","Not found");

        //System.out.println(codes.equals(codes2));

        codes.put("304", "not modified");
        System.out.println(codes);

        codes.put("404", "new info");
        System.out.println(codes);
        //System.out.println(codes.containsKey("404"));
        //System.out.println(codes.containsValue("OK"));

        Collection<String> mapValues = codes.values();
        //System.out.println(mapValues);

        for (Map.Entry entry: codes.entrySet()) {
          //  System.out.println(entry.getKey());
            //System.out.println(entry.getValue());
        }



        List<Trainer> trainers = Arrays.asList(new Trainer(2L, "Géza"), new Trainer(3L,"Joci"),
                new Trainer(4L, "Béci"));

        Map<Long, Trainer> m = new HashMap<>();

        for (Trainer trainer : trainers) {
            m.put(trainer.getId(), trainer);
        }

        Trainer t = m.get(3L);

        System.out.println(t.getName());









    }

}
