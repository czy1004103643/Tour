package me.luajk.notes.service;


import me.luajk.notes.model.TbNotes;
import me.luajk.utils.Result;

import java.util.List;

public interface NotesService {

    Result insert(TbNotes notes);

    Result update(TbNotes notes);

    Result delete(TbNotes notes);

    List<TbNotes> list(String parentId, Integer page, Integer rows);

    TbNotes get(String id);
}
