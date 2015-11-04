package me.yamlee.demo.test.custom;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by yamlee on 15/10/11.
 */
public class NotTextEmpty extends TypeSafeMatcher<String> {
    @Override
    protected boolean matchesSafely(String item) {
        if(null == item || "".equals(item)||item.trim().equals(item)){
            return false;
        }
        return true;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("a text is not null and content is not a white space");

    }

    @Factory
    public static <T> Matcher<String> notTextEmpty(){
        return new NotTextEmpty();
    }
}
