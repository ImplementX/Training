package data_structures.hash_table.cuckoo_hash;

public interface HashFamily<AnyType> {
    int hash(AnyType x, int which);
    int getNumberOfFunctions();
    void generateNewFunctions();
}
