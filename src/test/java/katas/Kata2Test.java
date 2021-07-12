package katas;

import com.google.common.collect.ImmutableList;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;


public class Kata2Test {

    @Test
    public void testExecute() {
        Assert.assertThat(Kata2.execute(), equalTo(generateTestData()));
    }

    private List<Integer> generateTestData() {
        return ImmutableList.of(654356453, 675465);
    }
}
