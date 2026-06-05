## date-SportsGameX-ML-Model

The idea of having a personal assistant tailored to each specific user was truly great. We had an excellent machine learning model capable of running locally directly on the user’s mobile device. This was a major step forward in user experience and would give us a significant advantage over competitors for multiple reasons.

This model will be run directly on mobile devices, so user data security will be greatly enhanced. Nothing will be sent to the server, absolutely nothing.

The model was brilliantly trained by our AI branch and designed to assist users during buy/sell actions. It provides personalized market anomaly alerts. We called it `anomaly_detecter` . This was a tiny model, optimized and converted to `tflite`, that runs on the mobile devices. It learns the user’s patterns, such as typical trading times, preferred tickers, and reactions to price movements. Then, it flags unusual events specific to that user, not for the whole market.

We could worn the user with some anomalies. Here are some output from the model when the sport if `Football`:

- The odds for the home team just moved faster than usual for matches you follow.
- Goal chance probability jumped suddenly. this doesn’t happen often in your tracked matches.
- Cards and foul rates just increased far quicker than in your usual match profiles
- The under/over line shifted faster than what you typically see.

Running the model itself wasn’t a challenge due to my years of experience. The real difficulty lay in my insistence on using Kotlin Multiplatform KMP to deploy the model and use its output on both Android and iOS platforms.
Because I had previously been responsible for a few KMP modules, my proposal didn’t concern our Mobile Head or the Android team, but the iOS team wasn’t particularly happy about it.

The iOS team was woried that if we did not use the apple framework to run our model it may effect on its speed and accurecy, since it needed CPU and CoreML for better result.

I respected their concerns, but it did not make me change my stance. Kotlin Multiplatform was an excellent choice for this situation, as it allows the use of native frameworks to run such a model. They wanted to use CoreML, certainly, I could easily integrate CoreML with KMP. This was not a wrapper, but a typical native implementation that directly uses Apple’s frameworks.


So, to prove my point, I started two small POC projects. One was a simple image based live detection app that used a tflite model for object detection, and the other was our text based model that relied on the CPU. Both projects used the offical tflite library for iOS under the hood. During several meetings with some of my trusted iOS colleagues, I demonstrated that the underlying code was actually the native Apple framework, with no actual changes in accuracy or performance. The results from my POC were identical to those of a native iOS implementation. In the end, I successfully convinced them to adopt a Kotlin Multiplatform module for this feature.

The challenge was quite satisfying, not only because I finally made my voice heard, but also because I managed to convince an entire iOS team. I was incredibly proud of myself and truly happy. Challenges like this are what make my work the best job in the world. Ohh I love coding so much. I shall mark this success in my work callender.




