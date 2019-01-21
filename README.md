# CrawlerAttempt
Baiscally, this is a failed attempt at creating a simple web "crawler"  that would check if a given URL (stored in a .db file) is avialiable or whatsoever.

To "successfully" run this "robot" you should download/clone the repository onto your workspace and open/launch it with your preferred IDE/code editor.

The task is comleted by, I'd say, 90-95%, however the remaining 10-5% were supposed to update the HTTP status[checks it just fine] of the websites IN THE DATABASE (apart from all the other things causing an experienced java-develeloper lift his eyebrow up, this one is crucial).

I sort of understand how it should have been done: either by finding other tools provided alongside with SQLite or by creating a temporary table of ID + statuses for the latter INNER JOINing the two tables, etc.

Originally, the whole idea of building this project had N consecutive points:
1. Set an entry point (a url) which would help me grab other urls that the "entry" url's page contained (can be processed DEEPLY, replacing the so-called "entry point" with all the urls that the "entry point" had).
2. Form a massive list of data.
3. Fullful a .db file with at least several hundred thousand rows of records.
-3.5- repeat 1-3 until a satisfying number of websites are included into the database.
4. Start the first iteration of the system (filling columns of "date" and "status").
5. Set the key amount of days that may pass without having to update the HTTP status.
6. Run the application, update'm statutes'n'dates (if needed).

Having done step 3, I realized I was able to retrieve-extract-reformat and import the first 1 million of world's most visited/popular websites (Alexa gave out coupies of a spcial .csv file about 5 years ago) into the DB.

Nevertheless, it was my first time writting something in Java; never will I forget the amazing 9-hour ride from-zero-to-close-to-something.

I realize my work is way below the emloyer's expectations. Nevertheless, it was my first time writting something in Java; never will I forget the amazing 9-hour ride from-zero-to-close-to-something.

PS. Guess, I'll have to cut the amount of rows in the .db file down to 500k(?) in order to push it here, into github. Let me know if you need a full list of a million indexed urls

PPS. Там в updateUrls, когда пытался апдейтнуть status,  уже шиза какая-то началась и танцы с бубном, поэтому, возможно, потеряна небольшая часть того, что ДАЖЕ исправно работало.

Извините, что без докера и юнит тестов
