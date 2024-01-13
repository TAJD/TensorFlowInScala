# Serving Tensorflow in Scala

This is the code accompanying my blog post [here](https://tajd.co.uk/2023/10/15/onnx-interface-scala).

## Prerequisites

- Scala 3 is installed and working with your development editor/environment of choice.
- Python 3.10 is installed.
- [Git LFS](https://git-lfs.com/) is installed.

## Method

### Serialize Tensorflow model to Onnx

1. Initialise local Python environment.

`pip install requirements.txt`

2. Clone TensorFlow model repository.

`git clone https://huggingface.co/keras-io/timeseries-anomaly-detection/ model/`

3. Serialize TensorFlow model to Onnx using the `tf2onnx` script below.

`python -m tf2onnx.convert --saved-model ./model --opset 10 --output tfScala/src/main/resources/model.onnx`

### Serve in Scala

The model is called within `Interface.scala` file through the `Interface` object. In Intellij this model can be called from within the IDE.