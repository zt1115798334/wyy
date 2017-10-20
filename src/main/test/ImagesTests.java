import base.TestBase;
import com.zt.constants.SysConst;
import com.zt.mysql.entity.Images;
import com.zt.mysql.services.ImagesServices;
import com.zt.utils.DateUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class ImagesTests extends TestBase {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ImagesServices imagesServices;

    @Test
    public void test1() {
        LocalDateTime now = DateUtils.currentDate();
        List<Images> imagesList = IntStream.rangeClosed(1, 10)
                .boxed()
                .map(i -> new Images(i, "d" + i + ".jpg", now, SysConst.DEFAULT_USER_ACCOUNT, now, SysConst.DEFAULT_USER_ACCOUNT))
                .collect(toList());
        imagesServices.save(imagesList);
    }

    @Test
    public  void  test2(){
        List<Images> imagesList = imagesServices.findByCreatedUser(SysConst.DEFAULT_USER_ACCOUNT);
        imagesList.forEach(System.out::println);
    }
}
