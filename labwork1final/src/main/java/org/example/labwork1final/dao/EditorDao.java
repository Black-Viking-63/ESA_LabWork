package org.example.labwork1final.dao;

import org.example.labwork1final.model.Editor;
import jakarta.persistence.EntityManager;

import java.util.List;

public class EditorDao {

    public void create(Editor editor) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(editor);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Editor get(Long id) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Editor editor = entityManager.find(Editor.class, id);

        entityManager.getTransaction().commit();
        entityManager.close();
        return editor;
    }

    public List<Editor> getAll() {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        List<Editor> editors = entityManager.createQuery("select e from Editor e", Editor.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return editors;
    }

    public void update(Long id, Editor newEditorData) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Editor editor = entityManager.find(Editor.class, id);
        if (editor != null) {
            editor.setNameEditor(newEditorData.getNameEditor());
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(Long id) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Editor editor = entityManager.find(Editor.class, id);
        if (editor != null) {
            entityManager.remove(editor);
        }
        entityManager.getTransaction().commit();

        entityManager.close();
    }

}
