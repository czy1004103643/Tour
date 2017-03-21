package me.luajk.notes.service;

import me.luajk.notes.dao.TbNotesMapper;
import me.luajk.notes.model.TbNotes;
import me.luajk.utils.IdGenerator;
import me.luajk.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class NotesServiceImpl implements NotesService {

    private final TbNotesMapper notesMapper;

    @Autowired
    public NotesServiceImpl(TbNotesMapper notesMapper) {
        this.notesMapper = notesMapper;
    }

    public Result insert(TbNotes notes) {
        notes.setId(IdGenerator.getId());
        notes.setDate(new SimpleDateFormat("yyyy-MM-dd : hh:mm:ss").format(new Date()));
        notes.setStatus(0);
        notesMapper.insert(notes);
        return new Result(notes);
    }

    public Result update(TbNotes notes) {
        notesMapper.updateByPrimaryKeySelective(notes);
        return new Result(null);
    }

    public Result delete(TbNotes notes) {
        notesMapper.deleteByPrimaryKey(notes.getId());
        return new Result(null);
    }

    public List<TbNotes> list(String parentId, Integer page, Integer rows) {
        return null;
    }

    public TbNotes get(String id) {
        return notesMapper.selectByPrimaryKey(id);
    }
}
