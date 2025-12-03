package com.km.ss;

import org.junit.Assert;
import org.junit.Test;

import java.net.URL;
import java.util.List;

public class TokenizerTest {

    @Test
    public void tokenizeTest() {
        List<String> input = loadFromTestFile();
        List<String> output = Tokenizer.tokenize(input);
        Assert.assertEquals(21, output.size());
    }

    @Test
    public void detokenizeTest() {
        List<String> input = loadFromTestFile();
        List<String> output = Tokenizer.tokenize(input);
        List<String> reinput = Tokenizer.detokenize(output);
        Assert.assertEquals(17, reinput.size());
    }

    private List<String> loadFromTestFile() {
        URL resourceUrl = TokenizerTest.class.getResource("/test1.txt");
        return Loader.readFromPath(resourceUrl.getFile());
    }

}