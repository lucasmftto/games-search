package br.com.games.api;

import br.com.games.api.resource.GamesResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("v1/games")
public interface GamesApi {

    @GetMapping(path = "/{id}", produces = "application/json")
    ResponseEntity<GamesResource> getGames(@PathVariable String id);
}
