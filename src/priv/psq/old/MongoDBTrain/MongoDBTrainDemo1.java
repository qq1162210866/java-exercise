package priv.psq.old.MongoDBTrain;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBTrainDemo1 {

	public static void main(String[] args) {
		try{
			//连接到mogoDB服务，27017是端口号
			MongoClient client = new MongoClient("127.0.0.1",27017);
			
			//连接到数据库，如果数据库不存在，MongoDB会新建一个数据库
			MongoDatabase database = client.getDatabase("mycol");
			
			System.out.println("连接数据库成功!");
			
			//创建集合
			database.createCollection("test");
			System.out.println("集合创建成功！");
			
			//选择已有的集合
			MongoCollection<Document> collection = database.getCollection("test");
			System.out.println("集合选择成功！");
		}catch (Exception e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
	}
}
