package arraylist;

public class CapsulesMain {

    public static void main(String[] args) {

        Capsules capsules = new Capsules();

        capsules.addFirst("kék");
        capsules.addFirst("piros");
        capsules.addFirst("kék");
        capsules.addLast("zöld");
        capsules.addFirst("kék");

        System.out.println(capsules.getColors());

        capsules.removeFirst();
        capsules.removeLast();

        System.out.println(capsules.getColors());

    }
}
