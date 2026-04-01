## jul-16-2024-StrAIberry-Changing-Camera-Focus

After changing the camera process from jaw detection to teeth detection, we faced an issue. This change has forced users to hold the camera much closer to their faces in order to detect molar teeth. 

1- This closeness caused the camera to lose focus, resulting in blurry frames. 

2- Another problem we faced was that the molar teeth were taking up the entire frame, making only the center molar clear (CameraX will centers the focus by default). Therefore, we needed to adjust the camera focus from the second molar to a point between the first and last molar. 

3- Focus changes must happen sequentially. Changing to the next focus point only upon completion of the current tooth detection and finishing current focus transaction (Camera focus changes has some delays). 

To fix the first problem, we found a function in CameraX that returns an int value for `minimum_focus_distance` on the current camera device. This value indicates the point at which the camera loses focus. Using this, we were able to warn both the code and the users when the camera was too close. 
Thanks to that, we were able to combine this value with the current frame’s teeth count and develop an algorithm to notify the user to move the phone either farther away or closer. 
For example, at the start of each checkup, we start on molar teeth. The frames related to this section must contain exactly three molar teeth from each side of the jaw.


The solution to the second issue was found not in CameraX, but in Camera2. CameraX did not have an API to control focus, whereas Camera2 offered a much deeper API, enabling us to change focus by defining specific focus points.

// TODO code and explanation for third problem.