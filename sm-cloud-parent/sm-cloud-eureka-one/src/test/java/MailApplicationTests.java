import com.dayunwu.manage.service.MailService;
import com.dayunwu.manage.service.impl.MailServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author： reyco
 * @date 2020/3/21
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailApplicationTests {

    @Autowired
    private MailServiceImpl mailServiceImpl;

    @Test
    public void test(){

    }
}
