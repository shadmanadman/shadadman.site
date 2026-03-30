## nov-9-2025-bit24-First-Sprint

I alwayse loved the first sprint in all of my entire workline for two reason, first finaly you can starting with coding and second is meeting with my teammates.

Thay had this amazing crypto exchange platform called bit24. At the time I joined them they were already at top of thier fields.

The source code was quite large packed in feature based modules. One thing that was really intersting is that each feature module was only had the presentation layer, data & domain for each feature were located inside the `services` module. Somthing like this:

````
- user
    - presentation
- wallet
    - presentation
- ticket
    - presentation
- services
    - user
        - data
        - domain
    - wallet
        - data
        - domain
    - ticket
        - data
        - domain
````

I found this arch very effective and a briliant idea. this not only seperates ui from buniess logic in code it also seperates it in module layer. 
This clean arch was compined with MVI. I loved MVI at my first impression on it when i worked at SportsGamex. I like its `contract` logic and i think it maches well with composables, make the ui code cleaner.

My cleages are very nice sepcialy Mohammad and Amir. Thier managment stack was, teams, gitlab and clickup. I remined myself that there was no ios applicaation at the time, Only Android.

I got hired mostly beacuse of my expirence in Kotlin Multiplatform. I believe they will migrate to kmp in near future. 