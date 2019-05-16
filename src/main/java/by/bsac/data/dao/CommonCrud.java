package by.bsac.data.dao;

import java.util.List;

public interface CommonCrud<T> {

    Number create(T t);
    List<T> read();
    void update(T t);
    void delete(T t);

}
