package sample.common.dao;
import javafx.collections.ObservableList;


public interface AccountingDAOIf <T> {
    public Integer save(T t);
    public Boolean update(T t);
    public Boolean delete(String id);
    public T search(String id);
    public ObservableList<T> search(int id);
    public ObservableList<T> listAll();
}