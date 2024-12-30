package br.com.games.mapper;

import br.com.games.api.resource.GamesResource;
import br.com.games.entity.Games;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GamesMapper {
    GamesMapper INSTANCE = Mappers.getMapper(GamesMapper.class);

    GamesResource toResource(Games games);
    Games toEntity(GamesResource gamesResource);
}
