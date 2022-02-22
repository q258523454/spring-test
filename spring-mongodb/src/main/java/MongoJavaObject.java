package entity;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-04-03
 */
public class MongoJavaObject {
    public static void main(String args[]) {
        try {
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient("47.107.133.247", 27017);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("java");
            System.out.println("Connect to database successfully");

            // 连接集合
            MongoCollection<Document> collection = mongoDatabase.getCollection("student");

            // 先查询所有文档
            findAll(collection);

            FindIterable<Document> findIterable1 = collection.find(Filters.eq("id", "200"));

            // 如果不存在则插入 (JavaBean --> Document)
            if (!findIterable1.iterator().hasNext()) {
                Student student = new Student();
                student.setId("200");
                student.setName("test");
                student.setAge(18);
                System.out.println("不存在,进行插入操作");
                Document document = Document.parse(JSONObject.toJSONString(student));
                collection.insertOne(document);
            }

            findAll(collection);

            // Document ---> JavaBean
            System.out.println("Document ---> JavaBean");
            FindIterable<Document> findIterable2 = collection.find(Filters.eq("id", "200"));
            MongoCursor<Document> mongoCursor = findIterable2.iterator();
            List<Student> students = new ArrayList<>();
            while (mongoCursor.hasNext()) {
                Document document = mongoCursor.next();
                System.out.println("document.toJson(): " + document.toJson());
                Student student = JSONObject.parseObject(document.toJson(), Student.class);
                students.add(student);
            }
            System.out.println(JSONObject.toJSONString(students));


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public static void findAll(MongoCollection<Document> collection) {
        // 检索所有文档
        /**
         * 1. 获取迭代器FindIterable<Document>
         * 2. 获取游标MongoCursor<Document>
         * 3. 通过游标遍历检索出的文档集合
         * */
        System.out.println("检索所有文档:");
        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()) {
            System.out.println(mongoCursor.next());
        }
    }
}
