TitonPlus
==========

TitonPlus is a plugin to have fun on TitonMC. More information on the [TitonWiki][TitonWiki].

Compilation
-----------

We use maven to handle our dependencies.

- Install [Maven 3][Maven]
- Check out this repository.
- Run ```mvn clean package```

The master branch is automatically build on our Jenkins CI server ([TitonPlus Jenkins Job][JenkinsJob]).

Issue Tracker Notes
-------------------

How do I create a ticket the right way?

- Separate your reports. You think there is something wrong, but also want this new feature? Make life easier for us and create two tickets. We'd appreciate it big times.
- Don't tell us your story of life. We want facts and information. The more information about `the Problem` you give us, the easier it is for us to figure out what's wrong.
- Check the closed tickets first. Maybe someone created a similar ticket already. If you think it's unresolved, then give us more information on there instead.

### Bug Report

Make sure to not tell us your story of life. We want brief descriptions of what's wrong to get directly to fixing.
Also try to make the title describe briefly what's wrong.

Include what you've expected to happen and what happened.

Also try and include information like version of TitonPlus and Bukkit.

Additional Information like what Java version the server runs on would be appreciated, but is not required at all times.

[TitonWiki]: http://wiki.titongames.com/
[JenkinsJob]: http://ci.titongames.com/job/TitonPlus/
[Bukkit]: http://bukkit.org/
[Maven]: http://maven.apache.org/
