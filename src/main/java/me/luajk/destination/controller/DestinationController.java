package me.luajk.destination.controller;

import me.luajk.destination.model.Destination;
import me.luajk.destination.service.DestinationService;
import me.luajk.utils.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DestinationController {

    private DestinationService destinationService;

    @Resource
    public void setDestinationService(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @RequestMapping("destination/list")
    public ModelAndView list() {
        return new ModelAndView("destination/list");
    }

    @RequestMapping("destination/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView("destination/detail");
        Destination destination = destinationService.getGuide(id);
        modelAndView.addObject("destination", destination);
        return modelAndView;
    }

    @RequestMapping("deslist")
    @ResponseBody
    public Map guideListResult(int page, int rows, String name) {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("page", page);
        parameter.put("rows", rows);
        if (StringUtils.isNotEmpty(name)) {
            parameter.put("name", name);
        }
        return destinationService.listGuide(parameter);
    }
}
