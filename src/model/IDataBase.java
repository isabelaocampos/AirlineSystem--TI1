package model;

public interface IDataBase<T> {

    void add(String arch);

    T search(String name);
}
