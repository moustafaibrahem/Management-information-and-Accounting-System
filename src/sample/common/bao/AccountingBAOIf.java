package sample.common.bao;
import javafx.collections.ObservableList;


public interface AccountingBAOIf <T> {
    public Integer save(T t);
    public Boolean delete(String id);
    public T search(String id);
    public ObservableList<T> search(int id);
    public ObservableList<T> listAll();
}