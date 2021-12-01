package com.example.labwork4final.model;

import java.util.function.Predicate;

public enum NotificationCondition {

    InsertGameWherePriceFrom100to1000(change -> {
        if (!change.getType().equals(DbChange.Type.INSERT))
            return false;
        if (!change.getEntitySimpleName().equals(Game.class.getSimpleName()))
            return false;
        long prices = Long.parseLong(change.getNewEntityMap().get("price"));
        return prices >= 100 && prices <= 1000;
    }),
    DeleteEditor(change -> change.getType().equals(DbChange.Type.DELETE)
            && change.getEntitySimpleName().equals(Editor.class.getSimpleName())
    );

    private final Predicate<DbChange> predicate;

    NotificationCondition(Predicate<DbChange> predicate) {
        this.predicate = predicate;
    }

    public boolean match(DbChange change) {
        return predicate.test(change);
    }
}

