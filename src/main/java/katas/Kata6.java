package katas;

import model.BoxArt;
import model.Movie;
import util.DataUtil;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();

        //return "someUrl";
        return DataUtil.getMovies()
                .stream()
                .map(Movie::getBoxarts)
                .flatMap(Collection::stream)
                .collect(Collectors.toList())
                .stream()
                .reduce(Kata6::getLargestBoxart)
                .map(BoxArt::getUrl)
                .orElse("");
    }

    private static BoxArt getLargestBoxart(BoxArt boxArt1, BoxArt boxArt2) {
        return (boxArt1.getHeight() * boxArt1.getWidth()) > (boxArt1.getHeight() * boxArt1.getWidth()) ? boxArt1 : boxArt1;
    }
}
