import org.apache.spark.SparkConf
import org.apache.spark.SparkContext


object BlueRayFullTest {
  def main(args: Array[String]): Unit = {
    
    
 
  val conf = new SparkConf().setAppName("BlueRay Test Application").setMaster(args(3));
    val sc = new SparkContext(conf)
    sc.setLocalProperty(("USER"), args(0));

    var inputFile = sc.textFile(args(1))
    inputFile.collect().foreach(println)

    val fs = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(args(2)), sc.hadoopConfiguration)
    if (fs.exists(new org.apache.hadoop.fs.Path(args(2)))) {
      fs.delete(new org.apache.hadoop.fs.Path(args(2)));
    }
    inputFile.coalesce(1, true).saveAsTextFile(args(2))
    
    val stringToBeBlocked=""
    val valueNotBlocked=""
    val newString="";
    val currentMillis = System.currentTimeMillis;
    println(inputFile.collect().size + " =======> " + inputFile.collect().mkString)
    inputFile.collect().mkString.contains(stringToBeBlocked)
    inputFile.collect().mkString.contains(valueNotBlocked)
    println("#$%#$%" + inputFile.collect().mkString)
    inputFile.collect().mkString.contains(newString)
   print(3 == inputFile.count());
    inputFile.take(3).mkString.contains(newString)
    inputFile.takeSample(false, 3, 0).mkString.contains(newString) 
    inputFile.first().toString().contains(newString)


  }
}
