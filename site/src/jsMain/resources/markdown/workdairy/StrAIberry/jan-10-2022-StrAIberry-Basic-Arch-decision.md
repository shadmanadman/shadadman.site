# jan-10-2022-StrAIberry-Basic-Arch-decision
This week was focused on defining the foundational architecture of the strAIberry app, setting the stage for scalable and maintainable development.
Initially, we considered a multimodule approach, where each feature (e.g., checkup, home, profile) would live in its own module, with shared logic in a `core` and `common` module. This would promote modularity and team autonomy.
However, after reviewing the current scope and user stories, still relatively small, we decided to start with a single app module to reduce overhead and accelerate development. The plan is to split into modules later if the project grows in complexity or team size.
The core architecture follows Clean Architecture:
- Domain: Contains business logic, use cases, and entities.
- Data: Handles data class.
- Presentation: Manages UI logic, view models, and user interactions.
  For the UI layer, we chose MVVM (Model-View-ViewModel) pattern:
  - View (UI) binds to ViewModel via data binding.
  - ViewModel exposes observable data.
