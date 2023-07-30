package varias_tareas.nimi;

import java.util.List;

public class Helpers {
    private Helpers() {
    }

    public static boolean isNullOrEmpty(List arrayList){
        return arrayList == null || arrayList.isEmpty();
    }
}
