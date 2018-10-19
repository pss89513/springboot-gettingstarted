package com.example.tutorial;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestPSs {
    @Test
    public void name() {
        List<String> list = null;
        List<String> collect = Optional.ofNullable(list).orElse(Collections.emptyList())
                .stream().map(l -> l + "1").collect(Collectors.toList());
        System.out.println(collect);
    }
}
