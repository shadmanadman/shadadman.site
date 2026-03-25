### june-15-2017-MarketMLM\_First\_Sprint

This weak at MarketMLM:

* We figure out the overall Android project architecture:
  To make this decision we created a flowchart of user stories. now because the website was already implemented
  figuring out the overall user story was really fast. We already had the auth layouts for mobile.
  Because the panel was a multi-tole pane including diff profiles for Customer, Vendors and Marketers, maked the profile a little complicated.
  The customer profile was the base one, other roles will inhereted from customer.
  Based on the above info, we decided to go with the following project infostructure:

  * MarketMLM

    * app
    * features

      * profile
      * main
      * auth
      * cart
      * product
      * post
      * splash
      * ticket

  each feature module included:

  * data
  * domain
  * scene

  obviously the clean arch is always the first and best choice. For the data architecture I decided to go with MVI for two reason, first it was new and interesting and i want it to learn it, second it was really a good match for compose, makes the ui code cleaner \& more readable.

