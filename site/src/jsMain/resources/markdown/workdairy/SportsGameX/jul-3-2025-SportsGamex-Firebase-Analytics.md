## jul-3-2025-SportsGamex-Firebase-Analytics

We already had Firebase through the Google Sign‑In implementation, so adding a KMP module for Analytics wasn’t a challenge. We needed this badly, it was going to be a huge help for tracking user events, especially since we had many user stories in our Fantasy section.

I was at the finish line for this module, that I decided to create some proactiveness and have a strategic vision. My mission was only Firebase Analytics but what if we needed to use other analytics platforms like `MixPannel`? We need to develop another module for `MixPannel` too? that's not a correct architecture.

For that i found the `Observer Pattern` an excellent choice for this purpose to decouple the event broadcasting. You can easily register any other platforms and this analytics system will submit the event to all of them. Receive and process the same event independently without the `AnalyticsRegistry` needing to know the specifics of each service.

```
data class AnalyticsEvent(val name: String, val params: Map<String, Any?> = mapOf())

interface AnalyticsService {
    fun logEvent(event: AnalyticsEvent)
}

object AnalyticsRegistry {
    private val services = mutableSetOf<AnalyticsService>()

    fun register(service: AnalyticsService) {
        services += service
    }

    fun unregister(service: AnalyticsService) {
        services -= service
    }

    fun logEvent(event: AnalyticsEvent) {
        services.forEach { it.logEvent(event) }
    }

    fun logEvent(name: String, buildParams: MutableMap<String, Any?>.() -> Unit = {}) {
        val params = mutableMapOf<String, Any?>().apply(buildParams)
        services.forEach { it.logEvent(AnalyticsEvent(name, params)) }
    }
}

``` 

Another task successfully completed! My colleagues were very impressed, and I’m very proud of myself.