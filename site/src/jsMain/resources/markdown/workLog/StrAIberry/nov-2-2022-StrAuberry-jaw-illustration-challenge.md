## nov-2-2022-StrAIberry-jaw-illustration-challenge

In an inner part of our checkup system we had this section where user could select which tooth needs more attention in the detection process. We had this design of an illustration of human jaw. The design was really good. Each tooth on the design should have been selectable by user. The challenge was making the design responsive, each tooth should stay in place when screen size was changing and in android we have this verity of screens unlike ios.


The design was simple, we had two overall shape for upper and lower jaw. on the teeth side we had 8 teeth. Why 8? Imagine the left side of your lower jaw, it has 8 tooth, now the right side is exactly the same but the tooth are mirroring. so in the design system we only needed 8 tooth, then inside the code we mirror them when needed.

The base challenge was to place the tooth around the jaw shape. The jaw shape had this oval kind of shape. At the time Android had this cool component called `ConstraineLayout`. The component had values for bias, It had values for `horizontal_bias` & `vertical_bias` plus you could add padding. You can place a view in a circular position around another view.

Using `ConstraineLayout` was a good help. The result was exactly like our designs and it was also responsive. But somthing that botherd me was our xml layout code was really big. we had to create an `imageView` for each tooth and calculate the bias manually. Maybe we could refactor this in near future.