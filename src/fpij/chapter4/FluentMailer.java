package fpij.chapter4;

import java.util.function.Consumer;

public class FluentMailer {
    private String from;
    private String to;
    private String subject;
    private String body;

    private FluentMailer() {}

    public FluentMailer from(final String from) {
        this.from = from;
        return this;
    }

    public FluentMailer to(final String to) {
        this.to = to;
        return this;
    }

    public FluentMailer subject(final String subject) {
        this.subject = subject;
        return this;
    }

    public FluentMailer body(final String body) {
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

    public static void send(final Consumer<FluentMailer> block) {
        final FluentMailer mailer = new FluentMailer();
        block.accept(mailer);
        System.out.println("Sending messsge...");
        System.out.println(mailer.toString());
    }
}
