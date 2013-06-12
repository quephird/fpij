package fpij.chapter4;

public class SendingMail {
    private static final String FROM    = "build@agiledeveloper.com";
    private static final String TO      = "venkat@agiledeveloper.com";
    private static final String SUBJECT = "Build notification";

    private static final String BODY_SUCKS       = "... Dude... your code sucks...";
    private static final String BODY_STILL_SUCKS = "... Dude... your code still sucks...";
    private static final String BODY_UBER        = "... Ahhh... much better...";

    public static void main(String[] args) {
        preJdk8Lame();
        preJdk8Better();
        jdk8();
    }

    private static void preJdk8Lame() {
        System.out.println("Generating mail the lame way...");
        Mailer mailer = new Mailer();
        mailer.from(FROM);
        mailer.to(TO);
        mailer.subject(SUBJECT);
        mailer.body(BODY_SUCKS);
        mailer.send();
    }

    private static void preJdk8Better() {
        System.out.println("Generating mail the slightly better way...");
        MailBuilder mailBuilder = new MailBuilder();
        mailBuilder
                .from(FROM)
                .to(TO)
                .subject(SUBJECT)
                .body(BODY_STILL_SUCKS)
                .send();
    }

    private static void jdk8() {
        System.out.println("Generating mail using JDK 8...");
        FluentMailer.send(mailer -> mailer
                .from(FROM)
                .to(TO)
                .subject(SUBJECT)
                .body(BODY_UBER));
    }
}
