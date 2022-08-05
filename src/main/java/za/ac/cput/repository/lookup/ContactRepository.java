package za.ac.cput.repository.lookup;

import za.ac.cput.domain.lookup.Contact;

import java.util.HashSet;
import java.util.Set;

public class ContactRepository implements  IContactRepository {


    private  static  ContactRepository repository = null;
    private Set<Contact> contactDB = null;


    // private cons
    private ContactRepository(){

        contactDB = new HashSet<Contact>();

    }
    public static ContactRepository getRepository(){

        if(repository ==null) {
            repository = new ContactRepository();
        }
        return repository;
    }




    @Override
    public Contact create(Contact contact) {

        boolean success = contactDB.add(contact);
        if(!success)
            return null;
        return contact;
    }

    @Override
    public Contact read(String conid) {
        for(Contact c :contactDB) {
            if (c.getConId().equals(conid))
                return c;
        }
        return null;

    }

    @Override
    public Contact update(Contact contact) {
        Contact oldCont = read(contact.getConId());
        if(oldCont!=null) {

            contactDB.remove(oldCont);
            contactDB.add(contact);

            return contact;
        }
        return null;

    }

    @Override
    public boolean delete(String conId) {

        Contact contactToDelete = read(conId);
        if(contactToDelete==null)
            return  false;
        contactDB.remove(contactToDelete);

        return true;
    }

    @Override
    public Set<Contact> getAll() {
        return contactDB;
    }
}
