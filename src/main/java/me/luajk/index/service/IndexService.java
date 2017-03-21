package me.luajk.index.service;

import me.luajk.destination.model.Destination;

import java.util.List;

public interface IndexService {

    List<Destination> init();

    List<Destination> top3();

    List<Destination> random3();
}
