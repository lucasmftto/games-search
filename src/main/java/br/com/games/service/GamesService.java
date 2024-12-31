package br.com.games.service;

import br.com.games.entity.Games;
import com.mongodb.client.AggregateIterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GamesService {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Games> findGameByTitle(String termo) {
        List<Document> pipeline = new ArrayList<>();

        // Estágio do $search
        Document searchStage = new Document("$search",
                new Document("text",
                        new Document("query", termo)
                                .append("path", "title")
                                .append("fuzzy", new Document("maxEdits", 2))
                )
        );
        pipeline.add(searchStage);

        AggregateIterable<Document> result = mongoTemplate.getCollection("gamesss").aggregate(pipeline);

        for (Document doc : result) {
            System.out.println(doc);
        }
        return null;
    }
}
