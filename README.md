# mem2speech
**This is now depecrated. The newer version (https://github.com/selcouthlyBlue/Mem2Speechv2) doesn't require adding the Tensorflow dependencies manually and is downloaded through gradle build.**

Handwriting Recognition Application for Android using Tensorflow.

If you want to use this application, follow these steps:
1. Get the files from the build: https://ci.tensorflow.org/view/Nightly/job/nightly-android/44/artifact/
2. Place the files in app/libs following this structure:

libs

|____arm64-v8a

| |____libtensorflow_inference.so

|____armeabi-v7a

| |____libtensorflow_inference.so

|____libandroid_tensorflow_inference_java.jar

|____x86| 

|____libtensorflow_inference.so

|____x86_64

| |____libtensorflow_inference.so


3. Build then run the application.
