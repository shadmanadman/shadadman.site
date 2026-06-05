## apr-9-2025-SportsGamex-First-Sprint

I have to admit, the first spring was amazing, but in all of my jobs, the first spring has always been exciting and new.

The idea behind the software was great, a platform to bet on sports and athletes, with the ability to create fantasy teams and bet on specific live plays.

At the time i join the team, the software was in a high stage of deployments. Android and iOS team was collaborating alongside each other long before i join them. Almost the main section of the app was complete, at the time they wore working on Fantasy section.

In the first few hours of getting my hands on the Android code, I had already figured out almost everything. The structure of the source code was new to me, but it was well architected for scalability and a large team. When I look at the code, there’s no need for extra words or documentations, I understand what’s going on just by reading it.

The project was using MVI for data floating and clean arch for business logic. What makes the project more interesting was the folder structure. We had 3 main modules called `shared`, `common` and `config`.

- `shared` was responsible for holding shared content such as splash, settings and main components like navigation tabs, deep links management and notification states like their screen destination.

- `common` was the main module holding both logic and views containing 3 submodules:
    - `base` containing the overall structure like models, navigation graphs, resources and theme
    - `feature` contained submodules for our features like onboarding, main and fantasy
    - `network` for Ktor configuration
    - `storage` for local preferences and database

- `config` responsible for holding different configs for release, debug and staging such as current currency and api urls.


The first spring ended with me familiarizing myself with my team, the designs, the feature goals, and the project structure. I’d also like to mention that the designs were stunning and eye catching, especially in the fantasy section. I have high hopes for this platform.