package br.com.games.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "games")
@Getter
@Setter
@AllArgsConstructor
public class Games {

    @Id
    private String id;

    private String img;
    private String title;
    private String console;
    private String genre;
    private String publisher;
    private String developer;

    @Field("critic_score")
    private BigDecimal criticScore;
    @Field("total_sales")
    private BigDecimal totalSales;
    @Field("na_sales")
    private BigDecimal naSales;
    @Field("jp_sales")
    private BigDecimal jSales;
    @Field("pal_sales")
    private BigDecimal palSales;
    @Field("other_sales")
    private BigDecimal otherSales;
    @Field("release_date")
    private LocalDateTime releaseDate;
    @Field("last_update")
    private LocalDateTime lastUpdate;

}
