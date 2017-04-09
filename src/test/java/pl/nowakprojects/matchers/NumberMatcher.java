package pl.nowakprojects.matchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * Created by Mateusz on 09.04.2017.
 */
public class NumberMatcher {

    public static <T extends Number>TypeSafeDiagnosingMatcher isIntegralEven(){
        return new TypeSafeDiagnosingMatcher<T>() {
            @Override
            protected boolean matchesSafely(T item, Description mismatchDescription) {
                return item.intValue()%2==0;
            }

            @Override
            public void describeTo(Description description) {

            }
        };
    }
}
