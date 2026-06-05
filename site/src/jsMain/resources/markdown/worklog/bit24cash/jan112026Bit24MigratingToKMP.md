## jan-11-2026-bit24-Migrating-To-KMP


Another opportunity to show myself at what I’m best at. When you can do one thing best, it gives you confidence and motivation to make it even better.

Our crypto exchange ecosystem, with over 2 million active users, was only targeting Android, and we were losing a significant portion of the iOS market. On the business side, migrating to KMP saves a decent amount of money in this situation by targeting iOS with minimum refactoring and the lowest estimation time, so they were very happy. On the engineers’ side, since all team members were Android developers, they all agreed this would be a good idea.

We were using Clean arch combined with MVI. Our project structure was quite unique \& interesting. Each feature module was only had the presentation layer, data \& domain for each feature were located inside the `services` module. Something like this:


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



I found this arch very effective and a brilliant idea. This not only separates ui from business logic in code it also separates it in module layer. 


Migrating in this scale is not gonging to be easy. Our brainstorming meetings was a great. Solving a big problem requires breaking it down into smaller ones, which we achieved by asking ourselves a few key questions and then answering them very carefully:


### Should we start the migration in the current repo, or fork a new one?

### What are the project dependencies that KMP does not support?

### What features need platform specific implementation?

### Which modules/features requires the least/most refactoring?

### What is the priority order for modules/features?

### How can we use AI to our needs? What prompts are most effective?

