package fpij.chapter4;

public class MailBuilder {
    private String from;
    private String to;
    private String subject;
    private String body;

    public MailBuilder from(final String from) {
        this.from = from;
        return this;
    }

    public MailBuilder to(final String to) {
        this.to = to;
        return this;
    }

    public MailBuilder subject(final String subject) {
        this.subject = subject;
        return this;
    }

    public MailBuilder body(final String body) {
        this.body = body;
        return this;
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
