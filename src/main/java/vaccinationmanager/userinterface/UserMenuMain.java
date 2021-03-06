package vaccinationmanager.userinterface;

import vaccinationmanager.operations.*;

import java.util.Scanner;

public class UserMenuMain {

    public static final Scanner SCANNER = new Scanner(System.in);


    public void displayMenu() {
        boolean isFinished = false;
        while (!isFinished) {
            System.out.println('\n' +
                    "*********************************" + '\n' +
                    "*         OLTÁS MENEDZSER       *" + '\n' +
                    "*    ------- Java App -------   *" + '\n' +
                    "*       Zámbó Ernő © 2021.      *" + '\n' +
                    "*********************************" + '\n' +
                    '\n' +
                    "1. Regisztráció" + '\n' +
                    "2. Tömeges regisztráció" + '\n' +
                    "3. Generálás" + '\n' +
                    "4. Oltás" + '\n' +
                    "5. Oltás meghiúsulás" + '\n' +
                    "6. Riport" + '\n' +
                    "7. Kilépés");

            System.out.println('\n' + "Kérjük válasszon menüpontot!");

            Integer input;
            try {
                input = Integer.parseInt(SCANNER.nextLine());
                isFinished = callService(input);

                if (!isFinished) {
                    System.out.println("******FELDOLGOZÁS SIKERES! A menühöz való visszatéréshez nyomjon ENTER-t...*****");
                    SCANNER.nextLine();
                }

            } catch (NumberFormatException nfe) {
                System.out.println('\n' + "Nincs ilyen menüpont. A menühöz való visszatéréshez nyomjon ENTER-t." + '\n');
                SCANNER.nextLine();

            } catch (InvalidMenuInputException ime) {
                System.out.println('\n' + "Nincs ilyen menüpont. A menühöz való visszatéréshez nyomjon ENTER-t." + '\n');
                SCANNER.nextLine();

            } catch (InvalidDataInputException ide) {
                System.out.println('\n' + "Nem megfelelő adatbevitel! A menühöz való visszatéréshez nyomjon ENTER-t." + '\n');
                SCANNER.nextLine();
            }

            catch (ExitDuringDataInputException ee) {
                System.out.println("Kilépett az adatbevitelből. A menühöz való visszatéréshez nyomjon ENTER-t.\"");
                SCANNER.nextLine();
            }

            catch (ExitFromApplicationException ee) {
                System.out.println('\n' + "Kilépett az alkalmazásból.");
                return;
            }
        }

    }


    private void pauseExecution() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {
            throw new IllegalStateException("Interrupted", ie);
        }
    }


    private boolean callService(Integer input) {
        VaccinationOperations vo = new VaccinationOperations();

        switch (input) {
            case 1: {
                vo.registerMain();
                break;
            }
            case 2: {
                vo.massRegister();
                break;
            }
            case 3: {
                vo.generate();
                break;
            }
            case 4: {
                vo.vaccinate();
                break;
            }
            case 5: {
                vo.cancelVaccinate();
                break;
            }
            case 6: {
                vo.report();
                break;
            }

            case 7: {

                throw new ExitFromApplicationException();

            }
            default: {
                throw new InvalidMenuInputException();
            }
        }


        return false;
    }


}
