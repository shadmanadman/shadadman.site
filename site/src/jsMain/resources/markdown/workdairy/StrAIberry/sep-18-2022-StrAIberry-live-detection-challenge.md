## sep-18-2022-StrAIberry-live-detection-challenge

A live detection system was the primary idea for StrAIberry.

On `live` side, Thanks to `camerax` with its awesome plugin called `Analyzer`, getting frames from camera in a thread-safe environment was really easy. You could use its observer to get the frames that camera fires based on your preferences.

On the `detection` side, at first we used Pytorch mobile because the model itself was also with Pytorch. we wanted to use it directly in order to not disturb its speed and accuracy but then we decided to convert it into a `tflite` model for 3 reason, better support for Android, no latency in both speed and accuracy and better documentation.

At the time using google codelab was a big help for us as the client developers. We could test and debug our inputs on the early stages.

