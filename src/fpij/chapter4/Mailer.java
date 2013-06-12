package fpij.chapter4;

public class Mailer {
    private String from;
    private String to;
    private String subject;
    private String body;

    public void from(final String from) {
        this.from = from;
    }

    public void to(final String to) {
        this.to = to;
    }

    public void subject(final String subject) {
        this.subject = subject;
    }

    public void body(final String body) {
        this.body = body;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("From: ");
        sb.append(this.from);
        sb.append("\nTo: ");
        sb.append(this.to);
        sb.append("\nSubject: ");
        sb.append(this.subject);
        sb.append("\nBody: ");
        sb.append(this.body);
        return sb.toString();
    }

    public void send() {
        System.out.println("Sending messsge...");
        System.out.println(this.toString());
    }
}
