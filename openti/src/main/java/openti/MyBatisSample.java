package openti;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisSample {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {

        SqlSession session = null;
        try {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
            session = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(session != null) {
            try {
                int id = session.selectOne("openti.BlogMapper.selectId", 2);
                System.out.println(id);
                  
                List<Map<String, Object>> result = session.selectList("openti.BlogMapper.selectTest");
                result.forEach(map -> {
                	map.forEach((k, v) -> {
                		System.out.println(k + " -> " + v);
                	});
                });
                
                String title = session.selectOne("openti.BlogMapper.selectTitle", 2);
                System.out.println(title);
                
            } finally {
                session.close();
            }
        }
    }
}
