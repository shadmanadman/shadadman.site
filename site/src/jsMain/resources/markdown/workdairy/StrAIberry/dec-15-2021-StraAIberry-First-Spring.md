# dec-15-2021-StraAIberry-First-Spring
This two weeks marked the beginning of an exciting journey at strAIberry, and I couldn’t be more happy. The team’s vision was clear: bring advanced dental health detection to everyday users through a mobile approach.
The core idea revolves around a machine learning model capable of identifying dental issues like misalignment, gaps, or crowding. While they already had a working React Native mobile app (MWP), the real challenge was shifting the jaw detection process from the server to the device itself, a move that drastically reduces latency and server load.
Here’s how it works:
- The user points their phone’s camera at their upper, lower, or front jaw.
- A TFLite model, originally trained in PyTorch and converted for mobile inference, runs locally on the device.
- It detects the jaw region, crops it precisely, and assigns a label: *upper*, *lower*, or *front*.
- The cropped image is then sent securely to the server for further analysis.
  This local processing not only improves performance but also enhances privacy, no raw images leave the device unless explicitly needed.
 
The onboarding layouts was ready to start. But before strating we needed to define the user stories. For now we had this main stories:</br>
Checkup, Containing two section:
- Whitening: </br> Input: front jaw picture , Output: A whitening score, showcasing the avg whiteness of their smile
- Regular Checkup: User could select what teeth they need to focus most. Input: pictures of the jaw , output: result of the detected issues.

Profile: including user info & checkup histories
Home: Including a profiler about overall users teeth situation
