package org.example.labwork1final.dao;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DaoUtil {

    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("postgres-store");

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static void refresh() {
        entityManagerFactory.close();
        entityManagerFactory = Persistence.createEntityManagerFactory("postgres-store");
    }
}
