package exam03retake01;

import java.util.ArrayList;
import java.util.List;

public class MailBox {

    private List<Mail> mails = new ArrayList<>();

    public List<Mail> getMails() {
        return mails;
    }

    public void addMail(Mail mail) {
        mails.add(mail);
    }


    public List<Mail> findByCriteria(String criteria) {
        String[] criteriaArr = criteria.split(":");
        if (criteriaArr.length == 1) {
            return getMailsPerOtherCase(criteria);
        } else if ("from".equals(criteriaArr[0])) {
            return getMailsPerFrom(criteriaArr[1]);
        } else {
            return getMailsPerTo(criteriaArr[1]);
        }
    }

    private List<Mail> getMailsPerTo(String text) {
        List<Mail> selectedMails = new ArrayList<>();
        for (Mail mail : mails) {
            if (hasContactListText(mail, text)) {
                selectedMails.add(mail);
            }
        }
        return selectedMails;
    }


    private boolean hasContactListText(Mail mail, String text) {
        for (Contact contact : mail.getTo()) {
            if (contact.getName().equals(text) ||
                    contact.getEmail().equals(text)) {
                return true;
            }
        }
        return false;
    }


    private List<Mail> getMailsPerFrom(String text) {
        List<Mail> selectedMails = new ArrayList<>();
        for (Mail mail : mails) {
            if (mail.getFrom().getName().equals(text) ||
                    mail.getFrom().getEmail().equals(text)) {
                selectedMails.add(mail);
            }
        }
        return selectedMails;


    }

    private List<Mail> getMailsPerOtherCase(String criteria) {
        List<Mail> selectedMails = new ArrayList<>();
        for (Mail mail : mails) {
            if (mail.getSubject().contains(criteria) ||
                    mail.getMessage().contains(criteria)) {
                selectedMails.add(mail);
            }
        }
        return selectedMails;
    }


    public static void main(String[] args) {
        new MailBox().findByCriteria("Hello");
    }
}
