package katas;

import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        //return ImmutableList.of(ImmutableMap.of("id", 5, "title", "Bad Boys", "boxart", "url"));
        return DataUtil.getMovieLists()
                .stream()
                .flatMap(movieList -> movieList.getVideos()
                        .stream()
                        .map(movie -> ImmutableMap.of(
                                "id", movie.getId(),
                                "title", movie.getTitle(),
                                "boxart", getBoxArt(movie))))
                .collect(Collectors.toList());
    }

    private static String getBoxArt(Movie movie) {
        return movie.getBoxarts()
                .stream()
                .reduce(Kata7::findSmallestBoxArt)
                .map(BoxArt::getUrl)
                .orElse("");
    }

    private static BoxArt findSmallestBoxArt(BoxArt boxArt1, BoxArt boxArt2) {
        return (boxArt1.getHeight() * boxArt1.getWidth()) < (boxArt2.getHeight() * boxArt2.getWidth()) ? boxArt1 : boxArt2;
    }
}
