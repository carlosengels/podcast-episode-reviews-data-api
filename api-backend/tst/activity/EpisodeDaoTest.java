package activity;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.podcast_reviews_service.dynamodb.EpisodeDao;
import com.podcast_reviews_service.dynamodb.models.Episode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.MockitoAnnotations.initMocks;

public class EpisodeDaoTest {

    @Mock
    AmazonDynamoDB amazonDynamoDB;
    @Mock
    DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
    EpisodeDao episodeDao = new EpisodeDao();

    @BeforeEach
    private void setup() {
        initMocks(this);
    }

    @Test
    public void saveEpisode_validData_returnsValidEpisode() {
        //GIVEN
        String podcast = "Podcast1";
        String name = "First Episode";
        int episodeNr = 1;

        //WHEN
//        Mockito.when(episodeDao.getEpisode(podcast, episodeNr)).thenReturn(null);
        Episode result = episodeDao.saveEpisode(podcast, name, episodeNr);

        //THEN
        Assertions.assertEquals(podcast, result.getPodcast());
        Assertions.assertEquals(name, result.getName());
        Assertions.assertEquals(episodeNr, result.getEpisodeNr());
        Assertions.assertNotNull(result.getEpisodeId());
        Assertions.assertEquals(0, result.getAvgRating());
    }

    @Test public void getEpisode_validEpisode_returnsEpisode() {
        //GIVEN
        String podcast = "Podcast1";
        String name = "First Episode";
        int episodeNr = 1;

        Episode searchObject = new Episode();
        searchObject.setPodcast(podcast);
        searchObject.setEpisodeNr(episodeNr);

        Episode mockEpisode = new Episode();
        mockEpisode.setPodcast(podcast);
        mockEpisode.setEpisodeNr(episodeNr);
        mockEpisode.setAvgRating(5);
        mockEpisode.setEpisodeId("testID");
        mockEpisode.setReviews(new ArrayList<>());

        //WHEN
        Mockito.when(dynamoDBMapper.load(searchObject)).thenReturn(mockEpisode);
        Episode result = episodeDao.getEpisode(podcast, episodeNr);

        //THEN
        Assertions.assertEquals(mockEpisode.getName(), result.getName());
    }
}
