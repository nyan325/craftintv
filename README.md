# craftintv-07092024

Create a microservice which serves the contents of photographers.json through a REST API.  

The service should expose three REST endpoints:

    GET /api/photographers - returns the list of all photographers.
    GET /api/photographers/{photographerID} - returns a single photographer by ID.
    GET /api/photographers/event/{eventType} - returns a list of photographers for the specified event type.

Examples of event_types:

    wedding
    birthdays
    wildlife
    sports

The above APIs should only return high-level characteristics of the photographer data. For example - name, contact, avatar, event_types etc.

Please create unit tests that cover the core logic.

With time permitting, package the application for distribution. Some examples of this:

    Docker image (preferred)
    Tomcat WAR
    Static binary
    