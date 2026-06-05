## may-8-2022-StrAIberry-chart-challenges

At home page we had 4 kind of charts. The overall purpose of this charts was to show an average health/whitening of users oral hygiene.
Charts layout was challenging but they are sincerely beautiful. After a couple of R&D we found no library that looks like our design, so we needed to go custom.

Looking at the chart form above, they seamed quite difficult to create, but a problem solving mind will always divides a big problem into smaller ones. I usually start with the easy one, it keeps me motivated during the process.

Our main tool was Canva. But first we extracted the data models for our charts. This models are needed to feed the charts & extracting them was a good starter point for charts overall structure.

Then we extracted the views. Each chart was giving a unique name, Each individual part of the chart should be an individual view and then gets combined in the main chart view. For example our `WhiteningChart` divided into two smaller views, the `bars` and the `floating_score`.

Charts had also some similar views, for example the x/y bars was similar in two of them.

I also proposed to convert this charts into a library for android. This text will be updated when its ready.