## jul-22-2017-MarketMLM_Offline_First
This week at MarketMLM:
- We faced a new decision on what to use for local database and what section should be offline-first:
    - For this we asked ourself a couple of questions:
        1. whats the domain of platform? </br> its e-commerce that uses wordpress.
        2. Since its product based, Do we need to make the home page offline and store products?</br>
           it would be good for ux but we decided not do that. one reason was
           price of the product was changing by minutes.
        2. Do we need to make the profile offline available?</br>
           that was yes ofcourse, but what part? we had a multi-role profile including customers,vendors and marketers. each role has different features, but the customer role was the base one, all others had customer profile feature inherited, so for now we decided to make the customer role offline-first.
        3. What other section would be good for ux to be offline-first?</br>
           we decided that the cart section would be great for that. user can see its cart and the products waited for purchase, this can be a good reminder for user.
           Another section was the ticket section. Customer support is always a important section. User may need info from that section or destails of an answered ticket. now another question will arise.
           should we3 store the important category or just store the last 20 ticket. will we cameup with a better solution, we give the user the ability to select what ticket it needs to be accessed offline. this was a good decision.