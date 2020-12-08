package defaultconstructor.date;

public class SimpleDateFormatter {

    private CountryCode countryCode;


    public SimpleDateFormatter() {
        countryCode = CountryCode.HU;

    }


    public String formatDateString(SimpleDate simpleDate) {

        String formattedDate = "";
        String code = countryCode.name();

        switch (code) {

            case "HU":
                formattedDate = simpleDate.getYear() + "-" + simpleDate.getMonth() + "-" + simpleDate.getDay();
                break;

            case "EN":
                formattedDate = simpleDate.getDay() + "-" + simpleDate.getMonth() + "-" + simpleDate.getYear();
                break;

            case "US":
                formattedDate = simpleDate.getMonth() + "-" + simpleDate.getDay() + "-" + simpleDate.getYear();
                break;
        }

        return formattedDate;

    }


    public String formatDateStringByCountryCode(CountryCode countryCode, SimpleDate simpleDate) {

        String formattedDate = "";

        switch (countryCode.name()) {

            case "HU":
                formattedDate = simpleDate.getYear() + "-" + simpleDate.getMonth() + "-" + simpleDate.getDay();
                break;

            case "EN":
                formattedDate = simpleDate.getDay() + "-" + simpleDate.getMonth() + "-" + simpleDate.getYear();
                break;

            case "US":
                formattedDate = simpleDate.getMonth() + "-" + simpleDate.getDay() + "-" + simpleDate.getYear();
                break;
        }

        return formattedDate;
    }


}
