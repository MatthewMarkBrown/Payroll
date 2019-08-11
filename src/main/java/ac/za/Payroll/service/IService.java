package ac.za.Payroll.service;

public interface IService <T, ID> {
    T create(T type);

    T update(T type);

    void delete(ID id);

    T read(ID id);
}
