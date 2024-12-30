package br.com.games.api.resource;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GamesResource {

    private String img;
    private String title;
    private String console;
    private String genre;
    private String publisher;
    private String developer;

    private BigDecimal criticScore;
    private BigDecimal totalSales;
    private BigDecimal naSales;
    private BigDecimal jSales;
    private BigDecimal palSales;
    private BigDecimal otherSales;
    private LocalDateTime releaseDate;
    private LocalDateTime lastUpdate;
}
