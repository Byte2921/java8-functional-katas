package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.*;
import util.DataUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        //return ImmutableList.of(ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl"));
        return DataUtil.getMovieLists()
                .stream()
                .flatMap(movieList -> movieList.getVideos()
                        .stream()
                        .map(movie -> ImmutableMap.of(
                                "id", movie.getId(),
                                "title", movie.getTitle(),
                                "time", getMiddleInterestingMoment(movie),
                                "url", getBoxArt(movie))))
                .collect(Collectors.toList());
    }

    private static Date getMiddleInterestingMoment(Movie movie) {
        return movie.getInterestingMoments()
                .stream()
                .filter(interestingMoment -> interestingMoment.getType().equals("Middle"))
                .map(InterestingMoment::getTime)
                .findFirst()
                .orElse(new Date());
    }

    private static String getBoxArt(Movie movie) {
        return movie.getBoxarts()
                .stream()
                .reduce(Kata9::findSmallestBoxArt)
                .map(BoxArt::getUrl)
                .orElse(null);
    }

    private static BoxArt findSmallestBoxArt(BoxArt boxArt1, BoxArt boxArt2) {
        return boxArt1.getHeight() * boxArt1.getWidth() < boxArt2.getHeight() * boxArt2.getWidth() ? boxArt1 : boxArt2;
    }
}
