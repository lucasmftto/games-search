package br.com.games.api.controller;

import br.com.games.api.GamesApi;
import br.com.games.api.resource.GamesResource;
import br.com.games.entity.Games;
import br.com.games.mapper.GamesMapper;
import br.com.games.repository.GamesRepository;
import br.com.games.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class GamesController implements GamesApi {

    @Autowired
    private GamesRepository gamesRepository;

    @Autowired
    private GamesMapper gamesMapper;

    @Autowired
    private GamesService gamesService;

    @Override
    public ResponseEntity<GamesResource> getGames(String id) {

        this.gamesService.findGameByTitle("Grand Theft Auto V");

        Optional<Games> one = this.gamesRepository.findById(id);
        return one.map(games -> ResponseEntity.ok(this.gamesMapper.toResource(games)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
