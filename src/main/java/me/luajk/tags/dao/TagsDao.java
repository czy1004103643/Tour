package me.luajk.tags.dao;

public interface TagsDao {

    void relate(int tag,String rela);

    void disrelate(int tag,String rela);
}
