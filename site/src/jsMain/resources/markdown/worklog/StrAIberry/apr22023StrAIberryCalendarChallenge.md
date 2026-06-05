## apr-2-2023-StrAIberry-Calendar-Challenge

We decided to impl a new user story for reminding users on dental events like brushing or dentist appointments. A local calendar system was much needed.

The calendar itself was not much of a challenge, what makes it more complex is the recurring system for reminders. A reminder system usually gives user a couple of options to store recurring events such as repeat everyday, once a week or etc. Now when user modifies a repeatable event, following scenarios might happen:

- Edit/Delete only current day
- Edit/Delete This and following events
- Edit/Delete All events


Obviously the solution is not creating a record for each recurring event, So i start to R&D for a better solution and then I came across this amazing article that explains very clearly.

<a href="https://github.com/bmoeskau/Extensible/blob/master/recurrence-overview.md">recurrence-overview</a>


We ended up with the following data structure. Each field should explain itself very well:

```
/**
 * Stores specific modifications or settings for an event instance.
 * Useful for tracking changes to recurring events or custom event behaviors.
 */
data class EventConfig(
    val parentId: String?,
    /** The date of the edit or configuration change. */
    val editDate: Date,
    /** Unique ID for the specific edited event. */
    val editEventId: String
)

data class EventModel(
    @PrimaryKey val remoteId: String,
    val title: String,
    var eventColor: EventColor,
    var startdDate: Date,
    /** if its null then forever **/
    val endDate: Date? = null,
    val minute: Int,
    val hour: Int,
    val am_pm: String,
    val repetition: EventRepetition,
    val doneDates: ArrayList<Date> = ArrayList(),
    val configs: ArrayList<EventConfig> = ArrayList()
)
```




   For editing/deleting event that has a repetition we use the following idea:
   - When user wants to edit/delete [OnlyThisEvent] we create a new event
     with edited inputs and update current `config`.
  
   - When user wants to edit/delete [ThisAndFutureEvent] we create a new event
     with edited inputs and update current `endDate`.
  
   - When user wants to edit/delete [AllEventInSeries] we just update current event.
