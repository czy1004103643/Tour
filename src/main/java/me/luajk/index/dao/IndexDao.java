package me.luajk.index.dao;

import me.luajk.destination.model.Destination;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndexDao {

    List<Destination> init();

    List<Destination> top3();

    List<Destination> random3();
}
