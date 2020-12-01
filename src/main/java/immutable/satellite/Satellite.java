package immutable.satellite;

public class Satellite {

    private CelestialCoordinates destinationCoordinates;
    private String registerIdent;

    public Satellite(CelestialCoordinates destinationCoordinates, String registerIdent) {

        if (!isEmpty(registerIdent)) {
            this.destinationCoordinates = destinationCoordinates;
            this.registerIdent = registerIdent;
        }
    }


    private boolean isEmpty(String text) {

        if (text == null) {
            throw new NullPointerException("Parameter must not be null!");
        }
            if (text.isBlank()) {
                throw new IllegalArgumentException("Register ident must not be empty!");
        }

        return false;


    }

    public CelestialCoordinates getDestinationCoordinates() {
        return new CelestialCoordinates(destinationCoordinates.getX(), destinationCoordinates.getY(), destinationCoordinates.getZ());
    }

    public String getRegisterIdent() {
        return registerIdent;
    }

    public void modifyDestination(CelestialCoordinates diff) {

        CelestialCoordinates oldCoordinates  = getDestinationCoordinates();

        CelestialCoordinates newCoordinates = new CelestialCoordinates(
                oldCoordinates.getX() + diff.getX(),
                oldCoordinates.getY() + diff.getY(),
                oldCoordinates.getZ() + diff.getZ());

        destinationCoordinates = newCoordinates;

    }

    @Override
    public String toString() {
        return registerIdent + ": " +
                destinationCoordinates.toString();
    }
}
