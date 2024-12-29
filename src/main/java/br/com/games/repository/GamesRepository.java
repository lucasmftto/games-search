package br.com.games.repository;

import br.com.games.entity.Games;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GamesRepository extends MongoRepository<Games, String> {
}
