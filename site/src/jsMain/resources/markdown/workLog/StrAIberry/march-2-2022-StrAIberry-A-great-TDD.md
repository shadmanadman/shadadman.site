# march-2-2022-StrAIberry-A-great-TDD
One of the best parts of working on this project was starting with TDD from day one. It made everything feel more solid and fun. We wrote unit tests for every ViewModel right away, even before adding the actual logic.
I started by setting up a simple test for the CameraViewModel. I checked if it could properly initialize, handle camera permission requests, and trigger the detection process when needed. Then I added tests for the JawDetectionViewModel , making sure it correctly passed the image to the TFLite model and updated the UI state when a jaw was detected.
Each test was small, focused, and written before the real code. This helped me think through the flow first, what should happen when the user takes a photo, how the model should respond, and how the UI should react.
We used Jest and React Native testing library to run the tests. It was fast and easy to see what was working and what wasn’t. When a test failed, I knew exactly what to fix.
The best part? I never had to guess if something broke. The tests caught bugs early, and I felt confident pushing changes.
This approach made me more careful, more organized, and honestly , more excited to code. It turned development into a game of building step by step, with tests as my guide.
