## mar-8-2024-StrAIberry-Advanced-Checkup

At some point we decided to change the checkup routine. Our checkup was based on the jaw detection, but a decision has been made to change the routine into teeth detection. A new segmentation model has been developed in order to detect each tooth.

Now instead of pointing the camera to each jaw, user must point for teeth. This new process was much more effective and precise. Now user must take the camera closer and this was resulting in much clear and noise reduction images. The overall routine was changed from taking a picture to take a video, but in the background we are picking best frames based on quality, teeth count and clarity then send it to server.


The overall procedure was straightforward. We divided each jaw into a left and right side, then each side, left/right, was divided into 3 other section containing:

- Molars :  These are the largest teeth, located at the back of the jaw.
- Canines : They are pointed and are used for tearing food.
- Incisors : These are the front teeth.

User will start pointing the camera at Molars, then we guide the user by visualization to move the camera into other section. When all section has been completed by 90% then we ask user to move the camera into another side. this process will continue until all the teeth (or selected teeth) has been detected successfully.

The overall result was really good. Not even our issue detection model was more precise in finding dental issues, the usage of new checkup was easier for our users.

Off course this replacement was not free of challenge. In our tooth detection model there was some post processing computation such as detecting missing tooth or finding the group of current teeth whether its from upper or lower.
This algorithms was making the model slow, so we decided to move the calculation in the mobile side. The necessary code was already writing in python, we just need it to convert this function into Kotlin. Thanks to grow of LLM models such as ChatGPT the conversion was really fast, but testing each part and fixing the LLM mistakes was a little time consuming.