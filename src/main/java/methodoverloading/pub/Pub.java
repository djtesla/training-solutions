package methodoverloading.pub;

public class Pub {

    private String name;
    private Time getOpenFrom;

    public Pub(String name, int hours, int minutes) {
       this.name = name;
       this.getOpenFrom = new Time(hours, minutes);

    }

    public String getName() {
        return name;
    }

    public Time getOpenFrom() {
        return getOpenFrom;
    }



    public boolean isEarlier (Pub pub) {

        if (this.getOpenFrom().getHours() < pub.getOpenFrom().getHours()) {
            return true;
        } else if (this.getOpenFrom().getHours() ==  pub.getOpenFrom().getHours() && this.getOpenFrom().getMinutes() < pub.getOpenFrom().getMinutes()) {
        return true;
        } else {
            return false;
        }


    }


    @Override
    public String toString() {
        return name +";" +  getOpenFrom;
    }
}
