
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object BlueRayTest {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("BlueRay Test Application").setMaster(args(3));
    val sc = SparkContext.getOrCreate(conf)
    sc.setLocalProperty(("USER"), args(0));

      var inputFile = sc.textFile(args(1))

    val fs = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(args(2)), sc.hadoopConfiguration)
    if (fs.exists(new org.apache.hadoop.fs.Path(args(2)))) {
      fs.delete(new org.apache.hadoop.fs.Path(args(2)));
    }
    /*inputFile.saveAsTextFile(args(2)) val df = sqlContext.read.schema(customSchema).csv(args(1))
    df.groupBy("age").count().show()  */
    /* val customSchema = StructType(Array(
      StructField("gender", StringType, true),
      StructField("zip", StringType, true),
      StructField("age", StringType, true),
      StructField("race", StringType, true)))

    val sqlContext = new SQLContext(sc)
    val df = sqlContext.read.schema(customSchema).csv(args(1))
    df.groupBy("age").count().show()
*/

  /*  val values = inputFile.flatMap(_.split("\n")).map(_.split(",")).map(x => ((x(2), x(3)), 1));
    values.reduceByKey(_+_).take(5).foreach(println);
  */
    println("Count : ::"+inputFile.flatMap(_.split("\n")).count());
      
  }
}

