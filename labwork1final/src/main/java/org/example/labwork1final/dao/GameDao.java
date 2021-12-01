package org.example.labwork1final.dao;

import org.example.labwork1final.model.Game;
import jakarta.persistence.EntityManager;

import java.util.List;

public class GameDao {

    public void create(Game game) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(game);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Game get(Long id) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Game game = entityManager.find(Game.class, id);

        entityManager.getTransaction().commit();
        entityManager.close();
        return game;
    }

    public List<Game> getAll() {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        List<Game> games = entityManager.createQuery("select g from Game g", Game.class).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return games;
    }

    public void update(Long id, Game newGameData) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Game game = entityManager.find(Game.class, id);
        if (game != null) {
            game.setNameGame(newGameData.getNameGame());
            game.setGenre(newGameData.getGenre());
            game.setPrice(newGameData.getPrice());
            game.setEditor(newGameData.getEditor());
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(Long id) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Game game = entityManager.find(Game.class, id);
        if (game != null) {
            entityManager.remove(game);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
