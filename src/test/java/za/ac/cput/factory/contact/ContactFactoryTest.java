package za.ac.cput.factory.contact;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.contact.Contact;

import static org.junit.jupiter.api.Assertions.*;

class ContactFactoryTest {

    private Contact contact_a;
    private Contact contact_b;
    private Contact contact_c;
    @Test
    void build() {
        contact_a = ContactFactory.build("01", "0813623440", "Telekom phone Number");
        contact_b = ContactFactory.build("02", "0613623550", "MTN phone Number");
        contact_c = ContactFactory.build("03", "0413623550", "WhatsApp Number");

        System.out.println(contact_a);
        System.out.println(contact_b);
        System.out.println(contact_c);
    }

    @Test
    public void testIdentity() {
        assertSame(contact_a, contact_c);
    }
    @Test
    public void testWithSuccess() {
        System.out.println(contact_a);
        assertNull(contact_a);
    }
}