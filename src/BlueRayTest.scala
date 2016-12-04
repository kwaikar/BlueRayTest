
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object BlueRayTest{
def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("Simple Application").setMaster("local[2]");
    val     sc = new SparkContext(conf)
    sc.setLocalProperty(("USER"), args(0));
    var inputFile = sc.textFile("hdfs://localhost/user/user_phone1.csv")
    inputFile.collect().foreach(println)
  
}
}
