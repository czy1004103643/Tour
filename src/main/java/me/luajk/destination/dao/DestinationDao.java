package me.luajk.destination.dao;

import me.luajk.destination.model.Destination;

import java.util.List;
import java.util.Map;

public interface DestinationDao {

    Destination getGuide(String id);

    List<Destination> listGuide(Map<String, Object> parameter);

    int count(Map<String, Object> parameter);

    void updateHit(String id);
}

