
import java.nio.file.{Files, Paths}
import scala.jdk.CollectionConverters._
import ai.onnxruntime.{OrtEnvironment, OrtSession}
import ai.onnxruntime.OnnxTensor
object Interface extends App {

  // instantiate model and environment
  val modelBytes = Files.readAllBytes(Paths.get(getClass.getResource("model.onnx").toURI))
  val env = OrtEnvironment.getEnvironment()
  val session = env.createSession(modelBytes)

  // interrogate loaded model file
  println(session.getMetadata)
  println(session.getInputInfo)
  println(session.getOutputInfo)

  // create input
  val input = Array(Seq.fill(288)(0).map(_.toFloat).map(Array(_)).toArray)
  val inputTensor = OnnxTensor.createTensor(env, input)
  val inputName = "input_1"
  val modelInput = Map(inputName -> inputTensor).asJava

  // pass input into session
  val result = session.run(modelInput).get("conv1d_transpose_2")
    .get()
    .getValue
    .asInstanceOf[Array[Array[Array[Float]]]]

  // parse output
  val parsedResult = result.head.flatMap(_.toSeq).toSeq
  println(parsedResult)
}

