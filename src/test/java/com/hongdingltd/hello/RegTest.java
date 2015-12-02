package com.hongdingltd.hello;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by jcchen on 15-12-1.
 */
public class RegTest {

    @Test
    public void zeroWidthPositiveLookAheadTest() {
        Pattern p = Pattern.compile("a(?=b)c");
        assertFalse(p.matcher("abc").matches());
        assertFalse(p.matcher("ab").matches());
        assertFalse(p.matcher("ac").matches());

        p = Pattern.compile("a(?=b)bc");
        assertTrue(p.matcher("abc").matches());
        assertFalse(p.matcher("ab").matches());
        assertFalse(p.matcher("ac").matches());

        zeroWidthPositiveLookAheadTest2();
    }

    public void zeroWidthPositiveLookAheadTest2() {
        Pattern p = Pattern.compile("a(?=b)");
        Matcher m = p.matcher("aacabab"); // 从"aacabab"中找"a",并且后面只允许出现b.
        while (m.find()) {
            System.out.println(m.group()+", start="+m.start()+", end="+m.end());
        }
    }
}
