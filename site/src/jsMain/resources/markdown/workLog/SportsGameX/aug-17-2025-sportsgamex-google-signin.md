aug-17-2025-sportsgamex-google-signin

We prioritized Google SignIn as the first KMP module to be developed, since we needed it for the onboarding section of our mobile platforms.

This part was not a major challenge. Google SignIn has well written documentation for both Android and iOS. I just needed to bring both implementations together to complete our KMP module.

Google SignIn was merged into Firebase a couple of years ago. This made my work easier going forward, because we also needed to add Firebase Analytics and track user events.

Both the Android and iOS implementations were tightly integrated with the Firebase console. Having everything in one place also made the work easier. I managed to finish the task in less than half a sprint. 

Injecting the module for Android was straightforward. I only needed to include the module as a submodule in the project and use it in the onboarding section.

Injecting for iOS was a bit more challenging, but nothing too concerning. I had to add a bash script to build the module as an `xcframework`, after which our iOS team could use the API in onboarding. They were so happy and couldn't believe what just happened. Getting rid of this kind of repetitive implementation will lift some weight on team shoulders. 