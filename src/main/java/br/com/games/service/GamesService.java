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
//        Document searchStage = new Document("$search",
//                new Document("text",
//                        new Document("query", termo)
//                                .append("path", "title")
//                                .append("score", new Document("boost", 1))
//                ).append("index", "index_games")
//        );


//        Document searchStage = new Document("$search", new Document("compound", new Document()
//                .append("must", List.of(
//                        new Document("text", new Document()
//                                .append("query", termo)
//                                .append("path", "title") // Campo obrigatório: "title"
//                                .append("fuzzy", new Document("maxEdits", 0))
//                        )
//                ))
//        ).append("index", "index_games"));

        Document searchStage = new Document("$search", new Document()
                .append("phrase", new Document()
                        .append("query", termo) // O termo exato a ser buscado
                        .append("path", "title") // Campo onde buscar
                ).append("index", "index_games")
        );

        pipeline.add(searchStage);

        AggregateIterable<Document> result = mongoTemplate.getCollection("games").aggregate(pipeline);

        for (Document doc : result) {
            String title = doc.getString("title");
            System.out.println(title);
        }
        return null;
    }
}
