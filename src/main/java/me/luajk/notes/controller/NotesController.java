package me.luajk.notes.controller;

import me.luajk.notes.model.TbNotes;
import me.luajk.notes.service.NotesService;
import me.luajk.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/notes")
public class NotesController {

    private final NotesService notesService;

    @Autowired
    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list() {
        return null;
    }

    @RequestMapping(value = "/{id}")
    public String get(@PathVariable("id") String id, Model model) {
        TbNotes notes = notesService.get(id);
        model.addAttribute("notes",notes);
        return "notes/notes-info";
    }

    @RequestMapping(value = "/create")
    @ResponseBody
    public Result create(TbNotes notes) {
        try {
            return notesService.insert(notes);
        } catch (Exception e) {
            return new Result(false, e.getMessage());
        }
    }

    @RequestMapping(value = "/modify/{id}")
    public String modify(@PathVariable("id") String id, Model model) {
        TbNotes notes = notesService.get(id);
        model.addAttribute("notes",notes);
        return "notes-update";
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public Result update(TbNotes notes) {
        try {
            return notesService.update(notes);
        } catch (Exception e) {
            return new Result(false, e.getMessage());
        }
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public Result delete(TbNotes notes) {
        try {
            return notesService.delete(notes);
        } catch (Exception e) {
            return new Result(false, e.getMessage());
        }
    }

}
