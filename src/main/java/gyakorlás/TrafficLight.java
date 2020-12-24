package gyakorlás;


public enum TrafficLight implements HasNext {

    RED {
        @Override
        public TrafficLight next() {
            return RED_YELLOW;
        }

    }, RED_YELLOW {
        @Override
        public TrafficLight next() {
            return GREEN;
        }
    }, GREEN {
        @Override
        public TrafficLight next() {
            return YELLOW;
        }
    }, YELLOW {
        @Override
        public TrafficLight next() {
            return null;
        }
    };

}



