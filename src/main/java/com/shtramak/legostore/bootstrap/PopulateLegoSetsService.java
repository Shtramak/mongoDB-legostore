package com.shtramak.legostore.bootstrap;

import com.shtramak.legostore.model.DeliveryInfo;
import com.shtramak.legostore.model.LegoSet;
import com.shtramak.legostore.model.LegoSetDifficulty;
import com.shtramak.legostore.model.ProductReview;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class PopulateLegoSetsService implements CommandLineRunner {
    private final MongoTemplate mongoTemplate;

    public PopulateLegoSetsService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        mongoTemplate.dropCollection(LegoSet.class);

        LegoSet millenniumFalcon = new LegoSet(
                "Millennium Falcon",
                "Star Wars",
                LegoSetDifficulty.HARD,
                new DeliveryInfo(LocalDate.now(), BigDecimal.TEN, true),
                Arrays.asList(
                        new ProductReview("Den", 7),
                        new ProductReview("Anna", 10),
                        new ProductReview("Andrew", 8)
                )
        );
        LegoSet skyPolice = new LegoSet(
                "Star Police Air Base",
                "City",
                LegoSetDifficulty.MEDIUM,
                new DeliveryInfo(LocalDate.now(), BigDecimal.valueOf(57.15), true),
                Arrays.asList(
                        new ProductReview("Peter", 5),
                        new ProductReview("Andrew", 8)
                )
        );
        LegoSet mcLarenSenna = new LegoSet(
                "McLaren Senna",
                "Speed Champions",
                LegoSetDifficulty.EASY,
                new DeliveryInfo(LocalDate.now(), BigDecimal.TEN, true),
                Arrays.asList(
                        new ProductReview("Anna", 6),
                        new ProductReview("Andrew", 7)
                )
        );

        List<LegoSet> legoSets = Arrays.asList(millenniumFalcon, skyPolice, mcLarenSenna);

        mongoTemplate.insertAll(legoSets);
    }
}
