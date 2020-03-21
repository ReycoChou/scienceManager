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
    private MailService mailServiceImpl;

    @Test
    public void testSimpleMail(){
        mailServiceImpl.sendSimpleMail("1046491327@qq.com","简单邮件测试","myfirst email:hello world");
    }
}
