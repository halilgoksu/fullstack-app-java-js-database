package com.revature.CreateLogin.data;

// producing DAOs
// For projects with multiple DAOs, we can still use just one factory to produce different types of daos
// Singleton - only want one instance of the DAO
public class DaoFactory {

    private static PersonDao personDao = null;


    // don't have access to the constructor:
    private DaoFactory() {

    }

    // only public method in this class (So far)
    // We would also add another method like this for every dao we're producing


    public static PersonDao getPersonDao() {
        if(personDao == null) {
            System.out.println("This should only run once");
            personDao = new PersonDaoImpl();
        }
        return personDao;
    }
}
