package ma.projet.dao;

import java.util.ArrayList;
import java.util.List;
import ma.projet.bean.Identifiable;


public class ListDao<T extends Identifiable> implements Dao<T> {
    protected final List<T> items = new ArrayList<>();

    @Override
    public void create(T obj) {
        items.add(obj);
    }

    @Override
    public T update(T obj) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == obj.getId()) {
                items.set(i, obj);
                return obj;
            }
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        return items.removeIf(o -> o.getId() == id);
    }

    @Override
    public T findById(int id) {
        return items.stream()
                    .filter(o -> o.getId() == id)
                    .findFirst()
                    .orElse(null);
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(items); // Copie défensive
    }
}