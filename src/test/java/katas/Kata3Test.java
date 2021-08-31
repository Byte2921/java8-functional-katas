package katas;

import com.google.common.collect.ImmutableList;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;


public class Kata3Test {

    @Test
    public void testExecute() {
        Assert.assertThat(Kata3.execute(), equalTo(generateTestData()));
    }

    private List<Integer> generateTestData() {
        return ImmutableList.of(70111470, 654356453, 65432445, 675465);
    }
}
