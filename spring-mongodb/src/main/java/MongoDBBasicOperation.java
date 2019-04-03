import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-04-03
 */
public class MongoBasicOperation {
    public static void main(String args[]) {
        try {
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient("47.107.133.247", 27017);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("java");
            System.out.println("Connect to database successfully");

            // 选择集合
            MongoCollection<Document> collection = mongoDatabase.getCollection("student");
            System.out.println("集合选择成功");

            // 检索所有文档
            System.out.println("所有文档:");
            findAll(collection);

            // 按条件查询
            System.out.println("按条件查询1");
            FindIterable<Document> findIterable1 = collection.find(Filters.eq("sex", "男"));
            printFind(findIterable1);

            // 按条件查询
            System.out.println("按条件查询2");
            FindIterable<Document> findIterable2 = collection.find(Filters.and(Filters.eq("sex", "男"), Filters.gt("id", 5)));
            printFind(findIterable2);

            // 更新文档   将文档中likes=100的文档修改为likes=200
            collection.updateMany(Filters.eq("id", 5), new Document("$set", new Document("id", 6)));

            // 检索所有文档
            System.out.println("所有文档:");
            findAll(collection);
            collection.updateMany(Filters.eq("id", 6), new Document("$set", new Document("id", 5)));

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
        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()) {
            System.out.println(mongoCursor.next());
        }
    }

    public static void printFind(FindIterable<Document> findIterable) {
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()) {
            System.out.println(mongoCursor.next());
        }
    }
}
