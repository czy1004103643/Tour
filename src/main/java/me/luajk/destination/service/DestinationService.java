package me.luajk.destination.service;

import me.luajk.destination.model.Destination;

import java.util.Map;

public interface DestinationService {

    Map<String, Object> listGuide(Map<String, Object> parameter);

    Destination getGuide(String id);
}
