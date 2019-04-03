import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-04-03
 */
public class MongoDB {
    public static void main(String args[]) {
        try {
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient("47.107.133.247", 27017);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("java");
            System.out.println("Connect to database successfully");

            // 创建集合
            // mongoDatabase.createCollection("student");
            // System.out.println("集合创建成功");

            // 选择集合
            MongoCollection<Document> collection = mongoDatabase.getCollection("student");
            System.out.println("集合选择成功");

            // 清空集合
            collection.drop();

            // 插入文档
            /**
             * 1. 创建文档 org.bson.Document 参数为key-value的格式
             * 2. 创建文档集合List<Document>
             * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document)
             * */
            Document document1 = new Document("id", 1).append("name", "张一").append("sex", "男");
            Document document2 = new Document("id", 5).append("name", "李五").append("sex", "女");
            Document document3 = new Document("id", 10).append("name", "王十").append("sex", "男");

            List<Document> documents = new ArrayList<Document>();
            documents.add(document1);
            documents.add(document2);
            documents.add(document3);
            collection.insertMany(documents);
            System.out.println("文档插入成功");

            // 检索所有文档
            findAll(collection);
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
