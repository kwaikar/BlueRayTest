
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object BlueRayTest {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("BlueRay Test Application").setMaster(args(3));
    val sc = SparkContext.getOrCreate(conf)
    sc.setLocalProperty(("USER"), args(0));
    var inputFile = sc.textFile(args(1))
 println("done" + inputFile.count())
    //inputFile.collect().foreach(println)
 // println("done" + inputFile.collect().mkString(","))
    
 sc.setLogLevel("DEBUG");
    val stringToBeBlocked="White"
    val valueNotBlocked="Black"
    val newString="ABC";
    val currentMillis = System.currentTimeMillis;
    println(inputFile.collect().size + " =======> " + inputFile.collect().mkString)
    println(inputFile.collect().mkString.contains(stringToBeBlocked))
    println(inputFile.collect().mkString.contains(valueNotBlocked))
    println("#$%#$%" + inputFile.collect().mkString)
    println(inputFile.collect().mkString.contains(newString))
   print(3 == inputFile.count());
    println(inputFile.take(3).mkString.contains(newString))
    println(inputFile.takeSample(false, 3, 0).mkString.contains(newString)) 
    println(inputFile.first().toString().contains(newString))

  }
}
