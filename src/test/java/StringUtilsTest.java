import org.junit.Assert;
import org.junit.Test;
import tasks.StringUtils;

public class StringUtilsTest {

    @Test
    public void testStringUtilsThenDefaultDelimiter() {
        StringUtils build =  new StringUtils().toBuilder()
                .build();
        Assert.assertEquals(" ", build.getDelimiter());
    }

    @Test
    public void testStringUtilsThenNoDefaultDelimiter() {
        StringUtils build =  new StringUtils(";").toBuilder()
                .build();
        Assert.assertEquals(";", build.getDelimiter());
    }

    @Test
    public void testStringUtilsThenNoArgs() {
        StringUtils build = new StringUtils().toBuilder()
                .build();
        StringUtils pojo = new StringUtils();
        Assert.assertEquals(build.getDelimiter(), pojo.getDelimiter());
    }

    @Test
    public void testStringUtilsReverse() {
        StringUtils build =  new StringUtils().toBuilder()
                .build();
        Assert.assertEquals(build.reverse("мама мыла раму"), "раму мыла мама");
    }
}


