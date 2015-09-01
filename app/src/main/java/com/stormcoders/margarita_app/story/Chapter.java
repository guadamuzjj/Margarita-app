package com.stormcoders.margarita_app.story;

/**
 * Created by oscarmcm on 25/7/15.
 */

import com.stormcoders.margarita_app.R;

/**
 * Clase que representa la existencia de un Chapter
 */

public class Chapter {
    private String name;
    private int idDrawable;

    public Chapter(String name, int idDrawable) {
        this.name = name;
        this.idDrawable = idDrawable;
    }

    public String getName() {
        return name;
    }

    public int getIdDrawable() {
        return idDrawable;
    }

    public int getId() {
        return name.hashCode();
    }

    public static Chapter[] ITEMS = {
            new Chapter("Cap 1", R.drawable.cap1),
            new Chapter("Cap 2", R.drawable.cap2),
            new Chapter("Cap 3", R.drawable.cap3),
            new Chapter("Cap 4", R.drawable.cap4),
            new Chapter("Cap 5", R.drawable.cap5),
            new Chapter("Cap 6", R.drawable.cap6),
            new Chapter("Cap 7", R.drawable.cap7),
            new Chapter("Cap 8", R.drawable.cap8),
    };

    /**
     * Obtiene item basado en su identificador
     *
     * @param id identificador
     * @return Chapter
     */
    public static Chapter getItem(int id) {
        for (Chapter item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}

